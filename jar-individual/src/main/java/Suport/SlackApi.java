/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Suport;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author diegovieira
 */

public class SlackApi {
    
    private static HttpClient client = HttpClient.newHttpClient();
    private static final String webhook = "https://hooks.slack.com/services/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";

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(webhook))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
        
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        //System.out.println(String.format("Status: %s", response.statusCode()));
        //System.out.println(String.format("Response: %s", response.body()));
        
    }
    
}
