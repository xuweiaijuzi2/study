package com.xuwei.jvm.tuning;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: study
 * @Date: 2024/10/24 16:11
 * @Author: Mr.Xu
 * @Description:
 */
public class OOMTest {
    public static void main(String[] args) {
        System.out.println("HelloGC!");
        List list = new LinkedList();
        for (; ; ) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }
    }
}
