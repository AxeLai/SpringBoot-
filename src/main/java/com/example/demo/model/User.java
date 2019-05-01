package com.example.demo.model;

/**
 * @author AxeLai
 * @date 2019-04-22 18:47
 */

public class User implements Comparable<User> {
    /**
     * 编号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 年龄
     */
    private String sex;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

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

    public User(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public int compareTo(User user) {
        //升序排序
        return this.id - user.id;
        //降序排序
        //return this.age - o.age;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", sex='" + sex + '\'' + '}';
    }
}
