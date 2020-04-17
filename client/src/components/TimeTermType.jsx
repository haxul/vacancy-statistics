import React from "react";

class TimeTermType extends React.PureComponent {

    handleTimType = (e) => {
        const {updateTimeType} = this.props;
        updateTimeType(e.target.value)
    }

    render() {
        return (
            <select onChange={this.handleTimType} defaultValue={"week"}>
                <option value="day">День</option>
                <option value="week" >Неделя</option>
                <option value="month">Месяц</option>
                <option value="year">Год</option>
            </select>
        )
    }
}

export default TimeTermType
