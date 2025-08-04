-- Problem 1

-- song table
-- | id |     artist     |        album        |         song         |
-- |----|----------------|---------------------|----------------------|
-- |1   |'The Beatles'   |'Abbey Road'         |'Come Together'       |
-- |2   |'The Beatles'   |'Let It Be'          |'Let It Be'           |
-- |3   |'Led Zeppelin'  |'IV'                 |'Black Dog'           |
-- |4   |'Led Zeppelin'  |'Physical Graffiti'  |'Kashmir'             |
-- |5   |'Led Zeppelin'  |'IV'                 |'Going to California' |
-- |6   |'The Eagles'    |'Hotel California'   |'Hotel California'    |

-- Problem 1: Use the `GROUP BY` clause with the `COUNT()` aggregate function to query the song table for the number of songs by each artist. The result of the query should have two columns: the artist, and the count(song) of the artist.
-- HINT: You should avoid using the wild card (*) in your statement. All projected columns must either be used in the `GROUP BY` clause or an aggregate function.

-- Write your sql statement anywhere below this line

SELECT artist, COUNT(song) FROM song GROUP BY artist;
