import {LOGOUT, AUTH} from "../acConstant";

const defaultUser = {
    id: '',
    name: '',
    role: ''
}

function userReducer(user = defaultUser, action) {
    const {type, payload} = action;

    switch (type) {
        case AUTH:
            return {...payload.user};
        case LOGOUT:
            return {...defaultUser}
        default:
            return user;
    }
}

export default userReducer
