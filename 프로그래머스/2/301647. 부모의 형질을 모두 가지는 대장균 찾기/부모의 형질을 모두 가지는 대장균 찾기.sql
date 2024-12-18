-- 대장균 별 형질
select a.id, a.genotype, b.genotype as parent_genotype
from ecoli_data a, ecoli_data b
where a.parent_id = b.id
and b.genotype & a.genotype = b.genotype
-- 대장균 별 부모의 형질 == 대장균 별 형질 같은지 확인
-- 부모와 자식을 and 했을 때 - 부모 형질의 2진수와 같은지 
order by a.id;
