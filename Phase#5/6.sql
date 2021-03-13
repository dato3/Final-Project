--Where can the client see the total amount for which he wants to order the medicine ?
SELECT SUM(totalPrice) FROM cart_table WHERE userName=?;