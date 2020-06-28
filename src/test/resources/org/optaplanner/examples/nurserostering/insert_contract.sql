insert into contract (id, cntr_cd, description, weekend_definition) values (1,'4_day_per_week', '4 working days per week','SaturdaySundayMonday')
update contract_line set cntr_id = 1
update pattern set cntr_id = 1