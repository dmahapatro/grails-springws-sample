class EndpointInterceptors{

    def getReservationValidator
    def listReservationValidator
    def updateReservationValidator
    def cancelReservationValidator

    def interceptors = {
        getReservationValidate(endpoint:'getReservation', interceptors: [getReservationValidator], validation)
        listReservationValidate(endpoint:'listReservation', interceptors: [listReservationValidator], validation)
        updateReservationValidate(endpoint:'updateReservation', interceptors: [updateReservationValidator], validation)
        cancelReservationValidate(endpoint:'cancelReservation', interceptors: [cancelReservationValidator], validation)
    }

    def validation = {
        handleRequest = {messageContext, endpoint ->
            return true
        }
        handleResponse = {messageContext, endpoint ->
            return true
        }

        handleFault = {messageContext, endpoint ->
            return true
        }
    }
}