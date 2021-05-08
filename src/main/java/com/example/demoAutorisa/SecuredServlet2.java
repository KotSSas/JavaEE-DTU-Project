package com.example.demoAutorisa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/servlet2")
@ServletSecurity(httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET",rolesAllowed = "manager"),
        @HttpMethodConstraint(value = "POST",rolesAllowed = "manager"),
})
public class SecuredServlet2 extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if (cart== null){
            cart = new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);
        }else{

        }
        request.setAttribute("cart",cart);
//        request.getRequestDispatcher("secured/showCart.jsp").forward(request,response);
       Integer count = (Integer) session.getAttribute("count");
        if (count==null){
            session.setAttribute("count",1);
            count=1;

        }else{
            session.setAttribute("count",++count);
        }
        Counter counter = new Counter(count);
        request.setAttribute("counter",counter);
        request.getRequestDispatcher("secured/secured2.jsp").forward(request,response);




//        response.setContentType("text/html");
//      response.getWriter().write("<h1>Secured servlet 2</h1>");
//      response.getWriter().write("<h3>"+count+"</h3>");

    }

    public void destroy() {
    }
}