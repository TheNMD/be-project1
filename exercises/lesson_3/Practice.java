public class Practice {
    public void question1(String var) {
        System.out.println("Question 1:\n");
        System.out.printf("Result: %s\n", var);
        System.out.println();
    }

    public void question2(int num) {
        System.out.println("Question 2:\n");
        if (num == 0) {
            System.out.printf("%d is neither negative nor positive\n", num);
        }
        else if (num > 0) {
            System.out.printf("%d is positive\n", num);
        }
        else {
            System.out.printf("%d is negative\n", num);
        }

        if (num % 2 == 0) {
            System.out.printf("%d is even\n", num);
        }
        else {
            System.out.printf("%d is odd\n", num);
        }
        System.out.println();
    }

    public void question3(int a, int b) {
        System.out.println("Question 3:\n");
        System.out.printf("Addition: %d\n", a + b);
        System.out.printf("Subtraction: %d\n", a - b);
        System.out.printf("Multiplication: %d\n", a * b);
        if (b != 0) {
            System.out.printf("Division: %.2f\n", (double) a / b);
        }
        else {
            System.out.println("Division: Divide by 0");
        }
        System.out.println();
    }

    public void question4(double a, double b) {
        System.out.println("Question 4:\n");
        if (a > b) {
            System.out.printf("a = %.2f is larger than b = %.2f\n", a, b);
        }
        else if (a < b) {
            System.out.printf("a = %.2f is smaller than b = %.2f\n", a, b);
        }
        else {
            System.out.printf("a = %.2f is equal to b = %.2f\n", a, b);
        }
        System.out.println();
    }

    public void question5(double length, double width) {
        System.out.println("Question 5:\n");
        System.out.printf("Perimeter: %.2f\n", 2 * (length + width));
        System.out.printf("Area: %.2f\n", length * width);
        System.out.println();
    }

    public void question6(double a, double b, double c) {
        System.out.println("Question 6:\n");
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("NO");
        }
        if (a + b > c && a + c  > b && b + c > a) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Practice obj = new Practice();
        obj.question1("Hello World");
        obj.question2(-13);
        obj.question3(3, 10);
        obj.question4(1, 10);
        obj.question5(7.6, 13.4);
        obj.question6(4, 5, 4);
    }
}
