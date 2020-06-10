insert into contract (id, cntr_cd, description, weekend_definition) values (1,'5_day_per_week', '5 working days per week','SaturdaySunday')
update contract_line set cntr_id = 1
update pattern set cntr_id = 1