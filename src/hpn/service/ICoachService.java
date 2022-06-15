package hpn.service;

import hpn.model.Coach;
import hpn.model.Staff;

import java.util.List;

public interface ICoachService {
    List<Coach> getCoachItem();

    void addCoachItem (Coach newCoach);

    void update (Coach newCoach);

    void remove (long id);

    boolean exists (int id);

    Staff getStaffByID(int staffID);

}
