-- 2번 형질 없음 
-- 1번 혹은 3번만 있음
select count(*) as count
from ecoli_data a
where 1=1 
and (genotype & 2) != 2
and ((genotype & 4) = 4 or (genotype & 1) = 1)


