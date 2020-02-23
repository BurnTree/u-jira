import React, {Component} from 'react';
import {NavLink} from "react-router-dom";
import {Button} from "reactstrap";
import history from "../../../history";
import axios from "axios";
import {connect} from "react-redux";

class RowStudent extends Component {

    state = {
        project: null,
        status: null,
        rating: 0
    }

    static onClick(idG, idP) {
        history.push("/home/" + idG + "/" + idP)
    }

    componentWillMount() {
        const idStudent = this.props.student.id
        const idTeacher = this.props.user.id
        axios.get('http://localhost:8080/api/project/projectBetweenStudentAndTeacher', {params: {idStudent, idTeacher}})
            .then(res => {
                this.setState({project: res.data})
                this.loadRating(res.data.id)
            })
            .catch(error => console.log('error: ', error))
    }

    loadStatus = (id) => {
        axios.get('http://localhost:8080/api/task/status', {params: {id}})
            .then(res => this.setState({status: res.data}))
            .catch(error => console.log('error: ', error))
    }

    loadRating = (id) => {
        axios.get('http://localhost:8080/api/project/rating', {params: {id}})
            .then(res => this.setState({rating: res.data}))
            .catch(error => console.log('error: ', error))
    }

    render() {
        if (!this.state.project) return null
        const {id, name, group} = this.props.student;
        if (!this.state.status) this.loadStatus(this.state.project.status)
        const rating = (this.state.rating > 1) ? <div className="btn-danger">в {this.state.rating.toFixed(2)} раз просрочил</div>
            : (this.state.rating < 1) ? <div className="btn-success">в {(1 / this.state.rating).toFixed(2)} раз быстрее</div> :
                <div className="btn-primary">Вовремя</div>
        return (
            <tr key={id} onClick={() => RowStudent.onClick(group, this.state.project.id)}>
                <td>{name}</td>
                <td>{this.state.project.name}</td>
                <td>
                    <div className=" text-center">
                        {rating}
                    </div>
                </td>
                <td><NavLink to={"/home/" + group + "/" + this.state.project.id}>
                    <Button>
                        Go to project
                    </Button>
                </NavLink></td>
            </tr>
        );
    }
}

export default connect((state) => ({user: state.user}))(RowStudent);
