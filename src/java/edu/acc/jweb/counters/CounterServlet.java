package edu.acc.jweb.counters;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CounterServlet", urlPatterns = {"/main"})
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {        
        
        Integer applicationCounter = (Integer) getServletContext().getAttribute ("applicationCounter");
        if (applicationCounter == null) {
            applicationCounter = 1;
        } else {
            applicationCounter = applicationCounter + 1;
        }
        getServletContext().setAttribute("applicationCounter", applicationCounter);
        
        HttpSession session = request.getSession(true);
        Integer sessionCounter = (Integer) session.getAttribute("sessionCounter");
        if (sessionCounter == null) {
            sessionCounter = 1;
        } else {
            sessionCounter = sessionCounter + 1;
        } 
        session.setAttribute("sessionCounter", sessionCounter);
        
        getServletContext().getRequestDispatcher("/WEB-INF/views/counters.jsp").forward(request, response);
    }
}