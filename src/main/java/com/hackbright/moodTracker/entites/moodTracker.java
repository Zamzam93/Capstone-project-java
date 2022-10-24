package com.hackbright.moodTracker.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Table(name = "Mood Tracker")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class moodTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    @ManyToOne // creates the association within hibernate
    @JsonBackReference // Annotation used to indicate that associated property is part of two-way linkage between fields;
    private User user;

}
