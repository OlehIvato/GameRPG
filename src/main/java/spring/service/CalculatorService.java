package spring.service;

import spring.model.CalculatorModel;

public interface CalculatorService {

    int add(CalculatorModel model);

    int subtract(CalculatorModel model);

    int multiply(CalculatorModel model);

    double divide(CalculatorModel model);

}