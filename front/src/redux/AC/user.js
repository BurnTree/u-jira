import {LOGOUT} from "../acConstant";

export function out() {
    return {
        type: LOGOUT
    }
}

export const logout = (push) => dispatch => {
    push('/auth')
    dispatch(out())
}
