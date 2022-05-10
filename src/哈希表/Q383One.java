package 哈希表;

/**
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */

public class Q383One {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        int index = 0;
        for (char c : magazine.toCharArray()){
            arr[(c - 'a')]++;
        }
        for (char c : ransomNote.toCharArray()){
            if (arr[c - 'a'] > 0){
                arr[(c - 'a')]--;
            }else {
                return false;
            }
        }
        return true;
    }
}
