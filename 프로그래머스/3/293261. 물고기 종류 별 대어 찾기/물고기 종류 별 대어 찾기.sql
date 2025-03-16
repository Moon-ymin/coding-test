-- 코드를 작성해주세요
select f.id, i.fish_name, f.length
from fish_info f
join (select fish_type, max(length) as max_length
from fish_info
group by fish_type) m
on f.fish_type = m.fish_type and f.length = m.max_length
join fish_name_info  i on f.fish_type = i.fish_type
order by f.id;