package by.photoshop.smelnik.ui.utils;

public class Waiter {
    public static void wait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
