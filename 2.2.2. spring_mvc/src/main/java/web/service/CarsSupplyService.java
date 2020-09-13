package web.service;

import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CarsSupplyService implements ItemsSupplyService {

    private final static Random RANDOMIZER = new Random();

    private final static String[] COLORS = {
            "Black", "Grey", "White", "Green"
    };

    private final static String[] MANUFACTURERS = {
            "Toyota", "BMW", "Dodge"
    };

    private final static Map<String, String[]> MODELS_BY_MANUFACTURERS = new HashMap<>();

    static {
        MODELS_BY_MANUFACTURERS.put("Toyota", new String[] {"Land Cruiser", "Camry"});
        MODELS_BY_MANUFACTURERS.put("BMW", new String[] {"X5", "M5", "X6"});
        MODELS_BY_MANUFACTURERS.put("Dodge", new String[] {"RAM", "Viper", "Avenger"});
    }

    @Override
    public List<Car> getItems() {
        return Stream.generate(this::createCar)
                .limit(3 + RANDOMIZER.nextInt(5))
                .collect(Collectors.toList());
    }

    private Car createCar() {
        String manufacturer = MANUFACTURERS[RANDOMIZER.nextInt(MANUFACTURERS.length)];

        String[] availableModels = MODELS_BY_MANUFACTURERS.get(manufacturer);
        String model = availableModels[RANDOMIZER.nextInt(availableModels.length)];

        String color = COLORS[RANDOMIZER.nextInt(COLORS.length)];

        return new Car(manufacturer, model, color);
    }
}
