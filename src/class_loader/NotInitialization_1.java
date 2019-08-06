package class_loader;

class SuperClass {
    static {
        System.out.println("super class init");
    }

    protected static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("sub class init");
    }
}

public class NotInitialization_1 {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
