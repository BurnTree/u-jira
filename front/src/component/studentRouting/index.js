import React, {Component} from 'react';
import {Route} from "react-router-dom";
import Subjects from "./Subjects";

class StudentRoute extends Component {
    render() {
        return (
            <React.Fragment>
                <Route path="/subjects" component={Subjects}/>
            </React.Fragment>
        );
    }
}

export default StudentRoute;