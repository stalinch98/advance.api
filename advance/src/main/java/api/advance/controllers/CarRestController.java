package api.advance.controllers;

import api.advance.service.CarService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {
    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/isValidToDrive")
    public Boolean isValidToDrive(@RequestParam("licensePlate") String licensePlate,
                                  @RequestParam("currentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime currentDate) {
        return carService.isValidToDrive(licensePlate,currentDate);
    }
}

