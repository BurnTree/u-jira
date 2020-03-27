import React, {Component} from 'react';
import {Button, Form, FormGroup, Label, Input, ModalHeader, ModalBody,} from 'reactstrap';
import Modal from "reactstrap/es/Modal";
import {connect} from "react-redux";
import {withCookies} from "react-cookie";
import {Redirect} from "react-router-dom";

import {STUDENT, TEACHER} from "../../helpers";
import {authUser} from '../../redux/AC/student'
import axios from 'axios';
import history from '../../history';

class Auth extends Component {

    constructor(props) {
        super(props);
        this.state = {
            login: '',
            password: '',
            role: STUDENT
        }
    }

    changeRole = (role) => {
        this.setState({role})
    }

    changeLogin = (login) => {
        this.setState({login})
    }

    changePassword = (password) => {
        this.setState({password})
    }

    sendData = (e) => {
        e.preventDefault()
        let path;
        console.log('role: ', this.state.role)
        if (this.state.role === STUDENT)
            path = 'http://localhost:8080/api/student/auth'
        if (this.state.role === TEACHER)
            path = 'http://localhost:8080/api/teacher/auth'
        axios.get(path,
            {params: {login: this.state.login, pass: this.state.password}})
            .then(res => {
                this.props.cookies.set('user', {id: res.data.id, role: this.state.role}, {path: '/'})
                history.push("/home")
            })
            .catch(err => console.log('error: ', err))
    }

    render() {
        return (
            <div>
                <Modal isOpen={true}>
                    <ModalHeader>Auth</ModalHeader>
                    <ModalBody>
                        <Form>
                            <FormGroup>
                                <Input type="select" name="select" id="exampleSelect"
                                       onChange={(e) => this.changeRole(e.target.value)}>
                                    <option value={STUDENT}>student</option>
                                    <option value={TEACHER}>teacher</option>
                                </Input>
                            </FormGroup>
                            <FormGroup>
                                <Label for="login">Login</Label>
                                <Input type="text" onChange={(e) => this.changeLogin(e.target.value)} name="login"
                                       id="login" placeholder="Login"/>
                            </FormGroup>
                            <FormGroup>
                                <Label for="password">Password</Label>
                                <Input type="password" onChange={(e) => this.changePassword(e.target.value)}
                                       name="password" id="password" placeholder="Password"/>
                            </FormGroup>
                            <Button onClick={(e) => this.sendData(e)}>Submit</Button>
                        </Form>
                    </ModalBody>
                </Modal>
            </div>
        );
    }
}

export default connect((state) => ({user: state.student}), {authUser})(withCookies(Auth));
