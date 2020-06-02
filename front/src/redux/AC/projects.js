import {LOAD_ALL_PROJECT} from "../acConstant";
import {fetchProjectsForStudent} from "./callApi";

export const writeProjects = (projects) => ({
    type: LOAD_ALL_PROJECT,
    payload: {projects}
})

export const loadProjectsTableForStudent = (studentId) => dispatch => {
    fetchProjectsForStudent(studentId)
        .then(projects => dispatch(writeProjects(projects)))
}