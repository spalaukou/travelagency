package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * @author Stanislau Palaukou on 18.04.2019
 * @project task06
 */

@WebServlet("/FirstServletTest")
public class FirstServlet extends HttpServlet {

    public FirstServlet() {
        super();
    }

    public void init() throws ServletException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("This is " + this.getClass().getName()
                + ", using the GET method");
        response.getWriter().println("Hello from Stas!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("This is " + this.getClass().getName()
                + ", using the POST method");
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }

}
