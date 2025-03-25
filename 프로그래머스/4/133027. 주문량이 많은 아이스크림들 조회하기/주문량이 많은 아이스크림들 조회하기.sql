-- 코드를 입력하세요
select flavor from (
    select flavor, sum(total_order) as total_order from
    (select flavor, total_order from first_half
    union all
    select flavor, total_order from july) a
    group by flavor ) b
order by total_order desc limit 3;