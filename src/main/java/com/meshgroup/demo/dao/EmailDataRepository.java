package com.meshgroup.demo.dao;

import com.meshgroup.demo.dao.entity.EmailData;
import org.springframework.data.repository.CrudRepository;

public interface EmailDataRepository extends CrudRepository<EmailData, Long> {
}
