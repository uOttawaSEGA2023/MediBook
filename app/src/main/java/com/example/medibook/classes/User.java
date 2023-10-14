package com.example.medibook.classes;
public class User {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String accountPassword;
    private String phoneNumber;
    private String address;

    public User(String firstName, String lastName, String emailAddress, String accountPassword, String phoneNumber,String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.accountPassword = accountPassword;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public String getFirstName(){
        return firstName;

    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return emailAddress;
    }

    public String getPassword() {
        return accountPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}