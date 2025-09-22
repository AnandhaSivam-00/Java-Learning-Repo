package Application.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    /**
     * Query parameters allow the developer in include some variable data in an HTTP request, as part of the endpoint,
     * that may be used to conduct some very specific query or action on your backend. A query parameter is the part
     * of the URL following the ? symbol, such as cats.site/cats?term=photos&format=png&orderby=popularity. For instance,
     * if you are writing an endpoint intended to return some search results, it would be conventional to include not
     * just the search term (eg 'cat photos') as a query parameter, but other site metrics such as filters
     * ('format=png'), ordering ('orderby=popularity'), or pagination ('page=2'). In a RESTful API, it is generally
     * recommended that a path param only identifies the entity or resource that you are working with, and variables
     * that refine how the backend should interact with the data should be included as a path parameter.
     *
     * Below is an example of how to extract a path parameter from an HTTP request.
     * This will extract the query parameter "term" from an HTTP request to localhost:9000/cats?term=searchterm,
     * responding with "searchterm".
     */
    @GetMapping(value = "cats", params = {"term"})
    public String getSearchTerm(@RequestParam String term){
        return term;
    }
    /**
     * Here's an example of how to extract multiple path params from the HTTP quest. Notice how the terms are defined
     * as part of the endpoint's signature - this allows Spring to identify two distinct endpoints that both use a
     * base endpoint "cats" but feature different query parameters.
     */
    @GetMapping(value = "cats", params = {"term", "format"})
    public String[] getSearchTermAndPage(@RequestParam String term, @RequestParam String format){
        return new String[]{term, format};
    }
    /**
     * TODO: extract the numeric 'amount' query parameter from a request, such as GET localhost:9000/cats?amount=50,
     * returning 50.
     */
    @GetMapping(value = "cats", params = {"amount"})
    public int getSearchFormat(@RequestParam int amount){
        return amount;
    }
    /**
     * TODO: extract the String 'format' and 'orderBy' query parameters from a request, such as
     * GET localhost:9000/cats?format=gif&orderby=new, returning a String array such as {"gif", "new"}
     */
    @GetMapping(value = "cats", params = {"format", "orderBy"})
    public String[] getSearchFormatAndAmount(@RequestParam String format, @RequestParam String orderBy){
        return new String[]{format, orderBy};
    }
}
