package com.example.dailylearning.test;



import com.example.dailylearning.bean.UserInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceTest {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.example.studyapp.login.bean.UserInfo");
            UserInfo userInfo = (UserInfo) aClass.newInstance();
            //获取构造方法并创建对象
            Constructor<?> c=aClass.getDeclaredConstructor(String.class,String.class,String.class);
            UserInfo userInfo1 = (UserInfo) c.newInstance("1", "奥特曼", "123456");
            System.out.println(userInfo1);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到类");
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
