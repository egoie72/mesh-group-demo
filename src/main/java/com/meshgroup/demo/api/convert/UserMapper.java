package com.meshgroup.demo.api.convert;

import com.meshgroup.demo.api.dto.UserDto;
import com.meshgroup.demo.api.dto.UserFilterDto;
import com.meshgroup.demo.dao.UserSearchCriteria;
import com.meshgroup.demo.dao.entity.Account;
import com.meshgroup.demo.dao.entity.EmailData;
import com.meshgroup.demo.dao.entity.PhoneData;
import com.meshgroup.demo.dao.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Mapping(target = "ballance", source = "account")
    UserDto mapUser(User user);

    static String mapEmail(EmailData data) {
        return Optional.ofNullable(data)
                       .map(EmailData::getEmail)
                       .orElse(null);
    }

    static String mapPhone(PhoneData data) {
        return Optional.ofNullable(data)
                       .map(PhoneData::getPhone)
                       .orElse(null);
    }

    static BigDecimal mapAccount(Account account) {
        return Optional.ofNullable(account)
                       .map(Account::getBalance)
                       .orElse(null);
    }

    UserSearchCriteria mapFilter(UserFilterDto filter);

}
