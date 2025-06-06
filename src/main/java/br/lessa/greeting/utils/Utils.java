package br.lessa.greeting.utils;

import br.lessa.greeting.exception.UnssuportedMathOperationException;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    public Double convertToDouble(String strNumber) throws UnssuportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnssuportedMathOperationException("Please set a numeric value");
        return Double.parseDouble(strNumber);
    }

    public boolean isNumeric(String strNumber) throws UnssuportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnssuportedMathOperationException("Please set a numeric value");

        String number = strNumber.replace(",", "."); // $ 5,00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
