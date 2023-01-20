package com.meshgroup.demo.service;

import com.meshgroup.demo.dao.EmailDataRepository;
import com.meshgroup.demo.dao.PhoneDataRepository;
import com.meshgroup.demo.dao.UserRepository;
import com.meshgroup.demo.dao.UserSearchCriteria;
import com.meshgroup.demo.dao.entity.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDataService {
    private final UserRepository userRepository;
    private final EmailDataRepository emailDataRepository;
    private final PhoneDataRepository phoneDataRepository;

    public Optional<User> getUser(final @NonNull Long id) {
        return userRepository.findById(id);
    }

    public List<User> findUser(final @NonNull UserSearchCriteria criteria) {
        return userRepository.findAll(UserRepository.searchSpec(criteria));
    }
}
