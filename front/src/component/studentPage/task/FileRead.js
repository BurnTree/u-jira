import React from 'react';

function FileRead(props) {

    let fileReader;

    const handleFileRead = (e) => {
        const content = fileReader.result
    }

    const handleFileChosen = (file) => {
        fileReader = new FileReader();
        fileReader.onloadend = handleFileRead;
        fileReader.readAsText(file);
    }

    return (
        <div>
            <input type="file" id="file" onChange={e => {
                handleFileChosen(e.target.files[0])
            }}/>
        </div>
    );
}

export default FileRead;
