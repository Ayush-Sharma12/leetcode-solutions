class Spreadsheet {

    int[][] matrix; 
    public Spreadsheet(int rows) {
        this.matrix = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
          char col = getCol(cell);

          int row =  getRow(cell);

          matrix[row-1][col - 'a'] = value;
    }
    
    public void resetCell(String cell) {
          setCell(cell, 0);
    }
    
    public int getValue(String formula) {
             String[] operands = formula.substring(1).split("\\+");

              String first = operands[0];
              String sec = operands[1];

              int opr1 = getVal(first);
              int opr2 = getVal(sec);
            
              return opr1 + opr2;

    }

    private char getCol(String cell) {
          return cell.substring(0, 1).toLowerCase().charAt(0);
    }

    private int getRow(String cell) {
          return Integer.parseInt(cell.substring(1));
    }

    private int getVal(String val) {
            
            if(Character.isDigit(val.charAt(0))) {
                  return Integer.parseInt(val.substring(0));
            }

            return matrix[getRow(val) - 1][getCol(val) - 'a'];
    }


}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */