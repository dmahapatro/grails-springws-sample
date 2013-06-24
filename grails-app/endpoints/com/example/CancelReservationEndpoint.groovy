package com.example

class CancelReservationEndpoint {

    def static namespace = "http://example.com/reservationService"
	
	def invoke = { request, response ->

        //Parse request
        Long reservationId = request.ReservationId?.text()?.toLong()

        def reservation = Reservation.get(reservationId)
        if(reservation){
            Reservation.withTransaction {
                reservation.delete(flush: true)
            }
            setSuccessResponse(response)
        } else {
            setErrorResponse(response)
        }
    }

    def setSuccessResponse(response){
        response.CancelReservationResponse(xmlns: namespace){
            Success("Reservation successfully deleted!!")
        }
    }

    def setErrorResponse(response){
        response.CancelReservationResponse(xmlns: namespace){
            Error("Reservation not found!!!")
        }
    }
}