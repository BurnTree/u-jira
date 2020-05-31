import {LOAD_PROJECT, LOAD_PROJECTS_TASK} from "../acConstant";
import {fetchProject, fetchTasksForProject} from "./callApi";

export const writeProject = (project) => ({
    type: LOAD_PROJECT,
    payload: {project}
})

export const writeTasksInProject = (tasks) => ({
    type: LOAD_PROJECTS_TASK,
    payload: {tasks}
})

export const loadProject = (id) => dispatch => {
    fetchProject(id)
        .then(project => dispatch(writeProject(project)))
}

export const loadTasks = (projectId) => dispatch => {
    fetchTasksForProject(projectId)
        .then(tasks => dispatch(writeTasksInProject(tasks)))
}