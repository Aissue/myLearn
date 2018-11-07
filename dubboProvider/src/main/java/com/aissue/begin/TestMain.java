package com.aissue.begin;

import com.aissue.entity.Student;
import org.junit.Test;

public class TestMain {

    @Test
    public void test1(){
        Student student = new Student();
        test(student);
        System.out.println(student.toString());
        int i=9;
        testInt(i);
        System.out.println(i);
    }


    public  void test(Student student ){
        student.setGender("nan");
        student.setHeight("123cm");
        System.out.println("===="+student.toString());
    }

    public void testInt(int i){
        i++;
        System.out.println("===="+i);
    }
}
