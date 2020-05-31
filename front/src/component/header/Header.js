import React, {Component} from 'react';
import {Button, Media} from 'reactstrap'
import {connect} from "react-redux";
import {logout} from "../../redux/AC/user";
import {withRouter} from 'react-router'

class Header extends Component {
    logout = () => {
        this.props.logout();
        this.props.history.push('/auth')
    }

    render() {
        const {user} = this.props;
        const {pathname} = this.props.history.location;
        return (pathname === "/auth") ? null :
            <Media className="border-bottom">
                <Media left>
                    <img width="100px" height="100px"
                         src="https://cdn2.iconfinder.com/data/icons/user-icon-2-1/100/user_5-15-512.png"
                         alt="user"/>
                </Media>
                <Media body>
                    <h3>{user.name}</h3>
                    <h3>{user.role}</h3>
                </Media>
                <Media right>
                    <Button className="m-4 px-4" onClick={() => this.logout()}>Logout</Button>
                </Media>
            </Media>
    }
}



export default withRouter(connect((state) => ({user: state.user}), {logout})(Header));
