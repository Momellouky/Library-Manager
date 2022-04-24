

drop procedure if exists getNbrEmprunt;

delimiter //

create procedure getNbrEmprunt(cin varchar(9))
begin 
    
    declare nbrEmpruntEx int default 0;
    declare nbrEmpruntTh int default 0;
    declare nbrEmprunt int default 0;
     

    select count(cin) into nbrEmpruntEx
    from emprunteexemplaire ee 
    where ee.cin = cin 
    and ee.dateretour is null ;
    
    select count(distinct cin) into nbrEmpruntTh
    from empruntthese et 
    where et.cin = cin 
    and et.dateretour is null ;

    set nbrEmprunt = nbrEmpruntEx + nbrEmpruntTh ; 

    select nbrEmprunt; 

end ; 

// 

delimiter ;

