package hpn.thread;

public class Exit implements Runnable {

    public void exit() {
        String[] string = {
                "☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪",
                "☪           Have a nice day!         ☪",
                "☪------------------------------------☪",
                "☪                                    ☪",
                "☪   CÙNG CODEGYM VƯƠN TẦM THẾ GIỚI   ☪",
                "☪                                    ☪",
                "☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪",
        };
        for (int i = 0; i < string.length; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(string[i]);
        }
        System.exit(0);
        return;
    }

    @Override
    public void run() {

    }
}
