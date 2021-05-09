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
            if (cookie.getName().equals(cart.getName())) {
                cart.setQuantity(Integer.parseInt(cookie.getValue()));
                break;
            }
        }

        String symbol = request.getParameter("symbol");
        if (symbol == null) {
            cart.setQuantity(cart.getQuantity());
        } else if (symbol.equals("minus")) {
            if (cart.getQuantity() > 0)
                cart.setQuantity(cart.getQuantity() - 1);
            setCookies(cart.getName(), cart.getQuantity(), response);
        } else if (symbol.equals("plus")) {
            cart.setQuantity(cart.getQuantity() + 1);
            setCookies(cart.getName(), cart.getQuantity(), response);
        }


        request.setAttribute("cart", cart);
        request.getRequestDispatcher("public/public1.jsp").forward(request, response);

    }

    private void setCookies(String name, int quantity, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, String.valueOf(quantity));
        cookie.setMaxAge(24 * 60 * 60 * 7);
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
