# Write your MySQL query statement below
WITH top_users AS (
    SELECT user_id
    FROM course_completions
    GROUP BY user_id
    HAVING COUNT(*) >= 5 AND AVG(course_rating) >= 4
),

ordered_courses AS (
    SELECT 
        user_id,
        course_name,
        ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY completion_date) AS rn
    FROM course_completions
    WHERE user_id IN (SELECT user_id FROM top_users)
),

pairs AS (
    SELECT 
        a.course_name AS first_course,
        b.course_name AS second_course
    FROM ordered_courses a
    JOIN ordered_courses b
    ON a.user_id = b.user_id
    AND a.rn + 1 = b.rn
)

SELECT 
    first_course,
    second_course,
    COUNT(*) AS transition_count
FROM pairs
GROUP BY first_course, second_course
ORDER BY transition_count DESC, first_course ASC, second_course ASC;