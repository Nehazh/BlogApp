package com.blog.app.repository;

import com.blog.app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//Since JPA is generics we need to pass the Entiy name and type of the primary key
//we need to create seperate entity for each Jpa entity
//JPA REPO Prvides all the crud methods
//we don't need @Repository annotation because it already contains the simplerepo class which has the repo and
//transaction methods
public interface PostRepository extends JpaRepository<Post,Long> {
}
