import React, {Component} from 'react';
import {connect} from "react-redux"
import {loadProject, loadTasks} from "../../redux/AC/project";
import _ from 'lodash'

class Project extends Component {

    componentDidMount() {
        console.log("did m")
        this.props.loadProject()
        this.props.loadTasks()
    }

    render() {
        const {project} = this.props
        const tasksComponent = _.map(_.get(project, "tasks"), (task) => (<h1>{task.name}</h1>))
        console.log("some", project)
        return (
            <div>
                {tasksComponent}
            </div>
        );
    }
}

// const mapStateToProps = ({user, projects}) => ({
//     user,
//     projects
// })

const mapDispatchToProps = (dispatch, ownProps) => ({
    loadProject: () => dispatch(loadProject(ownProps.match.params.idProject)),
    loadTasks: () => dispatch(loadTasks(ownProps.match.params.idProject))
})

export default connect(({project}) => ({project}), mapDispatchToProps)(Project);