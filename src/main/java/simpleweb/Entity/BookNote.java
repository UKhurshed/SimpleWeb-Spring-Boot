package simpleweb.Entity;

import com.google.common.base.Objects;


import javax.persistence.*;

@Entity
@Table(name = "store")
public class BookNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author;
    @Column(name = "done")
    private boolean done = false;

    public BookNote(){}

    public BookNote(String name, String description, String author){
        this.name = name;
        this.description = description;
        this.author = author;
        this.done = false;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
