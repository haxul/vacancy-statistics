import React from "react"
import Header from "./components/Header.jsx"
import Cities from "./components/Cities.jsx"
import Positions from "./components/Positions.jsx"
import Chart from "./components/Chart.jsx"
import ChartTime from "./components/ChartTime.jsx"
import TimeTermType from "./components/TimeTermType.jsx"
import NoPickCityOrPositionPopup from "./components/popups/NoPickCityOrPositionPopup.jsx"
import {getPort, getHost} from "./configuration/configs"

import "./App.css"

class App extends React.PureComponent {

    constructor(props) {
        super(props);
        this.runButton = React.createRef();
    }


    state = {
        city: null,
        position: null,
        timeType: "WEEK",
        statsList: []
    }

    updateTimeType = (timeType) => {
        this.setState({timeType})
    }
    updatePosition = (position) => {
        this.setState({position})
    }

    updateCity = (city) => {
        this.setState({city})
    }

    throwNoPickCityOrPositionPopup = () => {
        this.runButton.current.dataset.target="#NoPickCityOrPositionPopup"
        this.runButton.current.click()
        this.runButton.current.removeAttribute("data-target")
    }

    getStatistic = async () => {
        const {city, position, timeType} = this.state
        if (!city || !position) {
            this.throwNoPickCityOrPositionPopup()
            return
        }
        const url = `http://${getHost()}:${getPort()}/api/traces/${position}/${city}?timeTypes=${timeType}`
        const response = await fetch(url)
        const body = await response.json()
        if (response.status === 200) this.setState({statsList: body})
    }


    render() {
        const {statsList} = this.state
        const maxColumnHeight = Math.max(...statsList.map((e) => e.count));
        const chartList = statsList.map((elem, index) => <Chart key={index} count={elem.count} max={maxColumnHeight}/>)
        const dateList = statsList.map((elem, index) => <ChartTime key={index} date={elem.date.replace(/-/g, ".")}/>)
        return (
            <div className="main">
                <Header/>
                <Cities updateCityApp={this.updateCity}/>
                <Positions updatePositionApp={this.updatePosition}/>
                <div className="wrapper-date">
                    <div className="input-group mb-3 date ">
                        <TimeTermType updateTimeType={this.updateTimeType}/>
                        <div className="input-group-append">
                            <button
                                ref={this.runButton}
                                data-toggle="modal"
                                className="btn btn-outline-secondary"
                                type="button"
                                onClick={this.getStatistic}
                            >
                                Найти
                            </button>
                        </div>
                    </div>
                </div>

                <div className="charts-wrapper container">
                    <div className="row align-items-end justify-content-around charts">
                        {chartList}
                    </div>
                    <div className="row align-items-end justify-content-around wrapper-times">
                        {dateList}
                    </div>
                </div>
                <NoPickCityOrPositionPopup/>
            </div>
        )
    }
}

export default App
