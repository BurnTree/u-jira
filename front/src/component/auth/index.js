import React, {Component} from 'react';
import {connect} from "react-redux";

import {STUDENT, TEACHER} from "../../helpers";
import {authentication} from "../../redux/AC/general";

class Auth extends Component {

    constructor(props) {
        super(props);
        this.state = {
            login: '',
            password: '',
            role: TEACHER
        }
    }

    changeRole = (role) => {
        this.setState({role})
    }

    changeLogin = (login) => {
        this.setState({login})
    }

    changePassword = (password) => {
        this.setState({password})
    }

    sendData = (e) => {
        e.preventDefault()
        const {login, password, role} = this.state
        this.props.auth(login, password, role)
    }

    render() {
        const {role} = this.state;
        return (
            <div>
                <div className="auth">
                    <h2 className="mb-4 text-center">Авторизация</h2>
                    <div className="row mb-3">
                        <div className="col pr-0">
                            <button className={`float-right choiceElement px-5 ${role===TEACHER ? `activeElement` : ``}`} onClick={ev => this.changeRole(TEACHER)}>Препод</button>
                        </div>
                        <div className="col pl-0">
                            <button className={`float-left choiceElement px-5 ${role===STUDENT ? `activeElement` : ``}`} onClick={ev => this.changeRole(STUDENT)}>Студент</button>
                        </div>
                    </div>
                    <input type="text" className="mb-3" onChange={(e) => this.changeLogin(e.target.value)}
                           name="login" id="login" placeholder="Логин"/>
                    <input type="password" className="mb-3" onChange={(e) => this.changePassword(e.target.value)}
                           name="password" id="password" placeholder="Пароль"/>
                    <button className="submitButton" onClick={(e) => this.sendData(e)}>Войти</button>
                </div>
            </div>
        );
    }
}

const mapDispatchToProps = (dispatch, ownProps) => ({auth: (login, psw, role) => dispatch(authentication(login, psw, role, ownProps.history.push))})

export default connect((state) => ({user: state}), mapDispatchToProps)(Auth);
