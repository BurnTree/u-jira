import React, {Component} from 'react';
import {connect} from "react-redux"
import {loadTask} from "../../redux/AC/task";


class Task extends Component {

    componentDidMount() {
        this.props.loadTask()
    }

    render() {
        return (
            <div>
                <h2>{this.props.task.name} </h2>
            </div>
        );
    }
}

const mapDispatchToProps = (dispatch, ownProps) => ({loadTask: () => dispatch(loadTask(ownProps.match.params.idProject, ownProps.match.params.idTask))})


export default connect((state) => ({task: state.task}), mapDispatchToProps)(Task);