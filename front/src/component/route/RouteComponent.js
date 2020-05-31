import React, {Component} from 'react';
import {Redirect, Route, Switch} from "react-router-dom";
import {connect} from "react-redux";
import Home from "../home";
import NotFound from "../NotFound";
import {Auth, Project, Task} from "../index";
import Header from "../header/Header";

class RouteComponent extends Component {

    render() {
        return (
            <div>
                <Header/>
                <Switch>
                    <Route path="/subject/all"/>
                    <Route path="/subject_:idSubject/group_:idGroup"/>
                    <Route path="/project_:idProject/task_:idTask" component={Task}/>
                    <Route path="/project_:idProject" component={Project}/>
                    <Route path="/home" component={Home}/>
                    <Route path="/auth" component={Auth}/>
                    <Redirect from="/" to="/home"/>
                    <Route path="*" component={NotFound}/>
                </Switch>
            </div>
        );
    }
}


export default connect((state) => ({user: state.user}), {})(RouteComponent);
