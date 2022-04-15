/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author billg
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByComid", query = "SELECT c FROM Comment c WHERE c.comid = :comid"),
    @NamedQuery(name = "Comment.findByContent", query = "SELECT c FROM Comment c WHERE c.content = :content"),
    @NamedQuery(name = "Comment.findByDateCreate", query = "SELECT c FROM Comment c WHERE c.dateCreate = :dateCreate")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comid")
    private Integer comid;
    @Size(max = 250)
    @Column(name = "content")
    private String content;
    @Size(max = 45)
    @Column(name = "dateCreate")
    private String dateCreate;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private User username;
    @JoinColumn(name = "idWedding", referencedColumnName = "idWedding")
    @ManyToOne
    private Wedding idWedding;

    public Comment() {
    }

    public Comment(Integer comid) {
        this.comid = comid;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public Wedding getIdWedding() {
        return idWedding;
    }

    public void setIdWedding(Wedding idWedding) {
        this.idWedding = idWedding;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comid != null ? comid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.comid == null && other.comid != null) || (this.comid != null && !this.comid.equals(other.comid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SpringDemo.pojo.Comment[ comid=" + comid + " ]";
    }
    
}
