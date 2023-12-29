-- Создание таблицы Students
CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    student_name NVARCHAR(20),
	student_surname NVARCHAR(20)
);

-- Вставка 10 строк в таблицу Students
INSERT INTO Students (student_id, student_name, student_surname)
VALUES
    (1, 'Kristina', 'Minevich'),
    (2, 'Natasha', 'Stalmahova'),
    (3, 'Vasya', 'Belashkov'),
    (4, 'Karina', 'Shulyak'),
    (5, 'Irina', 'Kozak'),
    (6, 'Timofei', 'Hovanskii'),
    (7, 'Dima', 'Zvorikin'),
    (8, 'Anton', 'Apalanuk');
---------------------------------------------

-- Создание процедуры GetStudentById
CREATE PROCEDURE GetStudentById 
    @param_id INT = -1,
    @out_name NVARCHAR(100) OUTPUT
AS
BEGIN
    SELECT @out_name = student_name FROM Students WHERE student_id = @param_id;
END;

---------------------------------------------
DECLARE @c NVARCHAR(100);

EXEC GetStudentById 5, @c OUTPUT;
PRINT @c;