import React, {Component} from 'react';
import {Router} from "react-router-dom";
import {Provider, ReactReduxContext} from "react-redux"
import {CookiesProvider} from 'react-cookie';
import {ConnectedRouter} from "connected-react-router";
import store from './redux/store/index'
import MyRoute from './component/route/MyRoute';
import history from './history'

class App extends Component {
    render() {
        return (
            <CookiesProvider>
                <Router history={history}>
                    <Provider store={store}>
                        <MyRoute/>
                    </Provider>
                </Router>
            </CookiesProvider>
        );
    }
}

export default App;
