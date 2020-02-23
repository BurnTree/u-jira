import React, {Component} from 'react';
import {Route, Switch} from "react-router";
import Teachers from "../home";
import Groups from "../teacherPage/groups/Groups";
import StudentList from "../teacherPage/students/StudentList";
import Project from "../teacherPage/project/Project";
import Task from "../teacherPage/task/Task";

class RouteTeacher extends Component {
    render() {
        return (
            <div>
                <Switch>
                    <Route path="/home/:idGroup/:idProject/:idTask">
                        <Task/>
                    </Route>
                    <Route path="/home/:idGroup/:idProject">
                        <Project/>
                    </Route>
                    <Route path="/home/:idGroup">
                        <StudentList/>
                    </Route>
                    <Route path="/home">
                        <Groups/>
                    </Route>
                </Switch>
            </div>
        );
    }
}

export default RouteTeacher;
