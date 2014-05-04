package com.fisi.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class ImageSwitchMB implements Serializable {

	private static final long serialVersionUID = -8599240493981027582L;
	private List<String> images;  
	  
    public ImageSwitchMB() {  
        images = new ArrayList<String>();  
        images.add("resources/img/instituciones.jpg");
        images.add("resources/img/colegio_guadalupe.jpg");  
        images.add("resources/img/muniLima.jpg");  
        
    }  
  
    public List<String> getImages() {  
        return images;  
    }  
}
