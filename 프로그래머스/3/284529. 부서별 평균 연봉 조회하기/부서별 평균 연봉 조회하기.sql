select d.dept_id, d.dept_name_en, e.avg_sal 
from hr_department d join
(select dept_id, round(avg(sal)) as avg_sal
from hr_employees
group by dept_id) e
on d.dept_id = e.dept_id
order by e.avg_sal desc;