import React, {Component} from 'react';
import axios from 'axios';
import {connect} from "react-redux";
import {Col, Row, Container} from "reactstrap";
import Item from "./Item";

class Teachers extends Component {
    constructor(props) {
        super(props);
        this.state = {
            projects: null
        }
    }

    loadProject = () => {
        console.log(this.props)
        axios.get('http://localhost:8080/api/project/student', {params: {id: this.props.user.id}})
            .then(res => this.setState({projects: res.data}))
            .catch(error => console.log('error: ', error))

    }

    render() {
        if (!this.state.projects && this.props.user.id) this.loadProject()
        if (!this.state.projects) return null
        const columns = this.state.projects.map((project) => <Col key={project.id} xs="4" className="p-5">
            <Item project={project}/>
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

export default connect((state) => ({user: state.user}))(Teachers);
