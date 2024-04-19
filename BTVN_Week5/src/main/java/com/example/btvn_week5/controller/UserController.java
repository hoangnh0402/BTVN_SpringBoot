package com.example.btvn_week5.controller;

import javax.annotation.PostConstruct;

import com.example.btvn_week5.User;
import com.example.btvn_week5.dto.CreateUserRequest;
import com.example.btvn_week5.exception.CustomExceptionHandler;
import com.example.btvn_week5.exception.PasswordNotMatchException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class UserController {
    private List<User> users;

    @PostConstruct
    public void init() {
        users = IntStream.range(0,10)
                .mapToObj(i -> new User(i, "username" + i, "pass" + i))
                .collect(Collectors.toList());
    }
    // Lấy ra danh sách account
    @GetMapping("/users/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(users);
    }

    // Xem thông tin account
    @GetMapping("/users/getUser/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();

        if (userOptional.isPresent()) {
            return ResponseEntity.ok().body(userOptional.get());
        } else {
            throw new CustomExceptionHandler.AccountNotFoundException("Không tìm thấy user có id: " + id);
        }
    }


    @PostMapping("/users/createUser")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        String confirmPassword = request.getConfirmPassword();

        // Kiểm tra xác nhận mật khẩu
        if (!password.equals(confirmPassword)) {
            throw new CustomExceptionHandler.PasswordNotMatchException("Mật khẩu xác nhận không khớp");
        }

        // Kiểm tra xem account đã tồn tại chưa
        if (users.stream().anyMatch(acc -> acc.getUsername().equals(username))) {
            throw new CustomExceptionHandler.AlreadyExistsException("Account đã tồn tại");
        }

        // Tạo user mới và thêm vào danh sách
        User user = new User(username, password); // Giả sử có constructor Account(username, password)
        users.add(user);
        return ResponseEntity.ok().body(user);
    }



    // API xóa account
    @DeleteMapping("/users/deleteUser/{username}")
    public String deleteAccount(@PathVariable String username) {
        User accountToDelete = users.stream()
                .filter(account -> account.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new CustomExceptionHandler.AccountNotFoundException("Không tìm thấy account"));
        users.remove(accountToDelete);
        return "Account đã bị xóa";
    }



}
