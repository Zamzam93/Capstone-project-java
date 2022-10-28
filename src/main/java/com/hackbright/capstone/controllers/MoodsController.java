package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.MoodDto;
import com.hackbright.capstone.services.MoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/notes")
public class MoodsController {

    @Autowired
    private MoodsService moodsService;

    // get all moods by user

    @GetMapping("/user/{userId}")
    public List<MoodDto> getMoodsByUser(@PathVariable Long userId){
        return moodsService.getAllMoodsByUserId(userId);

    }


    // get a new mood

    @PostMapping("/user/{userId}")
    public void addNote (@RequestBody MoodDto moodDto, @PathVariable Long userId){
        moodsService.addMoods(moodDto, userId);
    }

    // delete mood

    @DeleteMapping("/{moodId}")
    public void deleteMoodsById(@PathVariable Long moodId){
        moodsService.deleteMoodsById(moodId);
    }

    @PutMapping
    public void updateMood(@RequestBody MoodDto moodDto) {
        moodsService.updateMoodsById(moodDto);
    }

    @GetMapping("/{moodId}")
    public Optional<MoodDto> getMoodDto(@PathVariable Long mooId){
        return moodsService.getMoodId(mooId);
    }




}
