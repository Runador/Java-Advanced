package multidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int R = dimensions[0];
        int C = dimensions[1];

        int[][] firstMatrix = new int[R][C];

        for (int col = 0; col < R; col++) {
            int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            firstMatrix[col] = arrayNumbers;
        }

        /*for (int[] arr : firstMatrix) {
            int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < arr.length; col++) {
                arr[col] = arrayNumbers[col];
            }
        }*/

        dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        R = dimensions[0];
        C = dimensions[1];

        int[][] secondMatrix = new int[R][C];

        for (int col = 0; col < R; col++) {
            int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            secondMatrix[col] = arrayNumbers;
        }

        if (areMatricesEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        /*for (int[] arr : secondMatrix) {
            int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < arr.length; col++) {
                arr[col] = arrayNumbers[col];
            }
        }*/

        /*if (firstMatrix[R].length != secondMatrix[R].length) {
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

        }*/

    }

    public static boolean areMatricesEqual(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

}
