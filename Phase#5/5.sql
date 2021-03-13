--If the client unintentionally put some medicine into his/her basket, is there a way to remove it ?
DELETE FROM cart_table WHERE medicine_name=?;