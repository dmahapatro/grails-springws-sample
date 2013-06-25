// Place your Spring DSL code here
beans = {
    getReservationValidator(org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor){
        schemas = '/xsds/reservation/GetReservation.xsd'
        validateRequest= true
        validateResponse= true
    }

    listReservationValidator(org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor){
        schema= '/xsds/reservation/ListReservations.xsd'
        validateRequest= true
        validateResponse= true
    }

    updateReservationValidator(org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor){
        schema= '/xsds/reservation/UpdateReservation.xsd'
        validateRequest= true
        validateResponse= true
    }

    cancelReservationValidator(org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor){
        schema= '/xsds/reservation/CancelReservation.xsd'
        validateRequest= true
        validateResponse= true
    }
}
