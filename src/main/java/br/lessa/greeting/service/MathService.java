package br.lessa.greeting.service;

import br.lessa.greeting.exception.UnssuportedMathOperationException;
import br.lessa.greeting.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    private Utils utils;

    public MathService(Utils utils) {
        this.utils = utils;
    }

    public Double sum(String numberOne, String numberTwo) throws UnssuportedMathOperationException{
        if(!utils.isNumeric(numberOne) || !utils.isNumeric(numberTwo)) throw new UnssuportedMathOperationException("Please set a numeric value");
        return utils.convertToDouble(numberOne) + utils.convertToDouble(numberTwo);
    }

    public Double minus(String numberOne, String numberTwo) throws UnssuportedMathOperationException{
        if(!utils.isNumeric(numberOne) || !utils.isNumeric(numberTwo)) throw new UnssuportedMathOperationException("Please set a numeric value");
        return utils.convertToDouble(numberOne) - utils.convertToDouble(numberTwo);
    }

    public Double times(String numberOne, String numberTwo) throws UnssuportedMathOperationException{
        if(!utils.isNumeric(numberOne) || !utils.isNumeric(numberTwo)) throw new UnssuportedMathOperationException("Please set a numeric value");
        return utils.convertToDouble(numberOne) * utils.convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) throws UnssuportedMathOperationException{
        if(!utils.isNumeric(numberOne) || !utils.isNumeric(numberTwo) && !numberTwo.equals("0")) throw new UnssuportedMathOperationException("Please set a numeric value");
        return utils.convertToDouble(numberOne) / utils.convertToDouble(numberTwo);
    }

    public Double sqrt(String number) throws UnssuportedMathOperationException{
        if(!utils.isNumeric(number)) throw new UnssuportedMathOperationException("Please set a numeric value");
        return Math.sqrt(utils.convertToDouble(number));
    }


}
