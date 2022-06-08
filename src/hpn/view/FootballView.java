package hpn.view;

import java.util.Scanner;

public class FootballView {
private static Scanner scanner = new Scanner(System.in);

public static void create() {
    Menu.ManagerFootball();
    ManagerFootballView managerFootballView = new ManagerFootballView();
    System.out.println("Chọn chức năng \n ➨ \t");
    try {
        int choice = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        do {
            switch (choice) {
                case 1:
                    managerFootballView.show();
                    break;
                case 2:
                    managerFootballView.add();
                    break;
                case 3:
                    managerFootballView.suaNhanVien();
                    break;
                case 4:
                    managerFootballView.xoaNhanVien();
                    break;
                case 5:
                    managerFootballView.xuatNhanVien();
                    break;
                case 6:
                    managerFootballView.timKiemCauThu();
                    break;
                case 7:
                    managerFootballView.nhapDuLieuTuDong();
                    break;
                case 8:
                    Menu.startMenu();
                    break;
                case 0:
                    Menu.exit();
                    System.exit(0);
                default:
                    System.out.println("Không hợp lệ, xin vui lòng nhập lại");
                    flag = false;
            }
        } while (!flag);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
}
