

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.CommandLine;

import io.javalin.Javalin;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    Javalin app = JavalinSingleton.getInstance();
    HttpClient webClient;
    ObjectMapper objectMapper;

    @Before
    public void beforeEach() throws InterruptedException{
        webClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
        app.start(9001);
        Thread.sleep(3000);
    }

    @After
    public void afterEach(){
        app.stop();
    }

    /**
     * The response for endpoint echo should contain an Object matching the data contained within the following
     * JSON request body:
     * {
     *     "songName": "Let it be",
     *     "artistName": "Beatles"
     * }
     * Meaning, the endpoint should respond with the same request body it was provided.
     */
    @Test
    public void prob1a() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9001/echo"))
                .POST(HttpRequest.BodyPublishers.ofString("{"+
                        "\"songName\":\"Let it be\"," +
                        "\"artistName\":\"Beatles\"}"))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse response = webClient.send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertFalse("Response body must not be empty",response.body().toString().length()==0);
        Song expected = new Song("Let it be", "Beatles");
        Song actual = objectMapper.readValue(response.body().toString(), Song.class);
        Assert.assertEquals("response body should match the request body", expected, actual);
        
    }

    /**
     * The response for endpoint echo should contain an Object matching the data contained within the following
     * JSON request body:
     * {
     *     "songName": "Paint it Black",
     *     "artistName": "Rolling Stones"
     * }
     * Meaning, the endpoint should respond with the same request body it was provided.
     */
    @Test
    public void prob1b() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9001/echo"))
                .POST(HttpRequest.BodyPublishers.ofString("{"+
                        "\"songName\":\"Paint it Black\"," +
                        "\"artistName\":\"Rolling Stones\"}"))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse response = webClient.send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertFalse("Response body must not be empty",response.body().toString().length()==0);
        Song expected = new Song("Paint it Black", "Rolling Stones");
        Song actual = objectMapper.readValue(response.body().toString(), Song.class);
        Assert.assertEquals("response body should match the request body", expected, actual);
        
    }
    /**
     * The response for endpoint changeartisttobeatles should contain an Object matching the data contained within the
     * following JSON request body:
     * {
     *     "songName": "Paint it Black",
     *     "artistName": "Rolling Stones"
     * }
     * Meaning, the endpoint should respond with the same request body it was provided.
     */
    @Test
    public void prob2a() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9001/changeartisttobeatles"))
                .POST(HttpRequest.BodyPublishers.ofString("{"+
                        "\"songName\":\"Paint it Black\"," +
                        "\"artistName\":\"Rolling Stones\"}"))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse response = webClient.send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertFalse("Response body must not be empty",response.body().toString().length()==0);
        Song expected = new Song("Paint it Black", "Beatles");
        Song actual = objectMapper.readValue(response.body().toString(), Song.class);
        Assert.assertEquals("response body should match the request body", expected, actual);

    }
}
