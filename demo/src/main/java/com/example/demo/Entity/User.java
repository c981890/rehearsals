package com.example.demo.Entity;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Indexed
public class User {

    @Id
    private Integer userId;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String location;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @NumericField
    private Integer age;

    public User() {

    }

    public User (int userId, String location, int age) {
        this.userId = userId;
        this.location = location;
        this.age = age;
    }

    public Integer getUserId() {
            return userId;
        }

    public void setUserId(int userId) {
            this.userId = userId;
        }

    public String getLocation() {
            return location;
        }

    public void setLocation(String location) {
            this.location = location;
        }

    public int getAge() {
            return age;
        }

    public void setAge(int age) {

        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", location='" + location + '\'' +
                ", age=" + age +
                '}';
    }
}
