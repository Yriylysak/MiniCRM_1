package entity;

/**
 * Created by Comfy on 05.02.2017.
 */
public class Employer {
    private Long id;
    private String name;
    private String sureName;
    private Integer age;
    private String sex;
    private String position;


    public Employer(String name, String sureName, Integer age, String sex, String position) {
        this.name = name;
        this.sureName = sureName;
        this.age = age;
        this.sex = sex;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPosition() {
        return position;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employer() {
    }
}
