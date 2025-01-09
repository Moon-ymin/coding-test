select sum(score) as score, g.emp_no, e.emp_name, e.position, e.email
from hr_grade g
 left join hr_employees e on g.emp_no = e.emp_no 
where year = 2022
group by emp_no
order by score desc
limit 1;