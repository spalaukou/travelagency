package servlet.command;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
// уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}