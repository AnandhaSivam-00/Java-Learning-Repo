import io.javalin.Javalin;

public class JavalinSample {
    public static void main(String args[]) {
        Javalin app = Javalin.create().start(5000);
        app.get("/", ctx -> ctx.result("Hello Hi"));
    }
}
