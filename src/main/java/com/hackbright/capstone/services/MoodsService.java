package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.MoodDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MoodsService {
    // add a mood description
    @Transactional
    void addMoods(MoodDto moodDto, Long userId);

    // delete an
    @Transactional
    void deleteMoodsById(Long moodsId);

    @Transactional
    void updateMoodsById(MoodDto moodDto);

    @Transactional
    List<MoodDto> getAllMoodsByUserId(Long userId);
    @Transactional
    Optional<MoodDto> getMoodId(Long moodId);
}
