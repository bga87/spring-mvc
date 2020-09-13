package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.ItemsSupplyService;

import java.util.Optional;

@Controller
public class CarController {

    private ItemsSupplyService supplyService;

    @Autowired
    public CarController(ItemsSupplyService carSupplyService) {
        supplyService = carSupplyService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "locale", required = false) String locale,
                            ModelMap model) {
        String requestLocale = Optional.ofNullable(locale).orElse("en");
        model.addAttribute("localized", requestLocale.equals("ru") ? "МАШИНА" : "CARS");
        model.addAttribute("cars", supplyService.getItems());
        return "cars";
    }
}
