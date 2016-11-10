package sparkdemo;

import lombok.Data;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.port;

/**
 *
 */
public class Main {

	@Data
    public static class Person {
        private String name = "Andres";
    }
    
    public static void main(String[] args) {
        
        port(8080);

        before((request, response) -> {
            boolean authenticated = true;
            // ... check if authenticated
            if (!authenticated) {
                halt(401, "You are not allowed to see this resource");
            }
        });

        get("/hello", (req, res) -> { return new Person(); }, new JsonTransformer());

    }
    
}
