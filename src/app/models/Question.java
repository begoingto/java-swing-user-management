/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import java.util.List;
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
public class Question {
    private Integer id;
    private String level;
    private String title;
    private List<String> answers;
    private Integer correctAnswer;
    private Integer answered;
}
