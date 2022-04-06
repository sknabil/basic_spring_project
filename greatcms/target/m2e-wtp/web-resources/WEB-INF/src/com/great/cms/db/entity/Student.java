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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByIdStudent", query = "SELECT s FROM Student s WHERE s.idStudent = :idStudent"),
    @NamedQuery(name = "Student.findByRegistrationNo", query = "SELECT s FROM Student s WHERE s.registrationNo = :registrationNo"),
    @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name"),
    @NamedQuery(name = "Student.findBySession", query = "SELECT s FROM Student s WHERE s.session = :session")})
public class Student implements Serializable, DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_student")
    private Integer idStudent;
    @Basic(optional = false)
    @Column(name = "registration_no")
    private int registrationNo;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "session")
    private int session;
    @JoinColumn(name = "id_dept_degree", referencedColumnName = "id_dept_degree")
    @ManyToOne(optional = false)
    private DegreeOfferedByDept idDeptDegree;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStudent")
    private List<CourseRegistration> courseRegistrationList;

    public Student() {
    }

    public Student(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Student(Integer idStudent, int registrationNo, String password, int session) {
        this.idStudent = idStudent;
        this.registrationNo = registrationNo;
        this.password = password;
        this.session = session;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public int getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(int registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public DegreeOfferedByDept getIdDeptDegree() {
        return idDeptDegree;
    }

    public void setIdDeptDegree(DegreeOfferedByDept idDeptDegree) {
        this.idDeptDegree = idDeptDegree;
    }

    @XmlTransient
    public List<CourseRegistration> getCourseRegistrationList() {
        return courseRegistrationList;
    }

    public void setCourseRegistrationList(List<CourseRegistration> courseRegistrationList) {
        this.courseRegistrationList = courseRegistrationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudent != null ? idStudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idStudent == null && other.idStudent != null) || (this.idStudent != null && !this.idStudent.equals(other.idStudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Student[ idStudent=" + idStudent + " ]";
    }
    
}
