package com.example.buspasssystem;

public class RegisterDetails {

    String fullName,age, prnreg,email,pwd,scl;

    public RegisterDetails(String fullName, String scl, String email, String pwd, String age, String prnreg ) {
        this.fullName = fullName;
        this.age = age;
        this.prnreg = prnreg;
        this.email = email;
        this.pwd = pwd;
        this.scl = scl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPrnreg() {
        return prnreg;
    }

    public void setPrnreg(String prnreg) {
        this.prnreg = prnreg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getScl() {
        return scl;
    }

    public void setScl(String scl) {
        this.scl = scl;
    }
}
