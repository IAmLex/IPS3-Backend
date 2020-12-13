package com.lex.ips3backend.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    @Getter
    private Integer id;

    @OneToMany(
            mappedBy="user",
            cascade=CascadeType.ALL,
            orphanRemoval=true
    )
    @JsonIgnore
    @Getter
    private List<Post> posts;

    @OneToMany(
            mappedBy="user",
            cascade=CascadeType.ALL,
            orphanRemoval=true
    )
    @JsonIgnore
    @Getter
    private List<Comment> comments;

    @Getter
    private String username;

    private String password;

    @Getter
    private String email;

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

    public User() {}

    public User(Integer id) {
        this.id = id;
    }

    @JsonGetter("password")
    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @JsonSetter("password")
    public void setPassword(String password) {
        this.password = password;
    }
}
