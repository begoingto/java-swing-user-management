/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repositories;

import app.models.Report;
import app.services.MainService;

/**
 *
 * @author begoingtodev
 */
public class ReportRepository extends MainService<Report>{

    public ReportRepository() {
        super.clazz = Report.class;
    }
    
    
    public Class<Report> getClazz(){
        return this.clazz;
    }
}
