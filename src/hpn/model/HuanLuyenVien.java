package hpn.model;

import java.util.Date;

public class HuanLuyenVien extends Nhanvien {
    private int soNamKinhNghiem;
    private double heSoLuong;
    private double phuCap;

    public HuanLuyenVien() {
    }
    public HuanLuyenVien(String ten, String quocTich, boolean gioiTinh, Date ngaySinh, Date ngayVaoLam,
                         int soNamKinhNghiem, double heSoLuong, double phuCap) {
        super(ten, quocTich, gioiTinh, ngaySinh, ngayVaoLam);
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }

    public int getSoNamKinhNghiem() {
        return soNamKinhNghiem;
    }

    public void setSoNamKinhNghiem(int soNamKinhNghiem) {
        this.soNamKinhNghiem = soNamKinhNghiem;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public double tinhLuong(){
        return (this.heSoLuong * 1050000) + this.phuCap + super.tinhPhuCapThamNien();
    }

//    @Override
//    public String toString() {
//        return "HuanLuanVien{" +
//                "soNamKinhNghiem=" + soNamKinhNghiem +
//                ", heSoLuong=" + heSoLuong +
//                ", phuCap=" + phuCap +
//                '}';
//    }
}
