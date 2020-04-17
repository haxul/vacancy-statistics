import React from "react"

class Date extends React.PureComponent {
  handleDate = (e) => {
    this.props.updateDateApp(e.target.value)
  }

  render() {
    return (
      <input
        type="date"
        style={{ display: "block" }}
        className="form-control"
        placeholder="Введите дату"
        onChange={this.handleDate}
      />
    )
  }
}

export default Date
