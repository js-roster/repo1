/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.examples.nurserostering.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.optaplanner.examples.nurserostering.domain.solver.EmployeeStrengthComparator;
import org.optaplanner.examples.nurserostering.domain.solver.MovableShiftAssignmentSelectionFilter;
import org.optaplanner.examples.nurserostering.domain.solver.ShiftAssignmentDifficultyComparator;

@PlanningEntity(difficultyComparatorClass = ShiftAssignmentDifficultyComparator.class,
        movableEntitySelectionFilter = MovableShiftAssignmentSelectionFilter.class)
@XStreamAlias("ShiftAssignment")
public class ShiftAssignment extends PObject {

    private Shift shift;
    private int indexInShift;

    // Planning variables: changes during planning, between score calculations.
    private Employee employee;


    public ShiftAssignment() {}
    public ShiftAssignment(Shift shift, int idx) {
        this.shift = shift;
        this.indexInShift = idx;
    }
    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public int getIndexInShift() {
        return indexInShift;
    }

    public void setIndexInShift(int indexInShift) {
        this.indexInShift = indexInShift;
    }

    @PlanningVariable(valueRangeProviderRefs = {"employeeRange"},
            strengthComparatorClass = EmployeeStrengthComparator.class)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

    @JsonIgnore
    public ShiftDate getShiftDate() {
        return shift.getShiftDate();
    }

    @JsonIgnore
    public ShiftType getShiftType() {
        return shift.getShiftType();
    }

    @JsonIgnore
    public int getShiftDateDayIndex() {
        return shift.getShiftDate().getDayIndex();
    }

    @JsonIgnore
    public DayOfWeek getShiftDateDayOfWeek() {
        return shift.getShiftDate().getDayOfWeek();
    }

    @JsonIgnore
    public Contract getContract() {
        if (employee == null) {
            return null;
        }
        return employee.getContract();
    }

    @JsonIgnore
    public boolean isWeekend() {
        if (employee == null) {
            return false;
        }
        WeekendDefinition weekendDefinition = employee.getContract().getWeekendDefinition();
        DayOfWeek dayOfWeek = shift.getShiftDate().getDayOfWeek();
        return weekendDefinition.isWeekend(dayOfWeek);
    }

    @JsonIgnore
    public int getWeekendSundayIndex() {
        return shift.getShiftDate().getWeekendSundayIndex();
    }

    @Override
    public String toString() {
        return shift.toString();
    }

}
