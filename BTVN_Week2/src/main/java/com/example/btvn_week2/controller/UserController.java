package com.example.btvn_week2.controller;
import com.example.btvn_week2.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password) {
        if (account.equals("admin") && password.equals("admin"))
            return "redirect:about";
        else return "alert";
    }

    @GetMapping("/about")
    public String about(Model model) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("1", "Nguyễn Văn A", "KTPM", 20);
        Student student2 = new Student("2", "Nguyễn Văn B", "KTPM", 20);
        Student student3 = new Student("3", "Nguyễn Văn C", "KTPM", 20);
        Student student4 = new Student("4", "Nguyễn Văn ", "KTPM", 20);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        model.addAttribute("list", students);
        return "about";
    }
}
