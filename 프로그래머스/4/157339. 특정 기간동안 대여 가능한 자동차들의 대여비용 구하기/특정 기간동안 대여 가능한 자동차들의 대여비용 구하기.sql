select car_id, a.car_type, floor(daily_fee * 30 * 0.01 * (100 - discount_rate)) as fee
from car_rental_company_car a left join car_rental_company_discount_plan b
on a.car_type = b.car_type
where a.car_type in ('SUV', '세단') and car_id not in
(select car_id from car_rental_company_rental_history
where start_date <= '2022-11-30' AND end_date >= '2022-11-01') 
and duration_type = '30일 이상'
and floor(daily_fee * 30 * 0.01 * (100 - discount_rate)) >= 500000
and floor(daily_fee * 30 * 0.01 * (100 - discount_rate)) < 2000000
order by 3 desc, 2 asc, 1 desc;