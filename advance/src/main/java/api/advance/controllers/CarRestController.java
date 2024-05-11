package api.advance.controllers;

import api.advance.models.CarModel;
import api.advance.service.CarService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {
    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarModel> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public ResponseEntity<CarModel> createCar(@RequestBody CarModel carModel) {
        try {
            CarModel savedCar = carService.saveCar(carModel);
            return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCarById(@PathVariable("id") String id) {
        try {
            carService.deleteCarById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarModel> updateCarById(@PathVariable("id") String id, @RequestBody CarModel carModel) {
        try {
            CarModel updatedCar = carService.updateCarById(id, carModel);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/isValidToDrive")
    public Boolean isValidToDrive(@RequestParam("licensePlate") String licensePlate,
                                  @RequestParam("currentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime currentDate) {
        return carService.isValidToDrive(licensePlate,currentDate);
    }
}

