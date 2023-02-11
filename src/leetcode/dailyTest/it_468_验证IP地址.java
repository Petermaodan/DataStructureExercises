package leetcode.dailyTest;

/**
 * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
 * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
 * 1 <= xi.length <= 4
 * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 在 xi 中允许前导零。
 */
public class it_468_验证IP地址 {
    public static void main(String[] args) {
        String s = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String res = new it_468_验证IP地址().validIPAddress(s);
        System.out.println(res);
    }

    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf('.') >= 0) {
            return checkIPv4(queryIP) ? "IPv4" : "Neither";
        } else {
            return checkIPv6(queryIP) ? "IPv6" : "Neither";
        }

    }

    private boolean checkIPv6(String queryIP) {
        String[] split = queryIP.split(":", -1);
        if (split.length != 8) {
            return false;
        }
        for (String s : split) {
            if (s.length() > 4 || s.length() == 0) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!Character.isDigit(c) && !(Character.toLowerCase(c) >= 'a') || !(Character.toLowerCase(c) <= 'f')) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean checkIPv4(String queryIP) {
        //加-1是防止出现空字符串无法计数 比如192.168.1.1. 后边多了一个点，不加-1会被忽略后边的空串
        String[] split = queryIP.split("\\.", -1);
        if (split.length != 4) {
            return false;
        }
        for (String s : split) {
            if (s.length() > 3 || s.length() == 0) {
                return false;
            }
            if (s.charAt(0) == '0' && s.length() != 1) {
                return false;
            }
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
                sum = sum * 10 + (c - '0');
            }
            if (sum > 255) {
                return false;
            }
        }
        return true;
    }
}
