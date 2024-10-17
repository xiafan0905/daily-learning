package com.example.dailylearning.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) {
        try {
            //使用 Class 类中的 forName()静态方法(最安全/性能最好)
            //Class clazz=Class.forName("类的全路径"); (最常用)
            //获取 Person 类的 Class 对象
            Class<?> clazz = Class.forName("com.example.studyapp.login.service.impl.UserInfoServiceImpl");
            //获取 Person 类的所有方法信息
            Method[] method=clazz.getDeclaredMethods();
            System.out.println("方法：");
            for(Method m:method){
                System.out.println(m.toString());
            }
            System.out.println("------------------------");
            //获取 Person 类的所有成员属性信息
            Field[] field=clazz.getDeclaredFields();
            System.out.println("成员属性：");
            for(Field f:field){
                System.out.println(f.toString());
            }
            System.out.println("------------------------");
            //获取 Person 类的所有构造方法信息
            Constructor[] constructor=clazz.getDeclaredConstructors();
            System.out.println("构造方法：");
            for(Constructor c:constructor){
                System.out.println(c.toString());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定类");
        }
    }
}
