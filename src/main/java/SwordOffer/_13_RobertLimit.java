package SwordOffer;
/**
 * 2021/09/29
 *
 * 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * */
public class _13_RobertLimit {

    public int movingCount(int m, int n, int k) {
        if(m <= 0 || n <= 0 || k < 0){
            return 0 ;
        }

        boolean[] visited = new boolean[m * n] ;
        int res = calculate(m , n , k , 0 , 0 , visited) ;
        return res ;
    }

    private int calculate(int m, int n, int k, int row, int col, boolean[] visited) {
        int count = 0 ;
        if(isvalid(m , n , k , row , col , visited)){
            visited[n * row + col] = true ;
            count = 1 + calculate(m , n , k , row - 1 , col , visited) +
                    calculate(m , n , k , row + 1 , col , visited) +
                    calculate(m , n , k , row , col - 1 , visited) +
                    calculate(m , n , k , row , col + 1 , visited) ;
        }
        return count ;
    }

    private boolean isvalid(int m, int n, int k, int row, int col, boolean[] visited) {
        if (row >= 0 && col >= 0 && row < m && col < n && !visited[row * n + col] && check(row , col , k)){
            return true ;
        }else{
            return false ;
        }
    }

    private boolean check(int row, int col, int k) {
        int tmp = 0 ;
        while (row >= 10){
            tmp += row % 10 ;
            row /= 10 ;
        }
        tmp += row ;
        while (col >= 10){
            tmp += col % 10 ;
            col /= 10 ;
        }
        tmp += col ;
        return tmp <= k ;
    }


    public static void main(String[] args) {
        _13_RobertLimit obj = new _13_RobertLimit() ;
        int m = 3 ;
        int n = 1 ;
        int k = 0 ;
        System.out.println(obj.movingCount(m , n , k));
    }
}
