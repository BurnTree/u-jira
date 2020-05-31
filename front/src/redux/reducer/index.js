import { combineReducers } from 'redux'
import user from './user'
import task from './task'
import project from './project'
import { connectRouter } from 'connected-react-router'
import history from '../../history'

const reducers = combineReducers({
    user, task, project,
    router: connectRouter(history)
})

export default reducers
