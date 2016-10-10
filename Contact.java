package com.example.luke.myproject;

/**
 * Created by TheAppExperts on 06/10/2016.
 */

public class Contact {

    // private variables
    public String _name;
    public String nationalNumber;
    public String password;
    public String rePassword;
    public String nation;

    public Contact() {
    }

    //return the nationality
    public String getNation() {
        return nation;
    }

    //set the nationality
    public void setNation(String nation) {
        this.nation = nation;
    }
    //return the password
    public String getRePassword() {
        return rePassword;
    }
    //set the password
    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
    //return the password
    public String getPassword() {
        return password;
    }
    //set the password
    public void setPassword(String password) {
        this.password = password;
    }
    //return the national insurance number
    public String getNationalNumber() {
        return nationalNumber;
    }
    //set the national insurance number
    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }
    //return the name
    public String get_name() {
        return _name;
    }
    //set the name
    public void set_name(String _name) {
        this._name = _name;
    }

    // constructor
    public Contact(String name, String nationalNumber , String password, String rePassword, String nation) {
        this._name = name;
        this.nationalNumber = nationalNumber;
        this.password = password;
        this.rePassword = rePassword;
        this.nation = nation;

    }

    @Override
    public String toString() {
        return "name: " + get_name() + ", national number: " + getNationalNumber() + "Password: " + getPassword() + ", nation: " + getNation() ;


    }
}