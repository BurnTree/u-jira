import React, {Component} from 'react';
import {DCell_4_8, DCell_6_6, DHeader} from "../components";

class Description extends Component {
    render() {
        const {name, description, status, created, deadline, changed} = this.props;
        return (
            <div>
                <DHeader name={name}/>
                <DCell_4_8 title="Описание:" body={description}/>
                <DCell_6_6 title="Статус:" body={_.get(status, "name")}/>
                <DCell_6_6 title="Дата создания:" body={created}/>
                <DCell_6_6 title="Дата сдачи:" body={deadline}/>
                <DCell_6_6 title="Изменен:" body={changed}/>
            </div>
        );
    }
}

export default Description;
