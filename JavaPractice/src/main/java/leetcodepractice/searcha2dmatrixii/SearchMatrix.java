package leetcodepractice.searcha2dmatrixii;

public class SearchMatrix{

    public static boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, matrix.length-1, 0,target);
    }

    public static boolean search(int[][] matrix, int r, int c,int target){
        if(r<0 || c>=matrix[0].length)
            return false;
        if(matrix[r][c] == target)
            return true;
        else if(matrix[r][c] < target)
            return search(matrix,r,c+1,target);
        else
            return search(matrix,r-1,c,target);
    }

    public static void main(String[] args){
        int[][] m = new int[][]{{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(m,20));
    }
}