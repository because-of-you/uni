package cn.acitrus.uni.service.permissions.impl;

import cn.acitrus.uni.service.permissions.UserRepositoryService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/31
 **/
@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
