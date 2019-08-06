package class_loader;

public class NotInitialization_3 {
    private static class AClass {
        static {
            System.out.println("a class init");
        }

        public static final String name = "haha";
    }

    public static void main(String[] args) {
        System.out.println(AClass.name);
    }
}
