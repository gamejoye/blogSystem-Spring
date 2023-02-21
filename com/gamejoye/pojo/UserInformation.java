package com.gamejoye.pojo;

public class UserInformation {
    String name;
    String avatarUrl;
    String sex;
    String address;
    String birthday;
    String aboutMe;

    public UserInformation() {
    }

    public UserInformation(String avatarUrl, String name, String sex, String address, String birthday, String aboutMe) {
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.aboutMe = aboutMe;
    }

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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}
