import React from "react"

class Cities extends React.PureComponent {
  render() {
    return (
      <div className="cities">
        <p>Выберите город: </p>
        <button type="button" className="btn btn-secondary">
          Самара
        </button>
        <button type="button" className="btn btn-secondary">
          Санкт-Петербург
        </button>
        <button type="button" className="btn btn-secondary">
          Москва
        </button>
      </div>
    )
  }
}

export default Cities
