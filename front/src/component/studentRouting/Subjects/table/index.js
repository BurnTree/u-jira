import React, {Component} from 'react';
import ObjectsTable from "../../../details/tables/ObjectsTable";
import {connect} from "react-redux";
import {loadProjectsTableForStudent} from "../../../../redux/AC/projects";
import {withRouter} from 'react-router-dom'
import {transfer} from "../../../../redux/AC/general";

class SubjectTable extends Component {

    constructor(props) {
        super(props)
        this.state = {
            allLoaded: false
        }
    }

    componentDidMount() {
        const {user} = this.props;
        this.props.loadTable(user.id)
        this.setState({allLoaded: true})
    }

    goToProject = (projectId) => {
        this.props.transfer(`/project_${projectId}`)
    }

    render() {
        const tableHeader = ["#", "Название", "Преподаватель", "Предмет", "Задачи"]
        return this.state.allLoaded ? (
            <div>
                <ObjectsTable head={tableHeader} body={this.props.projects} goto={this.goToProject}/>
            </div>
        ) : null
    }
}


const mapDispatchToProps = (dispatch, ownProps) => ({
    loadTable: (id) => dispatch(loadProjectsTableForStudent(id)),
    transfer: (path) => dispatch(transfer(ownProps.history.push, path))
})

const mapStateToProps = ({user, projects}) => ({
    user,
    projects
})

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(SubjectTable));