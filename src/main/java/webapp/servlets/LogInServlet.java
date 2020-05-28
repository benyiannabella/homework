package webapp.servlets;

import lombok.extern.log4j.Log4j2;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import webapp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@Log4j2
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(LogInServlet.class);

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Initialising log4j");
        String log4jLocation = config.getInitParameter("log4j-properties-location");

        ServletContext sc = config.getServletContext();

        if (log4jLocation == null) {
            System.out.println("No log4j properites...");
            BasicConfigurator.configure();
        } else {
            String webAppPath = sc.getRealPath("/");
            String log4jProp = webAppPath + log4jLocation;
            File output = new File(log4jProp);

            if (output.exists()) {
                System.out.println("Initialising log4j with: " + log4jProp);
                PropertyConfigurator.configure(log4jProp);
            } else {
                System.out.println("Find not found (" + log4jProp + ").");
                BasicConfigurator.configure();
            }
        }

        super.init(config);
        logger.debug("SignInServlet has been initialized!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<User> admins = new ArrayList<>();
        User administrator = new User("Paul1972-05-22", "Paul", "password",
                "paul@test.com", "0792548755", "1972-05-22");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        request.setAttribute("id", administrator.getId());
        request.setAttribute("name", administrator.getName());
        request.setAttribute("password", administrator.getPassword());
        request.setAttribute("email", administrator.getEmail());
        request.setAttribute("phonenumber", administrator.getPhoneNumber());
        request.setAttribute("birthday", administrator.getBirthDay());

        if (validate(administrator, name, password) == false) {
            String htmlRespone = "<html>";
            htmlRespone += "<h3>Username or password not valid!<h3>";
            htmlRespone += "<h4> <a href=/homework9> Back to the Login Page </a> <h4>";
            out.println(htmlRespone);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("welcome");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public static boolean validate(User customer, String name, String pass) {
        boolean valid;
        if (!name.equals(customer.getName()) || name.equals(null)
                || !pass.equals(customer.getPassword()) || pass.equals(null)) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }


    public void destroy() {
        logger.debug("LogInServlet has been destroyed!");
    }
}
