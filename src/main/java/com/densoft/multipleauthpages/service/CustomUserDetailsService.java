package com.densoft.multipleauthpages.service;

import com.densoft.multipleauthpages.Dao.UserRepository;
import com.densoft.multipleauthpages.auth.CustomUserDetails;
import com.densoft.multipleauthpages.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user found with the given email"));
        return new CustomUserDetails(user);
    }
}
