package api.advance.service;

import api.advance.util.Helper;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class CarService {
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
