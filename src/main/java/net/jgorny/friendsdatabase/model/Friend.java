package net.jgorny.friendsdatabase.model;

import java.util.Objects;

public class Friend {
    private String name;
    private String surname;
    private int age;


    private int id;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Friend friend = (Friend) o;
        return age == friend.age && id == friend.id && Objects.equals(name, friend.name) && Objects.equals(surname, friend.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, id);
    }

    @Override
    public String toString() {
        return "net.jgorny.friendsdatabase.modeldsdatabase.Friend{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + ", id=" + id + '}';
    }
}
