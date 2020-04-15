import React from "react"

class Chart extends React.PureComponent {
  render() {
    const { height, count } = this.props
    return (
      <div className="col-1 chart" style={{ height: `${height}px` }}>
        {count}
      </div>
    )
  }
}

export default Chart
