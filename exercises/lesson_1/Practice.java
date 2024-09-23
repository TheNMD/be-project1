public class Practice {
    public void question1() {
        System.out.println("Question 1:\n");
        System.out.println("Welcome to Java");
        System.out.println("Welcome to Computer Science");
        System.out.println("Programming is fun");
        System.out.println();
    }

    public void question2() {
        System.out.println("Question 2:\n");
        System.out.println("    J     A     V     V     A ");
        System.out.println("    J    A A     V   V     A A ");
        System.out.println("J   J   AAAAA     V V     AAAAA ");
        System.out.println(" J J   A     A     V     A     A");
        System.out.println();
    }

    public void question3() {
        System.out.println("Question 3:\n");
        System.out.println("a a^2 a^3");
        System.out.println("1 1   1");
        System.out.println("2 4   8");
        System.out.println("3 9   27");
        System.out.println("4 10  64");
        System.out.println();
    }

    public void question4(double radius) {
        System.out.println("Question 4:\n");
        System.out.printf("Perimeter: %.2f\n", 2 * radius * 3.14);
        System.out.printf("Area: %.2f\n", radius * radius * 3.14);
        System.out.println();
    }

    public void question5(double length, double width) {
        System.out.println("Question 5:\n");
        System.out.printf("Perimeter: %.2f\n", 2 * (length + width));
        System.out.printf("Area: %.2f\n", length * width);
        System.out.println();
    }

    public void question6() {
        System.out.println("Question 6:\n");
        System.out.printf("1st result: %.2f\n", (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));
        System.out.printf("2nd result: %d\n", 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9);
        System.out.printf("3rd result: %.0f\n", 1000000.0 * (1000000 + 1) / 2);
        System.out.printf("4th result: %.2f\n", 4 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11) + (1.0/13)));
        System.out.println();
    }

    public void question7(double distance, int hour, double minute, double second) {
        System.out.println("Question 7:\n");
        System.out.printf("Average speed: %.2f miles/h\n", (distance / 1.6) / (hour + minute / 60 + second / 3600));
        System.out.println();
    }

    public void question8(double distance, int hour, double minute, double second) {
        System.out.println("Question 8:\n");
        System.out.printf("Average speed: %.2f km/h\n", distance * 1.6  / (hour + minute / 60 + second / 3600));
        System.out.println();
    }

    public void question9() {
        System.out.println("Question 9:\n");
        System.out.printf("Population in 1 year: %.2f\n", 312032486 + (365 * 24 * 3600) * (1.0 / 7 + 1.0 / 13 + 1.0 / 45));
        System.out.printf("Population in 2 years: %.2f\n", 312032486 + 2 * (365 * 24 * 3600) * (1.0 / 7 + 1.0 / 13 + 1.0 / 45));
        System.out.printf("Population in 3 years: %.2f\n", 312032486 + 3 * (365 * 24 * 3600) * (1.0 / 7 + 1.0 / 13 + 1.0 / 45));
        System.out.printf("Population in 4 years: %.2f\n", 312032486 + 4 * (365 * 24 * 3600) * (1.0 / 7 + 1.0 / 13 + 1.0 / 45));
        System.out.printf("Population in 5 years: %.2f\n", 312032486 + 5 * (365 * 24 * 3600) * (1.0 / 7 + 1.0 / 13 + 1.0 / 45));
        System.out.println();
    }

    public void question10(double a, double b, double c, double d, double e, double f) {
        System.out.println("Question 10:\n");
        System.out.printf("x = %.2f\n", (e * d - b * f) / (a * d - b * c));
        System.out.printf("y = %.2f\n", (a * f - e * c) / (a * d - b * c));
        System.out.println();
    }

    public static void main(String[] args) {
        Practice obj = new Practice();
        obj.question1();
        obj.question2();
        obj.question3();
        obj.question4(5.5);
        obj.question5(4.5, 7.9);
        obj.question6();
        obj.question7(14, 0, 45, 30);
        obj.question8(24, 1, 40, 35);
        obj.question9();
        obj.question10(3.4, 50.2, 2.1, 0.55, 44.5, 5.9);
    }

}
