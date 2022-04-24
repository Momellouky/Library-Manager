drop procedure if exists getUsager; 


delimiter // 

create procedure getUsager(cin varchar(9))
begin 
        

        select nom, prenom 
        from usager u 
        where u.cin = cin; 

end ; 
//
delimiter ; 