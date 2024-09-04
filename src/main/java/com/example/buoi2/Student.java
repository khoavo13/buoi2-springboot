package com.example.buoi2;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("students")
public class Student {
    @Id
    private String user_id;
    private String email;
    private String name;
    private String given_name;
    private String family_name;
    private String nickname;
    private String last_ip;
    private String logins_count;
    private String created_at;
    private String updated_at;
    private String last_login;
    private boolean email_verified;

    public Student(String user_id, String email, String name, String given_name, String family_name, String nickname, String last_ip, String logins_count, String created_at, String updated_at, String last_login, boolean email_verified) {
        this.user_id = user_id;
        this.email = email;
        this.name = name;
        this.given_name = given_name;
        this.family_name = family_name;
        this.nickname = nickname;
        this.last_ip = last_ip;
        this.logins_count = logins_count;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.last_login = last_login;
        this.email_verified = email_verified;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public String getLogins_count() {
        return logins_count;
    }

    public void setLogins_count(String logins_count) {
        this.logins_count = logins_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public boolean isEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(boolean email_verified) {
        this.email_verified = email_verified;
    }
}
