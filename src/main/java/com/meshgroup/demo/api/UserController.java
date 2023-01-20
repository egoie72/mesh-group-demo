package com.meshgroup.demo.api;

import com.meshgroup.demo.api.convert.UserMapper;
import com.meshgroup.demo.api.dto.UserDto;
import com.meshgroup.demo.api.dto.UserFilterDto;
import com.meshgroup.demo.service.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserDataService userDataService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id) {
        return ApiUtil.getResult(() -> userDataService.getUser(id).orElse(null), userMapper::mapUser);

    }

    @PostMapping("find")
    public ResponseEntity<List<UserDto>> find(@RequestBody UserFilterDto filter) {
        return ApiUtil.getResults(() -> userDataService.findUser(userMapper.mapFilter(filter)),
                                  userMapper::mapUser);

    }

    @PostMapping("{id}/email/{email}")
    public ResponseEntity addEmail(@PathVariable Long id, @PathVariable String email) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}/email/{email}/{newEmail}")
    public void updateEmail(@PathVariable Long id, @PathVariable String email, @PathVariable String newEmail) {

    }

    @DeleteMapping("{id}/email/{email}")
    public void deleteEmail(@PathVariable Long id, @PathVariable String email) {

    }

    @PostMapping("{id}/phone/{phone}")
    public void addPhone(@PathVariable Long id, @PathVariable String phone) {

    }

    @PutMapping("{id}/phone/{phone}/{newPhone}")
    public void updatePhone(@PathVariable Long id, @PathVariable String phone, @PathVariable String newPhone) {

    }

    @DeleteMapping("{id}/phone/{phone}")
    public void deletePhone(@PathVariable Long id, @PathVariable String phone) {

    }

}
