
create procedure trouverRetard()
begin 
    declare numInv varchar(50) ;
    declare cin varchar(9); 
    declare cursor curs1 for 
        select ee.cin, e.numInv 
        from emprunteexemplaire ee, etudiant e
        where ee.cin = e.cin; 

    declare continue handler for not found set fincurs1 := 1; 

    open curs1 ; 

    repeat 
        fetch curs1 into cin; 
        if not fincurs1 then :
