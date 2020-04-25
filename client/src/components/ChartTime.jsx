import React from "react"

class ChartTime extends React.PureComponent {
  render() {
    const { date } = this.props
    return <div className="col-1 time">{date}</div>
  }
}

export default ChartTime
