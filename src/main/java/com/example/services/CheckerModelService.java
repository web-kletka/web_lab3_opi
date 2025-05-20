package com.example.services;

import jakarta.annotation.ManagedBean;

public class CheckerModelService {
    public boolean calculate(Float x, Float y, Float z, Float r){
        return !(x * x + y * y + z * z + Math.sin(4 * x) + Math.sin(4 * y) + Math.sin(4 * z) > r);
    }
}
