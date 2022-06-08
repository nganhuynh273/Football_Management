package hpn.service;

import hpn.model.Nhanvien;
import hpn.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class ManagerFootballService implements IManagerFootballService{
    List<Nhanvien> nhanviens = new ArrayList<>();
    private String path = "data/football.csv";

    @Override
    public List<Nhanvien> listNVs() {
        List<Nhanvien> newNVs = new ArrayList<>();
        List<String> records = CSVUtils.readData(path);
        for (String record : records) {
            newNVs.add(new Nhanvien(record));
        }
    return nhanviens = newNVs;
    }

    @Override
    public boolean them(Nhanvien nv) {
        return false;
    }

    @Override
    public boolean sua(int index, Nhanvien nv) {
        return false;
    }

    @Override
    public boolean xoa(int index, Nhanvien nv) {
        return false;
    }
}
