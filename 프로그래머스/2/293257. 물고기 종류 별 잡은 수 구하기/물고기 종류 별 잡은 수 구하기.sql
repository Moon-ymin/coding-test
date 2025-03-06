select a.fish_count, b.fish_name
from (select count(*) as fish_count, fish_type from fish_info 
group by fish_type) a inner join fish_name_info b Using (fish_type)
order by a.fish_count desc;
