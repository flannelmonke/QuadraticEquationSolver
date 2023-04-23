import java.util.Scanner;

public class QuadraticMethod extends Exception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double discriminant = b * b - 4 * a * c;
        double rootPos = 0;
        double rootNeg = 0;
        double specResult = 0;
        if (discriminant < 0) {
            System.out.println("This equation has no real roots");
        }else if(a== 0 && b ==0){
            System.out.println("There is no equation");
        } 
        else if (a == 0) {
            specResult = (c/b)*-1;
            System.out.println(specResult);
        } else {
            System.out.println("quadratic method");
            rootPos = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            rootNeg = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            System.out.println(rootPos);
            System.out.println(rootNeg);
        }
    }
}