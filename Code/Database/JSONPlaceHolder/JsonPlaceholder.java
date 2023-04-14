package Code.Database.JSONPlaceHolder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class JsonPlaceholder {
    public JsonPlaceholder() throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
            .build();
        
        HttpResponse <String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String resposeBody = httpResponse.body();

        // System.out.println(resposeBody);

        Gson gson = new Gson();
        Type listType = new TypeToken <ArrayList<Post>> (){}.getType();
        ArrayList <Post> posts = gson.fromJson(resposeBody, listType);

        posts.forEach((post) -> {
            System.out.println(post.getTitle());
        });
    }  
    
    private static class Post {
        // private Integer userId;
        // private Integer id;
        private String title; 
        // private String body;

        // private Integer getUserId() {
        //     return this.userId;
        // }

        // private void setUserId(Integer userId) {
        //     this.userId = userId;
        // }

        // private Integer getId() {
        //     return this.id;
        // }

        // private void setId(Integer id) {
        //     this.id = id;
        // }

        private String getTitle() {
            return this.title;
        }

        // private void setTitle(String title) {
        //     this.title = title;
        // }

        // private String getBody() {
        //     return this.body;
        // }

        // private void setBody(String body) {
        //     this.body = body;
        // }
    }
}
