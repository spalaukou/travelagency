package controller.command.implementation;

        import controller.command.Command;
        import model.ConstantContainer;
        import model.logic.dal.db_connection.DBConstantContainer;
        import model.logic.service.ServiceFactory;
        import model.logic.service.UserService;
        import model.logic.validator.Validator;
        import model.logic.validator.ValidatorFactory;

        import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class SignUpCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(ConstantContainer.LOGIN);
        String password = request.getParameter(ConstantContainer.PASSWORD);

        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator validator = validatorFactory.getLoginValidator();

        if(validator.validate(request)) {

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();

            int userID;

            userID = userService.signUp(login, password);

            request.setAttribute(DBConstantContainer.ID_USER, userID);
        }

        return ConstantContainer.SIGN_UP_PAGE;
    }
}
