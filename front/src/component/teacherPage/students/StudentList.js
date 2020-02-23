import React, {Component} from 'react';
import {matchPath} from "react-router";
import axios from "axios";
import {Table} from "reactstrap";
import RowStudent from "./RowStudent";
import {connect} from "react-redux";

class StudentList extends Component {

    state = {
        students: null,
        group: null
    }


    loadGroup = (id) => {
        axios.get('http://localhost:8080/api/group/get', {params: {id}})
            .then(res => this.setState({group: res.data}))
            .catch(error => console.log('error: ', error))
    }

    loadStudents = (idTeacher, idGroup) => {
        axios.get('http://localhost:8080/api/student/sort', {params: {idTeacher, idGroup}})
            .then(res => this.setState({students: res.data}))
            .catch(error => console.log('error: ', error))
    }

    render() {
        const match = matchPath(window.location.pathname, {path: '/home/:idGroup'});
        const idGroup = match.params.idGroup;
        if (!this.state.group) {
            this.loadGroup(idGroup)
            return null
        }
        if (!this.state.students) {
            this.loadStudents(this.props.user.id, idGroup)
            return null
        }
        const rows = this.state.students.map(student => <RowStudent student={student}/>)
        return (
            <div>
                <div className="text-center">
                    <h1>Group: {this.state.group.name}</h1>
                </div>
                <Table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Project name</th>
                        <th>Complete</th>
                        <th>Transfer</th>
                    </tr>
                    </thead>
                    <tbody>
                    {rows}
                    </tbody>
                </Table>
            </div>
        );
    }
}

export default connect((state) => ({user: state.user}))(StudentList);
