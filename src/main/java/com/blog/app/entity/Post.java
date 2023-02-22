package com.blog.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//  JPA Entity creation for post
@Data //for getter setter
@AllArgsConstructor
@NoArgsConstructor

@Entity //class as an entity
@Table //if we are  not providing name of table jpa will create with class name
        (name="posts",uniqueConstraints = {@UniqueConstraint(columnNames={"title"})})

public class Post {

    @Id //Primarykey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Identity does not create any additional sequence tables like GenerationType. AUTO /


    private  Long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "content",nullable = false)
    private String content;
}
