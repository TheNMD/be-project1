public class Practice {
    public void question1(double inches) {
        System.out.println("Question 1:\n");
        System.out.printf("%.2f inches = %.2f cm\n", inches, inches * 2.54);
        System.out.println();
    }

    public void question2(String degreeType, double degree) {
        System.out.println("Question 2:\n");
        if (degreeType.equals("C")) {
            System.out.printf("%.2f C = %.2f F\n", degree, degree * 9 / 5 + 32);
        }
        else if (degreeType.equals("F")) {
            System.out.printf("%.2f F = %.2f C\n", degree, (degree - 32) * 5 / 9);
        }
        System.out.println();
    }

    public void question3(int time) {
        int minuteInYear = 365 * 24 * 60;
        int minuteInDay =  24 * 60;
        int minuteInHour = 60;

        int numYear = time / minuteInYear;
        time -= minuteInYear * numYear;
        int numDay = time / minuteInDay;
        time -= minuteInDay * numDay;
        int numHour = time / minuteInHour;
        time -= minuteInHour * numHour;
        int numMinute = time;

        System.out.println("Question 3:\n");
        System.out.printf("Number of year: %d\n", numYear);
        System.out.printf("Number of day: %d\n", numDay);
        System.out.printf("Number of hour: %d\n", numHour);
        System.out.printf("Number of minute: %d\n", numMinute);
        System.out.println();
    }

    public double question4(int num) {
        if (num == 0) {
            return 1;
        }
        else {
            return num * question4(num - 1);
        }
    }

    public String question5(int num) {
        if (num == 0) {
            return "";
        }
        else {
            return question5(num / 2) + (num % 2);
        }
    }

    public void question6(int num) {
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        int valueHundred = 100;
        int valueTen = 10;
        int valueUnit = 1;

        String romanSymbol = "";
        int indexHundred = num / valueHundred;
        romanSymbol += hundreds[indexHundred];
        num -= valueHundred * indexHundred;
        int indexTen = num / valueTen;
        romanSymbol += tens[indexTen];
        num -= valueTen * indexTen;
        int indexUnit = num / valueUnit;
        romanSymbol += units[indexUnit];

        System.out.println("Question 6:\n");
        System.out.printf("Result: %s\n", romanSymbol);
        System.out.println("");
    }

    public void question7(double a, double b, double c) {
        System.out.println("Question 6:\n");
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Not a triangle");
        }
        else if (a + b > c && a + c  > b && b + c > a) {
            double perimeter = a + b + c;
            // Heron's method
            double s = (a + b + c) / 2;
            double area =  Math.sqrt(s *(s - a) * (s - b) * (s - c));
            System.out.printf("Perimeter: %.2f\n", perimeter);
            System.out.printf("Area: %.2f\n", area);

            // Equilateral
            if (a == b && b == c) {
                System.out.println("Equilateral triangle");
            }
            // Isosceles
            else if (a == b || a == c || b == c) {
                System.out.println("Isosceles triangle");
            }
            // Scalene
            else {
                System.out.println("Scalene triangle");
            }
        }
        else {
            System.out.println("Not a triangle");
        }
        System.out.println("");
    }

    public int question8(int num, int divisor) {
        if (divisor >= num) {
            return 0;
        }
        
        if (num % divisor == 0) {
            return divisor + question8(num, divisor + 1);
        }
        else {
            return question8(num, divisor + 1);
        }
    }

    public void question9(double a, double b, double c) {
        System.out.println("Question 9:\n");
        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite solutions");
            }
            else {
                System.out.printf("x = %.2f\n", -c / b);
            }
        }

        double delta = b * b - 4 * a * c ;
        if (delta < 0) {
            System.out.println("No solution");
        }
        else if (delta == 0) {
            System.out.printf("x1 = x2 = %.2f\n", -b / (2 * a));
        }
        else {
            double solution1 = (-b + Math.sqrt(delta)) / (2 * a);
            double solution2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("x1 = %.2f\nx2 = %.2f\n", solution1, solution2); 
        }
        System.out.println();
    }

    public void question10(int money) {
        int num500 = money / 500;
        money -= num500 * 500;
        int num200 = money / 200;
        money -= num200 * 200;
        int num100 = money / 100;
        money -= num100 * 100;
        int num50 = money / 50;
        money -= num50 * 50;
        int num20 = money / 20;
        money -= num20 * 20;
        int num10 = money / 10;
        money -= num10 * 10;
        int num5 = money / 5;
        money -= num5 * 5;
        int num2 = money / 2;
        money -= num2 * 2;
        int num1 = money / 1;

        System.out.println("Question 10:\n");
        System.out.printf("Number of 500: %d\n", num500);
        System.out.printf("Number of 200: %d\n", num200);
        System.out.printf("Number of 100: %d\n", num100);
        System.out.printf("Number of 50: %d\n", num50);
        System.out.printf("Number of 20: %d\n", num20);
        System.out.printf("Number of 10: %d\n", num10);
        System.out.printf("Number of 5: %d\n", num5);
        System.out.printf("Number of 2: %d\n", num2);
        System.out.printf("Number of 1: %d\n", num1);
        System.out.println();
    }

    public static void main(String[] args) {
        Practice obj = new Practice();
        obj.question1(100);
        obj.question2("F", 30);
        obj.question3(60 * 24 * 366 + 2);
        System.out.println("Question 4:\n");
        System.out.printf("Result: %.0f\n", obj.question4(5));
        System.out.println();
        System.out.println("Question 5:\n");
        System.out.printf("Result: %s\n", obj.question5(100));
        System.out.println();
        obj.question6(999);
        obj.question7(4, 5, 4);
        System.out.println("Question 8:\n");
        int givenNum = 6;
        System.out.printf("Is a perfect number?: %b\n", obj.question8(givenNum, 1) == givenNum);
        System.out.println();
        obj.question9(1, 3, 1);
        obj.question10(12345);
    }
}