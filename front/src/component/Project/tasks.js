import React, {Component} from 'react';
import {NumTable} from "../components";
import {withRouter} from "react-router";

class Tasks extends Component {

    transferTasksForTable = (tasks) => {
        return _.map(tasks, (task)=> ({
            id: task.id.taskId,
            name: task.name,
            status: _.get(task, "status.name")
        }))
    }

    goToTask = (taskId) => {
        this.props.history.push(`/project_${this.props.projectId}/task_${taskId}`)
    }

    render() {
        const tableHeader = ["№", "Имя", "Статус"]
        const tableBody = this.transferTasksForTable(this.props.tasks)
        return (
            <div>
                <h2>Задания</h2>
                <NumTable head={tableHeader} body={tableBody} goto={this.goToTask}/>
            </div>
        );
    }
}

export default withRouter(Tasks);