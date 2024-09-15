/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repositories;

import java.util.ArrayList;
import java.util.List;
import app.models.Question;
import app.services.MainService;

/**
 *
 * @author begoingtodev
 */
public class QuestionRepository extends MainService<Question>{

    public QuestionRepository() {
        super("question",Question.class);
        super.LoadData();
    }
    
    public void AddQuestion(Question q){
    
        List<Question> objs = new ArrayList<>(){{
            addAll(items);
        }};
        objs.add(q);
        super.writeItemsToJson(objs);
    }
 
    public void updateItem(int index, Question q){
        List<Question> objs = new ArrayList<>(){{
            addAll(items);
        }};
        objs.set(index, q);
        super.writeItemsToJson(objs);
    }
    
    public void deteleItem(Question q){
        List<Question> objs = new ArrayList<>(){{
            addAll(items);
        }};
        objs.remove(q);
        super.writeItemsToJson(objs);
    }
}
