package MultidimensionalArraysLab;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[4][4];

        for (int[] arr : matrix) {

            for (int j = 0; j < arr.length; j++) {
                int element = Integer.parseInt(scanner.nextLine());
                arr[j] = element;
            }

        }


    }
}
