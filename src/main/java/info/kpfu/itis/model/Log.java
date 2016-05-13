package info.kpfu.itis.model;


import javax.persistence.*;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "date")
    private String date;


    @Column(name = "methodName")
    private String methodName;


    @Column(name = "returnValue")
    private String returnValue;

    @Column(name = "username")
    private String username;

    public Log(String date, String methodName, String returnValue, String username) {
        this.date = date;
        this.methodName = methodName;
        this.returnValue = returnValue;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
