import React from 'react';
import axios from "axios";

class DownloadFile extends React.Component {

    constructor(props) {
        super(props);
    }

    // downloadEmployeeData = () => {
    //     axios.get('http://localhost:8080/attachment/get?id=1')
    //         .then(response => {
    //             console.log(response.data)
    //             response.file.blob().then(blob => {
    //                 console.log(blob)
                    // let url = window.URL.createObjectURL(blob);
                    // let a = document.createElement('a');
                    // a.href = url;
                    // a.download = 'employees.json';
                    // a.click();
                // });
                //window.location.href = response.url;
            // });
    // }

    render() {
        axios.get('http://localhost:8080/api/attachment/get?id=1')
            .then(response => {
                const blob = response.data.file;
                let url = window.URL.createObjectURL(new File[blob]);
                let a = document.createElement('a');
                a.href = url;
                a.download = 'employees.json';
                a.click();
                // response.data.file.blob().then(blob => {
                //     console.log(blob)})
            })
        return (
            <div id="container">
                <h1>Download File using React App</h1>
                <h3>Download Employee Data using Button</h3>
                {/*<button onClick={this.downloadEmployeeData}>Download</button>*/}
                {/*<p/>*/}
                {/*<h3>Download Employee Data using Link</h3>*/}
                {/*<a href="#" onClick={this.downloadEmployeeData}>Download</a>*/}
            </div>
        )
    }

}

export default DownloadFile;
