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
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByIdDept", query = "SELECT d FROM Department d WHERE d.idDept = :idDept"),
    @NamedQuery(name = "Department.findByDeptCode", query = "SELECT d FROM Department d WHERE d.deptCode = :deptCode"),
    @NamedQuery(name = "Department.findByDeptName", query = "SELECT d FROM Department d WHERE d.deptName = :deptName")})
public class Department implements Serializable, DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dept")
    private Integer idDept;
    @Basic(optional = false)
    @Column(name = "dept_code")
    private String deptCode;
    @Column(name = "dept_name")
    private String deptName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offeringDept")
    private List<Course> courseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acceptingDept")
    private List<Course> courseList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDept")
    private List<DegreeOfferedByDept> degreeOfferedByDeptList;

    public Department() {
    }

    public Department(Integer idDept) {
        this.idDept = idDept;
    }

    public Department(Integer idDept, String deptCode) {
        this.idDept = idDept;
        this.deptCode = deptCode;
    }

    public Integer getIdDept() {
        return idDept;
    }

    public void setIdDept(Integer idDept) {
        this.idDept = idDept;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @XmlTransient
    public List<Course> getCourseList1() {
        return courseList1;
    }

    public void setCourseList1(List<Course> courseList1) {
        this.courseList1 = courseList1;
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
        hash += (idDept != null ? idDept.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.idDept == null && other.idDept != null) || (this.idDept != null && !this.idDept.equals(other.idDept))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Department[ idDept=" + idDept + " ]";
    }
    
}
