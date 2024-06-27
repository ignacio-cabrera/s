package it.ciac.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = Util.UNSIGNED_INT)
    private long id;

    @NotBlank(message = "First name" + Util.FIELD_NOT_BLANK)
    @Size(max = 25, message = "First name" + Util.FIELD_MAX_SIZE + 25 + Util.CHARS_LONG)
    @Column(name = "first_name", length = 25, nullable = false)
    private String fname;

    @NotBlank(message = "Last name" + Util.FIELD_NOT_BLANK)
    @Size(max = 25, message = "Last name" + Util.FIELD_MAX_SIZE + 25 + Util.CHARS_LONG)
    @Column(name = "last_name", length = 25, nullable = false)
    private String lname;

    @Email(message = "Email" + Util.NOT_VALID_EMAIL)
    @NotBlank(message = "Email" + Util.FIELD_NOT_BLANK)
    @Size(max = 320, message = "Email" + Util.FIELD_MAX_SIZE + 320 + Util.CHARS_LONG)
    @Column(length = 320, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password" + Util.FIELD_NOT_BLANK)
    @Size(max = 20, message = "Password" + Util.FIELD_MAX_SIZE + 20 + Util.CHARS_LONG)
    @Column(length = 20, nullable = false)
    private String password;

    @Size(max = 45, message = "Phone number" + Util.FIELD_MAX_SIZE + 45 + Util.CHARS_LONG)
    @Column(length = 45)
    private String tel;

    @NotNull(message = "Admin" + Util.FIELD_NOT_NULL)
    @Column(nullable = false)
    private boolean admin = false;

    @Column(nullable = true)
    private Boolean activated = true;

    public User() {
    }

    public User(
            @NotBlank(message = "First name field cannot be blank") @Size(max = 25, message = "First name field must be at most 25 characters long") String fname,
            @NotBlank(message = "Last name field cannot be blank") @Size(max = 25, message = "Last name field must be at most 25 characters long") String lname,
            @Email(message = "Email field is not a valid email format") @NotNull(message = "Email field cannot be blank") @Size(max = 320, message = "Email field must be at most 320 characters long") String email,
            @NotBlank(message = "Password field cannot be blank") @Size(max = 20, message = "Password field must be at most 20 characters long") String password,
            @NotNull(message = "Admin field cannot be null") boolean admin) {
        this(fname, lname, email, password, null, admin);
    }

    public User(
            @NotBlank(message = "First name field cannot be blank") @Size(max = 25, message = "First name field must be at most 25 characters long") String fname,
            @NotBlank(message = "Last name field cannot be blank") @Size(max = 25, message = "Last name field must be at most 25 characters long") String lname,
            @Email(message = "Email field is not a valid email format") @NotNull(message = "Email field cannot be blank") @Size(max = 320, message = "Email field must be at most 320 characters long") String email,
            @NotBlank(message = "Password field cannot be blank") @Size(max = 20, message = "Password field must be at most 20 characters long") String password,
            @Size(max = 45, message = "Phone number field must be at most 45 characters long") String tel,
            @NotNull(message = "Admin field cannot be null") boolean admin) {
        this.fname = fname.trim();
        this.lname = lname.trim();
        this.email = email.trim();
        this.password = password;
        this.tel = tel == null || tel.isBlank() ? null : tel.trim();
        this.admin = admin;
        this.activated = admin ? false : true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFullName() {
        return fname + " " + lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Boolean isActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
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
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", tel=" + tel
                + ", admin=" + admin + ", activated=" + activated + "]";
    }
}
