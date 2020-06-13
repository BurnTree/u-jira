import React, {Component} from 'react';
import {connect} from "react-redux"
import {loadTask} from "../../redux/AC/task";
import Description from "./description";
import TaskHistory from "./taskHistory";


class Task extends Component {

    componentDidMount() {
        this.props.loadTask()
    }

    render() {
        const {name, description, status, created, deadline, changed} = this.props.task;
        return <div className="row">
            <div className="col">
                <Description name={name}
                             description={description}
                             status={status}
                             created={created}
                             deadline={deadline}
                             changed={changed}/>
            </div>
            <div className="col">
                <TaskHistory/>
            </div>
        </div>
    }
}

const mapDispatchToProps = (dispatch, ownProps) => ({loadTask: () => dispatch(loadTask(ownProps.match.params.idProject, ownProps.match.params.idTask))})


export default connect((state) => ({task: state.task}), mapDispatchToProps)(Task);