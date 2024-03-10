package com.microservices.bits.assignment.webmicroservice;

import com.microservices.bits.assignment.webmicroservice.Controller.webController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class webControllerTestClass {
    @Autowired
    private webController testController;

    @Test
    void testPostTestAPI() {
        // Mock the HTTP request
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("POST");
        request.setRequestURI("/test");

        // Mock the HTTP response
        MockHttpServletResponse response = new MockHttpServletResponse();

        // Call the controller method
        String res = testController.test();

        // Verify the response
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("webservice",res);
    }

    @Test
    void testPostdoRegisterAPI() throws IOException, InterruptedException {
        // Mock the HTTP request
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("POST");
        request.setRequestURI("/doRegister");

        HashMap<String, String> body = new HashMap<>();
        body.put("mobileno", "12345678900");
        body.put("empname","shiv");
        body.put("empid","123");
        body.put("emptype", "34");
        body.put("secretkey", "1234567890");
        // Mock the HTTP response
        MockHttpServletResponse response = new MockHttpServletResponse();

        // Call the controller method
      ResponseEntity<?>  res =  testController.doRegister(body);

        // Verify the response
        assertEquals(HttpStatus.OK.value(), response.getStatus());
       // assertEquals("webservice",res.getBody());
    }
}
