package Lab.Controller;

import Lab.Model.Sample;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * A RESTController allows for the creation of endpoints that will, by default, allow the developer to easily follow
 * RESTful conventions, such as the descriptive use of HTTP verbs (get, post, put, patch, delete), and will also
 * automatically convert variables returned from the endpoint's handler to a JSON response body, which was previously
 * done by including the @ResponseBody annotation.
 */
@RestController
public class SampleController {
    /**
     * Endpoint on GET localhost:9000/sample. Mappings such as @GetMapping, @PostMapping, @PutMapping, @PatchMapping,
     * and @DeleteMapping are now available to use thanks to Spring MVC's @RestController annotation. The return type
     * is Sample, a model contained in the 'Model' package, and Spring MVC will automatically convert any Object
     * returned by a handler into a JSON response body. In this case, a request to GET localhost:9000/sample will
     * respond with this JSON response body:
     * {
     *     id:1,
     *     text:"sample text"
     * }
     * There is no need to change this endpoint or handler.
     */
    @GetMapping("/sample/")
    public Sample getSample(){
        return new Sample(1L, "sample text");
    }
    /**
     * Endpoint on GET localhost:9000/string/{text}. For instance, an HTTP request to GET localhost:9000/string/abc
     * will parse "abc" as a path variable. Path variables are defined with curly braces in the endpoint signature,
     * and Spring will map incoming HTTP requests to an endpoint matching this patter. A path variable may be
     * extracted using the @PathVariable annotation used in the parameter, together with the type of variable it
     * should be.
     * In this case, a request to GET localhost:9000/string/hello will respond with "hello".
     * There is no need to change this endpoint or handler.
     */
    @GetMapping("/string/{text}")
    public String getStringPathVariable(@PathVariable String text){
        return text;
    }
    /**
     * TODO: extract a path variable from this endpoint and respond with it.
     * This should work the same as the above example. For example, an HTTP request to GET localhost:9000/long/1
     * should respond with "1".
     */
    @GetMapping("/long/{id}")
    public long getPathVariable(@PathVariable String id){
        //you will need to change the method's parameters and return the extracted path variable.
        return Long.parseLong(id);
    }
    /**
     * TODO: extract the request body and respond with it.
     * Similarly to how path variables are extracted with an annotation, request bodies may be extracted in a similar
     * way with the @RequestBody annotation. In that case, Spring will deserialize a JSON request body into a Java
     * Object using Jackson Databind. For example:
     * @PostMapping("endpoint")
     * public Type postType(@RequestBody Type pojo){
     *     //the request body is deserialized here as 'pojo'.
     * }
     * A PostMapping is used here, as GET requests don't use request bodies by convention.
     *
     * In this case, an HTTP request to POST localhost:9000/requestbody with the request body
     * {
     *     id:1
     *     text:"sample text"
     * }
     * should respond with this JSON response body
     * {
     *     id:1
     *     text:"sample text"
     * }
     */
    @PostMapping(value = "/requestbody")
    public Sample postSample(@RequestBody Sample value){
        //you will need to change the method's parameters and return the extracted request body.
        return value;
    }
}
