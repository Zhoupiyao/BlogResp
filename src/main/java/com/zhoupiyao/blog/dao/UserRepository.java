package com.zhoupiyao.blog.dao;

import com.zhoupiyao.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsernameAndPassword(String username,String password);
}
