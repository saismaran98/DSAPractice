package ArraysAndString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board){
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> grid = new HashMap<>();

        for(int r = 0;r<9;r++){
            for(int c = 0; c<9;c++){
                char current = board[r][c];
                if(current=='.')
                    continue;
                String gridKey=r/3+","+c/3;
                boolean currentExistsInRow = rows.computeIfAbsent(r, newSetForRow -> new HashSet<>()).contains(current); //chec if rows[r] contains current char.
                boolean currentExistsInCol = cols.computeIfAbsent(c, newSetForCol -> new HashSet<>()).contains(current); //check if cols[c] containns current i.e set in col[c] contains curent.
                boolean currentExistsInGrid = grid.computeIfAbsent(gridKey, newSetForGrid-> new HashSet<>()).contains(current);

                if(currentExistsInCol || currentExistsInRow || currentExistsInGrid)
                    return false;
                // add ele to row, that this item is present in 0 row
                rows.get(r).add(current);
                // add ele to col, this ele is present in row 0 col 0
                cols.get(c).add(current);
                // add ele to grid, this ele is present in row 0 col 0 grid: (0,0)
                grid.get(gridKey).add(current);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] board2 = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("sudokuValid: "+ isValidSudoku(board));
    }
}
