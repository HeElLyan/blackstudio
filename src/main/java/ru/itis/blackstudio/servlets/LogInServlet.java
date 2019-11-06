package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.dao.UsersDao;
import ru.itis.blackstudio.models.User;
import ru.itis.blackstudio.services.Auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/logIn")
public class LogInServlet extends HttpServlet {
    private UsersDao usersDao;
//
//    @Override
//    public void init() throws ServletException {
//        Properties properties = new Properties();
//        DriverManagerDataSource dataSource =
//                new DriverManagerDataSource();
//
//        try {
//            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
//            String dbUrl = properties.getProperty("db.url");
//            String dbUsername = properties.getProperty("db.username");
//            String dbPassword = properties.getProperty("db.password");
//            String driverClassName = properties.getProperty("db.driverClassName");
//
//            dataSource.setUsername(dbUsername);
//            dataSource.setPassword(dbPassword);
//            dataSource.setUrl(dbUrl);
//            dataSource.setDriverClassName(driverClassName);
//
//            usersDao = new UsersDaoJDBCTemplateImp(dataSource);
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Optional<User> user = usersDao.find(1);
//
//        Optional<User> users;
//        if (request.getParameter("firstName") != null) {
//            String username = request.getParameter("firstName");
//            users = usersDao.findByUsername(username);
//        } else {
//            users = usersDao.findAll();
//        }
//        request.setAttribute("usersFromServer", users);
        request.getServletContext().getRequestDispatcher("/jsp/logIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Auth auth = new Auth();
        Optional<User> user = auth.signIn(username, password);
        if(user.isPresent()){
            request.getServletContext().getRequestDispatcher("/jsp/main.jsp").forward(request, response);
        } else {
            doGet(request, response);
        }

    }
}
