package rohan.test.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DecsribeClassDemo {

    private String testString = "test";

    public static void describeClass(Class<?> clazz) throws SecurityException, NoSuchFieldException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println(clazz.getPackage());
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field.getType() + " " + field.getName());
        }
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getReturnType() + " " + method.getName());
            if (method.getName().equals("describeClass")) {
                method.invoke(null, InnerClass.class);
            }
        }
    }

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        describeClass(DecsribeClassDemo.class);
        // describeClass(InnerClass.class);

    }

    public class InnerClass {
        private String innerString = "innerString";
    }

}
