/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class User implements Serializable{
    private String firstName;
    private String lastName;
    private String tel;
    
    public User() {
        
    }

    @Override
    public String toString() {
        return "User{" 
                + "firstName=" + firstName
                + ", lastName=" + lastName
                + ", tel=" + tel + '}';
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
