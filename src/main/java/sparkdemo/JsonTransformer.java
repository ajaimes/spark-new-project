package sparkdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import spark.ResponseTransformer;

/**
 *
 */
public class JsonTransformer implements ResponseTransformer {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String render(Object model) throws IOException {
        try {
            return mapper.writeValueAsString(model);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
