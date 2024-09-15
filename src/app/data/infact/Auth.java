/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.data.infact;

/**
 *
 * @author begoingto
 */
public interface Auth {
    public Boolean check(String username, String password);
    public Boolean setCode(String code, String username);
    public Boolean verify(String code, String username);
}
