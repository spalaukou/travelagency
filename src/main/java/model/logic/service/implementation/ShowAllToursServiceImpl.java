package model.logic.service.implementation;

import model.entity.UserTour;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.ShowAllToursDAO;
import model.logic.service.ShowAllToursService;

import java.util.List;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class ShowAllToursServiceImpl implements ShowAllToursService {

    @Override
    public List<UserTour> getList() {
        System.out.println(0);
        DAOFactory daoFactory = DAOFactory.getInstance();
        ShowAllToursDAO showAllToursDAO = daoFactory.getShowAllToursDAO();

        return showAllToursDAO.getList();
    }
}
