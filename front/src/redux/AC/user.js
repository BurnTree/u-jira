import {LOGOUT, WRITE_USER} from "../acConstant";

export function writeUser(id, name, role) {
    return {
        type: WRITE_USER,
        payload: {
            id,
            name,
            role
        }
    }
}

export function logout() {
    return{
        type: LOGOUT
    }
}
