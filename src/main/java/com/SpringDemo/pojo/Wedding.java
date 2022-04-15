/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author billg
 */
@Entity
@Table(name = "wedding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wedding.findAll", query = "SELECT w FROM Wedding w"),
    @NamedQuery(name = "Wedding.findByIdWedding", query = "SELECT w FROM Wedding w WHERE w.idWedding = :idWedding"),
    @NamedQuery(name = "Wedding.findByName", query = "SELECT w FROM Wedding w WHERE w.name = :name"),
    @NamedQuery(name = "Wedding.findByPrice", query = "SELECT w FROM Wedding w WHERE w.price = :price"),
    @NamedQuery(name = "Wedding.findByStartDate", query = "SELECT w FROM Wedding w WHERE w.startDate = :startDate"),
    @NamedQuery(name = "Wedding.findByDuration", query = "SELECT w FROM Wedding w WHERE w.duration = :duration"),
    @NamedQuery(name = "Wedding.findByDetail", query = "SELECT w FROM Wedding w WHERE w.detail = :detail"),
    @NamedQuery(name = "Wedding.findByImg", query = "SELECT w FROM Wedding w WHERE w.img = :img")})
public class Wedding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idWedding")
    private Integer idWedding;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "price")
    private String price;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "duration")
    private Integer duration;
    @Size(max = 2000)
    @Column(name = "detail")
    private String detail;
    @Size(max = 200)
    @Column(name = "img")
    private String img;
    @Transient
    private MultipartFile file;

    public Wedding() {
    }

    public Wedding(Integer idWedding) {
        this.idWedding = idWedding;
    }

    public Integer getIdWedding() {
        return idWedding;
    }

    public void setIdWedding(Integer idWedding) {
        this.idWedding = idWedding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWedding != null ? idWedding.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wedding)) {
            return false;
        }
        Wedding other = (Wedding) object;
        if ((this.idWedding == null && other.idWedding != null) || (this.idWedding != null && !this.idWedding.equals(other.idWedding))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SpringDemo.pojo.Wedding[ idWedding=" + idWedding + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
