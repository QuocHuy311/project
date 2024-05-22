/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quoch
 */
public class Account {
    private int id;
    private String password;
    private String email;
    private boolean issell ;
    private boolean isadmin;
    private int phone;
    private String fullname;
    private String address;

    public Account() {
    }

    public Account(int id, String password, String email, boolean issell, boolean isadmin, int phone, String fullname, String address) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.issell = issell;
        this.isadmin = isadmin;
        this.phone = phone;
        this.fullname = fullname;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIssell() {
        return issell;
    }

    public void setIssell(boolean issell) {
        this.issell = issell;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", password=" + password + ", email=" + email + ", issell=" + issell + ", isadmin=" + isadmin + ", phone=" + phone + ", fullname=" + fullname + ", address=" + address + '}';
    }
    
    
    
}
