package com.blogging.bloging.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String postTitle;
    private String postContent;
    private String postImageName;
    private Date currentDate;
    private boolean deletePostId ;
    @ManyToOne
    private Category category;
    @ManyToOne
    private UserData userData;

   /* @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Collection<Comment> comment = new LinkedHashSet<>();*/

}
