package com.LeetCode.matrix;

import java.util.HashSet;
import java.util.Set;

public class MagicMatrix {

    // TODO: COL and ROW naming to be corrected
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for(int i=0; i<row-2; i++) {
            for(int j=0; j<col-2; j++) {

                int prevSum = -1;
                boolean breakLoop = false;
                Set<Integer> set = new HashSet<>();

                // Count Row
                for(int k=i; k<i+3; k++) {
                    int sumRow = 0;
                    for(int l=j; l<j+3; l++) {
                        if(set.contains(grid[k][l])) {
                            breakLoop = true;
                            break;
                        }
                        sumRow += grid[k][l];
                    }
                    if(prevSum == -1) {
                        prevSum = sumRow;
                    } else if(sumRow != prevSum) {
                        breakLoop = true;
                        break;
                    } else if(breakLoop) {
                        break;
                    }
                }

                if(breakLoop == true) {
                    break;
                }

                // Count Col
                for(int l=j; l<j+3; l++) {
                    int sumCol = 0;
                    for(int k=i; k<i+3; k++) {
                        sumCol += grid[k][l];
                    }
                    if(sumCol != prevSum) {
                        breakLoop = true;
                        break;
                    }
                }

                if(breakLoop == true) {
                    break;
                }

                // count diagonal 
                int rightDiagonal = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                int leftDiagonal = grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2];

                if(rightDiagonal != prevSum || leftDiagonal != prevSum)
                    breakLoop = true;

                if(breakLoop == false)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        
    }
}
