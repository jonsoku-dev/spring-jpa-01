package com.example.demo.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"}) // 연관관계 필드는 ToString 하지 않는 것이 좋다.
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;


    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    public Member(String username) {  this.username = username; }

    // 자신만 바꾸지않고, 반대쪽도 바꿔야하니 아래의 로직을 넣는다.
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
