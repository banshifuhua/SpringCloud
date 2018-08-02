package com.eamon.eamonauthservice.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class UserDao {

    private int id;
    private String access_key;
    private String secret_key;

    @Id
    @GenericGenerator(name="idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column
    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    @Basic
    @Column
    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDao userDao = (UserDao) o;
        return Objects.equals(id, userDao.id) &&
                Objects.equals(access_key, userDao.access_key) &&
                Objects.equals(secret_key, userDao.secret_key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, access_key, secret_key);
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", access_key='" + access_key + '\'' +
                ", secret_key='" + secret_key + '\'' +
                '}';
    }
}
