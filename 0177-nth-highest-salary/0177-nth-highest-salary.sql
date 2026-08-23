CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    select salary from(
        select salary,  DENSE_RANK() over (order by salary DESC) as rnk from Employee
    )t
    where rnk = N
    LIMIT  1
  );
END