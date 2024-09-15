/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author begoingtodev
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private UUID uuid;
    private String createdAt;
    private User user;
    private List<Question> questions;
}
