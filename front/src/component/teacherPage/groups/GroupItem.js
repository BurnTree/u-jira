import React, {Component} from 'react';
import {NavLink} from "react-router-dom";
import {Button, Col, Container, Row} from "reactstrap";

class GroupItem extends Component {


    render() {
        const {name, id} = this.props.group
        return (
            <NavLink to={"/home/"+id}>
                <Button>
                    <Container className="border">
                        <Row>
                            <Col>
                                <h4>Group: {name}</h4>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                projects: 3
                            </Col>
                        </Row>
                        {/*<Row>*/}
                            {/*<Col>*/}
                                {/*complete*/}
                            {/*</Col>*/}
                            {/*<Col>*/}
                                {/*not complete*/}
                            {/*</Col>*/}
                        {/*</Row>*/}
                    </Container>
                </Button>
            </NavLink>
        );
    }
}

export default GroupItem;
