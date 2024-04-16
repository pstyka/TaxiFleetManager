package com.example.pawel.bootstrap;

import com.example.pawel.entities.Car;
import com.example.pawel.entities.WheelState;
import com.example.pawel.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final CarRepository carRepository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
       loadCars();
    }

    private void loadCars() throws IOException {
        File imageFile = ResourceUtils.getFile("classpath:static/images/toyota_black.png");
        byte[] imageByte = Files.readAllBytes(imageFile.toPath());
        File imageFile2 = ResourceUtils.getFile("classpath:static/images/toyota_white.png");
        byte[] imageByte2 = Files.readAllBytes(imageFile.toPath());
        if(carRepository.count()==0){
            Car c1 = Car.builder()
                    .brand("Toyota")
                    .model("Corolla")
                    .color("Black")
                    .registrationNumber("KK56765")
                    .productionYear("2023")
                    .mileage(55654)
                    .wheelState(WheelState.GOOD)
                    .image(imageByte)
                    .build();
            Car c2 = Car.builder()
                    .brand("Toyota")
                    .model("Corolla")
                    .color("White")
                    .registrationNumber("KK61765")
                    .productionYear("2022")
                    .mileage(76543)
                    .wheelState(WheelState.MEDIUM)
                    .image(imageByte2)
                    .build();
            Car c3 = Car.builder()
                    .brand("Toyota")
                    .model("Corolla")
                    .color("White")
                    .registrationNumber("KK99876")
                    .productionYear("2022")
                    .mileage(5433)
                    .wheelState(WheelState.GOOD)
                    .image(imageByte2)
                    .build();
            carRepository.save(c1);
            carRepository.save(c2);
            carRepository.save(c3);
        }

    }

}
