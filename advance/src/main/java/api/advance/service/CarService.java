package api.advance.service;

import api.advance.data.CarRepository;
import api.advance.models.CarModel;
import api.advance.util.Helper;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public Boolean isValidToDrive(String licensePlate, LocalDateTime currentDate) {
        char lastDigit = licensePlate.charAt(licensePlate.length() - 1);
        int lastDigitInt = Character.getNumericValue(lastDigit);
        String restrictedDay = Helper.findKeyByValue(lastDigitInt);
        DayOfWeek currentDay = currentDate.getDayOfWeek();
        String nameOfDay = currentDay.toString();
        LocalTime currentHour = currentDate.toLocalTime();
        if(!restrictedDay.equalsIgnoreCase(nameOfDay)){
            return true;
        }else{
            boolean dentroDelRango = (currentHour.isAfter(LocalTime.of(5, 0)) && currentHour.isBefore(LocalTime.of(9, 30))) ||
                    (currentHour.isAfter(LocalTime.of(16, 0)) && currentHour.isBefore(LocalTime.of(21, 0)));
            return !dentroDelRango;
        }
    }
}
