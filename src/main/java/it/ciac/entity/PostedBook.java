package it.ciac.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "postedbooks")
public class PostedBook implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posted_book_id", columnDefinition = Util.UNSIGNED_INT)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", columnDefinition = Util.UNSIGNED_INT, nullable = false)
    private Book book;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", columnDefinition = Util.UNSIGNED_INT, nullable = false)
    private User postedBy;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_condition", columnDefinition = "VARCHAR(20)", nullable = false)
    private BookCondition bookCondition;

    @Size(max = 45, message = "Comment" + Util.FIELD_MAX_SIZE + 45 + Util.CHARS_LONG)
    @Column(length = 45)
    private String comment;

    @Positive(message = "Price field must be a positive decimal")
    @DecimalMax(value = "9999.99", message = "Price" + Util.FIELD_MAX_SIZE + "9999.99")
    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean available = true;

    public PostedBook() {
    }

    public PostedBook(Book book, User postedBy, BookCondition bookCondition,
            @Positive(message = "Price field must be a positive decimal") @DecimalMax(value = "9999.99", message = "Price field must be at most 9999.99") BigDecimal price,
            boolean available) {
        this(book, postedBy, bookCondition, null, price, available);
    }

    public PostedBook(Book book, User postedBy, BookCondition bookCondition,
            @Size(max = 45, message = "Comment field must be at most 45 characters long") String comment,
            @Positive(message = "Price field must be a positive decimal") @DecimalMax(value = "9999.99", message = "Price field must be at most 9999.99") BigDecimal price,
            boolean available) {
        this.book = book;
        this.postedBy = postedBy;
        this.bookCondition = bookCondition;
        this.comment = comment == null || comment.isBlank() ? null : comment.trim();
        this.price = price;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public BookCondition getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(BookCondition bookCondition) {
        this.bookCondition = bookCondition;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
        PostedBook other = (PostedBook) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PostedBook [id=" + id + ", book=" + book + ", postedBy=" + postedBy + ", bookCondition=" + bookCondition
                + ", comment=" + comment + ", price=" + price + ", available=" + available + "]";
    }
}
