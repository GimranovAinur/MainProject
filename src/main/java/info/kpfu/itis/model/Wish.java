package info.kpfu.itis.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "wish")
public class Wish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Length(min = 1, max = 1000)
    @NotBlank
    @Column(name = "text")
    private String text;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "wish", cascade = CascadeType.ALL)
    private Set<Advice> advices;

    @PrePersist
    public void onCreate(){
        dateTime = new Date();
    }

    public Wish() {
    }

    public Wish(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Advice> getAdvices() {
        return advices;
    }

    public void setAdvices(Set<Advice> advices) {
        this.advices = advices;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wish wish = (Wish) o;

        if (id != wish.id) return false;
        if (!text.equals(wish.text)) return false;
        if (!user.equals(wish.user)) return false;
        return !(advices != null ? !advices.equals(wish.advices) : wish.advices != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + text.hashCode();
        return result;
    }
}
