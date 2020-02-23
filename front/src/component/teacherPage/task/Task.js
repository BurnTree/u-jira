import React, {Component} from 'react';
import {matchPath} from "react-router-dom";
import axios from "axios";
import {Col, Row} from "reactstrap"
import Button from "reactstrap/es/Button";
import DownloadFile from "./DownloadFile";
import Label from "reactstrap/es/Label";
import Input from "reactstrap/es/Input";

class Task extends Component {

    state = {
        project: null,
        task: null,
        status: "",
        attachments: []
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


    loadAttach = (id) => {
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
        const match = matchPath(window.location.pathname, {path: '/home/:idGroup/:idProject/:idTask'});
        const idGen = match.params;
        if (!this.state.project) {
            this.loadProject(idGen.idProject)
            return null
        }
        if (!this.state.task) {
            this.loadTasks(idGen.idTask)
            return null
        }
        const {id, name, description, dataCreated} = this.state.task
        console.log(this.state.task);
        return (
            <div>
                <Row className="border-bottom">
                    <Col className="border-right">
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
                <div className="h3">
                    <div>
                        <Label>Data created: </Label>
                        <Input disabled={true} type="text" value={this.state.task.dataCreated}/>
                    </div>
                    <div>
                        <Label>Data deadline: </Label>
                        <Input disabled={true} type="text" value={this.state.task.dataDeadline}/>
                    </div>
                    <div>
                        <Label>You last changed</Label>
                        <Input disabled={true} type="text" value={this.state.task.dataChanged}/>
                    </div>
                </div>
                <div>
                    <h2>Attachment: </h2>
                    <div className="border">

                    </div>
                </div>
                <div className="m-2 p-2 float-right">
                    <Button disabled={this.state.task.status !== 3} className="mx-3 btn-danger"
                            onClick={(e) => this.changeStatus(2)}>Return</Button>
                    <Button disabled={this.state.task.status !== 3} className="mx-3 btn-success"
                            onClick={(e) => this.changeStatus(4)}>Close Task</Button>
                </div>
                {/*<DownloadFile/>*/}
            </div>
        );
    }
}

export default Task;
