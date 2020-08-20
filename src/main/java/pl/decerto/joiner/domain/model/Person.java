package pl.decerto.joiner.domain.model;


import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String fn;

    @Column(unique = true)
    private String ln;

    @Column
    private Integer age;

    public Person() {
    }

    public Person(String fn, String ln, Integer age) {
        this.fn = fn;
        this.ln = ln;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFn() {
        return fn;
    }

    public String getLn() {
        return ln;
    }

    public Integer getAge() {
        return age;
    }
}