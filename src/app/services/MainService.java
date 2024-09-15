/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author begoingtodev
 * @param <T> Object for get data
 */
public class MainService<T> {
    public final Gson gson = new Gson();
    public Map<String,List<T>> data = new HashMap<>();
    public List<T> items = new ArrayList<>();
    public String path = Paths.get("").toAbsolutePath().toString();
    public T object;
    Type mapType = new TypeToken<Map<String, List<T>>>(){}.getType();
    private String filename;
    protected Class<T> clazz;
    private T dataObj;

    public MainService(String filename,Class<T> classObj) {
        this.filename = filename;
        this.clazz = classObj;
    }

    public MainService() {
    }
    

    
    protected void LoadData(){
        data.put("data", items);
        // Read the JSON file to the map of the specified type
        try (FileReader reader = new FileReader(path+"/data/"+filename+".json")) {
            data = gson.fromJson(reader, mapType);
            items.addAll(data.get("data"));
            items = items.stream().map(item -> {
                String json = gson.toJson(item);
                object = gson.fromJson(json, clazz);
                return object;
            }).toList();
        } catch (IOException e) {
            System.err.println("Error read: "+ e.getMessage());
        }
    }
    
    protected void writeItemsToJson(List<T> listObj){
        items = listObj;
        data.put("data", listObj);
        String dataJson = gson.toJson(data,mapType);
        try (FileWriter writer = new FileWriter(path+"/data/"+ filename +".json")) {
            writer.write(dataJson);
        } catch (IOException e) {
           throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    public void writeItemsToJson(T obj,String dir,String fName){
        String dataJson = gson.toJson(obj);
        try (FileWriter writer = new FileWriter(path+"/data"+dir+"/"+ fName +".json")) {
            writer.write(dataJson);
        } catch (IOException e) {
           throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
