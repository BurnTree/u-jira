import React, {Component} from 'react';
import history from '../../../history'
import {connect} from "react-redux";
import axios from "axios"
import {Table, Button} from "reactstrap"
import {matchPath} from "react-router";
import {NavLink} from "react-router-dom";

class Project extends Component {
    constructor(props) {
        super(props);
        this.state = {
            tasks: null
        }
    }

    loadTasks = (id) => {
        axios.get('http://localhost:8080/api/task/project', {params: {id}})
            .then(res => this.setState({tasks: res.data}))
            .catch(error => console.log('error: ', error))
    }

    onClick(idP, idT) {
        history.push("/home/" + idP + "/" + idT)
    }

    render() {
        let id;
        const match = matchPath(window.location.pathname, {path: '/home/:idProject'});
        if (match)
            id = match.params.idProject
        else return null
        if (!this.state.tasks) {
            this.loadTasks(id)
            return null
        }
        const rows = this.state.tasks.map(task =>
            <tr key={task.id} onClick={() => this.onClick(id, task.id)}>
                <td>{task.name}</td>
                <td>{task.description}</td>
                <td><NavLink to={"/home/" + id + "/" + task.id}>
                    <Button>
                        Go to task
                    </Button>
                </NavLink></td>
            </tr>)
        return (
            <div>
                <Table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
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

export default connect((state) => ({router: state.router}))(Project);
