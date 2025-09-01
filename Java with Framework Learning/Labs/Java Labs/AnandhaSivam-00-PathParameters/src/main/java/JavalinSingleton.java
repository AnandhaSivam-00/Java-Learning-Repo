

import io.javalin.Javalin;

public class JavalinSingleton {
    /**
     * Assignment: retrieve the variable "first" from the path parameter and send it in the response body. Produce
     * the response using:
     *      ctx.result(StringVariable);
     *
     * You will not need to run app.start in this method. The test cases, or main method, will do this for you - this
     * method only needs to return a properly configured Javalin Server, represented by the 'app' object created below.
     *
     * Please refer to the "PathParameters.MD" file.
     */
    public static Javalin getInstance(){
        Javalin app = Javalin.create();

        app.get("/firstname/{first}", ctx -> {
            
            ctx.result(ctx.pathParam("first"));

        });

        return app;
    }
    
}
