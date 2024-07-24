package com.codegym.book_store.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

@Component
@Aspect
public class BookAspect {
    private static final String URL_BOOK = "/Users/tonthathoangphong/module4/ss9/book_store/src/main/java/com/codegym/book_store/file/book.csv";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* com.codegym.book_store.controller.BookStoreController.*(..))")
    public void logAfterVisitStudentController(JoinPoint joinPoint) {
        File file = new File(URL_BOOK);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String log = "Người dùng đã vào chức năng " + joinPoint.getSignature().getName()
                    + " vào lúc " + LocalDateTime.now() + "\n";
            bufferedWriter.write(log);
            bufferedWriter.flush();

        } catch (Exception e) {
            logger.error("Lỗi ghi file");
        }
        logger.info("Người dùng đã vào chức năng " + joinPoint.getSignature().getName()
                + " vào lúc " + LocalDateTime.now());
    }
}
