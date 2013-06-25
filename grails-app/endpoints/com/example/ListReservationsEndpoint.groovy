package com.example

class ListReservationsEndpoint {

    def static namespace = "http://example.com/reservationService"
    def static final ZULU_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
	
	def invoke = { request, response ->
        response.ListReservationsResponse(xmlns: namespace){
            Reservation.all?.each{reservation->
                Reservation{
                    ReservationId(reservation.id)
                    Departure(reservation.departure)
                    Arrival(reservation.arrival)
                    DepartureTime(reservation.departureTime.format(ZULU_DATE_FORMAT))
                    NoOfPassengers(reservation.noOfPassengers)
                }
            }
        }
    }
}