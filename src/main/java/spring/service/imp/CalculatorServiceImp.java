package spring.service.imp;

import org.springframework.stereotype.Service;
import spring.model.CalculatorModel;
import spring.service.CalculatorService;

@Service
public class CalculatorServiceImp implements CalculatorService {

    @Override
    public int add(CalculatorModel model) {
        return model.getA() + model.getB();
    }

    @Override
    public int subtract(CalculatorModel model) {
        return model.getA() - model.getB();
    }

    @Override
    public int multiply(CalculatorModel model) {
        return model.getA() * model.getB();
    }

    @Override
    public double divide(CalculatorModel model) {
        if (model.getA() == 0 || model.getB() == 0) return 0;
        return (double) model.getA() / model.getB();
    }
}
