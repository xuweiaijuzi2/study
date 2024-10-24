package com.xuwei.jvm.classloader;

/**
 * @program: study
 * @Date: 2024/10/23 12:19
 * @Author: Mr.Xu
 * @Description:
 */
public class MyClassLoder extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {



        return findClass(name);
    }
}
