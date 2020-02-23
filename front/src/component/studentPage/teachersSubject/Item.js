import React, {Component} from 'react';
import Form from "reactstrap/es/Form";
import {Col, Row, Container, Button} from "reactstrap";
import {Link, NavLink} from "react-router-dom";
import axios from 'axios';
import history from '../../../history'

class Item extends Component {

    state = {
        teacher: ''
    }

    getTeacher = (id) => {
        axios.get('http://localhost:8080/api/teacher/get', {params: {id}})
            .then(res => {
                this.setState({teacher: res.data})
            })
    }

    render() {
        const {name, deadline, id} = this.props.project
        console.log('pro', this.getTeacher(id))
        return (
            <NavLink to={"/home/" + id}>
                <Button>
                    <Container className="border">
                        <Row>
                            <Col>
                                Project: {name}
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                Teacher: {this.state.teacher.name}
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                deadline: {deadline}
                            </Col>
                            <Col>
                                Status:    In_process
                            </Col>
                        </Row>
                    </Container>
                </Button>
            </NavLink>
        );
    }
}

export default Item;
