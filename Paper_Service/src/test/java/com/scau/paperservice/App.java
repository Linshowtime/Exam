package com.scau.paperservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-07 12:43
 */
@SpringBootApplication
@MapperScan(basePackages ="com.scau.paperservice.mapper")
public class App {
    public static void main(String[] args) {

    }
}
