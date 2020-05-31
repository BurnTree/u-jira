import {LOAD_TASK} from "../acConstant";

function taskReducer(task = {}, action) {
    const {type, payload} = action;

    switch (type) {
        case LOAD_TASK: return payload.task;
        default: return task;
    }
}

export default taskReducer