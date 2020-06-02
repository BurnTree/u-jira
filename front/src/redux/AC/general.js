import {fetchAuth} from "./callApi";
import {AUTH} from "../acConstant";

export const writeUser = (user) => ({
    type: AUTH,
    payload: {user}
})

export const authentication = (login, psw, role, push) => dispatch => {
    fetchAuth({login, psw}, role)
        .then(data => {
            dispatch(writeUser(data))
            push("/subjects")
        })
        .catch(error => {
            console.log("its error" + error)
        })
}

export const transfer = (call, path) => dispatch => {
    call(path)
}