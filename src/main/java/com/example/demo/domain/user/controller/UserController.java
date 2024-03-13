package com.example.demo.domain.user.controller;


import com.example.demo.domain.user.dto.UserRequestRecord;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.global.handler.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("ErrorCode", null);
        return "signup";
    }


    @PostMapping("/signup")
    public String signup(UserRequestRecord requestDto, Model model) {
        try {
            userService.signUp(requestDto);
        } catch (BusinessException ex) {
            model.addAttribute("ErrorCode", ex.getErrorCode().getMessage());
            return "signup";
        }
        return "redirect:/users/signup";
    }
}