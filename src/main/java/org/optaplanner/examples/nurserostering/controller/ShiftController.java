package org.optaplanner.examples.nurserostering.controller;

import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class ShiftController {
    @Autowired
    ShiftService shiftService;

    @GetMapping("/shift")
    public ResponseEntity<Object> getAllShift() {
        return ok(shiftService.getAll());
    }
}
