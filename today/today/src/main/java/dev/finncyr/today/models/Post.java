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


    public Post(String datum, String title, String text, int steps) {
        super();
        this.datum = datum;
        this.title = title;
        this.text = text;
        this.steps = steps;
    }

    public Post(){

    }

    public String getTitle() {return this.title;}
}
