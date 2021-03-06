package com.lex.ips3backend.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    @Getter
    private Integer id;

    @ManyToOne(fetch=FetchType.EAGER)
    @Getter
    private User user;

    @OneToMany(
            mappedBy="post",
            cascade=CascadeType.ALL,
            orphanRemoval=true
    )
    @JsonIgnore
    @Getter
    private List<Comment> comments;

    @Getter
    private String content;

    @Getter
    private String caption;
    @Column(
            name="created_at",
            columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP",
            nullable = false,
            insertable = false
    )
    @Getter
    private LocalDateTime createdAt;

    @Column(name="deleted_at")
    @Getter
    private LocalDateTime deletedAt;

    public Post() {}

    public Post(String content, String caption, User user) {
        this.content = content;
        this.caption = caption;
        this.user = user;
    }
}
