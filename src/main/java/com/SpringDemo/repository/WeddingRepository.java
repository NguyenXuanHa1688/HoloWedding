/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SpringDemo.repository;

import com.SpringDemo.pojo.Wedding;
import java.util.List;

/**
 *
 * @author billg
 */
public interface WeddingRepository {
    List<Wedding> getWeddings(String kw,String collum, int page);
    int countWeds();
    boolean addOrUpdateWedding(Wedding w);
    Wedding getWeddingById(int id);
    boolean deleteWedding(Wedding w);
    List<Wedding> getAllWeddings();
    List<Wedding> getFindWeddings(String kw);
    List<Wedding> SortDescWeddings();
    List<Wedding> ascDescWeddings();
}
