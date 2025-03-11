-- 코드를 입력하세요
(SELECT DATE_format(sales_date, '%Y-%m-%d') as sales_date, product_id, user_id, sales_amount
from online_sale 
where sales_date like '2022-03-%')
union
(select DATE_format(sales_date, '%Y-%m-%d') as sales_date, product_id, null as user_id, sales_amount
from offline_sale
where sales_date like '2022-03-%')
order by 1, 2, 3;

