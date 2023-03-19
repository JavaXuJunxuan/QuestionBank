import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();
        int count = 0;
        int left = 1;
        int right = chars.length - 2;
        while(left < right){
            while(left < right && chars[left] != chars[left - 1]){
                left++;
            }
            while(left < right && chars[right] != chars[right + 1]){
                right--;
            }
            if(right < left) break;
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            if(chars[left] != chars[left - 1]){
                count++;
                left++;
            }
            if(chars[right] != chars[right + 1]){
                right--;
                count++;
            }
        }
        System.out.println(count);
    }

}




