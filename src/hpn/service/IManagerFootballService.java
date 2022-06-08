package hpn.service;

import hpn.model.Nhanvien;

import java.util.List;

public interface IManagerFootballService {
List<Nhanvien> listNVs();
boolean them(Nhanvien nv);
boolean sua(int index, Nhanvien nv);
boolean xoa(int index, Nhanvien nv);


}
