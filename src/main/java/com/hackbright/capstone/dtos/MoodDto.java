package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Moods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoodDto implements Serializable {
    private Long id;
    private String text;
    private String category;
    private UserDto userDto;

    public MoodDto(Moods moods) {
        if(moods.getId() != null){
            this.id = moods.getId();
        }
        if(moods.getMoodJournal()!= null){
            this.text= moods.getMoodJournal();
        }
        if (moods.getCategory() != null){
            this.category = moods.getCategory();
        }
    }

}
