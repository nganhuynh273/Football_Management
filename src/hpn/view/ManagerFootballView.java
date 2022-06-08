package hpn.view;

import hpn.model.CauThu;
import hpn.model.HuanLuyenVien;
import hpn.service.ManagerFootballService;

import java.util.Scanner;

public class ManagerFootballView {
private ManagerFootballService managerFootballService = new ManagerFootballService();
private Scanner scanner = new Scanner(System.in);

public void add() {
    int num = -1;
    boolean flag = false;
    do{
        String leftAlignFormat = "| %-2s | %-50s | %n";
        String line = "+----+----------------------------------------------------+%n";
        System.out.format(line);
        System.out.format("| #  | Chức năng                                          |%n");
        System.out.format(line);

        System.out.format(leftAlignFormat, 1, "Thêm Cầu thủ");
        System.out.format(leftAlignFormat, 2, "Thêm Huấn luận viên:");
        System.out.format(leftAlignFormat, 0, "Quay lại");
        System.out.format(line);

        do{
            System.out.print("\nThêm >");
            try{
                num = Integer.parseInt(scanner.nextLine());
                flag = true;
            }catch(Exception ex){
                flag = false;
            }
        }while(flag != true);


        switch(num){
            case 1:
                System.out.println("Thêm Cầu thủ: ");
                CauThu ct = this.nhapCauThu();
                if(this.them(ct))
                    System.out.println("Thêm thành công!");
                else
                    System.out.println("Thêm thất bại!");
                break;
            case 2:
                System.out.println("Thêm Huấn luyện viên: ");
                HuanLuyenVien hlv = this.nhapHuanLuyenVien();
                if(this.them(hlv))
                    System.out.println("Thêm thành công!");
                else
                    System.out.println("Thêm thất bại!");
                break;
        }

    }while(num != 0);
}
    private CauThu nhapCauThu(){
        CauThu ct = new CauThu();
        System.out.println("Họ và tên:");
        ct.setTen(scanner.nextLine());
        System.out.println("Quoc tich:");
        ct.setQuocTich(scanner.nextLine());
        System.out.println("Gioi tinh:");

        return ct;
    }
    private HuanLuyenVien nhapHuanLuyenVien(){
        HuanLuyenVien hlv = new HuanLuyenVien();
        System.out.println("Ho va ten:");
        hlv.setTen(scanner.nextLine());
        System.out.println("Quoc tich:");
        hlv.setQuocTich(scanner.nextLine());
        System.out.println("Gioi tinh:");
        hlv.setGioiTinh(this.convertStringToMale());
        System.out.println("Ngay sinh:");
        hlv.setNgaySinh(this.convertStringToDate());
        System.out.println("Ngay vao lam:");
        hlv.setNgayVaoLam(this.convertStringToDate());
        System.out.println("So nam kinh nghiem:");
        hlv.setSoNamKinhNghiem(this.inputInt());
        System.out.println("He so luong:");
        hlv.setHeSoLuong(this.inputDouble());
        System.out.println("Phu cap:");
        hlv.setPhuCap(this.inputDouble());
        return hlv;

    }
}
