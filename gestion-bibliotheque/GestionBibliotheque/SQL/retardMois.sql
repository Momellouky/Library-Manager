drop procedure if exists getRetardMois; 

delimiter // 
create procedure getRetardMois()
begin 
    
    select * 
    from emprunteexemplaire
    where dateretour null 
    and datediff(sysdate(), dateemprunt) > 30
    union 
    select * 
    from empruntthese
    where dateretour null 
    and datediff(sysdate(), dateemprunt) > 30
    

end; 
//
delimiter ; 

