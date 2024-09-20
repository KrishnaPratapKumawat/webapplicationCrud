package com.blogging.bloging.repo;

import com.blogging.bloging.model.Post;
import com.blogging.bloging.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    //List<Post> findByUser(UserData userData);
}
