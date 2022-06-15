package hpn.model;

import java.util.Date;

public class Coach extends Staff {
    private int soNamKinhNghiem;
    private double heSoLuong;
    private double phuCap;

    public Coach(long staffID, String maNhanVien, String ten, String quocTich, String gioiTinh, Date ngaySinh, Date ngayVaoLam,
                 int soNamKinhNghiem, double heSoLuong, double phuCap) {
        super(staffID, maNhanVien, ten, quocTich, gioiTinh, ngaySinh, ngayVaoLam);
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }
    public Coach(){
    }

    public Coach(String record) {
        String[] fields = record.split(",");
        soNamKinhNghiem = Integer.parseInt(fields[0]);
        heSoLuong = Double.parseDouble((fields[1]));
        phuCap = Double.parseDouble(fields[2]);

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

    @Override
    public String toString() {
        return super.toString() +soNamKinhNghiem +
                "," + heSoLuong +
                "," + phuCap;
    }
}
