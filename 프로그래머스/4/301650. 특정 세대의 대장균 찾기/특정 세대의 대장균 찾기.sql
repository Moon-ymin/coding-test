-- 코드를 작성해주세요
select a.id
from ecoli_data a left join ecoli_data b on a.parent_id = b.id
left join ecoli_data c on b.parent_id = c.id
left join ecoli_data d on c.parent_id = d.id
where d.id is null and c.id is not null and b.id is not null
order by a.id;