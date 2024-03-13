package com.example.demo.domain.user.service;


import com.example.demo.domain.user.dto.UserRequestRecord;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.global.handler.exception.BusinessException;
import com.example.demo.global.handler.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signUp(UserRequestRecord requestDto) {
        if (userRepository.findByEmail(requestDto.email()).isPresent()) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_EMAIL);
        }
        if (userRepository.findByNickname(requestDto.nickname()).isPresent()) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_NICKNAME);
        }

        User user = User.builder()
                .email(requestDto.email())
                .password(requestDto.password())
                .nickname(requestDto.nickname())
                .build();
        userRepository.save(user);
    }
}
