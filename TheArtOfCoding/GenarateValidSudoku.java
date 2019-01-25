package TheArtOfCoding;

import algorithom.Matrix;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/19 18:24
 */
public class GenarateValidSudoku {

    private static final int size = 9;

    private char[] getMapping()
    {
        char[] mapping = new char[9];
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }
        for (int i = 0; i < size; i++) {
            mapping[i] = (char)(list.remove(random.nextInt(list.size())).intValue() + '0');

        }
        return mapping;
    }
    public char[][] generateValidSudoku()
    {
        char[][] leftTop = {
                {'i', 'g', 'h'},
                {'c', 'a', 'b'},
                {'f', 'd', 'e'}};
        char[][] sudo = new char[9][9];
        int[] offset = {0,2,1};
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fillRow(leftTop, j, sudo, (j + offset[k] )%3, 3*k );
            }
            k++;
        }
        for(int m = 0; m < 3; m++)
        {
            k = 1;
            // fill two time below top
            for (int i = 1; i < 3; i++) {
                // fill one column
                for (int j = 0; j < 3; j++) {
                    fillCol(sudo, 3*k,j + 3*m, (j + offset[k] )%3, m);
                }
                k++;
            }
        }


        return sudo;
    }


    private void fillRow(char[][] leftTop, int row, char[][] sudoku, int r, int c)
    {
        for (int i = 0; i < 3; i++) {
            sudoku[r][c + i] = leftTop[row][i];
        }
    }

    private void fillCol( char[][] sudoku, int r, int c, int col, int block)
    {
        for (int i = 0; i < 3; i++) {
            sudoku[r + i][col + block*3] = sudoku[i][c];
        }
    }

    public  char [][] getSudoKu( char[][] sudo)
    {
        char[] mapping = getMapping();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sudo[i][j] = mapping[sudo[i][j] - 'a'];
            }
        }
        return sudo;
    }

    public static void main(String[] args) {
        GenarateValidSudoku genarateValidSudoku = new GenarateValidSudoku();
        char[][] sudo = genarateValidSudoku.generateValidSudoku();
        Matrix.print(sudo);
        char[][] sudoku = genarateValidSudoku.getSudoKu(sudo);

        System.out.println("**************");
        Matrix.print(sudoku);


    }

}
