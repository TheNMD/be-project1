import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Practice {
    public void question1(double[] arr) {
        double result = 0;
        System.out.println("Question 1:\n");
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        System.out.printf("Sum = %.2f\n", result);
        System.out.println();
    }

    public void question2(double[] arr, int idx) {
        System.out.println("Question 2:\n");
        if (idx < 0 || idx >= arr.length) {
            System.out.printf("arr[%d] = -1\n", idx);
        }
        else {
            System.out.printf("arr[%d] = %.2f\n", idx, arr[idx]);
        }
        System.out.println();
    }

    public void question3(double[][] matrix) {
        double max = matrix[0][0];
        
        System.out.println("Question 3:\n");

        for (double[] row : matrix) {
            for (double col : row) {
                max = col > max ? col : max;
            }
        }
        System.out.printf("Max value = %.2f\n", max);
        System.out.println();
    }

    public void question4(double[][][] matrix) {
        System.out.println("Question 4:\n");

        try {
            PrintWriter writer = new java.io.PrintWriter("files/question_4.txt");
            
            for (double[][] i : matrix) {
                for (double[] j : i) {
                    for (double k : j) {
                        writer.printf("%.2f\n", k);
                    }
                }
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Printed to file");
        System.out.println();
    }

    public void question5() {
        int result = 0;

        System.out.println("Question 5:\n");

        try {
            PrintWriter writer = new java.io.PrintWriter("files/question_5_output.txt");
            Scanner scanner = new Scanner(new File("files/question_5_input.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    result += Integer.parseInt(line);
                }
            }

            writer.print(result);
            writer.close();
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Printed to file");
        System.out.println();
    }

    public void question6(double[] arr) {
        boolean result = false;

        System.out.println("Question 6:\n");
        if (arr.length == 1) {
            System.out.println("YES");
        }
        else {
            for (int i = 0; i < arr.length / 2; i++) {
                result = arr[i] == arr[arr.length - 1 - i];
                if (!result) {
                    break;
                }
            }
    
            if (result) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Practice obj = new Practice();
        double[] matrix1D = {1.1, 2, 3.4, -5.9, -17.5, 20}; 
        obj.question1(matrix1D);
        obj.question2(matrix1D, 3);
        double[][] matrix2D = {{1.1,   2,   3.4,   -5.9,  -17.5, 20},
                               {-21.5, 8,   10.29, -76,   -33.4, 90.1},
                               {89.77, 36,  44.93, -9.94, -81.2, 52.52}};
        obj.question3(matrix2D);
        double[][][] matrix3D = {{{1.4}, {2}, {3.4}, {-5.9}, {-17.5}, {20.91}}};
        obj.question4(matrix3D);
        obj.question5();
        double[] tempArr = {1, 0, 1}; 
        obj.question6(tempArr);
    }
}
