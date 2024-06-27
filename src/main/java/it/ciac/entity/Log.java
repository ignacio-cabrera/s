package it.ciac.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", columnDefinition = Util.UNSIGNED_INT)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "action", columnDefinition = "VARCHAR(20)", nullable = false)
    private LogAction action;

    @ManyToOne(optional = false)
    @JoinColumn(name = "performed_on", columnDefinition = Util.UNSIGNED_INT, nullable = false)
    private User performedOn;

    @ManyToOne(optional = false)
    @JoinColumn(name = "performed_by", columnDefinition = Util.UNSIGNED_INT, nullable = false)
    private User performedBy;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();;

    public Log() {
    }

    public Log(LogAction action, User performedOn, User performedBy) {
        this.action = action;
        this.performedOn = performedOn;
        this.performedBy = performedBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LogAction getAction() {
        return action;
    }

    public void setAction(LogAction action) {
        this.action = action;
    }

    public User getPerformedOn() {
        return performedOn;
    }

    public void setPerformedOn(User performedOn) {
        this.performedOn = performedOn;
    }

    public User getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(User performedBy) {
        this.performedBy = performedBy;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
        Log other = (Log) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Log [id=" + id + ", action=" + action + ", performedOn=" + performedOn + ", performedBy=" + performedBy
                + ", date=" + date + "]";
    }
}
