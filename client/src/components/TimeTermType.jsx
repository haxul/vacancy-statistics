import React from "react";

class TimeTermType extends React.PureComponent {

    handleTimType = (e) => {
        const {updateTimeType} = this.props;
        updateTimeType(e.target.value)
    }

    render() {
        return (
            <select onChange={this.handleTimType} defaultValue={"WEEK"}>
                <option value="DAY">День</option>
                <option value="WEEK" >Неделя</option>
                <option value="MONTH">Месяц</option>
                <option value="YEAR">Год</option>
            </select>
        )
    }
}

export default TimeTermType
