package gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Main {

    public static void main(String... strings) {
        Gson gson = new Gson();

        List<JsonObject> jsonObjects = gson.fromJson(" [{\"params\":{\"user_id\":0000},\"method\":\"Test\",\"jsonrpc\":\"2.0\",\"\":\"1\"},{\"params\":{\"user_id\":0000},\"method\":\"Test\",\"jsonrpc\":\"2.0\",\"\":\"2\"}]"
                , new TypeToken<List<JsonObject>>() {
                }.getType());
        JsonElement jsonElement = gson.toJsonTree(" [{\"params\":{\"user_id\":0000},\"method\":\"Test\",\"jsonrpc\":\"2.0\",\"\":\"1\"},{\"params\":{\"user_id\":0000},\"method\":\"Test\",\"jsonrpc\":\"2.0\",\"\":\"2\"}]");
        System.out.println(jsonElement.toString());
        System.out.println(jsonObjects.toString());

        jsonObjects.forEach(System.out::println);
    }
}
