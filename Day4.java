import java.util.Scanner;

public class DayFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(findComplement(sc.nextInt()));
        sc.close();
    }

    public static int findComplement(int num) {
        int x = (int) (Math.log(num) / Math.log(2)) + 1;
        for (int i = 0; i < x; i++) {
            num = (num ^ (1 << i));
        }
        return num;
    }
}