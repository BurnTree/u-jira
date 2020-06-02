import React, {Component} from 'react';

class Description extends Component {
    render() {
        const {name, desc, status, created, deadline, changed} = this.props;
        return (
            <div>
                <div className="headerDesc">{name}</div>
                <div className="cellDesc row">
                    <div className="col-4"><strong>Описание:</strong></div>
                    <div className="col-8">{desc}</div>
                </div>
                <div className="cellDesc row">
                    <div className="col"><strong>Статус:</strong></div>
                    <div className="col">{status}</div>
                </div>
                <div className="cellDesc row">
                    <div className="col"><strong>Дата создания:</strong></div>
                    <div className="col">{created}</div>
                </div>
                <div className="cellDesc row">
                    <div className="col"><strong>Дата сдачи:</strong></div>
                    <div className="col">{deadline}</div>
                </div>
                <div className="cellDesc row">
                    <div className="col"><strong>Изменен</strong></div>
                    <div className="col">{changed}</div>
                </div>
            </div>
        );
    }
}

export default Description;