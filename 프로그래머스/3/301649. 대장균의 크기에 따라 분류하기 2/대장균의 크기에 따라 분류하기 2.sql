select D.id, case
when D.R >= 0.75 then 'CRITICAL'
when D.R >= 0.5 then 'HIGH'
when D.R >= 0.25 then 'MEDIUM'
else 'LOW'
end as colony_name
from 
(select id, percent_rank() over (order by  size_of_colony) as R
from ecoli_Data) D
order by D.id;