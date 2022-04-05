package 二分查找;

public class Q14Three {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0){
            return "";
        }
//        定义初始的最短字符串长度
        int minlength = Integer.MAX_VALUE;
//        遍历字符串数组，找到最短的字符串，且返回最短字符串的长度
        for (String str : strs){
            minlength = Math.min(minlength,str.length());
        }
//        定义二分查找的头指针和尾指针
        int low = 0,high = minlength;
        while (low < high){
//            向上取整
            int mid = (high-low+1)/2+low;
            if (isCommonPrefix(strs,mid)){
                low=mid;
            }else {
                high=mid-1;
            }
        }
        return strs[0].substring(0,low);
    }
    public boolean isCommonPrefix(String[] strings,int length){
//        对传入字符串数组中第一个字符串进行处理，取出中间数对应的字符串
        String str0 = strings[0].substring(0,length);
//        count是传入字符串数组的字符串总数
        int count = strings.length;
//        遍历字符串数组
        for (int i =1;i<count;i++){
//            取出此时正在遍历的字符串
            String str = strings[i];
//            将取出的字符串与数组中第一个字符串进行逐个字符比较
            for (int j =0;j<length;j++){
                if (str0.charAt(j)!=str.charAt(j)){
//                    不相同就返回false，这个方法返回false表明此时中间数
//                    对应的字符串长度大于最长公共前缀会执行代码
                    return false;
                }
            }
        }
        return true;
    }
}
