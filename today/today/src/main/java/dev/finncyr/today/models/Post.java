package dev.finncyr.today.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String datum;
    private String title;
    private String text;
    private int steps;
    private String filename;


    public Post(String datum, String title, String text, int steps, String filename) {
        super();
        this.datum = datum;
        this.title = title;
        this.text = text;
        this.steps = steps;
        this.filename = filename;
    }

    public Post(){

    }

    public String getTitle() {return this.title;}
    public String getDatum() {return this.datum;}
    public String getText() {return this.text;}
    public int getSteps() {return this.steps;}
    public String getFilename() {return this.filename;}
    public Long getId() {return this.id;}
}
