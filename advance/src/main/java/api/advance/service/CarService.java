package api.advance.service;

import api.advance.data.CarRepository;
import api.advance.models.CarModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarModel> getAllCars() {
        return carRepository.findAll();
    }

    public CarModel saveCar(CarModel carModel) {
        return carRepository.save(carModel);
    }

    public void deleteCarById(String id) {
        carRepository.deleteById(id);
    }

    public CarModel updateCarById(String id, CarModel carModel) {
        CarModel car = carRepository.findById(id).orElse(null);
        if (car == null) {
            return null;
        }
        car.setBrand(carModel.getBrand());
        car.setLicensePlate(carModel.getLicensePlate());
        car.setYear(carModel.getYear());
        return carRepository.save(car);
    }
}
