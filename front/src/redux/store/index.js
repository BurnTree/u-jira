import {createStore} from "redux";
import reducers from '../reducer/index'

const store = createStore(reducers);

window.store = store
export default store
