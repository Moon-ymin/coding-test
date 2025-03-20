-- 코드를 입력하세요
with ranked_products as ( 
select category, product_name, price, 
rank() over (partition by category order by price desc) as rank_no
from food_product
where category in ('과자', '국', '김치', '식용유') )

select category, price as max_price, product_name
from ranked_products
where rank_no = 1
order by max_price desc;