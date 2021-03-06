package br.com.mesttra.secretariat.service;

import br.com.mesttra.secretariat.data.UserRepository;
import br.com.mesttra.secretariat.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = this.userRepository.findByUserName(username);
        return optionalUser.orElseThrow(() -> new UsernameNotFoundException("UserName not found"));
    }
}
