/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.service.impl;
import com.SpringDemo.pojo.Wedding;
import com.SpringDemo.repository.WeddingRepository;
import com.SpringDemo.service.WeddingService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;


import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author billg
 */
@Service
public class WeddingServiceImpl implements WeddingService{
    @Autowired
    private WeddingRepository weddingRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Wedding> getWeddings(String kw,String collum, int page) {
        return this.weddingRepository.getWeddings(kw,collum, page);
    }

    @Override
    public int countWeds() {
        return this.weddingRepository.countWeds();
    }

    @Override
    public boolean addOrUpdateWedding(Wedding w) {
        if (w.getFile() != null){
            try {
                Map res = this.cloudinary.uploader().upload(w.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                w.setImg((String) res.get("secure_url"));
                
            } catch (IOException ex) {
                Logger.getLogger(WeddingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       return this.weddingRepository.addOrUpdateWedding(w);
    }

    @Override
    public Wedding getWeddingById(int i) {
        return this.weddingRepository.getWeddingById(i);
    }
    @Override
    public boolean deleteWedding(Wedding w){
        return this.weddingRepository.deleteWedding(w);
    }
    @Override 
    public List<Wedding> getAllWeddings(){
        return this.weddingRepository.getAllWeddings();
    }
    @Override
    public List<Wedding> getFindWeddings(String kw){
        return this.weddingRepository.getFindWeddings(kw);
    }

    @Override
    public List<Wedding> SortDescWeddings() {
        return this.weddingRepository.SortDescWeddings();
    }

    @Override
    public List<Wedding> ascDescWeddings() {
        return this.weddingRepository.ascDescWeddings();
    }
}
