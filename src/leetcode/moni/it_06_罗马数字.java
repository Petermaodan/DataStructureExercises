package leetcode.moni;

public class it_06_罗马数字 {
    public static void main(String[] args) {
        String s = "III";
        int res = new it_06_罗马数字().romanToInt(s);
        System.out.println(res);

    }


    public String I = "1", V = "5", X = "10", L = "50", C = "100", D = "500", M = "1000";


    public int romanToInt(String s) {
        // write code here
        int len = s.length();
        if (len < 1) return 0;

        int res = 0;

        for (int i = 0; i < len - 1; i++) {
            char c = s.charAt(i);
            String s1 = String.valueOf(c);
            if (s1.equals("I")) {
                if (String.valueOf(s.charAt(i + 1)) == "V") {
                    res += 4;
                    i = i + 1;
                    continue;
                } else if (String.valueOf(s.charAt(i + 1)) == "X") {
                    res += 9;
                    i = i + 1;
                    continue;
                } else {
                    res += Integer.valueOf(I);
                }
            } else if (s1.equals("V")) {
                res += Integer.valueOf(V);
            } else if (s1.equals("X")) {
                if (String.valueOf(s.charAt(i + 1)) == "L") {
                    res += 40;
                    i = i + 1;
                    continue;
                } else if (String.valueOf(s.charAt(i + 1)) == "C") {
                    res += 90;
                    i = i + 1;
                    continue;
                } else {
                    res += Integer.valueOf(X);
                }
            } else if (s1.equals("L")) {
                res += Integer.valueOf(L);
            } else if (s1.equals("C")) {
                if (String.valueOf(s.charAt(i + 1)) == "D") {
                    res += 400;
                    i = i + 1;
                    continue;
                } else if (String.valueOf(s.charAt(i + 1)) == "M") {
                    res += 900;
                    i = i + 1;
                    continue;
                } else {
                    res += Integer.valueOf(C);
                }
            } else if (s1.equals("D")) {
                res += Integer.valueOf(D);
            } else if (s1.equals("M")) {
                res += Integer.valueOf(M);
            }
        }
        if (len > 1) {
            String s1 = String.valueOf(s.charAt(len - 1));
            if (s1.equals("I")) {
                res += Integer.valueOf(I);
            } else if (s1.equals("V")) {
                res += Integer.valueOf(V);
            } else if (s1.equals("X")) {
                res += Integer.valueOf(X);
            } else if (s1.equals("L")) {
                res += Integer.valueOf(L);
            } else if (s1.equals("C")) {
                res += Integer.valueOf(C);
            } else if (s1.equals("D")) {
                res += Integer.valueOf(D);
            } else if (s1.equals("M")) {
                res += Integer.valueOf(M);
            }
        }

        return res;
    }
}
