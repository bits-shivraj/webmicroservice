package com.microservices.bits.assignment.webmicroservice.Controller;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class webController {

    @PostMapping("/test")
    public static String test() {

        return "webservice";
    }
    @PostMapping("/register")
    final public String doRegister(@RequestParam("mobileno") final String mobileno,
                              @RequestParam("empname") final String empname,
                              @RequestParam("empid") final String empid,
                              @RequestParam("emptype")final String emptype,
                              @RequestParam("secretkey") final String secretkey) throws IOException, InterruptedException {
       // Call Register service
        Map<Object, Object> body = new HashMap();
        body.put("mobileno",mobileno);
        body.put("empname",empname);
        body.put("empid",empid);
        body.put("emptype",emptype);
        body.put("secretkey",secretkey);
        ObjectMapper mapper = new ObjectMapper();
        String bdy = mapper.writeValueAsString(body);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().header("Content-Type", "application/json").uri(URI.create("http://localhost:9008/register")).POST(HttpRequest.BodyPublishers.ofString(bdy)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responsestr = (String)response.body();
        return responsestr;
    }

    @PostMapping("/auth")
    final public String doAuth(@RequestParam("mobileno") final String mobileno,
                         @RequestParam("signature") final String signature) throws IOException, InterruptedException {
        Map<Object, Object> body = new HashMap();
        body.put("mobileno",mobileno);
        body.put("signature",signature);
        ObjectMapper mapper = new ObjectMapper();
        String bdy = mapper.writeValueAsString(body);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().header("Content-Type", "application/json").uri(URI.create("http://localhost:9006/auth")).POST(HttpRequest.BodyPublishers.ofString(bdy)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responsestr = (String)response.body();
        return responsestr;
    }


}
