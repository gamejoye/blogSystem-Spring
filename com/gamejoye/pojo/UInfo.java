package com.gamejoye.pojo;

public class UInfo {
    String name;
    String sex;
    String address;
    String birthday;
    String aboutMe;

    @Override
    public String toString() {
        return "UInfo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getaboutMe() {
        return aboutMe;
    }

    public void setaboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}
