import React from "react"

class Chart extends React.PureComponent {

    constructor(props) {
        super(props)
        this.MAX_COLUMN_HEIGHT = 500
    }


    computeColumnHeight = (maxHeight, count) => (this.MAX_COLUMN_HEIGHT * count) / maxHeight

    render() {
        const {count, max} = this.props
        const height = this.computeColumnHeight(max, count)
        return <div className="col-1 chart" style={{height: `${height > 25 ? height : 25}px`}}>{Math.round(count)}</div>

    }
}

export default Chart
