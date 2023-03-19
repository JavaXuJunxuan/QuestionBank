package 数据结构;

/**
 * @Author: Xjx
 * @Create: 2023/3/19 - 16:58
 * 顺序表
 */
public class SequenceList {
    private int[] elements;
    private int length;
    private final int maxSize;

    public SequenceList(int maxSize) {
        this.maxSize = maxSize;
        this.elements = new int[maxSize];
        this.length = 0;
    }

    public void clear() {
        this.length = 0;
    }


    public void listSequence() {

    }
}
