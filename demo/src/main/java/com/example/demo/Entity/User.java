package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    private int userId;
    private String location;
    private int age;

    public User() {

    }

    public User (int userId, String location, int age) {
        this.userId = userId;
        this.location = location;
        this.age = age;
    }

    public int getUserId() {
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
}
