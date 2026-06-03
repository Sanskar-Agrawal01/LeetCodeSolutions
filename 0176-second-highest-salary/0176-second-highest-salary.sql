# Write your MySQL query statement below
select  MAX(salary) as SecondHighestSalary from
(select salary, DENSE_RANK() over (order by salary desc) rnk from Employee)t
where rnk = 2;