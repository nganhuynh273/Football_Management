package hpn.service;

import hpn.model.Coach;
import hpn.model.Footballer;
import hpn.model.Staff;
import hpn.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class CoachService implements ICoachService{
    List<Coach> coaches = new ArrayList<>();
    private static String path = "data/coach.csv.csv";

    public CoachService() {
        super();
    }

    @Override
    public List<Coach> getCoachItem() {
        List<Coach> newCoachs = new ArrayList<>();
        List<String> records = CSVUtils.readData(path);
        for (String record : records) {
            newCoachs.add(new Coach(record));
        }
        return coaches = newCoachs;
    }

    @Override
    public void addCoachItem(Coach newCoach) {
        List<Coach> coachs = getCoachItem();
        coachs.add(newCoach);
        CSVUtils.writeData(path, coachs);
    }

    @Override
    public void update(Coach newCoach) {
        List<Coach> coaches = getCoachItem();
        for (Coach coach : coaches) {
            if (coach.getStaffID() == newCoach.getStaffID()) {
                coach.setHeSoLuong(newCoach.getHeSoLuong());
                coach.setPhuCap(newCoach.getPhuCap());
                coach.setSoNamKinhNghiem(newCoach.getSoNamKinhNghiem());
            }
        }
        CSVUtils.writeData(path, coaches);
    }

    @Override
    public void remove(long id) {
        List<Coach> coachs = getCoachItem();
        for (int i = 0; i < coachs.size(); i++) {
            if (coachs.get(i).getStaffID() == id) {
                coachs.remove(i);
                break;
            }
        }
        CSVUtils.writeData(path, coachs);
    }

    @Override
    public boolean exists(int id) {
        return getStaffByID(id) != null;
    }


    @Override
    public Staff getStaffByID(int staffID) {
        List<Coach> coaches = getCoachItem();
        for (Coach coach : coaches) {
            if (coach.getStaffID() == staffID) {
                return coach;
            }
        }
        return null;
    }
}
