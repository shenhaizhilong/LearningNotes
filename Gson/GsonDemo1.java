package Gson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import org.codehaus.jackson.impl.JsonWriteContext;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class GsonDemo1 {
    public static void main(String[] args)throws IOException {

        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class);
        double d = gson.fromJson("100.0", double.class);
        boolean b = gson.fromJson("true", boolean.class);
        String str = gson.fromJson("String", String.class);
        double dd = gson.fromJson("\"99.99\"", double.class);
        String res =  String.format("%d, %f, %f, %b, %s", i, d, dd, b, str);
        System.out.println(res);

        String jsonNumber = gson.toJson(100);
        String jsonBoolean = gson.toJson(false);
        String jsonDouble = gson.toJson(99.999999999);
        System.out.println(jsonNumber);
        System.out.println(jsonBoolean);
        System.out.println(jsonDouble);


        User user = new User("Tom好啊好啊", 24);
        user.emailAddress = "tom@21vianet.com";
        System.out.println(user.hashCode());
        String jsonObject = gson.toJson(user);
        System.out.println(jsonObject);
        String jsonString = "{\"name\":\"Tom好啊好啊\",\"age\":24}";
        user = gson.fromJson(jsonString, User.class);
        System.out.println(user);
        System.out.println(user.hashCode());

        String json = "{\"name\":\"怪盗kidou\",\"age\":24,\"emailAddress\":\"ikidou_1@example.com\",\"email\":\"ikidou_2@example.com\"}";
        user = gson.fromJson(json, User.class);
        System.out.println(user.emailAddress); // ikidou_2@example.com

        String jsonArray = "[\"Tom\", \"Bob\", \"Andy\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>(){}.getType());
        System.out.println(stringList);


        //stream

        user = new User("Jacky", 24, "jacky@126.com");
        gson.toJson(user, System.out);


        System.out.println();
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(System.out));
        jsonWriter.beginObject()
                .name("name").value("tom")
                .name("age").value(24)
                .name("email").nullValue()
                .name("list")
                .beginArray()
                .value(1).value(2).value(3)
                .endArray()
                .endObject();

        jsonWriter.flush();


        Gson newgson = new GsonBuilder().serializeNulls().create();
        System.out.println();
        User user1 = new User("Tom", 30);

        System.out.println(gson.toJson(user1));
        System.out.println(newgson.toJson(user1));
    }
}
