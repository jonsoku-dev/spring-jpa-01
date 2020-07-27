package com.example.demo.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;


    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    public Member() {
    }

    public Member(String username){
        this.username = username;
    }
}
