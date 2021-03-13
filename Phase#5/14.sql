--Can a client search for a particular medicine ?
SELECT * FROM medicines WHERE LOWER(medicine_name) LIKE ? OFFSET "+(currentPage-1)*30+" ROWS FETCH FIRST 30 ROWS ONLY;
--This is basically how our search system is going to work, every page will contain 30 medicines.