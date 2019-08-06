package thread;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// 绕过编译器对泛型的检测，通过反射的方法
public class ReflectAvoidTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(123);

        try {
            Method method = list.getClass().getDeclaredMethod("add", Object.class);
            method.invoke(list, "test");
            method.invoke(list, 23.01);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        for (Object l : list) {
            System.out.println(">>> " + l);
        }
    }
}
