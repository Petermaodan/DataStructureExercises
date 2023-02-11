package leetcode.hot100;

/**
 * 有两种特殊字符：
 *
 * 第一种字符可以用一个比特 0 来表示
 * 第二种字符可以用两个比特(10 或 11)来表示、
 * 给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * 示例 2:
 *
 * 输入: bits = [1, 1, 1, 0]
 * 输出: false
 * 解释: 唯一的编码方式是两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 *
 * 思路，从开头遍历，如果是1则一定会把后续的0或者1吃掉，直到判断最后一个是否为0即可
 */
public class it_717_1比特与2比特字符 {
    public static void main(String[] args) {
        int[] bits={1,0,0,0};
        boolean oneBitCharacter = new it_717_1比特与2比特字符().isOneBitCharacter(bits);
        System.out.println(oneBitCharacter);
    }
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        int i=0;
        while (i<n){
            int val=bits[i];
            if (val==1){
                i+=2;
                continue;
            }else {
                if (i==n-1){
                    return true;
                }else {
                    i++;
                }
            }
        }
        return false;
    }
}
