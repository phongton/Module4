package com.codegym.bt2ss1.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class Repo {

    private static Map<String,String> word = new HashMap<>();
    static {
        word.put("hello", "xin chào");
        word.put("book", "quyển sách");
        word.put("computer", "máy tính");
    }

    public String findMeaning(String words) {
        if (word.containsKey(words)) {
            String value = word.get(words);
            return value;
        }
        return null;
    }
}
