package com.example.demo.model;

/**
 * @author AxeLai
 * @date 2019-04-22 18:47
 */

public class User {
    /** 编号 */
    private int id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private String sex;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
