package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hackbright.capstone.dtos.MoodDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "mood")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Moods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column
    //private String name;

    @Column
    private int date;

    @Column(columnDefinition = "text")
    private String moodJournal;

    public Moods(MoodDto mood_Dto) {
        if(mood_Dto.getText()!= null){
            this.moodJournal= mood_Dto.getText();
        }

    }

    @ManyToOne // creates the association within hibernate
    @JsonBackReference // Annotation used to indicate that associated property is part of two-way linkage between fields;
    private User user;

}
