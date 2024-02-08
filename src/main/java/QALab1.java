import java.util.InputMismatchException;
import java.util.Scanner;

public class QALab1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double x;
        double delta;
        while (true) {
            System.out.println("Введіть значення x:");
            try {
                x = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введені дані не є числом.");
                scanner.next();
            }
        }
        while (true) {
            System.out.println("Введіть значення delta:");
            try {
                delta = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введені дані не є числом.");
                scanner.next();
            }
        }
        double result = 0;
        for (int n = 0; true; n++) {
            double term = Math.pow(x,n)/getFactorial(n);
            result += term;
            System.out.println("Наближене значення у1 = "+term+" При N = " + n);
            if (term<delta) {
                System.out.println("Результат = "+ result + " з останнім числом = "+ term);
                break;
            }
        }
    }

    public static int getFactorial(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return f * getFactorial(f - 1);
        }
    }
}
