package controller.command.implementation;

        import controller.command.Command;
        import model.ConstantContainer;
        import model.logic.exception.logical.ServiceSQLException;
        import model.logic.exception.technical.DataSourceException;
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
        String page = ConstantContainer.SIGN_UP_PAGE;
        String login = request.getParameter(ConstantContainer.LOGIN);
        String password = request.getParameter(ConstantContainer.PASSWORD);

        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator lengthValidator = validatorFactory.getLoginPassLengthValidator();
        Validator loginValidator = validatorFactory.getLoginValidator();

        if(lengthValidator.validate(request)) {
            if(loginValidator.validate(request)) {

                try {
                    ServiceFactory serviceFactory = ServiceFactory.getInstance();
                    UserService userService = serviceFactory.getUserService();

                    userService.signUp(login, password);

                    request.setAttribute(ConstantContainer.USER, login);

                    page = ConstantContainer.SIGN_UP_RESULT_PAGE;
                } catch (ServiceSQLException e) {
                    //log.error("SQL error", e);
                } catch (DataSourceException e) {
                    //log.error("Problems with data source", e);
                }
            } else {
                request.setAttribute(ConstantContainer.ERR_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_USER_EXISTS);
            }
        } else {
            request.setAttribute(ConstantContainer.ERR_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_SHORT_LOGIN_PASS);
        }
        return page;
    }
}
