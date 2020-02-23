import {LOGOUT, WRITE_USER} from "../acConstant";

const defaultUser = {
    id: '',
    name: '',
    role: ''
}

function user(user = defaultUser, action) {
    const {type, payload} = action;

    switch (type) {
        case WRITE_USER:
            return {id: payload.id, name: payload.name, role: payload.role};
        case LOGOUT:
            return {...defaultUser}
        default:
            return user;
    }
}

export default user
