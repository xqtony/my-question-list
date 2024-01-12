package top50;

public class Q1_2850 {
    public static void main(String[] args) {

        int[][] grid =  {{1,3,0},{1,0,0},{1,1,2}};
//                {{0,0,0},{1,2,0},{3,0,3}};

        Solution s = new Solution();
        System.out.println(s.minimumMoves(grid));
    }
}

class Solution {
    int ans=Integer.MAX_VALUE;
    int[][] grid;
    int path, level = 0;
    public int minimumMoves(int[][] grid) {
        this.grid=grid;
        int cnt=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]==0){
                    cnt++;
                }
            }
        }
        this.printGrid();
        level = cnt;
        dfs(0,cnt);
        return ans;
    }
    //sum记录移动方案对应的移动次数
    //cnt记录剩余石头数为0的格子数
    private void dfs(int sum,int cnt){
//        System.out.println("进入dfs，sum = " + sum + " cnt = " + cnt);
        if(cnt==0){
            ans=Math.min(sum,ans);
            System.out.println(String.format("完事儿了%d次。。。。", ++path));
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]==0){
                    for(int k=0;k<3;k++){
                        for(int l=0;l<3;l++){
                            if(grid[k][l]>1){
                                grid[k][l]--;
                                grid[i][j]=1;
                                System.out.println("即将进入dfs，0位于" + i + ", " + j + ", 大于1的值位于" + k + ", " + l + ". ");
                                this.printGrid();
                                dfs(sum+Math.abs(i-k)+Math.abs(j-l),cnt-1);
                                grid[k][l]++;
                                grid[i][j]=0;
                            }
                        }
                    }
                }
            }
        }
    }

    private void printGrid() {
        for(int a=0;a<3;a++){
            System.out.print(" ");
            for(int b=0;b<3;b++){
                System.out.print(grid[a][b]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

//    作者：一路
//    链接：https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/solutions/2435465/dfsshi-xian-jian-ji-mei-ju-by-yi-lu-o-l0me/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}