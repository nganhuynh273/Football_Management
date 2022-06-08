package hpn.model;

import java.util.Calendar;
import java.util.Date;

public abstract class Nhanvien {
    private String ten;
    private String quocTich;
    private boolean gioiTinh;
    private Date ngaySinh;
    private Date ngayVaoLam;
private long MaNV;



    public Nhanvien() {
    }

    public Nhanvien(String ten, String quocTich, boolean gioiTinh, Date ngaySinh, Date ngayVaoLam) {
        this.ten = ten;
        this.quocTich = quocTich;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getTen() {

        return ten;
    }

    public void setTen(String ten) {

        this.ten = ten;
    }

    public String getQuocTich() {

        return quocTich;
    }

    public void setQuocTich(String quocTich) {

        this.quocTich = quocTich;
    }

    public boolean isGioiTinh() {

        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {

        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {

        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {

        this.ngaySinh = ngaySinh;
    }

    public Date getNgayVaoLam() {

        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {

        this.ngayVaoLam = ngayVaoLam;
    }

    public double tinhPhuCapThamNien(){
        Calendar calHienTai = Calendar.getInstance();
        Calendar calNgayLam = Calendar.getInstance();
        calHienTai.getTime();
        calNgayLam.setTime(ngayVaoLam);
        int soNamCongTac = calHienTai.get(Calendar.YEAR) - calNgayLam.get(Calendar.YEAR);
        return soNamCongTac * 1000000;
    }

    abstract double tinhLuong();
}
