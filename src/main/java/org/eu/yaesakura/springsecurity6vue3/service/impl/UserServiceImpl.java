package org.eu.yaesakura.springsecurity6vue3.service.impl;

import org.eu.yaesakura.springsecurity6vue3.domain.entity.User;
import org.eu.yaesakura.springsecurity6vue3.repository.UserRepository;
import org.eu.yaesakura.springsecurity6vue3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author YaeSakura
 */

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.queryUserByUsername(username);

        return null;
    }
}
