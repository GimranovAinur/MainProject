package info.kpfu.itis.model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "advice")
public class Advice implements Serializable{

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

    @ManyToOne
    @JoinColumn(name = "wish_id")
    private Wish wish;

    public Advice(){
    }

    public Advice(String text, User user) {
        this.text = text;
        this.user = user;
    }

    @PrePersist
    public void onCreate(){
        dateTime = new Date();
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

    public Wish getWish() {
        return wish;
    }

    public void setWish(Wish wish) {
        this.wish = wish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advice advice = (Advice) o;

        if (id != advice.id) return false;
        if (text != null ? !text.equals(advice.text) : advice.text != null) return false;
        if (user != null ? !user.equals(advice.user) : advice.user != null) return false;
        return !(wish != null ? !wish.equals(advice.wish) : advice.wish != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (wish != null ? wish.hashCode() : 0);
        return result;
    }
}
