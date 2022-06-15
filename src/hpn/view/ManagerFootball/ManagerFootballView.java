//
//package hpn.view;
//import hpn.model.Coach;
//import hpn.model.Footballer;
//import hpn.service.CoachService;
//import hpn.service.FootballerService;
//import hpn.service.StaffService;
//import hpn.utils.DateUtils;
//
//import java.util.Date;
//import java.util.Scanner;
//
//public class ManagerFootballView {
//private StaffService staffService = new StaffService();
//private FootballerService footballerService = new FootballerService();
//private CoachService coachService = new CoachService();
//private Scanner scanner = new Scanner(System.in);
//
//public void add() {
//
//    int num = -1;
//    boolean flag = false;
//    do{
//        String leftAlignFormat = "| %-2s | %-50s | %n";
//        String line = "+----+----------------------------------------------------+%n";
//        System.out.format(line);
//        System.out.format("| #  | Chức năng                                          |%n");
//        System.out.format(line);
//
//        System.out.format(leftAlignFormat, 1, "Thêm Cầu thủ");
//        System.out.format(leftAlignFormat, 2, "Thêm Huấn luận viên:");
//        System.out.format(leftAlignFormat, 0, "Quay lại");
//        System.out.format(line);
//
//        do{
//            System.out.print("\nThêm >");
//            try{
//                num = Integer.parseInt(scanner.nextLine());
//                flag = true;
//            }catch(Exception ex){
//                flag = false;
//            }
//        }while(flag != true);
//
//
//        switch(num){
//            case 1:
//                System.out.println("Thêm Cầu thủ: ");
//                Footballer ct = this.nhapCauThu();
//                if(this.add(ct))
//                    System.out.println("Thêm thành công!");
//                else
//                    System.out.println("Thêm thất bại!");
//                break;
//            case 2:
//                System.out.println("Thêm Huấn luyện viên: ");
//                Coach coach.csv = this.nhapHuanLuyenVien();
//                if(this.add(coach.csv))
//                    System.out.println("Thêm thành công!");
//                else
//                    System.out.println("Thêm thất bại!");
//                break;
//        }
//
//    }while(num != 0);
//}
//    private Footballer nhapCauThu(){
//        Footballer ct = new Footballer();
//        System.out.println("Họ và tên:");
//        ct.setTen(scanner.nextLine());
//        System.out.println("Quốc tịch:");
//        ct.setQuocTich(scanner.nextLine());
//        System.out.println("Giới tính:");
//        String ngaySinh = scanner.next();
//        Date date = DateUtils.stringToDate(ngaySinh);
//        System.out.println("Ngày sinh:");
//
//
//        return ct;
//    }
//    private Coach nhapHuanLuyenVien(){
//        Coach hlv = new Coach();
//        System.out.println("Ho va ten:");
//        hlv.setTen(scanner.nextLine());
//        System.out.println("Quoc tich:");
//        hlv.setQuocTich(scanner.nextLine());
//        System.out.println("Gioi tinh:");
//        hlv.setGioiTinh(this.convertStringToMale());
//        System.out.println("Ngay sinh:");
//        hlv.setNgaySinh(this.convertStringToDate());
//        System.out.println("Ngay vao lam:");
//        hlv.setNgayVaoLam(this.convertStringToDate());
//        System.out.println("So nam kinh nghiem:");
//        hlv.setSoNamKinhNghiem(this.inputInt());
//        System.out.println("He so luong:");
//        hlv.setHeSoLuong(this.inputDouble());
//        System.out.println("Phu cap:");
//        hlv.setPhuCap(this.inputDouble());
//        return hlv;
//
//    }
//}
//
