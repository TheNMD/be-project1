public class Practice {
    public void question1(int num) {
        System.out.println("Question 1:\n");
        for (int row = num; row > 0; row--) {
            for (int value = row; value > 0; value--) {
                System.out.printf("%d ", value);
            }
            
            for (int value = 2; value < row + 1; value++) {
                System.out.printf("%d ", value);
            }

            System.out.println();
        }
        System.out.println();
    }

    public void question2(String inputString) {
        char[] vowelList = {'a', 'i', 'u', 'e', 'o'};
        char[] consonantList = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        
        int numVowel = 0;
        int numConsonant = 0;
        boolean isVowel;

        System.out.println("Question 2:\n");
        System.out.printf("Input string: \"%s\"\n", inputString);

        // Convert input string to lowercase to reduce the cases to check
        inputString = inputString.toLowerCase();
        for (int idx = 0; idx < inputString.length(); idx++) {
            char letter = inputString.charAt(idx);
            isVowel = false;

            // Check if letter is a vowel
            for (int i = 0; i < vowelList.length; i++) {
                if (letter == vowelList[i]) {
                    numVowel += 1;
                    isVowel = true;
                    break;
                }
            }

            // Check if letter is a consonant
            if (!isVowel) {
                for (int i = 0; i < consonantList.length; i++) {
                    if (letter == consonantList[i]) {
                        numConsonant += 1;
                        break;
                    }
                }
            }
        }

        System.out.printf("Number of vowel: %d\n", numVowel);
        System.out.printf("Number of consonant: %d\n", numConsonant);
        System.out.println();
    }


    public void question3(int num) {
        System.out.println("Question 3:\n");

        System.out.println("Image A:\n");
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                if (col < row + 1) {
                    System.out.print("*");
                }
                else {
                    System.out.print("");
                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Image B:\n");
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                if (col < row) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Image C:\n");
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                if (col < num - row - 1) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Image C:\n");
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                if (col > num - row - 1) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println();
    }

    public void question4() {
        System.out.println("Question 4:\n");

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.printf("%d : %d = %d\n", i * j, i, j);
            }
            System.out.println();
        }

        System.out.println();
    }

    public void question5(String isbn) {
        int result = 0;

        System.out.println("Question 5:\n");

        for (int idx = 0; idx < isbn.length(); idx++) {
            int num = Character.getNumericValue(isbn.charAt(idx));
            if (idx % 2 == 0) {
                result += num;
            }
            else {
                result += 3 * num;   
            }
        }
        result = 10 - result % 10;

        if (result == 10) {
            System.out.printf("ISBN = %s0\n", isbn);
        }
        else {
            System.out.printf("ISBN = %s%d\n", isbn, result);
        }
        System.out.println();
    }

    public void question6(double[] numList) {
        double max = numList[0];
        double secondMax = numList[0];

        System.out.println("Question 6:\n");
        for (int idx = 0; idx < numList.length; idx ++) {
            max = numList[idx] > max ? numList[idx] : max;
        }

        for (int idx = 0; idx < numList.length; idx ++) {
            secondMax = (numList[idx] > secondMax) && (numList[idx] < max) ? numList[idx] : secondMax;
        }

        System.out.printf("The second largest number is: %.2f\n", secondMax);
        System.out.println();
    }

    public void question7(double num) {
        double fibonacci = 0;
        double fibonacci_prevprev = 1;
        double fibonacci_prev = 1;

        System.out.println("Question 7:\n");
        if (num < 1) {
            System.out.printf("%.0f is an invalid number\n", num);
        }
        else if (num == 1 || num == 2) {
            System.out.printf("Fibonacci(%.0f) = 1\n", num);
        }
        else {
            for (int i = 3; i < num + 1; i++) {
                fibonacci = fibonacci_prev + fibonacci_prevprev;
                fibonacci_prevprev =  fibonacci_prev;
                fibonacci_prev = fibonacci;
            }
            System.out.printf("Fibonacci(%.0f) = %.0f\n", num, fibonacci);
        }
        System.out.println();
    }

    public void question8(double num) {
        int i = 0;

        System.out.println("Question 8:\n");
        if (num < 0) {
            System.out.println("No such numbers");
        }
        else {
            while(i * i < num) {
                System.out.printf("[%d] %d\n", i, i * i);
                i += 1;
            }
        }

        System.out.println();
    }

    public void question9(int num) {
        double pi = 0;

        System.out.println("Question 9:\n");
        for (int i = 1; i < num + 1; i++) {
            if (i % 2 == 0) {
                pi += 1.0 / (2 * i - 1);
            }
            else {
                pi += -1.0 / (2 * i - 1);
            }
        }
        pi *= 4;

        System.out.printf("Pi(%d) = %.5f\n", num, pi);
        System.out.println();
    }

    public void question10(String str) {
        String strNum = "";
        String strLetter = "";
        String strSpecial = "";
        int asciiValue;

        System.out.println("Question 10:\n");
        for (int idx = 0; idx < str.length(); idx++) {
            asciiValue = (int) str.charAt(idx);
            //  ASCII values of numeric characters
            if (asciiValue >= 48 && asciiValue <= 57) {
                strNum += String.valueOf(str.charAt(idx));
            }
            //  ASCII values of alphabet characters
            else if ((asciiValue >= 65 && asciiValue <= 90) || (asciiValue >= 97 && asciiValue <= 122)) {
                strLetter += String.valueOf(str.charAt(idx));
            }
            // ASCII values of special characters
            else {
                strSpecial += String.valueOf(str.charAt(idx));
            }
            System.out.println(asciiValue);
        }

        System.out.printf("Numeric string = '%s'\n", strNum);
        System.out.printf("Alphabet string = '%s'\n", strLetter);
        System.out.printf("Special string = '%s'\n", strSpecial);
        System.out.println();
    }

    public static void main(String[] args) {
        Practice obj = new Practice();
        obj.question1(15);
        obj.question2("This is a random string");
        obj.question3(4);
        obj.question4();
        obj.question5("978013213079");
        double[] input = {10.5, 20.75, -5.25, -90.2, 0, 33};
        obj.question6(input);
        obj.question7(50);
        obj.question8(5000);
        obj.question9(1000);
        obj.question10("ab@#AB69C!}+21");
    }
}
