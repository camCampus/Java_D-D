package donjon;

public class Utils {

    public static void waitSecond(int number) {
        try {
            Thread.sleep(number);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
