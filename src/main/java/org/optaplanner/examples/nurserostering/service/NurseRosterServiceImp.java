package org.optaplanner.examples.nurserostering.service;

import org.apache.commons.math3.random.RandomGenerator;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.examples.nurserostering.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class NurseRosterServiceImp implements NurseRosterService {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ShiftService shiftService;

    final private Map<String, NurseRoster> solutionMap = new HashMap<String, NurseRoster>();

    @Override
    public NurseRoster getProblem() {
        List<Employee> employees = employeeService.getAllEmployee();
        List<Shift> shifts = shiftService.getAll();

        List<ShiftAssignment> shiftAssignments = shifts.stream()
                .flatMap(s -> Stream.iterate(
                        new ShiftAssignment(s, 0), a -> new ShiftAssignment(s, a.getIndexInShift() + 1))
                        .limit((long)s.getRequiredEmployeeSize())
                ).collect(Collectors.toList());

        NurseRosterParametrization parameeter = new NurseRosterParametrization();
        ShiftDate startDate = shifts.stream()
                .map(s -> s.getShiftDate())
                .min((a, b) -> a.getDayIndex() - b.getDayIndex())
                .get();
        ShiftDate endDate = shifts.stream()
                .map(s -> s.getShiftDate())
                .max((a, b) -> a.getDayIndex() - b.getDayIndex())
                .get();

        parameeter.setFirstShiftDate(startDate);
        parameeter.setLastShiftDate(endDate);
        parameeter.setPlanningWindowStart(startDate);
        NurseRoster nurseRoster = new NurseRoster();
        nurseRoster.setNurseRosterParametrization(parameeter);
        nurseRoster.setShiftAssignmentList(shiftAssignments);
        nurseRoster.setEmployeeList(employees);
        return nurseRoster;
    }

    @Override
    @Async
    public Future<NurseRoster> solve(final String id, NurseRoster problem) {
        SolverFactory<NurseRoster> solverFactory = SolverFactory.createFromXmlResource("solver.config.xml");
        Solver<NurseRoster> solver = solverFactory.buildSolver();

        solver.addEventListener(v -> {
            this.solutionMap.put(id,v.getNewBestSolution());
        });
        NurseRoster solution = solver.solve(problem);
        return new AsyncResult<NurseRoster>(solution);
    }

    @Override
    public void saveSolution(NurseRoster roster) {

    }

    @Override
    public NurseRoster getSolution(String id) {
        return this.solutionMap.get(id);
    }
}
