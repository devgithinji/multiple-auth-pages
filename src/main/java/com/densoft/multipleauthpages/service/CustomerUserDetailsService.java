package com.densoft.multipleauthpages.service;

import com.densoft.multipleauthpages.Dao.CustomerRepository;
import com.densoft.multipleauthpages.auth.CustomerUserDetails;
import com.densoft.multipleauthpages.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No customer found with the given email"));
        return new CustomerUserDetails(customer);
    }
}
