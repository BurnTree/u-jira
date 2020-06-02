import React, {Component} from 'react';
import {Route} from "react-router-dom";
import Groups from "./Groups"
import Projects from "./Projects";
import Subjects from "./Subjects";

class TeacherRoute extends Component {
    render() {
        return (
            <React.Fragment>
                <Route path="/subjects" component={Subjects}/>
                <Route path="/subject_:idSubject" component={Groups}/>
                <Route path="/subject_:idSubject/group_:idGroup" component={Projects}/>
            </React.Fragment>
        );
    }
}

export default TeacherRoute;