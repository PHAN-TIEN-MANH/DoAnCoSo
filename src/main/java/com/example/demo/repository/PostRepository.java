package com.example.demo.repository;

import com.example.demo.model.Post;
import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    List<Post> findByCategory(Category category); 
    List<Post> findByCategoryId(Long categoryId); 
    List<Post> findByCategory_Name(String categoryName); 
    List<Post> findTop3ByOrderByCreatedDateDesc();
}