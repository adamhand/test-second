package thread;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

class Person {
    private String name;
    private String gender;
    private int age;

    public Person() {}

    // 如果age的类型写为int的话，在main中根据Ingeger.class得不到这个方法，回报错
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}

public class ReflectConstructorTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Person p = new Person();

        Class cls = p.getClass();

        // 获取默认构造函数
        Constructor constructor = cls.getConstructor(new Class[]{});
        // 获取构造函数的信息
        System.out.println(">>> 修饰符 " + Modifier.toString(constructor.getModifiers()));
        System.out.println(">>> 构造函数名 " + constructor.getName());
        System.out.println(">>> 参数列表 " + constructor.getParameterTypes());

        // 获取带参数构造函数
        Constructor constructor1 = cls.getConstructor(new Class[]{String.class, Integer.class});
        // 获取构造函数信息
        System.out.println(">>> 修饰符 " + Modifier.toString(constructor1.getModifiers()));
        System.out.println(">>> 构造函数名 " + constructor1.getName());
        System.out.println(">>> 参数列表 " + constructor1.getParameterCount());

        // 获取带参数构造函数
        Constructor constructor2 = cls.getConstructor(new Class[]{String.class, String.class, Integer.class});
        // 获取构造函数信息
        System.out.println(">>> 修饰符 " + Modifier.toString(constructor2.getModifiers()));
        System.out.println(">>> 构造函数名 " + constructor2.getName());
        System.out.println(">>> 参数列表 " + constructor2.getParameterTypes());
    }
}
