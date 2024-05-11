package api.advance.data;

import api.advance.models.CarModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<CarModel, String> {
}
