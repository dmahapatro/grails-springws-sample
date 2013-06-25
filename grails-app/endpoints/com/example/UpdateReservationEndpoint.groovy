package com.example

class UpdateReservationEndpoint {
    //Namespace has to match with the targetNamespace from the the schema
    def static namespace = "http://example.com/reservationService"
    def static final ZULU_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
	
	def invoke = { request, response ->
        //Parse the request
        Long reservationId = request.Reservation?.ReservationId?.text()?.toLong()
        def departureAirport = request.Reservation?.Departure?.text()?.toString()
        def arrivalAirport = request.Reservation?.Arrival?.text()?.toString()
        def departureTime = request.Reservation?.DepartureTime?.text()?.toString()
        def noOfPassengers = request.Reservation?.NoOfPassengers?.text()?.toInteger()

        def reservation = Reservation.get(reservationId)

        //Check whether the reservation exists or not
        if(reservation){
            reservation.properties = [departure: departureAirport,
                                      arrival: arrivalAirport,
                                      departureTime: Date.parse(ZULU_DATE_FORMAT, departureTime),
                                      noOfPassengers: noOfPassengers ]
            Reservation.withTransaction {
                reservation.save(flush: true, failOnError: true)
            }
            setSuccessResponse(reservation, response)

        } else {
            setErrorResponse(response)
        }

        return
    }

    def setSuccessResponse(reservation, response){
        response.UpdateReservationResponse(xmlns: namespace){
            Reservation{
                ReservationId(reservation.id)
                Departure(reservation.departure)
                Arrival(reservation.arrival)
                DepartureTime(reservation.departureTime.format(ZULU_DATE_FORMAT))
                NoOfPassengers(reservation.noOfPassengers)
            }
        }
    }

    def setErrorResponse(response){
        response.UpdateReservationResponse(xmlns: namespace){
            Error("Reservation not found!!!")
        }
    }
}