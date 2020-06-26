package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.request.DayOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.DayOnRequest;
import org.optaplanner.examples.nurserostering.entity.DayOffRequestEntity;
import org.optaplanner.examples.nurserostering.entity.DayOnRequestEntity;

public interface DayRequestService {
    DayOffRequest fromEntity(DayOffRequestEntity entity);
    DayOffRequestEntity fromDomain(DayOffRequest dto);
    DayOnRequest fromEntity(DayOnRequestEntity entity);
    DayOnRequestEntity fromDomain(DayOnRequest dto);
}
