package com.example.stage_backend.controller;

import com.example.stage_backend.service.SumService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SumController {
    private final SumService sumService;

    public SumController(SumService sumService) {
        this.sumService = sumService;
    }

    @GetMapping("/sum")
    public int getSum(@RequestParam int a, @RequestParam int b) {
        return sumService.calculateSum(a, b);
    }
}
