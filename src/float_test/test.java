package float_test;

import java.math.BigDecimal;

public class test {
    public static void main(String[] args) {
        float f = 0.0f;
        BigDecimal bd = new BigDecimal(0.0);

        for (int i = 0; i < 10; i++) {
            bd = bd.add(new BigDecimal(0.1));
        }
        System.out.println(bd.floatValue());

        for (int i = 0; i < 10; i++) {
            f += 0.1;
        }
        System.out.println(f);

        double d = 0.0;
        for (int i = 0 ; i < 10; i++) {
            d += 0.1;
        }
        System.out.println(d);
    }
}
