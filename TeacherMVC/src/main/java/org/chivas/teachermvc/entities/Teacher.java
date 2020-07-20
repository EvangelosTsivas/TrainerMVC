
package org.chivas.teachermvc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vagos
 */
@Entity
@Table(name = "teachers", catalog = "teachermvc", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findById", query = "SELECT t FROM Teacher t WHERE t.id = :id")
    , @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT t FROM Teacher t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "Teacher.findByLastName", query = "SELECT t FROM Teacher t WHERE t.lastName = :lastName")
    , @NamedQuery(name = "Teacher.findBySubject", query = "SELECT t FROM Teacher t WHERE t.subject = :subject")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "subject", nullable = false, length = 50)
    private String subject;

    public Teacher() {
    }

    public Teacher(Integer id) {
        this.id = id;
    }

    public Teacher(Integer id, String firstName, String lastName, String subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chivas.teachermvc.entities.Teacher[ id=" + id + " ]";
    }
    
}
