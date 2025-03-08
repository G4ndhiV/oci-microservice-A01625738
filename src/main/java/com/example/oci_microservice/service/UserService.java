package com.example.oci_microservice.service;
import com.example.oci_microservice.model.User;
import com.example.oci_microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
@Autowired
private UserRepository userRepository;
public User createUser(User user) {
return userRepository.save(user);
}
public List<User> getAllUsers() {
return userRepository.findAll();
}
public Optional<User> getUserById(Long id) {
return userRepository.findById(id);
}
public User updateUser(Long id, User userDetails) {
return userRepository.findById(id).map(user -> {
user.setName(userDetails.getName());
user.setEmail(userDetails.getEmail());
return userRepository.save(user);
}).orElse(null);
}
public boolean deleteUser(Long id) {
if (userRepository.existsById(id)) {
userRepository.deleteById(id);
return true;
}
return false;
}
}