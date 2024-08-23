package ra.rekkei.restapi_basic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.rekkei.restapi_basic.model.dto.request.UserRequest;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @PostMapping
    public ResponseEntity<?> insertUser(@Validated @RequestBody UserRequest userRequest){
        return new ResponseEntity<>("Ok", HttpStatus.CREATED);
    }
}
