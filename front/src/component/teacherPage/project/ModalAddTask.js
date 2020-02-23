import React, {Component} from 'react';
import {Modal, ModalBody, ModalFooter, ModalHeader, Button, Form, FormGroup, Input} from 'reactstrap'
import Label from "reactstrap/es/Label";
import axios from "axios"

class ModalAddTask extends Component {

    createNewTask = (ev) => {
        ev.preventDefault();
        const task = {
            name: this.name.value,
            description: this.description.value,
            project: this.props.project,
            data_deadline: this.deadline.value,
            status: 1
        }
        console.log(task)
        axios.post('http://localhost:8080/api/task/add', task)
            .then(res => this.props.toggle())
            .catch(error => console.log('error: ', error))
    }

    render() {
        const {modal, toggle} = this.props
        return (
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader toggle={toggle}>New task</ModalHeader>
                <ModalBody>
                    <Form>
                        <FormGroup>
                            <Label for="name">Name</Label>
                            <Input innerRef={ref => this.name = ref} type="text" name="name" id="name"
                                   placeholder="Name"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="description">Description</Label>
                            <Input innerRef={ref => this.description = ref} type="text" name="description"
                                   id="description" placeholder="Description"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="deadline">Deadline</Label>
                            <Input innerRef={ref => this.deadline = ref} type="date" name="deadline" id="deadline"
                                   placeholder="Deadline"/>
                        </FormGroup>
                        <Button onClick={ev => this.createNewTask(ev)}>Create</Button>
                    </Form>
                </ModalBody>
                < ModalFooter>
                </ModalFooter>
            </Modal>
        );
    }
}

export default ModalAddTask;
