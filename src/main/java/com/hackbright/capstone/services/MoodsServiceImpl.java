package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.MoodDto;
import com.hackbright.capstone.entities.Moods;
import com.hackbright.capstone.entities.User;
import com.hackbright.capstone.repositories.MoodsRepository;
import com.hackbright.capstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoodsServiceImpl implements MoodsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MoodsRepository moodsRepository;


    @Override
    @Transactional
    public void addMoods(MoodDto moodDto, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Moods moods = new Moods(moodDto);
        userOptional.ifPresent(user -> {
            //Moods moods = new Moods(moodDto);
            moods.setUser(userOptional.get());
            moods.setCategory(moodDto.getCategory());
            moods.setMoodJournal(moodDto.getText());

            moodsRepository.saveAndFlush(moods);
        });
//        Moods moods = new Moods(moodDto);
//        moods.setUser(userOptional.get());
//        moods.setCategory(moodDto.getCategory());
//        moods.setMoodJournal(moodDto.getText());
//
//        moodsRepository.saveAndFlush(moods);

        //return response;


    }

    @Override
    @Transactional
    public void deleteMoodsById(Long moodsId){
        Optional<Moods> moodsOptional = moodsRepository.findById(moodsId);
        moodsOptional.ifPresent(moods -> moodsRepository.delete(moods));






}
    @Override
    @Transactional
    public void updateMoodsById(MoodDto moodDto){
        Optional<Moods> moodsOptional = moodsRepository.findById(moodDto.getId());
        moodsOptional.ifPresent(moods -> {
            moods.setMoodJournal(moodDto.getText());
            moodsRepository.saveAndFlush(moods);
        });
    }



    @Override
    public List<MoodDto> getAllMoodsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Moods> moodsList = moodsRepository.findAllByUserEquals(userOptional.get());
            return moodsList.stream().map(moods -> new MoodDto(moods)).collect(Collectors.toList());

        }
        return Collections.emptyList();
    }

    @Override
    public Optional<MoodDto> getMoodId(Long moodId){
        Optional<Moods> moodsOptional = moodsRepository.findById(moodId);
            if (moodsOptional.isPresent()){
                return Optional.of(new MoodDto(moodsOptional.get()));

        }
            return Optional.empty();
    }

    }

