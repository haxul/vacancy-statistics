import React from "react"

class Cities extends React.PureComponent {
  render() {
    return (
      <div className="cities">
        <button type="button" className="btn btn-secondary">
          Самара
        </button>
        <button type="button" disabled className="btn btn-secondary">
          Санкт-Петербург
        </button>
        <button type="button" disabled className="btn btn-secondary">
          Москва
        </button>
      </div>
    )
  }
}

export default Cities
