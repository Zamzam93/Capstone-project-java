package com.hackbright.capstone.repositories;

import com.hackbright.capstone.entities.Moods;
import com.hackbright.capstone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // to access data
public interface MoodsRepository extends JpaRepository<Moods, Long> {
    List<Moods> findAllByUserEquals(User user);

}
