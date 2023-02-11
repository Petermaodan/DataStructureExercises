package leetcode.dailyTest;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
public class it_1108_IP地址无效化 {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        String res = new it_1108_IP地址无效化().defangIPaddr(address);
        System.out.println(res);
    }
    public String defangIPaddr(String address) {
        StringBuilder builder=new StringBuilder();
        String[] split = address.split("\\.");
        for (int i = 0; i < split.length; i++) {
            if (i==split.length-1){
                builder.append(split[i]);
                break;
            }
            builder.append(split[i]).append("[.]");
        }
        return builder.toString();
    }
}
