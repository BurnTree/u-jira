import {AUTH_STUDENT} from "../acConstant";

export function authUser(login, pass) {
    return {
        type: AUTH_STUDENT,
        payload: {
            login,
            pass
        }
    }
}
