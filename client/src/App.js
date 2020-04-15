import React from "react"
import Header from "./components/Header"
import Cities from "./components/Cities"
import Date from "./components/Date"
import Positions from "./components/Positions"
import Chart from "./components/Chart"
import "./App.css"

class App extends React.PureComponent {
  render() {
    return (
      <div className="main">
        <Header />
        <Cities />
        <Positions />
        <Date />
        <div className="charts-wrapper">
          <Chart />
        </div>
      </div>
    )
  }
}

export default App
