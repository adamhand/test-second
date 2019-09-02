package written_exam;

import java.util.ArrayList;
import java.util.List;

public class test {



    public static void main(String[] args) {

        System.out.println("A");

        new test();

        new test();

    }



    public void test() {

        System.out.println("B");

    }



    {

        System.out.println("C");

    }



    static {

        System.out.println("D");

    }

}
