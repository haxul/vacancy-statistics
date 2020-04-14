import React from "react"

class Date extends React.PureComponent {
  render() {
    return (
      <div className="wrapper-date">
        <div className="input-group mb-3 date ">
          <input
            type="text"
            style={{ display: "block" }}
            className="form-control"
            placeholder="Recipient's username"
            aria-label="Recipient's username"
            aria-describedby="basic-addon2"
          />
          <div className="input-group-append">
            <button className="btn btn-outline-secondary" type="button">
              Найти
            </button>
          </div>
        </div>
      </div>
    )
  }
}

export default Date
