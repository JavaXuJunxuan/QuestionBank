package 递归;

/*剑指 Offer 12. 矩阵中的路径
        给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
        单词必须按照字母顺序，通过相邻的单元格内的字母构成，
        其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
        同一个单元格内的字母不允许被重复使用。*/

public class J12_1One {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 遍历图
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {

                // 如果找到了，就返回true。否则继续找
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        // 遍历结束没找到false
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 判断传入参数的可行性 i 与图行数row比较，j与图列数col比较
        // i，j初始都是0，都在图左上角
        // k是传入字符串当前索引，一开始是0，如果当前字符串索引和图当前索引对应的值不相等，表示第一个数就不相等
        // 所以继续找第一个相等的数。题目说第一个数位置不固定，即路径起点不固定（不一定是左上角为第一个数）

        // 如果board[i][j] == word[k]，则表明当前找到了对应的数，就继续执行（标记找过，继续dfs 下上右左）
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        // 表示找完了，每个字符都找到了
        // 一开始k=0，而word.length肯定不是0，所以没找到，就执行dfs继续找。
        if(k == word.length - 1) return true;

        // 访问过的标记空字符串，“ ”是空格 '\0'是空字符串，不一样的！
        // 比如当前为A，没有标记找过，且A是word中对应元素，则此时应该找A下一个元素，假设是B，在dfs（B）的时候还是-
        // ->要搜索B左边的元素（假设A在B左边），所以就是ABA（凭空多出一个A，A用了2次，不可以），如果标记为空字符串->
        // 就不会有这样的问题，因为他们值不相等AB != ABA。
        board[i][j] = '\0';

        // 顺序是 下 上 右 左；上面找到了对应索引的值所以k+1
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        // 还原找过的元素，因为之后可能还会访问到（不同路径）
        board[i][j] = word[k];
        // 返回结果，如果false，则if(dfs(board, words, i, j, 0)) return true;不会执行，就会继续找
        return res;
    }
}
