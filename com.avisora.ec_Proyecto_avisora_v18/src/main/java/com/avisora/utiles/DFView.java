/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.utiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

/**
 *
 * @author avmei
 */
@ManagedBean(name = "dfView")
public class DFView {
         
    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");
         
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    
    public static Calendar makeDate(String date){
  Date d=null;
  Calendar calendar=Calendar.getInstance();
  try {
    SimpleDateFormat format=new SimpleDateFormat("dd MMM yyyy");
    d=format.parse(date);
    calendar.setTime(d);
  }
 catch (  ParseException e) {
    e.printStackTrace();
  }
  return calendar;
}
    
}