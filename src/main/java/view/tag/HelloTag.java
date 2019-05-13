package view.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Custom tag with greeting User on each page
 * of the application.
 *
 * @author Stanislau Palaukou on 12.05.2019
 * @project TravelAgency
 */

@SuppressWarnings("serial")
public class HelloTag extends TagSupport {
    private String login;
    private String welcomeMessage;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    @Override
    public int doStartTag() throws JspException {
        try {

            String welcome = welcomeMessage;

            if (!login.equalsIgnoreCase("")) {
                welcome += ", " + login + "!";
            }

            pageContext.getOut().write(welcome);

        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }

        return SKIP_BODY;
    }
}
