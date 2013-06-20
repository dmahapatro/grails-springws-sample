import com.example.Reservation

class BootStrap {

    def init = { servletContext ->
        def reservation1 = new Reservation(departure: 'JFK', arrival: 'DFW', departureTime: new Date(), noOfPassengers: 2)
        def reservation2 = new Reservation(departure: 'HOU', arrival: 'CMH', departureTime: new Date() + 2, noOfPassengers: 3)
        def reservation3 = new Reservation(departure: 'PHX', arrival: 'LAX', departureTime: new Date() + 4, noOfPassengers: 1)
        def reservation4 = new Reservation(departure: 'DEN', arrival: 'LAS', departureTime: new Date() + 5, noOfPassengers: 5)

        [reservation1, reservation2, reservation3, reservation4]*.save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
