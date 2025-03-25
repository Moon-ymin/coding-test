-- 코드를 입력하세요
select flavor
from (
select fh.flavor, (fh.total_order + j.total_order) as total_order
from first_half fh left join (
SELECT flavor, sum(total_order) as total_order
from july
group by flavor) j on fh.flavor = j.flavor
order by total_order desc) a
limit 3;