package hpn.service;

import hpn.model.Footballer;
import hpn.model.Staff;


import java.util.List;

public interface IFootballerService {
    List<Footballer> getFootballerItem();

    void addFootballerItem (Footballer newFootballer);

    void update (Footballer newFootballer);

    void remove (long id);

    boolean exists(int id);

    boolean existsbyIDStaff (String maNhanvien);

    Staff getStaffByID(int staffID);

}
