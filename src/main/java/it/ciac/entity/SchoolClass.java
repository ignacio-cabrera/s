package it.ciac.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "classes")
public class SchoolClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", columnDefinition = Util.UNSIGNED_INT)
    private long id;

    @NotBlank(message = "Class name" + Util.FIELD_NOT_BLANK)
    @Size(max = 15, message = "Class name" + Util.FIELD_MAX_SIZE + 15 + Util.CHARS_LONG)
    @Column(name = "class_name", length = 15, nullable = false, unique = true)
    private String className;

    public SchoolClass() {
    }

    public SchoolClass(
            @NotBlank(message = "Class name field cannot be blank") @Size(max = 15, message = "Class name field must be at most 15 characters long") String className) {
        this.className = className.trim();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
        SchoolClass other = (SchoolClass) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Class [id=" + id + ", className=" + className + "]";
    }
}
