package com.kaplan.regimen.services;
import com.kaplan.regimen.entities.User;
import com.kaplan.regimen.exceptions.InvalidUserPassword;
import com.kaplan.regimen.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.setPassword(this.passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Boolean checkUserPassword(UserDetails user, String password) {
        if (!this.passwordEncoder().matches(password,
                user.getPassword())) {
            throw new InvalidUserPassword();

        }
        return true;
    }
}