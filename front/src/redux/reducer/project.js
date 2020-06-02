import {LOAD_PROJECT, LOAD_PROJECTS_TASK} from "../acConstant";

const defaultProject = {
    id: "",
    status: {
        id: "",
        name: ""
    },
    tasks: []
}

function projectReducer(project = defaultProject, action) {
    const {type, payload} = action;
    switch (type) {
        case LOAD_PROJECT:
            return {...project, ...payload.project};
        case LOAD_PROJECTS_TASK:
            return {...project, tasks: payload.tasks};
        default:
            return project;
    }
}

export default projectReducer