package webapp.servlets;

import lombok.extern.log4j.Log4j2;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import webapp.model.User;

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
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

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
        logger.debug("DeleteUserServlet has been initialized!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> users = new ArrayList<>();
        users.add(new User("Paul1972-05-22", "Paul", "password", "paul@test.com", "0792548755", "1972-05-22"));
        users.add(new User("Ana1989-01-12", "Ana", "password1", "ana@test.com", "0746987858", "1989-01-12"));
        users.add(new User("Mark1992-04-09", "Mark", "password2", "mark@test.com", "0753654952", "1992-04-09"));
        users.add(new User("Nina2001-10-20", "Nina", "password3", "nina@test.com", "0733414698", "2001-10-20"));
        users.add(new User("Rob1965-08-01", "Rob", "password4", "rob@test.com", "0789179853", "1965-08-01"));

        PrintWriter out = response.getWriter();
        String htmlRespone = "<html><head><style>" +
                ".monospace {font-family: Lucida Console, Courier, monospace}" +
                "h1 { display: block; font-size: 4em; margin-top: 0.67em; margin-bottom: 0.67em;" +
                "font-weight: bold; color:#4B4F69;text-align:center; class:Courier;}" +
                "table, th, td {border: 1px solid black;border-collapse: collapse;}" +
                "th, td {paddig: 5px;} th {text-align: left;}" +
                ".div1 {border: 3px outset green; background-color: #43e8d8;" +
                "text-align: center; height:150px;}</style></head>" +
                "<body>" +
                "<div class=div1><h1>User Management System</h1></div>";
        out.println(htmlRespone);

        out.println("<table width='100% border: 1px solid black'>");

        out.println("<tr>" +
                "<th>User Name</th>" +
                "<th>Password</th>" +
                "<th>Email Address</th>" +
                "<th>Phone Number</th>" +
                "<th>Birthday</th>" +
                "</tr>");

        for (User user : users) {
            out.println("<tr>" +
                    "<td>" + user.getName() + "</td>" +
                    "<td>" + user.getBirthDay() + "</td>" +
                    "<td>" + user.getPassword() + "</td>" +
                    "<td>" + user.getEmail() + "</td>" +
                    "<td>" + user.getPhoneNumber() + "</td>" +
                    "<td> <button onclick=myFunction() name='deleteButton'>Delete</button> " +
                    "<script type='text/javascript'>" +
                    "function myFunction() {" +
                    "  alert('Selected user has been deleted!');" +
                    "} </script></td>" +
                    "</tr>");
        }

        out.println("</table></body></html>");
    }

    public void destroy() {
        logger.debug("DeleteServlet has been destroyed!");
    }
}
