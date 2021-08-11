package com.kim;

public class Customer{
    int cId;
    String pw;
    String firstName;
    String lastName;

    public Customer(int cId, String pw, String firstName, String lastName) {
        this.cId = cId;
        this.pw = pw;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {

    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", pw='" + pw + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
//generate getter setter
//generate constructor
//generate tostring method