package com.example.authorization.service.impl;

import com.example.authorization.dto.UserDTO;
import com.example.authorization.exception.DataNotFoundException;
import com.example.authorization.exception.TechnicalException;
import com.example.authorization.exception.TransactionException;
import com.example.authorization.mappers.UserMapper;
import com.example.authorization.model.User;
import com.example.authorization.repository.IUserRepository;
import com.example.authorization.security.JwtTokenUtil;
import com.example.authorization.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @autor Juan David Morantes Vergara
 */
public class UserServiceImpl implements IUserService{
        private IUserRepository userRepository;

        private JwtTokenUtil jwtTokenUtil;



        @Override
        public UserDTO getUserDataByToken(String token) {
            String username = null;
            if (token != null && token.startsWith("Bearer ")) {
                String jwtToken = token.substring(7);
                try {
                    username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                } catch (Exception e) {
                    System.out.println("JwtRequestFilter: " + e.getMessage());
                }
            } else {
                throw new TechnicalException("Token not found");            }
            User user = this.userRepository.findTopByUsername(username)
                    .orElseThrow((() -> new DataNotFoundException("User not found")));
            return UserMapper.INSTANCE.toUserDTO(user);
        }

        @Override
        public Boolean createUser(UserDTO userDTO) {
            // check if user already exists
            if (this.userRepository.findTopByUsername(userDTO.getUsername()).isPresent()) {
                throw new TransactionException("User already exists");
            }
            User user = UserMapper.INSTANCE.toUser(userDTO);
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
            this.userRepository.save(user);
            return true;
        }

        @Autowired
        public void setUserRepository(IUserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Autowired
        public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
            this.jwtTokenUtil = jwtTokenUtil;
        }

}
