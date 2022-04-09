

LOAD DATA INFILE 'C:/Users/HP/Desktop/GestionBibliothequeData/usagersDataSet.csv' 
INTO TABLE usager 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS