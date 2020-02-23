import React, {Component} from 'react';
import axios from "axios"
import {Table} from "reactstrap"
import {matchPath} from "react-router";
import RowTask from "./RowTask";
import ModalAddTask from "./ModalAddTask";

class Project extends Component {

    state = {
        project: null,
        tasks: null,
        student: null,
        modal: false,
        persmissionOnCreated: false
    }

    toggle = () => {
        const revertModal = !this.state.modal;
        console.log("modal: ", revertModal)
        this.setState({modal: revertModal})
    }

    loadProject = (id) => {
        axios.get('http://localhost:8080/api/project/get', {params: {id}})
            .then(res => this.setState({project: res.data}))
            .catch(error => console.log('error: ', error))
    }

    loadTasks = (id) => {
        axios.get('http://localhost:8080/api/task/project', {params: {id}})
            .then(res => this.setState({tasks: res.data}))
            .catch(error => console.log('error: ', error))
        axios.get('http://localhost:8080/api/task/addPermission', {params: {id}})
            .then(res => this.setState({persmissionOnCreated: res.data}))
            .catch(error => console.log('error: ', error))
    }

    loadStudent = (id) => {
        axios.get('http://localhost:8080/api/task/project', {params: {id}})
            .then(res => this.setState({student: res.data}))
            .catch(error => console.log('error: ', error))
    }

    render() {
        const match = matchPath(window.location.pathname, {path: '/home/:idGroup/:idProject'});
        const idProject = match.params.idProject
        const idGroup = match.params.idGroup
        if (!(this.state.tasks)) {
            this.loadTasks(idProject);
            return null
        }
        if (!(this.state.project)) {
            this.loadProject(idProject);
            return null
        }
        const rows = this.state.tasks.map(task =>
            <RowTask key={task.id} task={task} path={"/home/" + idGroup + "/" + idProject + "/" + task.id}/>)
        return (
            <div>
                <div className="text-center">
                    <h1>Project: {this.state.project.name}</h1>
                </div>
                <div>
                    <h2>Description:</h2>
                    <div className="border p-2">
                        <h4>{this.state.project.description}</h4>
                    </div>
                </div>
                <div>
                    <h2>Deadline:
                        <div className="text-primary">{this.state.project.deadline}</div>
                    </h2>
                </div>
                <div className="text-center">
                    <h1>
                        Tasks
                    </h1>
                </div>
                <Table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Status</th>
                        <th>Transfer</th>
                    </tr>
                    </thead>
                    <tbody>
                    {rows}
                    </tbody>
                </Table>
                <div>
                    <button aria-disabled={true} disabled={!this.state.persmissionOnCreated}
                            className="mx-5 btn btn-outline-primary" onClick={this.toggle}>Add new task
                    </button>
                    <ModalAddTask project={idProject} toggle={this.toggle} modal={this.state.modal}/>
                </div>
            </div>
        );
    }
}

export default Project;
