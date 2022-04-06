/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sknabil
 */
@Entity
@Table(name = "course_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseRegistration.findAll", query = "SELECT c FROM CourseRegistration c"),
    @NamedQuery(name = "CourseRegistration.findByIdCourseReg", query = "SELECT c FROM CourseRegistration c WHERE c.idCourseReg = :idCourseReg"),
    @NamedQuery(name = "CourseRegistration.findByIsApproved", query = "SELECT c FROM CourseRegistration c WHERE c.isApproved = :isApproved"),
    @NamedQuery(name = "CourseRegistration.findByMarks", query = "SELECT c FROM CourseRegistration c WHERE c.marks = :marks")})
public class CourseRegistration implements Serializable, DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_course_reg")
    private Integer idCourseReg;
    @Basic(optional = false)
    @Column(name = "is_approved")
    private boolean isApproved;
    @Column(name = "marks")
    private Integer marks;
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    @ManyToOne(optional = false)
    private Student idStudent;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;

    public CourseRegistration() {
    }

    public CourseRegistration(Integer idCourseReg) {
        this.idCourseReg = idCourseReg;
    }

    public CourseRegistration(Integer idCourseReg, boolean isApproved) {
        this.idCourseReg = idCourseReg;
        this.isApproved = isApproved;
    }

    public Integer getIdCourseReg() {
        return idCourseReg;
    }

    public void setIdCourseReg(Integer idCourseReg) {
        this.idCourseReg = idCourseReg;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Student getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Student idStudent) {
        this.idStudent = idStudent;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCourseReg != null ? idCourseReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseRegistration)) {
            return false;
        }
        CourseRegistration other = (CourseRegistration) object;
        if ((this.idCourseReg == null && other.idCourseReg != null) || (this.idCourseReg != null && !this.idCourseReg.equals(other.idCourseReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CourseRegistration[ idCourseReg=" + idCourseReg + " ]";
    }
    
}
