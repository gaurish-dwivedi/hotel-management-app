//package com.hotel.management.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.hotel.management.entity.User;
//import com.hotel.management.repository.UserRepository;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		User user = userRepository.findUserByEmail(username);
//		
//
//		if (user == null) {
//			throw new UsernameNotFoundException("User name not found !!");
//		}
//
//		return new CustomUserDetail(user);
//	}
//
//}
