import {LOAD_ALL_PROJECT} from "../acConstant";


function projectsReducer(projects = [], action) {
    const {type, payload} = action;
    switch (type) {
        case LOAD_ALL_PROJECT:
            return {...projects, ...payload.projects};
        default:
            return projects;
    }
}

export default projectsReducer