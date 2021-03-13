--If the client wants to see the list of all the available medicine, how can he/she do it ?
SELECT * FROM medicines OFFSET "+(currentPage-1)*30+" ROWS FETCH FIRST 30 ROWS ONLY;
--+(currentPage-1)*30+ here is used to identify how many medicines will be in the page, maximum number of medicines in 1 page is 30.