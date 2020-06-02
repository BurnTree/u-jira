import React, {Component} from 'react';

class ObjectsTable extends Component {

    render() {
        const {head, body, goto} = this.props;
        const thead = _.map(head, (el) => (<th>{el}</th>))
        const tbody = _.map(body, (row) => (
            <tr key={row.id} onClick={e => goto(row.id)}>
                {_.values(row).map(col => <td>{col}</td>)}
            </tr>
        ))
        return (
            <div>
                <table className="table">
                    <thead>
                    <tr>
                        {thead}
                    </tr>
                    </thead>
                    <tbody>
                    {tbody}
                    {/*<tr>*/}
                    {/*    <td>asd</td>*/}
                    {/*    <td>ddd</td>*/}
                    {/*</tr>*/}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default ObjectsTable;