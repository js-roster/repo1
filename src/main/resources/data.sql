
values next value for shift_date_seq;
values next value for shift_date_seq;
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (31, '07-06-2020', 0, 'Sunday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (32, '08-06-2020', 1, 'Monday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (33, '09-06-2020', 2, 'Tuesday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (34, '10-06-2020', 3, 'Wednesday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (35, '11-06-2020', 4, 'Thursday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (36, '12-06-2020', 5, 'Friday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (37, '13-06-2020', 6, 'Saturday');

insert into shift_date (id, shift_dte, day_idx, day_of_week) values (38, '14-06-2020', 7, 'Sunday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (39, '15-06-2020', 8, 'Monday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (40, '16-06-2020', 9, 'Tuesday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (41, '17-06-2020', 10, 'Wednesday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (42, '18-06-2020', 11, 'Thursday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (43, '19-06-2020', 12, 'Friday');
insert into shift_date (id, shift_dte, day_idx, day_of_week) values (44, '20-06-2020', 13, 'Saturday');

values next value for shift_type_seq;
values next value for shift_type_seq;
insert into shift_type (id, type_idx, night, type_cd, start_time, end_time, description) values (31, 1, false, 'E', '6', '14', 'Early');
insert into shift_type (id, type_idx, night, type_cd, start_time, end_time, description) values (32, 2, false, 'D', '8:30', '17:30', 'Day');
insert into shift_type (id, type_idx, night, type_cd, start_time, end_time, description) values (33, 3, false, 'DH', '68:30', '17:30', 'Day Header');
insert into shift_type (id, type_idx, night, type_cd, start_time, end_time, description) values (34, 4, false, 'L', '14', '22', 'Late');
insert into shift_type (id, type_idx, night, type_cd, start_time, end_time, description) values (35, 5, true, 'N', '22', '6', 'Night');

values next value for skill_seq;
values next value for skill_seq;
insert into skill (id, skill_cd) values (31, 'MT');
insert into skill (id, skill_cd) values (32, 'EM');
insert into skill (id, skill_cd) values (33, 'BA');

insert into shift_type_skill_requirement (shift_type_id, skill_id) values (31, 31);
insert into shift_type_skill_requirement (shift_type_id, skill_id) values (32, 31);
insert into shift_type_skill_requirement (shift_type_id, skill_id) values (32, 32);
insert into shift_type_skill_requirement (shift_type_id, skill_id) values (32, 33);
insert into shift_type_skill_requirement (shift_type_id, skill_id) values (34, 33);
insert into shift_type_skill_requirement (shift_type_id, skill_id) values (35, 31);
insert into shift_type_skill_requirement (shift_type_id, skill_id) values (35, 32);

values next value for shift_seq;
values next value for shift_seq;
values next value for shift_seq;
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (31, 31, 31, 31, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (32, 31, 32, 32, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (33, 31, 33, 33, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (34, 31, 34, 34, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (35, 31, 35, 35, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (36, 32, 31, 36, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (37, 32, 32, 37, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (38, 32, 33, 38, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (39, 32, 34, 39, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (40, 32, 35, 40, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (41, 33, 31, 41, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (42, 33, 32, 42, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (43, 33, 33, 43, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (44, 33, 34, 44, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (45, 33, 35, 45, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (46, 34, 31, 46, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (47, 34, 32, 47, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (48, 34, 33, 48, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (49, 34, 34, 49, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (50, 34, 35, 50, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (51, 35, 31, 51, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (52, 35, 32, 52, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (53, 35, 33, 53, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (54, 35, 34, 54, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (55, 35, 35, 55, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (56, 36, 31, 56, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (57, 36, 32, 57, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (58, 36, 33, 58, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (59, 36, 34, 59, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (60, 36, 35, 60, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (61, 37, 31, 61, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (62, 37, 32, 62, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (63, 37, 33, 63, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (64, 37, 34, 64, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (65, 37, 35, 65, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (66, 38, 31, 66, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (67, 38, 32, 67, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (68, 38, 33, 68, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (69, 38, 34, 69, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (70, 38, 35, 70, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (71, 39, 31, 71, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (72, 39, 32, 72, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (73, 39, 33, 73, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (74, 39, 34, 74, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (75, 39, 35, 75, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (76, 40, 31, 76, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (77, 40, 32, 77, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (78, 40, 33, 78, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (79, 40, 34, 79, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (80, 40, 35, 80, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (81, 41, 31, 81, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (82, 41, 32, 82, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (83, 41, 33, 83, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (84, 41, 34, 84, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (85, 41, 35, 85, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (86, 42, 31, 86, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (87, 42, 32, 87, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (88, 42, 33, 88, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (89, 42, 34, 89, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (90, 42, 35, 90, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (91, 43, 31, 91, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (92, 43, 32, 92, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (93, 43, 33, 93, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (94, 43, 34, 94, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (95, 43, 35, 95, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (96, 44, 31, 96, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (97, 44, 32, 97, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (98, 44, 33, 98, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (99, 44, 34, 99, 2);
insert into shift (id, shift_dte_id, shift_type_id, index, size) values (100, 44, 35, 100, 2);

values next value for contract_seq;

insert into contract (id, cntr_cd, description, weekend_definition) values (31,'5_day_per_week', '5 working days per week','SaturdaySunday');


values next value for employee_seq;
values next value for employee_seq;
values next value for employee_seq;
insert into employee (id, emp_nm, emp_cd, contract_id) values(31, 'Emp 31','ID031', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(32, 'Emp 32','ID032', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(33, 'Emp 33','ID033', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(34, 'Emp 34','ID034', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(35, 'Emp 35','ID035', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(36, 'Emp 36','ID036', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(37, 'Emp 37','ID037', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(38, 'Emp 38','ID038', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(39, 'Emp 39','ID039', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(40, 'Emp 40','ID040', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(41, 'Emp 41','ID041', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(42, 'Emp 42','ID042', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(43, 'Emp 43','ID043', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(44, 'Emp 44','ID044', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(45, 'Emp 45','ID045', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(46, 'Emp 46','ID046', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(47, 'Emp 47','ID047', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(48, 'Emp 48','ID048', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(49, 'Emp 49','ID049', 31);
insert into employee (id, emp_nm, emp_cd, contract_id) values(50, 'Emp 50','ID050', 31);


insert into skill_proficiency (emp_id, skill_id) values(31, 33);
insert into skill_proficiency (emp_id, skill_id) values(31, 31);
insert into skill_proficiency (emp_id, skill_id) values(32, 32);
insert into skill_proficiency (emp_id, skill_id) values(32, 33);
insert into skill_proficiency (emp_id, skill_id) values(33, 31);
insert into skill_proficiency (emp_id, skill_id) values(33, 32);
insert into skill_proficiency (emp_id, skill_id) values(34, 33);
insert into skill_proficiency (emp_id, skill_id) values(34, 31);
insert into skill_proficiency (emp_id, skill_id) values(35, 32);
insert into skill_proficiency (emp_id, skill_id) values(35, 33);
insert into skill_proficiency (emp_id, skill_id) values(36, 31);
insert into skill_proficiency (emp_id, skill_id) values(36, 32);
insert into skill_proficiency (emp_id, skill_id) values(37, 33);
insert into skill_proficiency (emp_id, skill_id) values(37, 31);
insert into skill_proficiency (emp_id, skill_id) values(38, 32);
insert into skill_proficiency (emp_id, skill_id) values(38, 33);
insert into skill_proficiency (emp_id, skill_id) values(39, 31);
insert into skill_proficiency (emp_id, skill_id) values(39, 32);
insert into skill_proficiency (emp_id, skill_id) values(40, 33);
insert into skill_proficiency (emp_id, skill_id) values(40, 31);
insert into skill_proficiency (emp_id, skill_id) values(41, 32);
insert into skill_proficiency (emp_id, skill_id) values(41, 33);
insert into skill_proficiency (emp_id, skill_id) values(42, 31);
insert into skill_proficiency (emp_id, skill_id) values(42, 32);
insert into skill_proficiency (emp_id, skill_id) values(43, 33);
insert into skill_proficiency (emp_id, skill_id) values(43, 31);
insert into skill_proficiency (emp_id, skill_id) values(44, 32);
insert into skill_proficiency (emp_id, skill_id) values(44, 33);
insert into skill_proficiency (emp_id, skill_id) values(45, 31);
insert into skill_proficiency (emp_id, skill_id) values(45, 32);
insert into skill_proficiency (emp_id, skill_id) values(46, 33);
insert into skill_proficiency (emp_id, skill_id) values(46, 31);
insert into skill_proficiency (emp_id, skill_id) values(47, 32);
insert into skill_proficiency (emp_id, skill_id) values(47, 33);
insert into skill_proficiency (emp_id, skill_id) values(48, 31);
insert into skill_proficiency (emp_id, skill_id) values(48, 32);
insert into skill_proficiency (emp_id, skill_id) values(49, 33);
insert into skill_proficiency (emp_id, skill_id) values(49, 31);
insert into skill_proficiency (emp_id, skill_id) values(50, 32);
insert into skill_proficiency (emp_id, skill_id) values(50, 33);

values next value for request_day_seq;
values next value for request_day_seq;
values next value for request_day_seq;
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(31, 'OFF', 100, 31, 31);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(32, 'ON', 100, 31, 32);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(33, 'OFF', 100, 32, 33);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(34, 'ON', 100, 32, 34);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(35, 'OFF', 100, 33, 35);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(36, 'ON', 100, 33, 36);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(37, 'OFF', 100, 34, 37);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(38, 'ON', 100, 34, 38);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(39, 'OFF', 100, 35, 39);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(40, 'ON', 100, 35, 40);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(41, 'OFF', 100, 36, 41);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(42, 'ON', 100, 36, 42);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(43, 'OFF', 100, 37, 43);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(44, 'ON', 100, 37, 44);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(45, 'OFF', 100, 38, 31);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(46, 'ON', 100, 38, 32);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(47, 'OFF', 100, 39, 33);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(48, 'ON', 100, 39, 34);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(49, 'OFF', 100, 40, 35);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(50, 'ON', 100, 40, 36);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(51, 'OFF', 100, 41, 37);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(52, 'ON', 100, 41, 38);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(53, 'OFF', 100, 42, 39);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(54, 'ON', 100, 42, 40);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(55, 'OFF', 100, 43, 41);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(56, 'ON', 100, 43, 42);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(57, 'OFF', 100, 44, 43);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(58, 'ON', 100, 44, 44);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(59, 'OFF', 100, 45, 31);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(60, 'ON', 100, 45, 32);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(61, 'OFF', 100, 46, 33);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(62, 'ON', 100, 46, 34);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(63, 'OFF', 100, 47, 35);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(64, 'ON', 100, 47, 36);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(65, 'OFF', 100, 48, 37);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(66, 'ON', 100, 48, 38);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(67, 'OFF', 100, 49, 39);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(68, 'ON', 100, 49, 40);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(69, 'OFF', 100, 50, 41);
insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(70, 'ON', 100, 50, 42);


