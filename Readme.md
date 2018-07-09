http://localhost:8080/h2-console/


http://localhost:8080/swagger-ui.html

1. Create : 
HTTP Method: POST, URL: /vehicle 
HTTP Response Status Code: 201 CREATED and 409 CONFLICT 

2. Read : 
HTTP Method: GET, URL: /vehicle/{id} (Fetches article by id) 
HTTP Method: GET, URL: /vehicle (Fetches all articles) 
HTTP Response Status Code: 200 OK 

3. Update : 
HTTP Method: PUT, URL: /vehicle
HTTP Response Status Code: 200 OK 

4. Delete : 
HTTP Method: DELETE, URL: /vehicle/{id} 
HTTP Response Status Code: 204 NO CONTENT 




HttpStatus

200 - OK
201 - Created
204 - No Content

400 - Bad Request
401 - Unauthorized
403 - Forbidden
404 - Not Found
409 - Conflict

500 - Internal Server Error
503 - Service Unavailable


> REST stands for REpresentational State Transfer, which uses HTTP protocol to send data from client to server 

> There are some HTTP methods e.g. GET which produce same response no matter how many times you use them e.g. sending multiple GET request to the same URI will result in same response without any side-effect hence it is known as idempotent.
    On the other hand, the POST is not idempotent because if you send multiple POST request, it will result in multiple resource creation on the server, but again, PUT is idempotent if you are using it to update the resource.
    Even, multiple PUT request to update a resource on a server will give same end result.

> REST is Scalable and interoperable. 
> Rest is Statless.


1) REST is more simple and easy to use than SOAP
2) REST uses HTTP protocol for producing or consuming web services while SOAP uses XML.
3) REST is lightweight as compared to SOAP and preferred choice in mobile devices and PDA’s.
4) REST supports different format like text, JSON and XML while SOAP only support XML.
5) REST web services call can be cached to improve performance.


HTTP Method	Idempotent	Safe
OPTIONS 	yes             yes
GET             yes             yes
HEAD            yes             yes
PUT             yes             no
POST            no      	no
DELETE          yes             no
PATCH           no              no

> HttpMessageConverter is a strategy interface that specifies a converter that can convert from and to HTTP requests and responses.
     Internally Spring MVC uses it to convert the Http request to an object representation and back. 
     Message converters are used to marshall and unmarshall Java Objects to and from JSON, XML, etc – over HTTP

@RestController: It is used at class level to make RESTful web service endpoints. @RestController is combination of @Controller and @ResponseBody. 
@CrossOrigin: It is used for CORS support that permits cross-origin requests on class level as well as method level. 
@RequestMapping: It maps web requests onto methods in REST web service endpoints to provide flexible method signature. 

@GetMapping: It is @RequestMapping with HTTP GET method. 
@PostMapping: It is @RequestMapping with HTTP POST method. 
@PutMapping: It is @RequestMapping with HTTP PUT method. 
@DeleteMapping: It is @RequestMapping with HTTP DELETE method. 
@PatchMapping: It is @RequestMapping with HTTP PATCH method. 

@PathVariable: It indicates that a method parameter should be bound to a URI template variable. 
@RequestBody: It is used with the method parameter to bind the body of the web request. 
@RequestParam: It is used with method parameter to bind the web request parameter. 

@ResponseStatus annotation available on custom exceptions and to map these exceptions to HTTP status codes.


ResponseEntity: It is the extension of HttpEntity that represents HTTP request or response entity, consisting of headers and body. 
UriComponentsBuilder: It is the builder for UriComponents that represents an immutable collection of URI components. 

 



The annotations @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping and @PatchMapping are having optional elements as following. 
consumes: It defines an array of consumable media types of mapped request. 
produces: It defines an array of producible media types of mapped request. 
headers: It defines the acceptable headers of mapped request. 
params: It defines the parameters of the mapped request, narrowing the primary mapping. 
path: It defines path mapping URIs in servlet environment. 
name: It assigns a name to this mapping. 
value: It defines primary mapping expressed by this annotation.




