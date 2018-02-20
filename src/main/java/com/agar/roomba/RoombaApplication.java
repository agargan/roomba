package com.agar.roomba;

import com.agar.roomba.service.HooverRoomService;
import com.agar.roomba.service.HooverRoomServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author agar
 *
 */
@SpringBootApplication
public class RoombaApplication {

    @Bean
    public HooverRoomService hooverRoomService() {
        return new HooverRoomServiceImpl();
    }

    public static void main( String[] args ) {
        SpringApplication.run(RoombaApplication.class, args);
    }
}
