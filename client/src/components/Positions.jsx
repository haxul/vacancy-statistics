import React from "react"

class Positions extends React.PureComponent {
  state = {
    buttons: [
      { position: "Java", isPicked: false },
      { position: "Javascript", isPicked: false },
      { position: "Python", isPicked: false },
    ],
    currentPosition: null,
  }

  handlePosition = (e) => {
    const { buttons } = this.state

    const updatedButtons = buttons.map((button) => {
      if (button.position === e.target.innerText) {
        button.isPicked = true
        this.setState({ currentPosition: button.position })
        this.props.updatePositionApp(button.position)
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
        key={i}
        onClick={this.handlePosition}
        className="btn btn-secondary"
      >
        {b.position}
      </button>
    ))
    return (
      <div className="positions">
        <p>Выберите вакансию:</p>
        {buttonsList}
      </div>
    )
  }
}

export default Positions