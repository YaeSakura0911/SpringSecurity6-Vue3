package org.eu.yaesakura.springsecurity6vue3.repository;

import org.apache.ibatis.annotations.Select;
import org.eu.yaesakura.springsecurity6vue3.domain.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层
 *
 * @author YaeSakura
 */

@Repository
public interface UserRepository {

    @Select("SELECT * FROM t_user WHERE username = #{username}")
    User queryUserByUsername(String username);
}
