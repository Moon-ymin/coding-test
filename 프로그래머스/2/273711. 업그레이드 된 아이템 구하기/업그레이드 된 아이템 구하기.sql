select info.item_id, item_name, rarity
from item_info info 
left outer join item_tree tree
on info.item_id = tree.item_id
where parent_item_id in (
    select item_id
    from item_info
    where rarity = 'RARE'
)
order by 1 desc;