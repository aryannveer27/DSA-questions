class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        int m = arr.length;
        int n = arr[0].length;

        int fr = 0, lr = m - 1;
        int fc = 0, lc = n - 1;

        while (fr <= lr && fc <= lc) {

            
            for (int j = fc; j <= lc; j++)
                ans.add(arr[fr][j]);
            fr++;

            
            for (int i = fr; i <= lr; i++)
                ans.add(arr[i][lc]);
            lc--;

            if (fr > lr || fc > lc) break;

            
            for (int j = lc; j >= fc; j--)
                ans.add(arr[lr][j]);
            lr--;

            
            for (int i = lr; i >= fr; i--)
                ans.add(arr[i][fc]);
            fc++;
        }

        return ans;
        
    }
}