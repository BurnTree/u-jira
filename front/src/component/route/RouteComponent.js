import React, {Component} from 'react';
import {Redirect, Route, Switch} from "react-router-dom";
import {connect} from "react-redux";
import Home from "../home";
import NotFound from "../NotFound";
import {Auth, Project, Task} from "../components";
import Header from "../header/Header";
import {STUDENT, TEACHER} from "../../helpers";
import StudentRoute from "../studentRouting";
import TeacherRoute from "../teacherRouting";

class RouteComponent extends Component {

    render() {
        return (
            <div className="container pt-5">
                <Header/>
                <Switch>
                    <Route path="/project_:idProject/task_:idTask" component={Task}/>
                    <Route path="/project_:idProject" component={Project}/>
                    {/*<Route path="/home" component={Home}/>*/}
                    <Route path="/auth" component={Auth}/>
                    <Redirect from="/" to="/subjects" exact/>
                    {this.getRouteFromRole()}
                    <Route path="*" component={NotFound}/>
                </Switch>
            </div>
        );
    }

    getRouteFromRole() {
        const {role} = this.props.user;
        if (role === STUDENT) {
            return <StudentRoute/>
        } else if (role === TEACHER) {
            return <TeacherRoute/>
        }
    }
}


export default connect((state) => ({user: state.user}), {})(RouteComponent);
