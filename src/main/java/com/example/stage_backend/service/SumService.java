package com.example.stage_backend.service;

import org.springframework.stereotype.Service;
@Service
public class SumService {
    public int calculateSum(int a, int b) {
        return a + b;
    }
}
