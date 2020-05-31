import {LOAD_TASK} from "../acConstant";
import {fetchTask} from "./callApi";

export const writeTask = (task) => ({
    type: LOAD_TASK,
    payload: {task}
})

export const loadTask = (projectId, taskId) => dispatch => {
    fetchTask(projectId, taskId)
        .then(task => {
            dispatch(writeTask(task))
        })
}