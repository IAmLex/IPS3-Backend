package com.lex.ips3backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    @Getter
    private Integer id;

//    @ManyToOne(fetch=FetchType.EAGER)
//    @Getter
//    private Post post;

    @ManyToOne(fetch=FetchType.EAGER)
    @Getter
    private User user;

    @Getter
    private String text;

    @Column(name="created_at",
            columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP",
            nullable = false,
            insertable = false)
    @Getter
    private LocalDateTime createdAt;

    @Column(name="deleted_at")
    @Getter
    private LocalDateTime deletedAt;
}
