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
                System.out.println("Введені дані не є числом або дробове число має крапку.");
                scanner.next();
            }
        }
        while (true) {
            System.out.println("Введіть значення delta:");
            try {
                delta = Math.abs(scanner.nextDouble());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введені дані не є числом або дробове число має крапку.");
                scanner.next();
            }
        }
        double result = 0;
        double term = 0;
        for (int n = 0; GetExp(x,n)>delta; n++) {
            term = GetExp(x,n);
            result += term;
            System.out.println("Наближене значення у1 = "+term+" При N = " + n + " - " + result);
        }
        System.out.println("Результат = "+ result + " з останнім числом = "+ term);
    }

    public static double GetExp(double x, int n)
    {
        double result =1;
        for (int i =1; i<=n;i++)
        {
            result*=x/i;
        }
        return result;
    }
}
