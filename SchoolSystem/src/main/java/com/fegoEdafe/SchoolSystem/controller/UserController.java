package com.fegoEdafe.SchoolSystem.controller;


import com.fegoEdafe.SchoolSystem.Dto.UserRegisterationDTO;
import com.fegoEdafe.SchoolSystem.model.Students;
import com.fegoEdafe.SchoolSystem.model.User;
import com.fegoEdafe.SchoolSystem.services.ImplementationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/users")
public abstract class UserController implements GenericController<User> {

    @Autowired
    private final ImplementationService<User> userService;

    public UserController(ImplementationService<User> userService) {
        this.userService = userService;
    }

    @Override
    public Page<User> findAllByText(Pageable pageable, String Text) {
        return userService.findAllByText(pageable, Text);
    }

    @Override
    public Page<User> findAll(int pageNo) {
        return userService.SelectPage(pageNo);
    }

    @Override
    public Optional<User> findById(long id) {
        return userService.findById(id);
    }

    @Override
    public void deleteById(long id) {
        userService.deleteById(id);
    }

    @Override
    public void updateById(long id, User user) {
        userService.Save(user);
    }


    public void SaveUser(User user) {
       userService.Save(user);
    }
}
