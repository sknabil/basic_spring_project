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
@Table(name = "degree_offered_by_dept")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DegreeOfferedByDept.findAll", query = "SELECT d FROM DegreeOfferedByDept d"),
    @NamedQuery(name = "DegreeOfferedByDept.findByIdDeptDegree", query = "SELECT d FROM DegreeOfferedByDept d WHERE d.idDeptDegree = :idDeptDegree")})
public class DegreeOfferedByDept implements Serializable, DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dept_degree")
    private Integer idDeptDegree;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeptDegree")
    private List<Student> studentList;
    @JoinColumn(name = "id_dept", referencedColumnName = "id_dept")
    @ManyToOne(optional = false)
    private Department idDept;
    @JoinColumn(name = "id_degree", referencedColumnName = "id_degree")
    @ManyToOne(optional = false)
    private Degree idDegree;

    public DegreeOfferedByDept() {
    }

    public DegreeOfferedByDept(Integer idDeptDegree) {
        this.idDeptDegree = idDeptDegree;
    }

    public Integer getIdDeptDegree() {
        return idDeptDegree;
    }

    public void setIdDeptDegree(Integer idDeptDegree) {
        this.idDeptDegree = idDeptDegree;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Department getIdDept() {
        return idDept;
    }

    public void setIdDept(Department idDept) {
        this.idDept = idDept;
    }

    public Degree getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(Degree idDegree) {
        this.idDegree = idDegree;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeptDegree != null ? idDeptDegree.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DegreeOfferedByDept)) {
            return false;
        }
        DegreeOfferedByDept other = (DegreeOfferedByDept) object;
        if ((this.idDeptDegree == null && other.idDeptDegree != null) || (this.idDeptDegree != null && !this.idDeptDegree.equals(other.idDeptDegree))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DegreeOfferedByDept[ idDeptDegree=" + idDeptDegree + " ]";
    }
    
}
