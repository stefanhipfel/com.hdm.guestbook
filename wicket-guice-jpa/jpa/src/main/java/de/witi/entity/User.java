package de.witi.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User.
 *
 * @author Witold Czaplewski - http://50226.de
 */
@Entity(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 2959377496669050427L;
    @Id
    @GeneratedValue
    private Short id;
    private String name;
    private String password;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof User)) {
            return false;
        }

        final User other = (User) obj;

        if (this.getId() != other.getId() && (this.getId() == null
                || !this.getId().equals(other.getId()))) {
            return false;
        }

        if ((this.getName() == null) ? (other.getName() != null) : !this.getName().equals(other.getName())) {
            return false;
        }

        if ((this.getPassword() == null) ? (other.getPassword() != null)
                : !this.getPassword().equals(other.getPassword())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        hash = 11 * hash + (this.getName() != null ? this.getName().hashCode() : 0);
        hash = 11 * hash + (this.getPassword() != null ? this.getPassword().hashCode() : 0);
        return hash;
    }
}