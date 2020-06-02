const api = "http://localhost:8080/api"

export const fetchTask = (projectId, taskId) =>
    fetch(`${api}/project/${projectId}/task/${taskId}`, {})
        .then(response => response.json())


export const fetchProject = (id) =>
    fetch(`${api}/project/${id}`, {})
        .then(response => response.json())

export const fetchTasksForProject = (projectId) =>
    fetch(`${api}/project/${projectId}/task`, {})
        .then(response => response.json())

export const fetchAuth = (auth, role) => {
    return fetch(`${api}/auth?role=${role}`, {
        method: 'POST',
        body: JSON.stringify(auth),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (response.ok) return response.json()
            throw new Error("всё плохо")
        })
}

export const fetchProjectsForStudent = (studentId) => {
    return fetch(`${api}/project/studentTable?student=${studentId}`, {})
        .then(response => response.json())
}