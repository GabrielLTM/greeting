package br.lessa.greeting.controller;


import br.lessa.greeting.exception.UnssuportedMathOperationException;
import br.lessa.greeting.service.MathService;
import br.lessa.greeting.utils.Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        return mathService.sum(numberOne, numberTwo);
    }

    @RequestMapping("/minus/{numberOne}/{numberTwo}")
    public Double minus(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        return mathService.minus(numberOne, numberTwo);
    }


    @RequestMapping("/times/{numberOne}/{numberTwo}")
    public Double times(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        return mathService.times(numberOne, numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        return mathService.division(numberOne, numberTwo);
    }

    @RequestMapping("/sqrt/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws UnssuportedMathOperationException{
        return mathService.sqrt(number);
    }

}
