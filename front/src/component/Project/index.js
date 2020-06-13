import React, {Component} from 'react';
import {connect} from "react-redux"
import {loadProject, loadTasks} from "../../redux/AC/project";
import _ from 'lodash'
import Description from "./description";
import Tasks from "./tasks";

class Project extends Component {

    componentDidMount() {
        this.props.loadProject()
        this.props.loadTasks()
    }

    render() {
        const {id, name , description, status, created, deadline, changed, tasks} = this.props.project;
        return (
            <div className="row">
                <div className="col-6">
                    <Description name={name}
                                 description={description}
                                 status={status.name}
                                 created={created}
                                 deadline={deadline}
                                 changed={changed}
                    />
                </div>
                <div className="col-6">
                    <Tasks projectId={id} tasks={tasks}/>
                </div>
            </div>
        );
    }
}

const mapDispatchToProps = (dispatch, ownProps) => ({
    loadProject: () => dispatch(loadProject(ownProps.match.params.idProject)),
    loadTasks: () => dispatch(loadTasks(ownProps.match.params.idProject))
})

export default connect(({project}) => ({project}), mapDispatchToProps)(Project);