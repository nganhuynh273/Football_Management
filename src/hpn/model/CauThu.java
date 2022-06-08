package hpn.model;

import java.util.Date;

public class CauThu extends Nhanvien {
    private String viTriThiDau;
    private int soLuotTranThamGia;
    private int banThang;
    private double luongThoaThuan;

    public CauThu() {
    }

    public CauThu(String ten, String quocTich, boolean gioiTinh, Date ngaySinh, Date ngayVaoLam, String viTriThiDau, int soLuotTranThamGia, int banThang, double luongThoaThuan) {
        super(ten, quocTich, gioiTinh, ngaySinh, ngayVaoLam);
        this.viTriThiDau = viTriThiDau;
        this.soLuotTranThamGia = soLuotTranThamGia;
        this.banThang = banThang;
        this.luongThoaThuan = luongThoaThuan;
    }

    public String getViTriThiDau() {

        return viTriThiDau;
    }

    public void setViTriThiDau(String viTriThiDau) {

        this.viTriThiDau = viTriThiDau;
    }

    public int getSoLuotTranThamGia() {

        return soLuotTranThamGia;
    }

    public void setSoLuotTranThamGia(int soLuotTranThamGia) {

        this.soLuotTranThamGia = soLuotTranThamGia;
    }

    public int getBanThang() {

        return banThang;
    }

    public void setBanThang(int banThang) {

        this.banThang = banThang;
    }

    public double getLuongThoaThuan() {

        return luongThoaThuan;
    }

    public void setLuongThoaThuan(double luongThoaThuan) {
        this.luongThoaThuan = luongThoaThuan;
    }

    public double tinhLuong() {
        return this.luongThoaThuan + super.tinhPhuCapThamNien();
    }

    @Override
    public String toString() {
        return viTriThiDau + "," +
                soLuotTranThamGia +
                "," + banThang +
                "," + luongThoaThuan;
    }
}
