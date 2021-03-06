package com.zhoupiyao.dao;

import com.zhoupiyao.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query(value = "select * from t_tags  where binary name=?1 ", nativeQuery = true)
    Tag findByName(String name);

    @Query("select tag from t_tags tag")
    List<Tag> findtagTop(Pageable pageable);
}
