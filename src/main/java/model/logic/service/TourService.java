package model.logic.service;

import model.entity.Tour;

import java.util.List;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public interface TourService {

    List<Tour> getToursByCountry(String country);
}
