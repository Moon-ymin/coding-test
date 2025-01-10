with fe as (
    select sum(code) as skill_code
    from skillcodes
    group by category
    having category = 'Front End'
), -- fe.skill_code 에는 front end 기술을 모두 표현해놓은 값
dev_grade as (
    select 
        case
            when dev.skill_code & fe.skill_code 
                and dev.skill_code & (select code from skillcodes where name = 'Python')
                then 'A'
            when dev.skill_code & (select code from skillcodes where name = 'C#')
                then 'B'
            when dev.skill_code & fe.skill_code
                then 'C'
            else null
        end as grade, id, email
    from developers dev, fe
    )

select grade, id, email
from dev_grade
where grade is not null
order by grade, id;