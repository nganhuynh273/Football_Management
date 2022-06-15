package hpn.model;

import java.util.Date;

public class Footballer extends Staff {
    private String viTriThiDau;
    private int soLuotTranThamGia;
    private int banThang;
    private double luongThoaThuan;


    public Footballer(long id, String maNhanvien, String ten, String quocTich, String gioiTinh, Date ngaySinh, Date ngayVaoLam, String viTriThiDau, int soLuotTranThamGia, int banThang, double luongThoaThuan) {
        super(id, maNhanvien, ten, quocTich, gioiTinh, ngaySinh, ngayVaoLam);
        this.viTriThiDau = viTriThiDau;
        this.soLuotTranThamGia = soLuotTranThamGia;
        this.banThang = banThang;
        this.luongThoaThuan = luongThoaThuan;
    }

    public Footballer() {
    }

    public Footballer(String record) {
        String[] fields = record.split(",");
        viTriThiDau = fields[0];
        banThang = Integer.parseInt(fields[1]);
        luongThoaThuan = Double.parseDouble(fields[2]);

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
        return super.toString() + viTriThiDau + "," +
                soLuotTranThamGia +
                "," + banThang +
                "," + luongThoaThuan;
    }
}
