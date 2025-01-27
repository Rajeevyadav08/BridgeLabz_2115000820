package Jan27;

import java.util.Random;

public class MatrixOperations {

    public static int[][] generateRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Generate random numbers between 0 and 9
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            System.out.println("Matrix multiplication not possible. Incompatible dimensions.");
            return null;
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    // ... (Implement methods for determinant, inverse, etc.)

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rows1 = 2, cols1 = 3;
        int rows2 = 3, cols2 = 2;

        int[][] matrix1 = generateRandomMatrix(rows1, cols1);
        int[][] matrix2 = generateRandomMatrix(rows2, cols2);

        System.out.println("Matrix 1:");
        printMatrix(matrix1);

        System.out.println("Matrix 2:");
        printMatrix(matrix2);

        int[][] sumMatrix = addMatrices(matrix1, matrix2); // Assuming matrices have same dimensions
        System.out.println("Sum of Matrices:");
        printMatrix(sumMatrix);

        int[][] differenceMatrix = subtractMatrices(matrix1, matrix2); // Assuming matrices have same dimensions
        System.out.println("Difference of Matrices:");
        printMatrix(differenceMatrix);

        int[][] productMatrix = multiplyMatrices(matrix1, matrix2);
        if (productMatrix != null) {
            System.out.println("Product of Matrices:");
            printMatrix(productMatrix);
        }

        int[][] transposeMatrix1 = transposeMatrix(matrix1);
        System.out.println("Transpose of Matrix 1:");
        printMatrix(transposeMatrix1);

        // ... (Implement and call methods for determinant, inverse, etc.)
    }
}