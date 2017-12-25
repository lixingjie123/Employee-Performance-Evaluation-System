package com.epes.demo.repository;

import com.epes.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lixingjie
 * Date: 2017-12-25
 * Time: 15:12
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
