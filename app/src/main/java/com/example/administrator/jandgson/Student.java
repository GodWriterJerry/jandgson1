package com.example.administrator.jandgson;

import java.util.List;

/**
 * Created by Administrator on 2017/3/5.
 */

public class Student {

    /**
     * id : 1
     * name : zhangsan
     * age : 18
     */

    private List<StuBean> stu;

    public List<StuBean> getStu() {
        return stu;
    }

    public void setStu(List<StuBean> stu) {
        this.stu = stu;
    }

    public static class StuBean {
        private int id;
        private String name;
        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
