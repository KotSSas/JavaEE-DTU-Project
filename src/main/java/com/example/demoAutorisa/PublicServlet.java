package com.example.demoAutorisa;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(urlPatterns = "/PublicServlet")

public class PublicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Cookie[] cookies = request.getCookies();
            if (cart == null) {
                cart = new Cart("car", 1);
               session.setAttribute("cart", cart);

            }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(cart.getName())){
                cart.setQuantity(Integer.parseInt(cookie.getValue()));
                break;
            }
        }
       request.setAttribute("cart",cart);
       request.getRequestDispatcher("public/public1.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
