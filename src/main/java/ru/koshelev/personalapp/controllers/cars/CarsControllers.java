package ru.koshelev.personalapp.controllers.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.koshelev.personalapp.dao.CarDao;
import ru.koshelev.personalapp.models.Car;

@Controller
@RequestMapping("/cars")
public class CarsControllers {
    private final CarDao carDao;

    @Autowired
    public CarsControllers(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("cars", carDao.carList());
        return "cars/cars";
    }

    @GetMapping("/{id}")
    public String showCar(@PathVariable("id") int id, Model model){
        model.addAttribute("car", carDao.showCar(id));
        return "cars/show";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car")Car car){
        return "cars/new";
    }

    @PostMapping()
    public String createCar(@ModelAttribute("car")Car car){
        carDao.createCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")int id, Model model){
        model.addAttribute("car", carDao.showCar(id));
        return "cars/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id")int id, Car car){
        carDao.update(id,car);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        carDao.delete(id);
        return "redirect:/cars";
    }
}
