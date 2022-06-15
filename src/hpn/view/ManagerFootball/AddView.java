package hpn.view.ManagerFootball;

import hpn.model.Footballer;
import hpn.model.Staff;
import hpn.service.CoachService;
import hpn.service.FootballerService;
import hpn.utils.ConvertUtils;
import hpn.utils.DateUtils;
import hpn.utils.ValidationUtils;
import hpn.view.Menu;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AddView {
    static Scanner scanner = new Scanner(System.in);
    static CoachService coachService = new CoachService();
    static FootballerService footballerService = new FootballerService();
    DecimalFormat format = new DecimalFormat("###,###,###" + " VNĐ");

    public static void add() {
        boolean isChoice = true;
        int choice = -1;
        do {
            String leftAlignFormat = "| %-2s | %-50s | %n";
            String line = "+----+----------------------------------------------------+%n";
            System.out.format(line);
            System.out.format("| #  | Chức năng                                          |%n");
            System.out.format(line);
            System.out.format(leftAlignFormat, 1, "Thêm Cầu thủ");
            System.out.format(leftAlignFormat, 2, "Thêm Huấn luận viên:");
            System.out.format(leftAlignFormat, 0, "Quay lại");
            System.out.format(line);
            System.out.print("Chọn\t➨ ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
            switch (choice) {
                case 1:
                    addFootballer();
                    break;
                case 2:
                    //addCoach();
                    break;
                case 0:
                    FootballView.create();
                    isChoice = false;
                    break;
                default:
                    System.out.println("Chưa hợp lệ! Xin vui lòng nhập lại!");
            }
        } while (isChoice);
    }

    public static void addFootballer() {
        try {
            int id;
            Random r = new Random();
            int low = 1;
            int high = 9999;
            do {
                id = r.nextInt(high - low) + low;
            } while (footballerService.exists(id));

            System.out.println("Nhập mã nhân viên (Ví dụ: HLV02 hoặc CT273): ");
            System.out.print("➨ ");
            String maNhanvien = scanner.nextLine();
            while (!ValidationUtils.isIDStaffValid(maNhanvien)) {
                System.out.println("Mã nhân viên " + maNhanvien + " chưa hợp lệ. Vui lòng nhập lại!\n" +
                        "Mã nhân viên phải bắt đầu bằng chữ in hoa HLV hoặc CT. (Ví dụ: HLV02 hoặc CT273)");
                maNhanvien = scanner.nextLine();
            }
            while (footballerService.existsbyIDStaff(maNhanvien)) {
                System.out.println("Mã nhân viên đã tồn tại, xin vui lòng nhập lại!");
                maNhanvien = scanner.nextLine();
            }

            System.out.println("Nhập họ và tên: (Ví dụ: Huỳnh Phương Ngân) ");
            System.out.print("➨ ");
            String ten = scanner.nextLine();
            String namecheck;
            namecheck = ConvertUtils.removeAccent(ten);
            while (!ValidationUtils.isNameValid(namecheck)) {
                System.out.println("Tên " + namecheck + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu)");
                System.out.println("Nhập tên (Ví dụ: Huỳnh Phương Ngân) ");
                System.out.print("➨ ");
                ten = scanner.nextLine();
            }
            System.out.println("Nhập quốc tịch (Ví dụ: Viet Nam) ");
            System.out.print("➨ ");
            String quocTich = scanner.nextLine();
            while (!ValidationUtils.isNameValid(quocTich)) {
                System.out.println("Nhập sai. Vui lòng nhập lại! \n" +
                        "Lưu ý: Tên phải viết hoa chữ cái đầu và không dấu");
                System.out.println("Nhập quốc tịch (vd: Viet Nam) ");
                System.out.print("➨ ");
                ten = scanner.nextLine();
            }
            System.out.println("Nhập giới tính (Ví dụ: Nam hoặc Nữ) ");
            System.out.print("➨ ");
            String gioiTinh = scanner.nextLine();
            while (!ValidationUtils.isGioitinh(gioiTinh)) {
                System.out.println("Giới tính " + gioiTinh + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và có dấu)");
                System.out.println("Nhập giới tính (ví dụ: Nam hoặc Nữ");
                System.out.print("➨ ");
                gioiTinh = scanner.nextLine();
            }
            System.out.print("Nhập ngày sinh (Ví dụ: 27-03-1996)");
            System.out.println("➨ ");
            Date ngaySinh = DateUtils.stringToDate(scanner.nextLine());
            System.out.print("Nhập ngày vào làm (Ví dụ: 03-05-2021)");
            Date ngayVaoLam = DateUtils.stringToDate(scanner.nextLine());
            System.out.println("Nhập vị trí thi đấu: (Ví dụ: Cầu thủ) ");
            System.out.println("➨ ");
            String viTriThiDau = scanner.nextLine();
            namecheck = ConvertUtils.removeAccent(viTriThiDau);
            while (!ValidationUtils.isNameValid(namecheck)) {
                System.out.println("Vị trí " + namecheck + " không đúng." + " Vui lòng nhập lại!" + " (Vị trí phải viết hoa chữ cái đầu)");
                System.out.println("Nhập tên: (Ví dụ: Thủ môn) ");
                System.out.print("➨ ");
                viTriThiDau = scanner.nextLine();
            }

            System.out.println("Số trận đã thi đấu: ");
            int soLuotTranThamGia;
            do {
                soLuotTranThamGia = Integer.parseInt(scanner.nextLine());
                if (!(soLuotTranThamGia >= 0)) {
                    System.out.println("! ERROR ! \n" +
                            " \t Xin vui lòng nhập lại! \n ➨ \t ");
                    System.out.print("➨ \t ");
                }
            } while (!(soLuotTranThamGia >= 0));

            System.out.println("Số lượt ghi bàn thắng: ");
            int banThang;
            do {
                banThang = Integer.parseInt(scanner.nextLine());
                if (!(banThang >= 0)) {
                    System.out.println("! ERROR ! \n" +
                            " \t Xin vui lòng nhập lại! \n ➨ \t ");
                    System.out.print("➨ \t ");
                }
            } while (!(banThang >= 0));


            System.out.println("Nhập lương thỏa thuận: ");
            System.out.print(" ➨ ");
            double luongThoaThuan;
            do {
                luongThoaThuan = Double.parseDouble(scanner.nextLine());
                if (!(luongThoaThuan >= 0)) {
                    System.out.println("! ERROR ! \n" +
                            " \t Xin vui lòng nhập lại! \n ➨ \t ");
                    System.out.print("➨ \t ");
                    luongThoaThuan = Double.parseDouble(scanner.nextLine());
                }
            } while (!(luongThoaThuan >= 0));

            Footballer footballer = new Footballer(id, maNhanvien, ten, quocTich, gioiTinh, ngaySinh, ngayVaoLam,
                    viTriThiDau, soLuotTranThamGia, banThang, luongThoaThuan);
//        System.out.printf("Lương thực nhận: %.2f ", footballer.tinhLuong());
            footballerService.addFootballerItem(footballer);
            System.out.println("Cầu thủ đã được thêm vào danh sách!");
            do {
                System.out.println("❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂");
                System.out.println("❂                                         ❂");
                System.out.println("❂     1. Nhấn 'y' để tạo thêm danh sách   ❂");
                System.out.println("❂     2. Nhấn 'c' để trở lại              ❂");
                System.out.println("❂     3. nhấp 'p' để in danh sách         ❂");
                System.out.println("❂     4. Nhấn 't' để thoát                ❂");
                System.out.println("❂                                         ❂");
                System.out.println("❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂");
                System.out.print(" ➨ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "y":
                        addFootballer();
                        break;
                    case "c":
                        FootballView.create();
                        break;
                    case "p":
                        showFootballerInfo(footballer);
                        break;
                    case "t":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Không hợp lệ! Xin vui lòng nhập lại!");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Nhập sai. Xin vui lòng nhập lại!");

        }
    }
    public static void showFootballerInfo(Footballer footballer) {
        try {
            System.out.println("---------------------- DANH SÁCH -----------------------------");
            System.out.println("");
            System.out.println("ID: " + footballer.getStaffID() + "Mã nhân viên: " + footballer.getMaNhanvien() + "Họ và tên: " + footballer.getTen());
            System.out.printf("|%-15s %-20s %-12s %-23s %-10s \n|", "Quốc tịch", "Giới tính", "Ngày sinh", "Ngày vào làm");
            System.out.printf("|%-15s %-20s %-12s %-23s %-10s \n|",
                    footballer.getQuocTich(),
                    footballer.getGioiTinh(),
                    footballer.getNgaySinh(),
                    footballer.getNgayVaoLam());
            System.out.printf("|%-15s %-20s %-12s %-23s %-10s \n|",
                    footballer.getBanThang(),
                    footballer.getViTriThiDau(),
                    footballer.getSoLuotTranThamGia(),
                    footballer.getLuongThoaThuan());
            System.out.print("Lương thực nhận: " + footballer.tinhLuong());

            boolean is = true;
            do {
                System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                System.out.println("Nhấn ");
                System.out.print("➨ \t ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        FootballView.create();
                        break;
                    case "t":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Không hợp lệ. Xin vui lòng nhập lại");
                }
            } while (!is);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
//        Footballer footballer = new Footballer();
//        addFootballer();
        System.out.println("Nhập họ và tên: (Ví dụ: Huỳnh Phương Ngân) ");
        System.out.print("➨ ");
        String ten = scanner.nextLine();
        String namecheck;
        namecheck = ConvertUtils.removeAccent(ten);
        while (!ValidationUtils.isNameValid(namecheck)) {
            System.out.println("Tên " + namecheck + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu)");
            System.out.println("Nhập tên (Ví dụ: Huỳnh Phương Ngân) ");
            System.out.print("➨ ");
            ten = scanner.nextLine();
        }
    }

//    public static void addCoach() {
//        int id;
//        Random r = new Random();
//        int low = 1;
//        int high = 9999;
//        do {
//            id = r.nextInt(high - low) + low;
//        } while (coachService.exists(id));
//
//        System.out.println("Nhập mã nhân viên: (Ví dụ: HLV02 hoặc CT273) ");
//        System.out.println(" ➨ ");
//        String maNhanvien = scanner.nextLine();
//        while (!ValidationUtils.isIDStaffValid(maNhanvien)) {
//            System.out.println("Mã nhân viên " + maNhanvien + " chưa hợp lệ. Vui lòng nhập lại (Mã nhân viên phải bắt đầu bằng chữ in hoa HLV hoặc CT) \n " +
//                    " \t (Ví dụ: HLV02 hoặc CT273) \n ➨ \t");
//            maNhanvien = scanner.nextLine();
//        }\
//        while (footballerService.existsbyIDStaff(maNhanvien)) {
//            System.out.println("Mã nhân viên đã tồn tại, xin vui lòng nhập lại!");
//            maNhanvien = scanner.nextLine();
//        }
//
//        System.out.println("Nhập họ và tên: (Ví dụ: Huỳnh Phương Ngân) ");
//        System.out.print(" ➨ ");
//        String name = scanner.nextLine();
//        String namecheck;
//        namecheck = ConvertUtils.removeAccent(name);
//        while (!ValidationUtils.isNameValid(namecheck)) {
//            System.out.println("Tên " + namecheck + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu)");
//            System.out.println("Nhập tên: (Ví dụ: Huỳnh Phương Ngân) ");
//            System.out.print(" ➨ ");
//            name = scanner.nextLine();
//        }
//        System.out.println("Nhập quốc tịch (Ví dụ: Viet Nam) ");
//        System.out.print(" ➨ ");
//        String quocTich = scanner.nextLine();
//        while (!ValidationUtils.isNameValid(quocTich)) {
//            System.out.println("Quốc tịch " + quocTich + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và không dấu)");
//            System.out.println("Nhập quốc tịch (vd: Viet Nam) ");
//            System.out.print(" ➨ ");
//            name = scanner.nextLine();
//        }
//        System.out.println("Nhập giới tính (Ví dụ: Nam hoặc Nữ) ");
//        System.out.print(" ➨ ");
//        String gioiTinh = scanner.nextLine();
//        while (!ValidationUtils.isGioitinh(gioiTinh)) {
//            System.out.println("Giới tính " + gioiTinh + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và có dấu)");
//            System.out.println("Nhập giới tính (ví dụ: Nam hoặc Nữ");
//            System.out.print(" ➨ ");
//            gioiTinh = scanner.nextLine();
//        }
//        System.out.print("Nhập ngày sinh (Ví dụ: 27-03-1996)");
//        System.out.print(" ➨ ");
//        String ngaySinh = scanner.next();
//        Date date = DateUtils.stringToDate(ngaySinh);
//        System.out.print("Nhập ngày vào làm (Ví dụ: 03-05-2021)");
//        String ngayVaoLam = scanner.next();
//
//
//        System.out.println("Số năm kinh nghiệm: ");
//        int soNamKinhNghiem;
//        do {
//            soNamKinhNghiem = Integer.parseInt(scanner.nextLine());
//            if (!(soNamKinhNghiem > 0 && soNamKinhNghiem <= 100)) {
//                System.out.println("Số năm kinh nghiệm không vượt quá 100 năm");
//                System.out.print("➨ \t ");
//            }
//        } while (!(soNamKinhNghiem > 0 && soNamKinhNghiem <= 1000));
//
//
//        System.out.println("Lương thỏa thuận: ");
//        double luongThoaThuan;
//        Footballer footballer = new Footballer();
//        footballerService.addFootballerItem(footballer);
//    }


}

