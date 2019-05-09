package controller.command.implementation;

        import controller.command.Command;
        import model.ConstantContainer;
        import model.logic.exception.logical.ServiceSQLException;
        import model.logic.exception.technical.DataSourceException;
        import model.logic.service.ServiceFactory;
        import model.logic.service.UserService;
        import model.logic.validator.Validator;
        import model.logic.validator.ValidatorFactory;
        import org.apache.log4j.Logger;

        import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class SignUpCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(SignUpCommand.class);

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
                } catch (DataSourceException e) {
                    LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
                } catch (ServiceSQLException e) {
                    LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
                }
            } else {
                request.setAttribute(ConstantContainer.ERR_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_USER_EXISTS);
            }
        } else {
            request.setAttribute(ConstantContainer.SHORT_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_SHORT_LOGIN_PASS);
        }
        return page;
    }
}
