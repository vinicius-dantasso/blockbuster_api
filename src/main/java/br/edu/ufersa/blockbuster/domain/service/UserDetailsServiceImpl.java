package br.edu.ufersa.blockbuster.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.User;
import br.edu.ufersa.blockbuster.domain.repoitory.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
  {
    User currentUser = userRepository.findByEmail(email);
    UserDetails user = new org.springframework.security.core.userdetails
      .User(
        email, 
        currentUser.getSenha(),
        true, 
        true,
        true,
        true, 
        AuthorityUtils.createAuthorityList("USER")
      );

    return user;
  }
}
