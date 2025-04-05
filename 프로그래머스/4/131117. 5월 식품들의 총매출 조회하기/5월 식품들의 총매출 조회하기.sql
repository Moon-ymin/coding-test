-- 코드를 입력하세요
SELECT o.product_id, p.product_name, sum(amount)*p.price as total_sales
from food_order o left join food_product p on o.product_id = p.product_id
where produce_date like '2022-05-%' and p.product_name is not null
group by product_id
order by 3 desc, 1 asc;