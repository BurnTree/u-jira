import React, {Component} from 'react';
import {connect} from 'react-redux'
import Header from '../header/Header'
import history from "../../history";
import {STUDENT, TEACHER} from "../../helpers";
import axios from "axios";
import {withCookies} from "react-cookie";
import {writeUser} from "../../redux/AC/user";
import RouteStudent from "../route/RouteStudent";
import RouteTeacher from "../route/RouteTeacher";


class Home extends Component {

    componentWillMount() {
        console.log('---------')
        const {user, cookies, writeUser} = this.props;
        if (user.id && user.role) return null
        if (!cookies.get('user')) {
            if (history.location.pathname !== '/auth') history.push('/auth')
            return null
        }
        const id = cookies.get('user').id
        const role = cookies.get('user').role
        let path;
        if (role === STUDENT) path = 'http://localhost:8080/api/student/get'
        if (role === TEACHER) path = 'http://localhost:8080/api/teacher/get'
        axios.get(path, {params: {id}})
            .then(res => writeUser(id, res.data.name, role))
            .catch(err => console.log('error: ', err))
    }

    render() {
        let route = (this.props.cookies.get('user').role === STUDENT) ? <RouteStudent/> : <RouteTeacher/>
        return (
            <div>
                <Header/>
                <div className="container">
                    {route}
                </div>
            </div>
        );
    }
}

export default connect((state) => ({user: state.user}), {writeUser})(withCookies(Home));
