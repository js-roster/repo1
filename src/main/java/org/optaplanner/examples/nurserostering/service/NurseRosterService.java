package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.NurseRoster;

public interface NurseRosterService {
    NurseRoster getProblem();
    void solve(String id, NurseRoster problem);
    void saveSolution(NurseRoster roster);
    NurseRoster getSolution(String id);

}
