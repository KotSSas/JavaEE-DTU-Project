package com.example.demoAutorisa;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/secucred/servlet1")
public class SecuredServlet1 extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
      response.getWriter().write("<h1>Secured servlet 1</h1>");
    }

    public void destroy() {
    }
}