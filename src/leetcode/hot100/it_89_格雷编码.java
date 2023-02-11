package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
 * 每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 *
 * 输入：n = 2
 * 输出：[0,1,3,2]
 * 解释：
 * [0,1,3,2] 的二进制表示是 [00,01,11,10] 。
 * - 00 和 01 有一位不同
 * - 01 和 11 有一位不同
 * - 11 和 10 有一位不同
 * - 10 和 00 有一位不同
 * [0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
 * - 00 和 10 有一位不同
 * - 10 和 11 有一位不同
 * - 11 和 01 有一位不同
 * - 01 和 00 有一位不同
 *
 * 思路：
 * 设 n 阶格雷码集合为 G(n)，则 G(n+1) 阶格雷码为：
 * 给 G(n) 阶格雷码每个元素二进制形式前面添加 0，得到 G'(n)；
 * 设 G(n) 集合倒序（镜像）为 R(n)，给R(n) 每个元素二进制形式前面添加 1，得到 R'(n)；
 * G(n+1) = G'(n) ∪ R'(n)拼接两个集合即可得到下一阶格雷码。
 * 根据以上规律，可从 0 阶格雷码推导致任何阶格雷码。
 * 代码解析：
 * 由于最高位前默认为 0，因此 G'(n) = G(n)，只需在 res(即 G(n) )后添加 R'(n)
 *  (n) 即可；
 * 计算 R'(n)：执行 head = 1 << i 计算出对应位数，以给 R(n) 前添加 1 得到对应 R'(n)；
 * 倒序遍历 res(即 G(n) )：依次求得 R'(n) 各元素添加至 res 尾端，遍历完成后 res(即G(n+1))。
 *
 */
public class it_89_格雷编码 {
    public static void main(String[] args) {
        int n=3;
        List<Integer> list = new it_89_格雷编码().grayCode(n);
        ListUtil.arrayOne(list);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        res.add(0);
        int head=1;
        //实际上利用了对称性
        for (int i = 0; i < n; i++) {
            for (int j = res.size()-1; j >=0 ; j--) {
                res.add(head+res.get(j));
            }
            head<<=1;
        }
        // 计算 R'(n)：执行 head = 1 << i 计算出对应位数，以给 R(n) 前添加 1 得到对应 R'(n)；
        return res;
    }
}
