package hello_world;

/**
 * Created by shenhaizhilong on 5/27/2017.
 */
public class RotateImage
{
    public static void rotateClockWise90(int[][] matrix)
    {
        reverse(matrix, true, false);
        symmetry(matrix);
    }
    public static void reverse(int[][] matrix, boolean upDown, boolean leftRight)
    {
        if (upDown)
        {
            for (int i = 0; i < matrix.length/2; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                            int temp = matrix[i][j];
                            matrix[i][j] = matrix[matrix.length-1-i][j];
                            matrix[matrix.length -1-i][j] = temp;
                }
            }
        }
        else if (leftRight)
        {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length/2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix[i].length-1-j];
                    matrix[i][matrix[i].length-1-j] = temp;
                }
            }
        }

    }
    public static void symmetry(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static void swap(int[] numbser, int index1, int index2)
    {
        int temp = numbser[index1];
        numbser[index1] = numbser[index2];
        numbser[index2] = temp;
    }
    public static void main(String[] args)
    {
        int[] a = {1,2};
        swap(a, 0,1);
        System.out.println(a[0] + "," + a[1]);
        int[][] b = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(b);
        reverse(b, true, false);
        printMatrix(b);

        int[][] c = {{1,2,3},{4,5,6},{7,8,9}};
        reverse(c, false,true);
        printMatrix(c);

        int[][] d = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        reverse(d, false, true);
        printMatrix(d);

        int[][] e = {{1,2,3},{4,5,6},{7,8,9}};
        symmetry(e);
        printMatrix(e);

        int[][] f = {{1,2,3},{4,5,6},{7,8,9}};
        rotateClockWise90(f);
        printMatrix(f);
    }
    public static void printMatrix(int[][] matrix)
    {
        System.out.println("{");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("  {");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ",");
                if(j == matrix[i].length -1)
                {
                    System.out.println("},");
                }
            }

        }
        System.out.println("}");
    }
}
