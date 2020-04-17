import React from "react"
import logo from "../icons/logo.png"
class Header extends React.PureComponent {
  render() {
    return (
      <nav className="navbar navbar-light bg-light">
        <a className="navbar-brand" href="/">
          <img src={logo} width="80" height="80" alt="" />
        </a>
      </nav>
    )
  }
}

export default Header
