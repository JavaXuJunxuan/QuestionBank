import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Xjx
 * @Create: 2023/3/18 - 10:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int left = 0;
        int right = str.length();
        char[] chars = new char[str.length()];
        while (left < right){
            if (str.charAt(left) < str.charAt(right)){
                chars[left] = str.charAt(left);
                chars[right] = str.charAt(left);
            } else if (str.charAt(left) > str.charAt(right)){
                chars[right] = str.charAt(right);
                chars[left] = str.charAt(right);
            }
            right--;
            left++;
        }
        System.out.println(chars.toString());



        /*Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        System.out.println(length);
        int var = scanner.nextInt();
        System.out.println(var);
        int[] colors = new int[length];
        for (int i = 0; i < length; i++){
                int color = scanner.nextInt();
                colors[i] = color;
        }
        for (int c : colors) {
            System.out.println(c);
        }

        HashMap<Integer, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < colors.length) {
            int add = colors[right];
            right++;
            window.put(add, window.getOrDefault(add, 0) + 1);
            while (window.size() > var) {
                int del = colors[left];
                left++;
                window.put(del, window.get(del) - 1);
                if (window.get(del) == 0){
                    window.remove(del);
                }
            }
            res = Math.max(res, right - left);
        }
        System.out.println(res);*/
    }
}
