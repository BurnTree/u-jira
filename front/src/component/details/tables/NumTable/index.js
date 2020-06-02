import React, {Component} from 'react';

class NumTable extends Component {
    render() {
        const {head, body, goto} = this.props;
        const thead = _.map(head, (el) => (<th>{el}</th>))
        const tbody = _.map(body, (row) => (
            <tr className="cellDesc" key={row.id} onClick={e => goto(row.id)}>
                {_.values(row).map(col => <td>{col}</td>)}
            </tr>
        ))
        return (
            <div>
                <table className="table">
                    <thead>
                    <tr className="cellDesc">
                        {thead}
                    </tr>
                    </thead>
                    <tbody>
                    {tbody}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default NumTable;