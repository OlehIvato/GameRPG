package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.model.CalculatorModel;
import spring.service.CalculatorService;

@Controller
public class  CalculatorController {

    private CalculatorModel calculatorModel = new CalculatorModel();

    @Autowired
    private CalculatorService service;

    @GetMapping("/calculator")
    public String getCalculatorPage(Model model) {
        model.addAttribute("calculator", calculatorModel);
        return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "add", method = RequestMethod.POST)
    public String add(CalculatorModel calculatorModel, Model model) {
        model.addAttribute("result", service.add(calculatorModel));
        return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "subtract", method = RequestMethod.POST)
    public String subtract(CalculatorModel calculatorModel, Model model) {
        model.addAttribute("result", service.subtract(calculatorModel));
        return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "multiply", method = RequestMethod.POST)
    public String multiply(CalculatorModel calculatorModel, Model model) {
        model.addAttribute("result", service.multiply(calculatorModel));
        return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "divide", method = RequestMethod.POST)
    public String divide(CalculatorModel calculatorModel, Model model) {
        model.addAttribute("result", service.divide(calculatorModel));
        return "calculator";
    }
}
