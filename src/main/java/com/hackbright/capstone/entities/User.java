package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackbright.capstone.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity // tells spring that this class is being mapped to a data source
@Table(name="Users") // this annotation sets what table you want objects to map to.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) // same as @Table. used to change fields in the data private username field.
    // uniqie = true is to specify this username is unique
    private String username;
    @Column
    private String password;

    public User(UserDto userDto) {
        if (userDto.getUsername()!= null){
            this.username= userDto.getUsername();
        }
        if(userDto.getPassword()!= null){
            this.password= userDto.getPassword();
        }
    }



// private member variables are only accessible withtin class they reside in
    // in order to get the vaules, getters and setters are needed.

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Moods> moodTrackers=new HashSet<>();



}
