package 动态规划;

public class Q121Two {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0;i<prices.length;i++){
//          遍历数组如果遍历的值比前面的值小则替换
//          这个方法特点在于如果这个值得后面那一天的价格比当天低，那么从后一天买入在卖出哪怕同一天卖出也一定比前一天利润大
            if (prices[i] < minprice){
                minprice = prices[i];
//                如果后一天价格比当前最低价格高则进行利润判断
//                假设找到一个区间的最小值那么明天的价格一定比它贵就会进入else条件中，然后存储利润
//                如果后面还有最小值比当前最小值小那么会进行替换
            }else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
