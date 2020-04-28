import React from "react"

class NoPickCityOrPositionPopup extends React.PureComponent {

    render() {
        return (
            <div className="modal fade" id="NoPickCityOrPositionPopup" tabIndex="-1" role="dialog"
                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div className="modal-dialog modal-dialog-centered" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="exampleModalLongTitle">Инфо</h5>
                            <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div className="modal-body">
                            Выберите город и вакансию
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-dismiss="modal">Ok</button>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default NoPickCityOrPositionPopup
