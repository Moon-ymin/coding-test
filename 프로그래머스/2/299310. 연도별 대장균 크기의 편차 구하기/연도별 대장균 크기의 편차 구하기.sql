select a.year, (a.max_size - e.size_of_colony) as year_dev, e.id
from ecoli_data e left join 
( select year(differentiation_date) as year, max(size_of_colony) as max_size
from ecoli_data
group by year(differentiation_date) ) a 
on a.year = year(differentiation_date)
order by a.year, year_dev;