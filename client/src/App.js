import React from "react"
import Header from "./components/Header.jsx"
import Cities from "./components/Cities.jsx"
import Date from "./components/Date.jsx"
import Positions from "./components/Positions.jsx"
import Chart from "./components/Chart.jsx"
import ChartTime from "./components/ChartTime.jsx"
import TimeTermType from "./components/TimeTermType.jsx"

import "./App.css"

class App extends React.PureComponent {
  state = {
    city: null,
    position: null,
    date: null,
    timeType: "week"
  }

  updateTimeType = (timeType) => {
    this.setState({timeType})
  }
  updateDate = (date) => {
    this.setState({ date })
  }

  updatePosition = (position) => {
    this.setState({ position })
  }

  updateCity = (city) => {
    this.setState({ city })
  }

  sendInfoToFindStatistic = () => {
    const { city, position, date } = this.state
  }

  render() {
    return (
      <div className="main">
        <Header />
        <Cities updateCityApp={this.updateCity} />
        <Positions updatePositionApp={this.updatePosition} />
        <div className="wrapper-date">
          <div className="input-group mb-3 date ">
            <Date updateDateApp={this.updateDate} />
            <TimeTermType updateTimeType={this.updateTimeType}/>
            <div className="input-group-append">
              <button
                className="btn btn-outline-secondary"
                type="button"
                onClick={this.sendInfoToFindStatistic}
              >
                Найти
              </button>
            </div>
          </div>
        </div>

        <div className="charts-wrapper container">
          <div className="row align-items-end justify-content-around charts">
            <Chart height={100} count={10} />
            <Chart height={250} count={10} />
            <Chart height={300} count={10} />
            <Chart height={400} count={10} />
            <Chart height={300} count={10} />
            <Chart height={450} count={10} />
            <Chart height={280} count={10} />
            <Chart height={100} count={10} />
            <Chart height={100} count={10} />
            <Chart height={100} count={10} />
          </div>
          <div className="row align-items-end justify-content-around wrapper-times">
            <ChartTime date={"01.12.1941"} />
            <ChartTime date={"01.12.1941"} />
            <ChartTime date={"01.12.1941"} />
            <ChartTime date={"01.12.1941"} />
            <ChartTime date={"01.12.1941"} />
            <ChartTime date={"01.12.1941"} />
            <ChartTime date={"01.12.1941"} />
            <ChartTime date={"01.12.1941"} />
            <ChartTime date={"01.12.1941"} />
            <ChartTime date={"01.12.1941"} />
          </div>
        </div>
      </div>
    )
  }
}

export default App
