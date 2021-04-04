package test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main3 {

    public static void main(String[] args) {

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        //斐波那契数列的迭代形式
        for (int i = 3; i < 500; i++) {
            BigInteger t = b;
            b = a.add(b);//大整数的加法
            a = t;
        }
        //大浮点数的除法
        BigDecimal divide = new BigDecimal(a, 110).divide(new BigDecimal(b, 110), BigDecimal.ROUND_HALF_DOWN);
        //截取字符串
        System.out.println(divide.toPlainString().substring(0, 103));
    }
}
