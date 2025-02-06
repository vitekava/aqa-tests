package guru.qa;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.lang.Thread.sleep;

public class JUnitSimpleTest {

    String userAgent = "{\"sdk\":25,\"version_name\":\"4.4.0\",\"version_code\":647,\"platform\":\"android\",\"device_id\":\"123123123\",\"name\":\"YOUR_DEVICE_NAME\",\"app\":\"com.infolink.limeiptv\"}";

    public void registrationNewUser(String userEmail, String password) throws IOException, InterruptedException {
        String url = "https://pl.iptv2021.com/api/v1/register";
        String deleteUserUrl = "https://pl.iptv2021.com/api/v1/account-delete";
        String bodyToRegister = "email="+userEmail
                +"&password="+password
                + "&confirmPassword="+password
                + "&confirmRules=1";
        HttpClient client = HttpClient.newHttpClient();
        System.out.println(userEmail);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", userAgent)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(BodyPublishers.ofString(bodyToRegister))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> responseMap = objectMapper.readValue(response.body(), Map.class);
        String token = (String) responseMap.get("token");
        sleep(1000);
        String bodyToDelete = "email="+userEmail+"&password="+password;
        HttpRequest requestForDelete = HttpRequest.newBuilder()
                .uri(URI.create(deleteUserUrl))
                .header("User-Agent", userAgent)
                .header("x-token",token)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(BodyPublishers.ofString(bodyToDelete))
                .build();
        HttpResponse<String> response1 = client.send(requestForDelete, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response Code: " + response1.statusCode());
        System.out.println("Response Body: " + response1.body());
    }
}