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

    public static long findGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long findLCM(long a, long b, long gcd) {
        return (a / gcd) * b;
    }

    public void question7() {
        Scanner scanner = new Scanner(System.in);
        long numA;
        long numB;
        long gcd;
        long lcm;

        System.out.println("Question 7:\n");
        System.out.print("Number of tests: ");
        int numTest = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numTest; i++) {
            System.out.printf("\nTest [%d]: ", i + 1);
            numA = scanner.nextLong();
            numB = scanner.nextLong();
            gcd = findGCD(numA, numB);
            lcm = findLCM(numA, numB, gcd);
            System.out.printf("\nGCD = %d", gcd);
            System.out.printf("\nLCM = %d\n", lcm);
        }
        scanner.close();
        System.out.println();
    }

    public void question8() {
        Scanner scanner = new Scanner(System.in);
        int numEle;
        int[] arr;
        boolean dupEle;

        System.out.println("Question 8:\n");
        System.out.print("Number of tests: ");
        int numTest = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numTest; i++) {
            dupEle = false;

            System.out.printf("\nTest [%d]: ", i + 1);
            numEle = scanner.nextInt();

            arr = new int[numEle];
            for (int j = 0; j < numEle; j ++) {
                arr[j] = scanner.nextInt();
            }

            for (int j = 0; j < numEle; j++) {
                for (int k = j + 1; k < numEle - 1; k++) {
                    if (arr[j] == arr[k]) {
                        dupEle = true;
                        System.out.printf("\n%d\n", arr[j]);
                        break;
                    }
                }

                if (dupEle) {
                    break;
                }
            }

            if (!dupEle) {
                System.out.println("\nN0");
            }
            
        }
        scanner.close();
        System.out.println();
    }

    public void question9() {
        Scanner scanner = new Scanner(System.in);
        long num;
        long numEvenDenominator = 0;

        System.out.println("Question 9:\n");
        System.out.print("Number of tests: ");
        int numTest = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numTest; i++) {
            System.out.printf("\nTest [%d]: ", i + 1);
            num = scanner.nextLong();
            for (int j = 1; j <= num; j++) {
                numEvenDenominator += (num % j == 0 && j % 2 == 0 ? 1 : 0);
            }
            System.out.printf("\nResult = %d\n", numEvenDenominator);
        }
        scanner.close();
        System.out.println();
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;

        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        
        return result;
    }

    public void question10() {
        Scanner scanner = new Scanner(System.in);
        int N;
        int M;
        int[][] matrix;

        System.out.println("Question 10:\n");
        System.out.print("Number of tests: ");
        int numTest = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numTest; i++) {
            System.out.printf("\nTest [%d]: ", i + 1);
            N = scanner.nextInt();
            M = scanner.nextInt();

            matrix = new int[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int[][] transposedMatrix = transpose(matrix);

            int[][] resultMatrix = multiplyMatrices(matrix, transposedMatrix);

            System.out.printf("\nResult [%d]:\n", i + 1);
            for (int j = 0; j < resultMatrix.length; j++) {
                for (int k = 0; k < resultMatrix[j].length; k++) {
                    System.out.printf("%d ", resultMatrix[j][k]);
                }
                System.out.println();
            }

        }
        scanner.close();
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
        obj.question7();
        obj.question8();
        obj.question9();
        obj.question10();
    }
}
