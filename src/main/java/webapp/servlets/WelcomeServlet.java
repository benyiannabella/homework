package webapp.servlets;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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

@Log4j2
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

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
        logger.debug("Welcome Servlet has been initialized!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = (String) request.getAttribute("name");
        String password = (String) request.getAttribute("password");
        String email = (String) request.getAttribute("email");
        String phoneNumber = (String) request.getAttribute("phonenumber");
        String birthday = (String) request.getAttribute("birthday");
        String id = name + birthday;

        PrintWriter out = response.getWriter();
        String htmlRespone = "<html><head><style>" +
                ".monospace {font-family: Lucida Console, Courier, monospace}" +
                "h1 { display: block; font-size: 4em; margin-top: 0.67em; margin-bottom: 0.67em;" +
                "font-weight: bold; color:#4B4F69;text-align:center; class:Courier;}" +
                "table, th, td {border: 1px solid black;border-collapse: collapse;}" +
                "th, td {paddig: 5px;} th {text-align: left;}" +
                ".div1 {border: 3px outset green; background-color: #43e8d8;" +
                "text-align: center; height:150px;}" +
                ".div2 {border: 2px outset blue; background-color: #C1CEFA;" +
                "text-align: center; left: 0px; }" +
                ".div3 {border: 1px outset black; text-align: left; right: 0px; float: left;  width: 700px}" +
                ".div4 {border: 1px outset black; background-color: #F8FDAD;" +
                "text-align: center; right: 0px; width: 640px; float: right;}" +
                "input[type=submit] {border-radius: 5px; border: 0; width: 80px; height:25px;" +
                "font-family: Tahoma; background: #f4f4f4;}</style></head>" +
                "<body><form action=edit method=get> " +
                "<div class=div1><h1>User Management System</h1></div>" +
                "<div class=div2><h2  style=font-weight: bold> Hi " + name + " !</h2>" +
                "<h2>Welcome to your page!</h2></div>" +
                "<div class=div3><h3>Please see your account details below:</h3>" +
                "<table border='2', width='80%'>" +
                "<tr>" +
                "<td><h4 style=font-weight: bold>To change your details untick the box, than Save: </h4></td>" +
                "<td><button name='save'>Save</button></td>" +
                "</tr>" +
                "<tr>" +
                "<td> ID: </td>" +
                "<td><input type=text id=id required disabled = true value=" + id + "></td>" +
                "<td>" +
                "</tr>" +
                "<td> Name: </td>" +
                "<td><input type=text id=name required disabled = true value=" + name + "></td>" +
                "<td></td>" +
                "</tr>" +
                "<tr>" +
                "<td> Password: </td>" +
                "<td><input type=text id=password required minlength=6 maxlength=12 disabled = true value="
                + password + "></td>" +
                "<td><input type=checkbox checked id=passBox>" +
                "<script>" +
                "document.getElementById('passBox').onchange = function() {" +
                "document.getElementById('password').disabled = this.checked;};" +
                "</script></td>" +
                "</tr>" + "<tr>" +
                "<td> Email Address: </td>" +
                "<td><input type=text id=email required disabled = true" +
                "pattern=[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,} value=" + email +
                "></td>" +
                "<td><input type=checkbox checked id=emailBox>" +
                "<script>" +
                "document.getElementById('emailBox').onchange = function() {" +
                "document.getElementById('email').disabled = this.checked;};" +
                "</script></td>" +
                "</tr>" +
                "<tr>" +
                "<td> Phone Number: </td>" +
                "<td><input type=text id=phone required disabled = true value=" + phoneNumber + "></td>" +
                "<td><input type=checkbox checked id=phoneBox>" +
                "<script>" +
                "document.getElementById('phoneBox').onchange = function() {" +
                "document.getElementById('phone').disabled = this.checked;};" +
                "</script></td>" +
                "</tr>" +
                "<td> Birthday: </td>" +
                "<td><input type=text id=birthday required disabled = true value=" + birthday + "></td>" +
                "<td></td>" +
                "</tr>" +
                "</table></form></div>" +
                "<form action=delete method=post>" +
                "<div class=div4><h3>If you want to Delete the existent users, click below!<h3>" +
                "<input type=submit class=button_active value= Delete></div>" +
                "</table></form></body></html>";
        out.println(htmlRespone);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public void destroy() {
        logger.debug("WelcomeServlet has been destroyed!");
    }

}
