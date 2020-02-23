import React, {Component} from 'react';
import {NavLink} from "react-router-dom";
import {Button} from "reactstrap";
import history from "../../../history";
import axios from "axios";

class RowTask extends Component {

    state = {
        status: ""
    }

    loadStatus = (id) => {
        axios.get('http://localhost:8080/api/task/status', {params: {id}})
            .then(res => this.setState({status: res.data}))
            .catch(error => console.log('error: ', error))
    }

    onClick(path) {
        history.push(path)
    }

    render() {
        const {id, name, description, status} = this.props.task;
        if(this.state.status === "")this.loadStatus(status);
        return (
            <tr onClick={()=>this.onClick(this.props.path)}>
                <td>{name}</td>
                <td>{description}</td>
                <td>{this.state.status}</td>
                <td><NavLink to={this.props.path}>
                    <button className={(this.props.task.status === 3)?" btn btn-success":"btn btn-secondary"}>
                        Go to task
                    </button>
                </NavLink></td>
            </tr>
        );
    }
}

export default RowTask;
