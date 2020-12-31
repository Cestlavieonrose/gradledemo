package com.gradledemo.ex68;

import com.gradledemo.ex68.bean.Person;
public class HelloWorld {
    public static void main(String[] args) {
        Person p = new Person("张三", 18);
        System.out.println("name:" + p.getName() + "  age:" + p.getAge());
    }
}
