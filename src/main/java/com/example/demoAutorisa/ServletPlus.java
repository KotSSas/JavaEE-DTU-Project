package com.example.demoAutorisa;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletPlus", value = "/ServletPlus")
public class ServletPlus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        cart.setQuantity(cart.getQuantity()+1);
        setCookies(cart.getName(),cart.getQuantity(),response);


        request.setAttribute("cart",cart);
        request.getRequestDispatcher("public/public1.jsp").forward(request,response);
    }

    private void setCookies(String name, int quantity, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, String.valueOf(quantity));
        cookie.setMaxAge(24*60*60*7);
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
