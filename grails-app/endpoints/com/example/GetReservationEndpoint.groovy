package com.example

class GetReservationEndpoint {

    //Namespace has to match with the targetNamespace from the the schema
	def static namespace = "http://example.com/reservationService"

    //Can also me used as method invoke(request, response)
    //Default template for endpoint has closure invoke
	def invoke = { request, response ->
        //Parse the request to get the reservation id
        Long reservationId = request.ReservationId?.text?.toLong()
        def reservation = Reservation.get(reservationId)

        //Markup Builder is used to create the response xml. To make sure the response xml validates against the
        //schema (contract) use the same name of the response element from the schema
        //In this case "GetReservationResponse" is taken from GetReservation.xsd
        response.GetReservationResponse(xmlns: namespace){
            Reservation{
                ReservationId(reservation.id)
                Departure(reservation.departure)
                Arrival(reservation.arrival)
                DepartureTime(reservation.departureTime)
                NoOfPassengers(reservation.noOfPassengers)
            }
        }
    }
}