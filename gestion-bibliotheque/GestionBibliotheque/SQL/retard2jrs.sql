drop procedure if exists getRetardJrs; 

delimiter // 
create procedure getRetardJrs()
begin 
    
    select * 
    from emprunteexemplaire 
    where datediff(sysdate(), dateemprunt) > 9 
    and cin in ( select cin from etudiant )
    union 
    select * 
    from empruntthese 
    where datediff(sysdate(), dateemprunt) > 9 
    and cin in ( select cin from etudiant ) 
    union
    select * 
    from emprunteexemplaire 
    where datediff(sysdate(), dateemprunt) > 15 
    and cin in ( select cin from enseignant )
    union 
    select * 
    from empruntthese 
    where datediff(sysdate(), dateemprunt) > 15
    and cin in ( select cin from enseignant ) ;
    

end; 
//
delimiter ; 

