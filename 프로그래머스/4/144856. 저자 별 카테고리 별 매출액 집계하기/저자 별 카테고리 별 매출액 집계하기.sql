-- 코드를 입력하세요
SELECT b.author_id, c.author_name, b.category, sum(b.price * sales) as total_sales
from book_sales a left join book b on a.book_id = b.book_id
left join author c on b.author_id = c.author_id
where sales_date like '2022-01-%'
group by b.author_id, b.category
order by b.author_id, b.category desc;
