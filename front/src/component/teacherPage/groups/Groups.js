import React, {Component} from 'react';
import axios from 'axios';
import {connect} from "react-redux";
import {Col, Container, Row} from "reactstrap";
import GroupItem from "./GroupItem";

class Groups extends Component {
    constructor(props) {
        super(props);
        this.state = {
            groups: null
        }
    }

    loadGroups = () => {
        axios.get('http://localhost:8080/api/group/teacher', {params: {id: this.props.user.id}})
            .then(res => this.setState({groups: res.data}))
            .catch(error => console.log('error: ', error))

    }

    render() {
        if (!this.state.groups && this.props.user.id) this.loadGroups()
        if (!this.state.groups) return null
        console.log(this.state.groups)
        const columns = this.state.groups.map((group) => <Col xs="4" className="p-5">
            <GroupItem group={group}/>
        </Col>)
        return (
            <div>
                <Container>
                    <Row>
                        {columns}
                    </Row>
                </Container>
            </div>
        );
    }
}

export default connect((state) => ({user: state.user}))(Groups);
