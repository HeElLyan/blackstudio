package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.JspPaths;
import ru.itis.blackstudio.constants.Urls;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Urls.SERVICE)
public class ServiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(JspPaths.SERVICE).forward(req,resp);
    }
}
