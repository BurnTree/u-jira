import React, {Component} from 'react';
import {matchPath} from "react-router-dom";
import axios from "axios";
import {Row, Col} from "reactstrap"
import Button from "reactstrap/es/Button";
import FileRead from "./FileRead";

class Task extends Component {

    state = {
        project: null,
        task: null,
        status: ""
    }

    loadProject = (idProject) => {
        axios.get('http://localhost:8080/api/project/get', {params: {id: idProject}})
            .then(res => this.setState({project: res.data}))
            .catch(error => console.log('error: ', error))
    }

    loadTasks = (id) => {
        axios.get('http://localhost:8080/api/task/get', {params: {id}})
            .then(res => {
                this.setState({task: res.data})
                this.loadStatus(res.data.status)
            })
            .catch(error => console.log('error: ', error))
    }


    loadStatus = (id) => {
        axios.get('http://localhost:8080/api/task/status', {params: {id}})
            .then(res => this.setState({status: res.data}))
            .catch(error => console.log('error: ', error))
    }

    changeStatus = (idStatus) => {
        let newTask = {...this.state.task}
        newTask.status = idStatus;
        console.log(newTask)
        axios.put('http://localhost:8080/api/task/put', newTask)
            .then(res => {
                this.setState({task: res.data})
                this.loadStatus(res.data.status)
            })
            .catch(error => console.log('error: ', error))
    }

    render() {
        const match = matchPath(window.location.pathname, {path: '/home/:idProject/:idTask'});
        const idGen = match.params;
        if (!this.state.project) {
            this.loadProject(idGen.idProject)
            return null
        }
        if (!this.state.task) {
            this.loadTasks(idGen.idTask)
            return null
        }
        const {id, name, description} = this.state.task
        return (
            <div>
                <Row className="border-bottom">
                    <Col>
                        <h1>Project: {this.state.project.name}</h1>
                    </Col>
                    <Col>
                        <h1>Task: {this.state.task.name}</h1>
                    </Col>
                </Row>
                <br/>
                <div>
                    <h2>Status: <div className="text-primary border">{this.state.status}</div></h2>
                </div>
                <div>
                    <h2>Description:</h2>
                    <div className="border p-2 text-secondary">
                        <h4>{this.state.task.description}</h4>
                    </div>
                </div>

                <div>
                    <h2>Attachment: </h2>
                    <div className="border">
                        <FileRead/>
                    </div>
                </div>
                <div className="m-2 p-2 float-right">
                    <div className="m-2 p-2">
                        <Button disabled={this.state.task.status !== 1} className="mx-3 btn-primary"
                                onClick={(e) => this.changeStatus(2)}>
                            Start
                        </Button>
                    </div>
                    <div className="m-2 p-2">
                        <Button disabled={this.state.task.status !== 2} className="mx-3 btn-success"
                                onClick={(e) => this.changeStatus(3)}>
                            Send on test
                        </Button>
                    </div>
                </div>
            </div>
        );
    }
}

export default Task;
