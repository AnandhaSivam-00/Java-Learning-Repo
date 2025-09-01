

import io.javalin.Javalin;

public class JavalinSingleton {
    /**
     * Assignment: return the status code for a generic "client side error" in the http response
     *
     * You will not need to run app.start in this method. The test cases, or main method, will do this for you - this
     * method only needs to return a properly configured Javalin Server, represented by the 'app' object created below.
     *
     * Please refer to the "StatusCodes.MD" file.
     */
    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        

        app.get("/client-side-err", ctx -> {
        
           ctx.status(404);
            
        });

        return app;
    }
    
}
