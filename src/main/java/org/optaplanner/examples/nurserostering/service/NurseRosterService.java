package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.NurseRoster;

import java.util.concurrent.Future;

public interface NurseRosterService {
    NurseRoster getProblem();
    Future<NurseRoster> solve(String id, NurseRoster problem);
    void saveSolution(NurseRoster roster);
    NurseRoster getSolution(String id);

}
