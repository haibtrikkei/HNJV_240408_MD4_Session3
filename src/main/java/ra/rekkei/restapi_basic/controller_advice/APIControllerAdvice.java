package ra.rekkei.restapi_basic.controller_advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.rekkei.restapi_basic.model.dto.response.ErrorResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class APIControllerAdvice {
    public APIControllerAdvice() {
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<Map<String,String>>> handleArgumentNotValid(MethodArgumentNotValidException ex){
        Map<String,String> map = new HashMap<>();
        //ex.getFieldErrors().stream().forEach(err -> map.put(err.getField(),err.getDefaultMessage()));
        for(int i=0;i<ex.getAllErrors().size();i++){
            map.put("error: "+(i+1),ex.getAllErrors().get(i).getDefaultMessage());
        }
        return new ResponseEntity<>(new ErrorResponse<>("Error",map, HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse<String>> handleNoSuchElelement(NoSuchElementException ex){
        return new ResponseEntity<>(new ErrorResponse<>("Error",ex.getMessage(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
}
