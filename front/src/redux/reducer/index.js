import { combineReducers } from 'redux'
import user from './user'
import { connectRouter } from 'connected-react-router'
import history from '../../history'

const reducers = combineReducers({
    user,
    router: connectRouter(history)
})

export default reducers
