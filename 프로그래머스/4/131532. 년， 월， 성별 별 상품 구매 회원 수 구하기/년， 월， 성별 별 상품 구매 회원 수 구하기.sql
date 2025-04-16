-- 코드를 입력하세요
select year(o.sales_date) as year, month(o.sales_date) as month, u.gender, count(distinct(o.user_id)) as users
from online_sale o join (SELECT user_id, gender
from user_info
where gender is not null) u on o.user_id = u.user_id
group by year(o.sales_date), month(o.sales_date), u.gender
order by 1, 2, 3;

