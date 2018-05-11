package com.eriegarbage.garbageapp;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountDao accountDao;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Account account = accountDao.findByUserName(username);
        if (account == null) {
            throw new UsernameNotFoundException(
                    "No user found with username: "+ username);
        }
        System.out.println(account.getUserName());
        System.out.println(account.getPickupTime());
        System.out.println(account.getPassword());
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return  new org.springframework.security.core.userdetails.User
                (account.getUserName(),
                        account.getPassword(), enabled, accountNonExpired,
                        credentialsNonExpired, accountNonLocked,
                        getAuthorities(account));
    }

    private static List<GrantedAuthority> getAuthorities (Account account) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(account.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("USER"));
        }
        return authorities;
    }
}
