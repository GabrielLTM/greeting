package br.lessa.greeting.controller;


import br.lessa.greeting.exception.UnssuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {


    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnssuportedMathOperationException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnssuportedMathOperationException("Please set a numeric value");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/minus/{numberOne}/{numberTwo}")
    public Double minus(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnssuportedMathOperationException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnssuportedMathOperationException("Please set a numeric value");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }


    @RequestMapping("/times/{numberOne}/{numberTwo}")
    public Double times(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnssuportedMathOperationException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnssuportedMathOperationException("Please set a numeric value");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnssuportedMathOperationException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnssuportedMathOperationException("Please set a numeric value");
        if(numberTwo.equals("0")) throw new UnssuportedMathOperationException("Cannot divide by zero");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) throws UnssuportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnssuportedMathOperationException("Please set a numeric value");
        return Double.parseDouble(strNumber);
    }

    private boolean isNumeric(String strNumber) throws UnssuportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnssuportedMathOperationException("Please set a numeric value");

        String number = strNumber.replace(",", "."); // $ 5,00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
