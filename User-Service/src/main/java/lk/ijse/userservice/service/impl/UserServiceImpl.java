package lk.ijse.userservice.service.impl;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.Role;
import lk.ijse.userservice.entity.User;
import lk.ijse.userservice.repo.UserRepo;
import lk.ijse.userservice.service.UserService;
import lk.ijse.userservice.util.JwtUtil;
import lk.ijse.userservice.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtTokenUtil;

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return authorities;
    }

    @Override
    public int registerUser(UserDTO dto) {
        if (userRepo.existsByEmail(dto.getEmail())) {
            return VarList.Not_Acceptable;
        }else {
            User user = modelMapper.map(dto, User.class);

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            if (user.getRole() == null) {
                user.setRole(Role.USER);
            }
            userRepo.save(user);
            return VarList.Created;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User updateUser(Integer id, UserDTO dto) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(dto, user);
        return userRepo.save(user);
    }

    public UserDTO loadUserDetailsByUsername(String username)throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return modelMapper.map(user, UserDTO.class);

    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }
}
