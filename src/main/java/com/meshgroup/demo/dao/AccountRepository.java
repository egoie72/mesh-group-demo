package com.meshgroup.demo.dao;

import com.meshgroup.demo.dao.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
