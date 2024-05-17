package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;

        int[] firstTokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int R1 = firstTokens[0];
        int C1 = firstTokens[1];

        int[][] firstMatrix = new int[R1][C1];

        for (int[] arr : firstMatrix) {
            int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < arr.length; col++) {
                arr[col] = arrayNumbers[col];
            }
        }

        int[] secondTokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int R2 = secondTokens[0];
        int C2 = secondTokens[1];

        int[][] secondMatrix = new int[R2][C2];

        for (int[] arr : secondMatrix) {
            int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < arr.length; col++) {
                arr[col] = arrayNumbers[col];
            }
        }

        if (R1 != R2) {
            flag = true;
        }

        for (int i = 0; i < firstMatrix.length; i++) {

            int[] firstMatrixArray = firstMatrix[i];
            int[] secondMatrixArray = secondMatrix[i];

            if (firstMatrixArray.length != secondMatrixArray.length) {
                flag = true;
                break;
            }

            for (int j = 0; j < firstMatrixArray.length; j++) {
                if (firstMatrixArray[j] != secondMatrixArray[j]) {
                    flag = true;
                    break;
                }
            }

        }

        if (flag) {
            System.out.println("not equal");
        } else {
            System.out.println("equal");
        }

    }

}
