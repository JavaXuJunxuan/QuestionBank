package 暴力解法;

public class Q121One {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0;i< prices.length-1; i++){
            int j = i+1;
            while (j<prices.length && prices[j] > prices[i]){
                int max = prices[j]-prices[i];
                if (profit<max){
                    profit = max;
                }
                j++;
            }
        }
        return profit;
    }
}
