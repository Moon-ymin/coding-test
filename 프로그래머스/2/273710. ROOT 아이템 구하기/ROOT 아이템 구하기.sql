select t.item_id, i.item_name
from item_tree t left join item_info i using (item_id)
where t.parent_item_id is null;