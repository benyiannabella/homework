package webapp.servlets;

import lombok.extern.log4j.Log4j2;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
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

@Log4j2
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
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
        logger.debug("SignUpServlet has been initialized!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> admins = new ArrayList<>();
        User administrator = new User();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phonenumber");
        String birthday = request.getParameter("birthday");
        String id = name + birthday;

        administrator.setId(id);
        administrator.setName(name);
        administrator.setPassword(password);
        administrator.setEmail(email);
        administrator.setPhoneNumber(phoneNumber);
        administrator.setBirthDay(birthday);
        admins.add(administrator);

        PrintWriter out = response.getWriter();
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("password", password);
        request.setAttribute("email", email);
        request.setAttribute("phonenumber", phoneNumber);
        request.setAttribute("birthday", birthday);


        if (validate(administrator) == false) {
            out.println("All the fields are mandatory!");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("welcome");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public static boolean validate(User administrator) {
        boolean valid;
        if (administrator.getName().equals(null) || administrator.getPassword().equals(null)
                || administrator.getEmail().equals(null) || administrator.getPhoneNumber().equals(null) ||
                administrator.getBirthDay().equals(null)) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public void destroy() {
        logger.debug("SignUpServlet has been destroyed!");
    }
}
