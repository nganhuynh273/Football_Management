package hpn.service;

import hpn.model.Footballer;
import hpn.model.Staff;
import hpn.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class FootballerService implements IFootballerService {
    List<Footballer> footballers = new ArrayList<>();
    private static String path = "data/footballer.csv";

    @Override
    public List<Footballer> getFootballerItem() {
        List<Footballer> newFootballers = new ArrayList<>();
        List<String> records = CSVUtils.readData(path);
        for (String record : records) {
            newFootballers.add(new Footballer(record));
        }
        return footballers = newFootballers;
    }

    @Override
    public void addFootballerItem(Footballer newFootballer) {
        List<Footballer> footballers = getFootballerItem();
        footballers.add(newFootballer);
        CSVUtils.writeData(path, footballers);
    }

    @Override
    public void update(Footballer newFootballer) {
        List<Footballer> footballers = getFootballerItem();
        for (Footballer footballer : footballers) {
            if (footballer.getStaffID() == newFootballer.getStaffID()) {
                footballer.setBanThang(newFootballer.getBanThang());
                footballer.setLuongThoaThuan(newFootballer.getLuongThoaThuan());
                footballer.setSoLuotTranThamGia(newFootballer.getSoLuotTranThamGia());
                footballer.setBanThang(newFootballer.getBanThang());

            }
        }
        CSVUtils.writeData(path, footballers);
    }

    @Override
    public void remove(long id) {
        List<Footballer> footballers = getFootballerItem();
        for (int i = 0; i < footballers.size(); i++) {
            if (footballers.get(i).getStaffID() == id) {
                footballers.remove(i);
                break;
            }
        }
        CSVUtils.writeData(path, footballers);
    }

    @Override
    public boolean exists(int id) {
        return getStaffByID(id) != null;
    }

    @Override
    public boolean existsbyIDStaff(String maNhanvien) {
        for (Footballer footballer : footballers) {
            if (footballer.getMaNhanvien().equals(maNhanvien))
                return true;
        }
        return false;
    }


    @Override
    public Staff getStaffByID(int staffID) {
        List<Footballer> footballers = getFootballerItem();
        for (Footballer footballer : footballers) {
            if (footballer.getStaffID() == staffID) {
                return footballer;
            }
        }
        return null;
    }
}
