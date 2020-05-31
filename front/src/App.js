import React, {Component} from 'react';
import {Router} from "react-router-dom";
import {Provider} from "react-redux"
import store from './redux/store/index'
import RouteComponent from './component/route/RouteComponent';
import history from './history'

class App extends Component {
    render() {
        return (
            <Router history={history}>
                <Provider store={store}>
                    <RouteComponent/>
                </Provider>
            </Router>
        );
    }
}

export default App;
