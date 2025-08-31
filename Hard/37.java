class Solution {
    public void solveSudoku(char[][] board) {

         solvedSudoku(board);

    }

    private boolean solvedSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                           
                            if (solvedSudoku(board)) {
                                return true;
                            }

                            board[i][j] = '.';

                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }


    private boolean isValid(char[][] board, int i, int j, char target) {
           
            // check row and col

            for(int itr = 0; itr<9; itr++) {
                   
                   if(itr != j && board[i][itr] == target) {
                      return false;
                   } 

                   if(itr != i && board[itr][j] == target) {
                       return false;
                   }

            }

            // check grid
            int startRow = i - (i % 3);
            int startCol = j - (j % 3);

            for(int row = startRow; row< startRow + 3; row++) {
                   for(int col = startCol; col<startCol+3; col++) {
                            
                             if(row == i && col == j) {
                                   continue;
                             }

                             if(board[row][col] == target) {
                                  return false;
                             }
                   }
            }


            return true;
    }
}