package org.ebndrnk.leverxhomework.controller;

import org.ebndrnk.leverxhomework.model.UserDto;
import org.ebndrnk.leverxhomework.monitoring.PossibleActions;
import org.ebndrnk.leverxhomework.monitoring.UserAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * these methods may have different logic,
 * using an aspect allows you to add your
 * own logic without affecting someone else’s at all
 */
@RestController
@RequestMapping("/test-aspect")
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);


    @PostMapping("/login")
    @UserAction(actionType = PossibleActions.LOGIN)
    public ResponseEntity<String> logIn(@RequestBody UserDto user){
        log.info("user with id: {} there!", user.getId());
        return ResponseEntity.ok("Login!");
    }


    @DeleteMapping
    @UserAction(actionType = PossibleActions.DELETE)
    public ResponseEntity<String> deleteSomething(@RequestBody UserDto user){
        log.info("user with id: {} delete something!", user.getId());
        return ResponseEntity.ok("Delete!");
    }

    @PostMapping("/logout")
    @UserAction(actionType = PossibleActions.LOGOUT)
    public ResponseEntity<String> logOut(@RequestBody UserDto user){
        log.info("user with id: {} logout( ", user.getId());
        return ResponseEntity.ok("Logout(");
    }

    @PutMapping
    @UserAction(actionType = PossibleActions.CHANGE)
    public ResponseEntity<String> changed(@RequestBody UserDto user){
        log.info("user with id: {} changed something ", user.getId());
        return ResponseEntity.ok("Changed");
    }
}
