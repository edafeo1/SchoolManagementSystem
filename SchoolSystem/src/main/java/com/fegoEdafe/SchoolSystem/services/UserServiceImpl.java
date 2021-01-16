package com.fegoEdafe.SchoolSystem.services;



import com.fegoEdafe.SchoolSystem.Dto.UserRegisterationDTO;
import com.fegoEdafe.SchoolSystem.model.Roles;
import com.fegoEdafe.SchoolSystem.model.User;
import com.fegoEdafe.SchoolSystem.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements ImplementationService<User>{


    @Autowired
    private final UseRepository useRepository;

    public UserServiceImpl(UseRepository useRepository) {
        this.useRepository = useRepository;
    }


    @Override
    public void Save(User user) {
        useRepository.save(user);
    }

    @Override
    public void update(Long id, User user) {
       User updateUser = useRepository.findById(id).orElse(null);
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());
        updateUser.setRoles(user.getRoles());

        useRepository.save(updateUser);
    }

    @Override
    public void deleteById(long id) {
        useRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.ofNullable(useRepository.findById(id).orElse(null));
    }

    @Override
    public List<User> getAll() {
        return (List<User>) useRepository.findAll();
    }

    @Override
    public Page<User> SelectPage(int pageNo) {
        int size = 5;
        Pageable page = PageRequest.of(pageNo, size, Sort.by("name"));
        return useRepository.findAll(page);
    }

    @Override
    public Page<User> findAllByText(Pageable pageable, String text) {
        return useRepository.findAllUsers(pageable, text);
    }
}
