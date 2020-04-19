import React from "react"

class Chart extends React.PureComponent {
  render() {
    const { count } = this.props
    return (
      <div className="col-1 chart" style={{ height: `${count}px` }}>
        {count}
      </div>
    )
  }
}

export default Chart
