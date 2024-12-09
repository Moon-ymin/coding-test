select a.id as ID, ifnull(b.cnt, 0) as CHILD_COUNT
from ecoli_data a left join
(select parent_id, count(*) as cnt
from ecoli_data 
group by parent_id
having parent_id is not null) b
on a.id = b.parent_id
order by ID;