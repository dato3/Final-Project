--How the system will know who is ordering a medicine and how the basket is assigned to the user ?
SELECT * FROM cart_table WHERE username=?;
--System will know who is ordering cause it is attached to the cart_table and deleted whever user is logged out