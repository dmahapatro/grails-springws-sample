package com.example

import org.codehaus.groovy.grails.plugins.spring.ws.EndpointFunctionalTestCase

class ReservationTests extends EndpointFunctionalTestCase {
    def serviceURL = "http://localhost:8080/grails-springws-sample/services"
    def namespace = "http://example.com/reservationService"

    void setUp(){
        super.setUp()
        webServiceTemplate.setDefaultUri(serviceURL)
    }

    /**
     * Since this is an integration test, the below test would need the instance
     * of the application running in localhost:8080
     */
    void testGetReservationService() {
        def result = withEndpointRequest(serviceURL) {
            GetReservationRequest(xmlns: namespace){
                ReservationId(1)
            }
        }

        assert result
        assert result.Reservation.ReservationId == 1
        assert result.Reservation.Departure == "JFK"
    }
}
