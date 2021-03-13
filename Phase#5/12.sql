--If the particular medicine is sold, how the client will know about it ?
SELECT availability FROM medicines WHERE medicine_name=?;
--If the availability of certain medicine is 0, then it will be impossible to order it and the button will turn red.