# spring-procedure-function

update_stock:
--------------
```
CREATE PROCEDURE amlandb.update_stock(
	IN productId INT,
    IN quantity INT
    )
BEGIN
	UPDATE product
    SET stockQuantity = stockQuantity - quantity
    WHERE id = productId;
END
```
get_total_price:
----------------
```
CREATE FUNCTION amlandb.get_total_price(productId INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE total DECIMAL(10,2);
    SELECT SUM(price * stockQuantity) INTO total
    FROM Product
    WHERE id = productId;

    RETURN total;
END
```
### Why Use Stored Procedures and Functions?

Complex Logic: If you have complicated SQL operations — like multiple joins or conditional logic — stored procedures can help organize your code.

Performance: Stored procedures sometimes run faster because the database can optimize and cache them.

Security: You can permit to run a stored procedure without allowing direct access to the underlying tables.

Reusability: If many applications or parts of your code need the same SQL logic, you can store it in a procedure or function and call it whenever you want
