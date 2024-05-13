package com.example.pawel.controller;

import com.example.pawel.entities.Car;
import com.example.pawel.model.CarDTO;
import com.example.pawel.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name="Car")
public class CarController {
    private static final String CAR_PATH = "/api/v1/car";
    private static final String CAR_PATH_ID = CAR_PATH + "/{carId}";
    private final CarService carService;

    @Operation(
            summary = "Get all cars",
            description = "Get all cars from the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of cars"),
                    @ApiResponse(responseCode = "403", description = "Unauthorized")

            }

    )
    @GetMapping(value = CAR_PATH)
    public List<CarDTO> getCars(){
        return carService.getCars();
    }

    @GetMapping(value = CAR_PATH_ID)
    public CarDTO getCarById(@PathVariable("carId") UUID carId){
        return carService.getCarById(carId).orElseThrow(NotFoundException::new);
    }
    @PostMapping(value = CAR_PATH)
    public ResponseEntity  addCar(@Validated @RequestBody CarDTO carDTO){
        CarDTO savedCar = carService.saveNewCar(carDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",
                CAR_PATH + "/" + savedCar.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PutMapping(value = CAR_PATH_ID)
    public ResponseEntity updateCarById(@PathVariable("carId") UUID carId,
                                        @Validated @RequestBody CarDTO carDTO){
        if(carService.updateCarById(carId, carDTO).isEmpty()){
            throw new NotFoundException();
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(value = CAR_PATH_ID)
    public ResponseEntity deleteCar(@PathVariable("carId")UUID carId){
        if(!carService.deleteById(carId)){
            throw new NotFoundException();
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = CAR_PATH_ID)
    public ResponseEntity updateCarPatchById(@PathVariable("carId") UUID carId,
                                            @RequestBody CarDTO carDTO){
        carService.patchCarById(carId, carDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
