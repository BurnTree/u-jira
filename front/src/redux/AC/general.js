import {fetchAuth} from "./callApi";
import {AUTH} from "../acConstant";

export const writeUser = (user) => ({
    type: AUTH,
    payload: {user}
})

export const authentication = (login, psw, role, push) => dispatch => {
    fetchAuth({login, psw}, role)
        .then(data => {
            console.log(" data " + data)
            dispatch(writeUser(data))
            push("/home")
        })
        .catch(error => {
            console.log("its error" + error)
        })
}