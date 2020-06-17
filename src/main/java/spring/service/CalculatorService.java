package spring.service;

import org.springframework.stereotype.Service;
import spring.model.CalculatorModel;

@Service
public class CalculatorService {

    public int add(CalculatorModel model) {
        return model.getA() + model.getB();
    }

    public int subtract(CalculatorModel model) {
        return model.getA() - model.getB();
    }

    public int multiply(CalculatorModel model) {
        return model.getA() * model.getB();
    }

    public double divide(CalculatorModel model) {
        if (model.getA() == 0 || model.getB() == 0) return 0;
        return (double) model.getA() / model.getB();
    }
}
