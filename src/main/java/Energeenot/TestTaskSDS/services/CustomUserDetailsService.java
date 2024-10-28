package Energeenot.TestTaskSDS.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!USERNAME.equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.withUsername(USERNAME)
                .password("{noop}" + PASSWORD)
                .build();
    }
}
