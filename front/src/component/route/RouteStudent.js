import React, {Component} from 'react';
import {Route, Switch} from "react-router-dom";
import Project from "../studentPage/project/Project";
import Teachers from "../studentPage/teachersSubject/teachers"
import Task from "../studentPage/task/Task";
import Header from "../home";

class RouteStudent extends Component {
    render() {
        return (
            <div>
                <Switch>
                    <Route path="/home/:idProject/:idTask">
                        <Task/>
                    </Route>
                    <Route path="/home/:idProject">
                        <Project/>
                    </Route>
                    <Route path="/home">
                        <Teachers/>
                    </Route>
                </Switch>
            </div>
        );
    }
}

export default RouteStudent;
