import React from "react"

class Positions extends React.PureComponent {
  render() {
    return (
      <div className="positions">
        <button type="button" className="btn btn-secondary">
          Java
        </button>
        <button type="button" disabled className="btn btn-secondary">
          Javascript
        </button>
        <button type="button" disabled className="btn btn-secondary">
          Python
        </button>
      </div>
    )
  }
}

export default Positions
