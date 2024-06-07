package com.middleware2.middleware2.controllers;


import com.middleware2.middleware2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/months")
public class MonthController {
    @GetMapping
    public Month getMonth(HttpServletRequest request) {
        Month month = (Month) request.getAttribute("month");
        return month;
    }
}
