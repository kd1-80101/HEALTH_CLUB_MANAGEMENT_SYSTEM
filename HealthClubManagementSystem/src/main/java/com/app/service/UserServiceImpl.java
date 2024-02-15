package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dto.ApprovedDTO;
import com.app.dto.RegisterUserDTO;
import com.app.entities.User;
import com.app.enums.Role;
import com.app.enums.Status;
import com.app.exception.UserNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private MyLogger logger = MyLogger.getInstance();

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OtpService otpService;

    @Override
    public RegisterUserDTO registerUser(RegisterUserDTO reqDTO) {
        User user = mapper.map(reqDTO, User.class);
        user.setStatus(Status.PENDING);
        user.setRole(Role.PENDING);
        user.setPassword(encoder.encode(user.getPassword()));
        return mapper.map(userDao.save(user), RegisterUserDTO.class);
    }

    @Override
    public List<User> getPendingUsersList() {
        return userDao.findAllByStatus(Status.PENDING);
    }

    @Override
    public Status getUserStatus(String email) {
        User temp = userDao.findByEmail(email);
        if (temp == null) {
            throw new RuntimeException("User not found");
        }
        return temp.getStatus();
    }

    @Override
    public Role getUserRole(String email) {
        User temp = userDao.findByEmail(email);
        if (temp == null) {
            throw new RuntimeException("User not found");
        }
        return temp.getRole();
    }

    @Override
    public ApprovedDTO approveUsers(ApprovedDTO approved) {
        User user = userDao.findById(approved.getId()).orElseThrow();
        user.setRole(approved.getRole());
        user.setStatus(approved.getStatus());
        return new ApprovedDTO(user.getId(), user.getStatus(), user.getRole());
    }

    @Override
    public List<User> getCustomerList() {
        return userDao.findAllByStatusAndRole(Status.APPROVED, Role.CUSTOMER);
    }

    @Override
    public List<User> getTrainerList() {
        return userDao.findAllByStatusAndRole(Status.APPROVED, Role.TRAINER);
    }
    @Override
    public void resetPassword(String email, String newPassword) {
        logger.info("Resetting password for user with email: {}",email);
        User user = userDao.findByEmail(email);
        
        try {
        if (user == null) {
            logger.error("User not found for email: {}", email);
            throw new UserNotFoundException("User not found for email: " + email);
        }
        }catch(UserNotFoundException e){
        	e.printStackTrace();
        }
        String encodedPassword = encoder.encode(newPassword);
        user.setPassword(encodedPassword);
        userDao.save(user);
        logger.info("Password reset successfully for user with email: {}");
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public String generateAndSendOTP(String email) {
        User user = userDao.findByEmail(email);
        if (user != null) {
            String otp = otpService.generateAndSendOTP(email);
            return otp;
        } else {
            throw new RuntimeException("User not found");
        }
    }

}
