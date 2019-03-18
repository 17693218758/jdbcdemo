package com.cheer.jdbc;

import org.junit.Test;

public class JunitTest {
    //psvm
    public static void main(String[] args){
        //sout
        System.out.println("Hello World");
    }

    //单元测试方法（单元测试用列）可以单独执行
    @Test
    public void print(){
        System.out.println("Hello World!");
    }

    @Test
    public void test(){
        System.out.println(4 / 0);
    }
}
