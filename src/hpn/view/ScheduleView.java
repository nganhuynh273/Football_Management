//package hpn.view;
//
//import java.util.Scanner;
//
//public class ScheduleView {
//    static Scanner scanner = new Scanner(System.in);
//
//    public static void start() {
//        Menu.ManagerSchedule();
//        ManagerScheduleView managerScheduleView = new ManagerScheduleView();
//        System.out.println("Chọn chức năng \n ➨ \t");
//        try {
//            boolean flag = true;
//            int choice = Integer.parseInt(scanner.nextLine());
//            do {
//                switch (choice) {
//                    case 1:
//                        managerScheduleView.viewSchedule();
//                        break;
//                    case 2:
//                        managerScheduleView.updateSchedule();
//                        break;
//                    case 3:
//                        managerScheduleView.createSchedule();
//                        break;
//                    case 4:
//                        managerScheduleView.results();
//                        break;
//                    case 5:
//                        managerScheduleView.playerPrice();
//                        break;
//                    case 6:
//                        Menu.startMenu();
//                        break;
//                    default:
//                        System.out.println("Không hợp lệ, xin vui lòng nhập lại");
//                        flag = false;
//                }
//            } while (!flag);
//        } catch (Exception e) {
//            System.out.println("Không hợp lệ, vui lòng nhập lại!");
//        }
//    }
//}
