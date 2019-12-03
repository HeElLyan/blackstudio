package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.ServletKeys;
import ru.itis.blackstudio.constants.Urls;
import ru.itis.blackstudio.utils.CookiesUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(false).invalidate();
        CookiesUtil.removeUserId(resp);
        resp.sendRedirect(ServletKeys.CONTEXT_PATH + Urls.LOGIN);
    }

}
