package servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/**
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 */

@WebServlet("/ServletSynchronization")
public class ServletSynchronization extends HttpServlet {
    // синхронизируемый объект
    private final StringBuilder locked = new StringBuilder();
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        Writer out = res.getWriter();
        out.write(makeString());
        out.flush();
    }
    private String makeString() {
// оригинал строки
        final String SYNCHRO = "SYNCHRONIZATION";
        synchronized (locked) {
            try {
                for (int i = 0; i < SYNCHRO.length(); i++) {
                    locked.append(SYNCHRO.charAt(i));
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
// пустой
            }
            String result = locked.toString();
            locked.delete(0, SYNCHRO.length());
            return result;
        } // ending synchronized block
    }
}
