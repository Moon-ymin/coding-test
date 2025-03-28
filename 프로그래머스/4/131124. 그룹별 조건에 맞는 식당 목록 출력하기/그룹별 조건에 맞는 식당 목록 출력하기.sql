-- 코드를 입력하세요
-- 리뷰 수 가장 많은 사람 구하기
-- 그 사람의 모든 리뷰 가져오기
with review_counts as (
    select member_id, count(*) as cnt
    from rest_review
    group by member_id 
)
select m.member_name, r.review_text, date_format(r.review_date,'%Y-%m-%d') as review_date
from member_profile m left join rest_review r on m.member_id = r.member_id
where m.member_id in ( select member_id
from review_counts
where cnt = ( select max(cnt) from review_counts ) )
order by r.review_date, r.review_text;


# with review_counts as (
#     select member_id, count(*) as cnt
#     from rest_review
#     group by member_id
# )
# select member_id
# from review_counts
# where cnt = (select max(cnt) from review_counts)


