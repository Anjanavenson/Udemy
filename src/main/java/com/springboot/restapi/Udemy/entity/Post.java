package com.springboot.restapi.Udemy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "Posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"Title"})}
)

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "Title", nullable = false)
    private String Title;

    @Column(name = "Description", nullable = false)
    private String Description;

    @Column(name = "Content", nullable = false)
    private String Content;
}
