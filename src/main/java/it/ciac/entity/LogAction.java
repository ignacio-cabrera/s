package it.ciac.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "logaction")
public class LogAction implements Serializable {
    @Transient
    public static final String CREATION = "Creation";

    @Transient
    public static final String ACTIVATION = "Activation";

    @Transient
    public static final String SUSPENSION = "Suspension";

    @Transient
    public static final String BAN = "Ban";

    @Id
    @Column(length = 20, unique = true, insertable = false, updatable = false)
    private String action;

    public LogAction() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((action == null) ? 0 : action.hashCode());
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
        LogAction other = (LogAction) obj;
        if (action == null) {
            if (other.action != null)
                return false;
        } else if (!action.equals(other.action))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LogAction [action=" + action + "]";
    }
}
