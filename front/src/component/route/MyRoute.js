import React, {Component} from 'react';
import {Route, Switch} from "react-router-dom";
import {withCookies} from "react-cookie";
import {connect} from "react-redux";
import axios from 'axios';

import {writeUser} from "../../redux/AC/user";
import Auth from "../auth";
import Home from "../home";
import history from '../../history'
import {STUDENT, TEACHER} from "../../helpers";
import NotFound from "../NotFound";

class MyRoute extends Component {


    // componentDidMount() {
    //     console.log('---------')
    //     const {user, cookies, writeUser} = this.props;
    //     if (user.id && user.role) return null
    //     if (!cookies.get('user')) {
    //         if (history.location.pathname !== '/auth') history.push('/auth')
    //         return null
    //     }
    //     const id = cookies.get('user').id
    //     const role = cookies.get('user').role
    //     let path;
    //     if (role === STUDENT) path = 'http://localhost:8080/api/student/get'
    //     if (role === TEACHER) path = 'http://localhost:8080/api/teacher/get'
    //     axios.get(path, {params: {id}})
    //         .then(res => writeUser(id, res.data.name, role))
    //         .catch(err => console.log('error: ', err))
    // }

    render() {
        return (
            <div>
                <Switch>
                    <Route path="/auth">
                        <Auth/>
                    </Route>
                    <Route path="/home">
                        <Home/>
                    </Route>
                    <Route path="/*">
                        <NotFound/>
                    </Route>
                </Switch>
            </div>
        );
    }
}

export default connect((state) => ({user: state.user}), {writeUser})(withCookies(MyRoute));
