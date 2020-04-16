import React from "react"

class Cities extends React.PureComponent {
  state = {
    buttons: [
      { city: "Самара", isPicked: false },
      { city: "Москва", isPicked: false },
      { city: "Санкт-Петербург", isPicked: false },
    ],
    currentCity: null,
  }

  handleCity = (e) => {
    const { buttons } = this.state
    const updatedButtons = buttons.map((button) => {
      if (button.city === e.target.innerText) {
        button.isPicked = true
        this.setState({ currentCity: button.city })
        this.props.updateCityApp(button.city)
        return button
      }
      button.isPicked = false
      return button
    })
    this.setState({ buttons: updatedButtons })
  }

  render() {
    const { buttons } = this.state
    const buttonsList = buttons.map((b, i) => (
      <button
        type="button"
        disabled={b.isPicked}
        onClick={this.handleCity}
        key={i}
        className="btn btn-secondary"
      >
        {b.city}
      </button>
    ))
    return (
      <div className="cities">
        <p>Выберите город: </p>
        {buttonsList}
      </div>
    )
  }
}

export default Cities
