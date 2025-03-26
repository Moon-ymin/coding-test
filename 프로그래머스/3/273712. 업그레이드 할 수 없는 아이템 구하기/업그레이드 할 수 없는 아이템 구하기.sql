-- 코드를 작성해주세요
-- parent_item_id에 없는 item_id를 고른다
select item_id, item_name, rarity
from item_info
where item_id not in 
( select distinct(i.item_id) 
from item_tree t left join item_info i on t.parent_item_id = i.item_id
where i.item_id is not null )
order by item_id desc;