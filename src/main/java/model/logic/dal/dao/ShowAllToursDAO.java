package model.logic.dal.dao;

import model.entity.UserTour;

import java.util.List;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public interface ShowAllToursDAO {

    List<UserTour> getList();
}
