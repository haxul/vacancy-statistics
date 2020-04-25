import React from "react"

class Chart extends React.PureComponent {

    computeColumnHeight = (maxHeight, count) => (500 * count) / maxHeight

    render() {
        const {count, max} = this.props
        const height = this.computeColumnHeight(max, count)
        return (
            <div className="col-1 chart" style={{height: `${height > 25 ? height : 25}px`}}>
                {count}
            </div>
        )
    }
}

export default Chart
