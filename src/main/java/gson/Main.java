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

        Animal animal = new Cat();
        System.out.println(gson.toJson(animal)); // {"name":"cat"}

        // interfaceの型の場合、実装の型に合わせてjson化される
        // プリミティブは初期値があるので、初期値でjson化される
        System.out.println(gson.toJson(new Muga(new TestImpl(true, "test", true)))); // {"test":{"a":true,"b":"test","c":true}}
        System.out.println(gson.toJson(new Muga(new TestImpl2(true)))); // {"test":{"a":true}}
        System.out.println(gson.toJson(new Muga(new TestImpl()))); // {"test":{"a":false}}
    }

    public interface Test {
        boolean getA();
    }

    public static class Muga {
        public Test test;

        public Muga(Test test) {
            this.test = test;
        }
    }

    public static class TestImpl implements Test {

        public boolean a;
        public String b;
        public Boolean c;

        public TestImpl() {
        }

        public TestImpl(boolean a, String b, boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean getA() {
            return a;
        }
    }

    public static class TestImpl2 implements Test {

        public boolean a;

        public TestImpl2(boolean a) {
            this.a = a;
        }

        @Override
        public boolean getA() {
            return a;
        }
    }
}