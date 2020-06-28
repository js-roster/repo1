package org.optaplanner.examples.nurserostering.controller;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.examples.nurserostering.domain.NurseRoster;
import org.optaplanner.examples.nurserostering.service.NurseRosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class NurseRosterController {
    @Autowired
    NurseRosterService nurseRosterService;

    @GetMapping("/roster")
    ResponseEntity<Object> getProblem() {
        NurseRoster roster = nurseRosterService.getProblem();
        return ResponseEntity.ok(roster);
    }

    @PostMapping("/solution/{id}")
    ResponseEntity<Object> solve(@PathVariable String id) {
        NurseRoster problem = nurseRosterService.getProblem();
        problem.setCode(id);
        nurseRosterService.solve(id, problem);
        return  ResponseEntity.ok(problem);
    }

    @GetMapping("/solution/{id}")
    ResponseEntity<Object> getSolution(@PathVariable String id) {
        NurseRoster solution = nurseRosterService.getSolution(id);
        return  ResponseEntity.ok(solution);
    }
}
