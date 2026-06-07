package com.example.demo.repository;

import com.example.demo.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    
    // THÊM DÒNG NÀY ĐỂ GIẢI QUYẾT LỖI "CANNOT FIND SYMBOL"
    List<History> findByUsername(String username);
    
    List<History> findByUsernameOrderByViewedAtDesc(String username);

    @Transactional
    @Modifying
    @Query("DELETE FROM History h WHERE h.post.id = :postId")
    void deleteByPostId(@Param("postId") Long postId);
}