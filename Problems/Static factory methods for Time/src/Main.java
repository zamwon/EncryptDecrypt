import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        // write your code here

        Time noon = new Time();
        noon.hour = 12;
        noon.minute = 0;
        noon.second = 0;
        return noon;
    }

    public static Time midnight() {
        // write your code here
        Time mid = new Time();
        mid.hour = 0;
        mid.minute = 0;
        mid.second = 0;
        return mid;
    }

    public static Time ofSeconds(long seconds) {
        // write your code here
        int temp = (int) (seconds / 3600);
        int hour = temp > 23 ? (temp % 24) : temp;
        int minutes = (int) ((seconds % 3600) / 60);
        int second = (int) (seconds % 60);

        return Time.of(hour, minutes, second);
    }

    public static Time of(int hour, int minute, int second) {
        // write your code here
        if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59) {
          Time currentT = new Time();
          currentT.hour = hour;
          currentT.minute = minute;
          currentT.second = second;
          return currentT;
        } else {
            return null;
        }
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}