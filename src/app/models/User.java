/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author begoingtodev
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String fullName;
    private String gender;
    private String password;
    private String role;
    private Boolean status;

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    public String getUsername() {
        return username.toLowerCase();
    }
    
}
