package hpn.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public Menu() {
        startMenu();
    }

    public static void mainMenu() {
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        System.out.println("✤                      MAIN MENU                       ✤");
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        System.out.println("✤                                                      ✤");
        System.out.println("✤                 1. Quản lý danh sách đội bóng        ✤");
        System.out.println("✤                 2. Quản lý thi đấu                   ✤");
        System.out.println("✤                 3. Thoát                             ✤");
        System.out.println("✤                                                      ✤");
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        System.out.print("Chọn chức năng \n➨ \t");

    }
    public static void ManagerFootball() {
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷                QUẢN LÝ DANH SÁCH ĐỘI BÓNG            ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷                                                      ✷");
        System.out.println("✷           1. Hiển thị danh sách                      ✷");
        System.out.println("✷           2. Thêm danh sách                          ✷");
        System.out.println("✷           3. Sửa danh sách                           ✷");
        System.out.println("✷           4. Xóa danh sách                           ✷");
        System.out.println("✷           5. Tìm kiếm nhân viên theo vị trí          ✷");
        System.out.println("✷           6. Tìm kiếm cầu thủ theo vị trí thi đấu    ✷");
        System.out.println("✷           7. Tạo dữ liệu tự động                     ✷");
        System.out.println("✷           8. Quay về menu chính                      ✷");
        System.out.println("✷           0. Thoát chương trình                      ✷");
        System.out.println("✷                                                      ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println();
        System.out.printf("Chọn chức năng  \n➨ \t");
    }

    public static void ManagerSchedule() {
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷                QUẢN LÝ THI ĐẤU                       ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷                                                      ✷");
        System.out.println("✷           1. Xem lịch thi đấu                        ✷");
        System.out.println("✷           2. Cập nhật lịch thi đấu                   ✷");
        System.out.println("✷           3. Tạo lịch thi đấu                        ✷");
        System.out.println("✷           4. Xem kết quả thi đấu                     ✷");
        System.out.println("✷           5. Bảng giá chuyển nhượng cầu thủ          ✷");
        System.out.println("✷           6. Quay về menu chính                      ✷");
        System.out.println("✷           0. Thoát chương trình                      ✷");
        System.out.println("✷                                                      ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println();
        System.out.printf("Chọn chức năng  \n➨ \t");
    }

    public  static void startMenu() {
        try {
            boolean flag = true;
            do {
                mainMenu();
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        FootballView.create();
                        break;
                    case 2:
                        ScheduleView.start();
                        break;
                    default:
                        System.out.println("Không hợp lệ, xin vui lòng nhập lại!");
                        flag = false;
                }
            } while (!flag);
        } catch (InputMismatchException io) {
            io.printStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
