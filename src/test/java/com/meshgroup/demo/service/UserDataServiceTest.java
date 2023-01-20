package com.meshgroup.demo.service;

import com.meshgroup.demo.MeshGroupDemoApplication;
import com.meshgroup.demo.dao.AccountRepository;
import com.meshgroup.demo.dao.EmailDataRepository;
import com.meshgroup.demo.dao.PhoneDataRepository;
import com.meshgroup.demo.dao.UserRepository;
import com.meshgroup.demo.dao.entity.Account;
import com.meshgroup.demo.dao.entity.EmailData;
import com.meshgroup.demo.dao.entity.User;
import com.meshgroup.demo.util.MeshGroupDemoSqlContainer;
import lombok.extern.slf4j.Slf4j;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MeshGroupDemoApplication.class)
@ActiveProfiles({"test"})
@Slf4j
class UserDataServiceTest {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected AccountRepository accountRepository;

    @Autowired
    protected EmailDataRepository emailDataRepository;

    @Autowired
    protected PhoneDataRepository phoneDataRepository;

    @Autowired
    private EntityManager entityManager;

    @ClassRule
    public static MeshGroupDemoSqlContainer container = MeshGroupDemoSqlContainer.getInstance();

    @Transactional
    @Test
    void getUser() {
/*
        final User user = userRepository.save(new User("TEST", LocalDate.of(1972, 3, 19)));

        accountRepository.save(new Account(null, user, new BigDecimal(100)));

        emailDataRepository.save(EmailData.builder()
                                          .user(user)
                                          .email("ego@ngs.ru")
                                          .build());

        emailDataRepository.save(EmailData.builder()
                                          .user(user)
                                          .email("egoie@mail.ru")
                                          .build());

*/

        final var created = userRepository.findAll();
        log.info("Created users {}", created);
//        assertNotNull(created);
//        log.info("Has emails {}", created.getEmails());
    }

    @Test
    void findUser() {
    }
}