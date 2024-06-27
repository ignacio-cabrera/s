package it.ciac.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "classbooks")
public class ClassBook implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classbook_id", columnDefinition = Util.UNSIGNED_INT)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "class_id", columnDefinition = Util.UNSIGNED_INT, nullable = false)
    private SchoolClass assignedTo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", columnDefinition = Util.UNSIGNED_INT, nullable = false)
    private Book book;

    @Column(nullable = false)
    private boolean optional = false;

    public ClassBook() {
    }

    public ClassBook(SchoolClass assignedTo, Book book, boolean optional) {
        this.assignedTo = assignedTo;
        this.book = book;
        this.optional = optional;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SchoolClass getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(SchoolClass assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClassBook other = (ClassBook) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClassBook [id=" + id + ", assignedTo=" + assignedTo + ", book=" + book + ", optional=" + optional + "]";
    }
}
