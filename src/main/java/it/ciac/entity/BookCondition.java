package it.ciac.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookcondition")
public class BookCondition implements Serializable {
    @Id
    @Column(length = 20, unique = true, insertable = false)
    private String condition;

    @Column(length = 150, nullable = false, insertable = false)
    private String description;

    public BookCondition() {
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((condition == null) ? 0 : condition.hashCode());
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
        BookCondition other = (BookCondition) obj;
        if (condition == null) {
            if (other.condition != null)
                return false;
        } else if (!condition.equals(other.condition))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BookCondition [condition=" + condition + ", description=" + description + "]";
    }
}
