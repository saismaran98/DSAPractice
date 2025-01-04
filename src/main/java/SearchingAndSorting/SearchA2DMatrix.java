package SearchingAndSorting;

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // tag: binary search
        int startRow = 0, colSize = matrix[0].length -1 , rowSize = matrix.length -1;

        while(startRow<=rowSize){ // check the
            // until you reach the element eliminate the start row.
            // start at the mid row.
            int mid = (startRow + rowSize)/2;
            int lastEleOfMidRow=matrix[mid][colSize];

            if(target < lastEleOfMidRow) {
                // element must be on above row.
                rowSize = mid - 1;
            }
            else if(target > lastEleOfMidRow){
                // element must be below row.
                startRow = mid + 1;
            }
            else
                return true; //this row last index contanis the element.
        }
        if(startRow  >= matrix.length)
            return false;
        int start = 0, end = colSize;
        while(start <= end){
            int mid = (start + end) / 2;
            if(target > matrix[startRow][mid])
                start = mid+1;
            else if ( target < matrix[startRow][mid])
                end = mid -1;
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { // matrix[m][n] m = no of rows, i.e matrix.size, col = first row no. of else matrix[0].length
                {1, 3, 5},
                {7, 10, 12},
                {15, 20, 25}
        };
        System.out.println("element found ? "+searchMatrix(matrix, 5));



    }
}


