import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        int input = scanner.nextInt();

        if (input % 2 == 1) {
            input++;
        } else if (input % 2 == 0) {
            input += 2;
        }

        System.out.println(input);
    }
}