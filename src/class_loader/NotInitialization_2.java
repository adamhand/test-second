package class_loader;

class AClass {
    static {
        System.out.println("a class init");
    }
}

public class NotInitialization_2 {
    public static void main(String[] args) {
        AClass[] aClasses = new AClass[10];
    }
}
