package com.example.membership.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor // JPA에서 관리되는 엔티티를 위해서는 기본 생성자가 필요
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}