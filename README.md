**Sample Grails app using springws plugin.**

**Outline**
 1. Use of contract first webservice.
 2. Effective use of latest [springws](https://github.com/dmahapatro/grails-springws) plugin (v 1.0.0)
 3. Use of interceptors.
 4. Used Flight Reservation service as an example.


**Insight on Sample App**

**WSDL**  
`http://localhost:8080/grails-springws-sample/services/ReservationService.wsdl`

**Endpoints**  
grails-app/endpoints  
`GetReservationEndpoint.groovy`  
`UpdateReservationEndpoint.groovy`  
`ListReservationEndpoint.groovy`  
`CancelReservationEndpoint.groovy`  
 
**Integration Test**  
test/integration  
`ReservationTests.groovy`

**SOAPUI**  
soapui  
`springws-sample-soapui-project.xml` - Import this project in SOAPUI to see the test cases for each of the above endpoints.
Each endpoint has three basic test cases:
 - Happy Path
 - Error Path
 - Interceptor in Action

