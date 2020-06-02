import React, {Component} from 'react';
import {Title} from "../../components";
import SubjectTable from "./table";

class Subjects extends Component {
    render() {
        return (
            <div>
                <Title name="Предметы"/>
                <SubjectTable/>
            </div>
        );
    }
}

export default Subjects;