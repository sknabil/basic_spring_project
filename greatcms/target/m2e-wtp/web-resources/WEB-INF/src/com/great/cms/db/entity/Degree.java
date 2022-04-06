/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.db.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sknabil
 */
@Entity
@Table(name = "degree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Degree.findAll", query = "SELECT d FROM Degree d"),
    @NamedQuery(name = "Degree.findByIdDegree", query = "SELECT d FROM Degree d WHERE d.idDegree = :idDegree"),
    @NamedQuery(name = "Degree.findByDegreeType", query = "SELECT d FROM Degree d WHERE d.degreeType = :degreeType"),
    @NamedQuery(name = "Degree.findByDegreeCategory", query = "SELECT d FROM Degree d WHERE d.degreeCategory = :degreeCategory"),
    @NamedQuery(name = "Degree.findByTotalSemester", query = "SELECT d FROM Degree d WHERE d.totalSemester = :totalSemester")})
public class Degree implements Serializable, DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_degree")
    private Integer idDegree;
    @Basic(optional = false)
    @Column(name = "degree_type")
    private String degreeType;
    @Basic(optional = false)
    @Column(name = "degree_category")
    private String degreeCategory;
    @Column(name = "total_semester")
    private Integer totalSemester;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDegree")
    private List<DegreeOfferedByDept> degreeOfferedByDeptList;

    public Degree() {
    }

    public Degree(Integer idDegree) {
        this.idDegree = idDegree;
    }

    public Degree(Integer idDegree, String degreeType, String degreeCategory) {
        this.idDegree = idDegree;
        this.degreeType = degreeType;
        this.degreeCategory = degreeCategory;
    }

    public Integer getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(Integer idDegree) {
        this.idDegree = idDegree;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getDegreeCategory() {
        return degreeCategory;
    }

    public void setDegreeCategory(String degreeCategory) {
        this.degreeCategory = degreeCategory;
    }

    public Integer getTotalSemester() {
        return totalSemester;
    }

    public void setTotalSemester(Integer totalSemester) {
        this.totalSemester = totalSemester;
    }

    @XmlTransient
    public List<DegreeOfferedByDept> getDegreeOfferedByDeptList() {
        return degreeOfferedByDeptList;
    }

    public void setDegreeOfferedByDeptList(List<DegreeOfferedByDept> degreeOfferedByDeptList) {
        this.degreeOfferedByDeptList = degreeOfferedByDeptList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDegree != null ? idDegree.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Degree)) {
            return false;
        }
        Degree other = (Degree) object;
        if ((this.idDegree == null && other.idDegree != null) || (this.idDegree != null && !this.idDegree.equals(other.idDegree))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Degree[ idDegree=" + idDegree + " ]";
    }
    
}
