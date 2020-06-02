import React, {Component} from 'react';
import {connect} from "react-redux";
import {withRouter} from 'react-router-dom'
import {logout} from "../../redux/AC/user";

class Header extends Component {

    componentDidMount() {
        const {user} = this.props;
        if (!user.isAuth) this.props.logout()
    }

    render() {
        const {user} = this.props;
        const {pathname} = this.props.history.location;
        return (pathname === "/auth") ? null :
            <div className="row mb-5">
                <div className="col-4">

                </div>
                <div className="col-1">
                    <img width="100px" height="100px"
                         src="https://cdn2.iconfinder.com/data/icons/user-icon-2-1/100/user_5-15-512.png"
                         alt="user"/>
                </div>
                <div className="col-4 py-2">
                    <h3>{user.name}</h3>
                    <h4>{user.role}</h4>
                </div>
                <div className="col-3">
                    <button className="greenButton" onClick={() => this.props.logout()}>Выход</button>
                </div>
            </div>
    }
}

const mapDispatchToProps = (dispatch, ownProps) =>
    ({logout: () => dispatch(logout(ownProps.history.push))})

export default withRouter(connect((state) => ({user: state.user}), mapDispatchToProps)(Header));
