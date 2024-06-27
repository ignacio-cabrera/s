package it.ciac.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", columnDefinition = Util.UNSIGNED_INT)
    private long id;

    @NotBlank(message = "Title" + Util.FIELD_NOT_BLANK)
    @Size(max = 100, message = "Title" + Util.FIELD_MAX_SIZE + 100 + Util.CHARS_LONG)
    @Column(length = 100, nullable = false)
    private String title;

    @NotBlank(message = "Author" + Util.FIELD_NOT_BLANK)
    @Size(max = 50, message = "Author" + Util.FIELD_MAX_SIZE + 50 + Util.CHARS_LONG)
    @Column(length = 50, nullable = false)
    private String author;

    @NotBlank(message = "Publishing house" + Util.FIELD_NOT_BLANK)
    @Size(max = 45, message = "Publishing house" + Util.FIELD_MAX_SIZE + 45 + Util.CHARS_LONG)
    @Column(name = "publishing_house", length = 45, nullable = false)
    private String pubHouse;

    @Size(max = 15, message = "Version" + Util.FIELD_MAX_SIZE + 15 + Util.CHARS_LONG)
    @Column(length = 15)
    private String version;

    @DecimalMax(value = "9999.99", message = "Standard price" + Util.FIELD_MAX_SIZE + "9999.99")
    @Column(name = "standard_price", precision = 6, scale = 2)
    private BigDecimal stdPrice;

    public Book() {
    }

    public Book(
            @NotBlank(message = "Title field cannot be blank") @Size(max = 100, message = "Title field must be at most 100 characters long") String title,
            @NotBlank(message = "Author field cannot be blank") @Size(max = 50, message = "Author field must be at most 50 characters long") String author,
            @NotBlank(message = "Publishing house field cannot be blank") @Size(max = 45, message = "Publishing house field must be at most 45 characters long") String pubHouse) {
        this(title, author, pubHouse, null, null);
    }

    public Book(
            @NotBlank(message = "Title field cannot be blank") @Size(max = 100, message = "Title field must be at most 100 characters long") String title,
            @NotBlank(message = "Author field cannot be blank") @Size(max = 50, message = "Author field must be at most 50 characters long") String author,
            @NotBlank(message = "Publishing house field cannot be blank") @Size(max = 45, message = "Publishing house field must be at most 45 characters long") String pubHouse,
            @Size(max = 15, message = "Version field must be at most 15 characters long") String version) {
        this(title, author, pubHouse, version, null);
    }

    public Book(
            @NotBlank(message = "Title field cannot be blank") @Size(max = 100, message = "Title field must be at most 100 characters long") String title,
            @NotBlank(message = "Author field cannot be blank") @Size(max = 50, message = "Author field must be at most 50 characters long") String author,
            @NotBlank(message = "Publishing house field cannot be blank") @Size(max = 45, message = "Publishing house field must be at most 45 characters long") String pubHouse,
            @DecimalMax(value = "9999.99", message = "Standard price field must be at most 9999.99") BigDecimal stdPrice) {
        this(title, author, pubHouse, null, stdPrice);
    }

    public Book(
            @NotBlank(message = "Title field cannot be blank") @Size(max = 100, message = "Title field must be at most 100 characters long") String title,
            @NotBlank(message = "Author field cannot be blank") @Size(max = 50, message = "Author field must be at most 50 characters long") String author,
            @NotBlank(message = "Publishing house field cannot be blank") @Size(max = 45, message = "Publishing house field must be at most 45 characters long") String pubHouse,
            @Size(max = 15, message = "Version field must be at most 15 characters long") String version,
            @DecimalMax(value = "9999.99", message = "Standard price field must be at most 9999.99") BigDecimal stdPrice) {
        this.title = title.trim();
        this.author = author.trim();
        this.pubHouse = pubHouse.trim();
        this.version = version.isBlank() ? null : version.trim();
        this.stdPrice = stdPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubHouse() {
        return pubHouse;
    }

    public void setPubHouse(String pubHouse) {
        this.pubHouse = pubHouse;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigDecimal getStdPrice() {
        return stdPrice;
    }

    public void setStdPrice(BigDecimal stdPrice) {
        this.stdPrice = stdPrice;
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
        Book other = (Book) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", pubHouse=" + pubHouse + ", version="
                + version + ", stdPrice=" + stdPrice + "]";
    }
}
