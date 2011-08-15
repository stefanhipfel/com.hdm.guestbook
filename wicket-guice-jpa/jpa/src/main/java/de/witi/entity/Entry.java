package de.witi.entity;

import java.io.Serializable;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "entry")
public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	private String username;
	private Date dateTime;
	private String text;
        
        //</editor-fold>
	// Constructors:
	public Entry() {
	}

	public Entry(String user, Date timetamp, String text) {
		this.username = user;
		this.dateTime = timetamp;
		this.text = text;
	}

	// String Representation:
	@Override
	public String toString() {
		return username + ", " + dateTime + ", " + text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimetamp() {
		return dateTime;
	}

	public void setTimetamp(Date timetamp) {
		this.dateTime = timetamp;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUser(String user) {
		this.username= user;
	}
	
	public String getUser() {
		return this.username;
	}
        
         @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Entry)) {
            return false;
        }

        final Entry other = (Entry) obj;

        if ((this.getUser() == null) ? (other.getUser() != null) : !this.getUser().equals(other.getUser())) {
            return false;
        }

        if ((this.getTimetamp() == null) ? (other.getTimetamp() != null)
                : !this.getTimetamp().equals(other.getTimetamp())) {
            return false;
        }
        
         if ((this.getText() == null) ? (other.getText() != null)
                : !this.getText().equals(other.getText())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.getUser() != null ? this.getUser().hashCode() : 0);
        hash = 11 * hash + (this.getTimetamp() != null ? this.getTimetamp().hashCode() : 0);
        hash = 11 * hash + (this.getText() != null ? this.getText().hashCode() : 0);
        return hash;
    }
}