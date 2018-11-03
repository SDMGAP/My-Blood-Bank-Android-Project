package com.zinfinity.www.model;

public class Donor {

    private long mId;
    private String name;
    private int age;
    private String sex;
    private String bloodGroup;
    private String occupation;
    private String address;
    private String contactNo;
    private String lastDonationDate;

    public Donor() {

    }

    public Donor(String name, int age, String sex, String bloodGroup, String occupation, String address, String contactNo) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.bloodGroup = bloodGroup;
        this.occupation = occupation;
        this.address = address;
        this.contactNo = contactNo;
    }

    public Donor(long mId, String name, String bloodGroup, String contactNo, int age) {
        this.mId = mId;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.age = age;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(String lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }
}
