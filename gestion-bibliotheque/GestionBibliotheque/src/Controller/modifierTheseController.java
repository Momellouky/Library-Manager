package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Connexion;
import model.TheseModel;
import view.ConsulterTheseView;
import view.modifierTheseView;

public class modifierTheseController extends Controller {
	
	private modifierTheseView mtv; 
	private ConsulterTheseView ctv; 
	private Connexion currentCnx; 
	
	public modifierTheseController(modifierTheseView mtv, ConsulterTheseView ctv,  Connexion currentCnx) {
		
		this.mtv = mtv; 
		this.currentCnx = currentCnx; 
		this.ctv = ctv; 
		
	}
	
	public void initController() {
		
			initWindow();
			
			mtv.getBtnAnnuler().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					mtv.dispose();
					
				}
			});
			
			mtv.getBtnModifier().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String titre = mtv.getTxtTitre().getText().trim(); 
					Date dt = mtv.getDtSoutenance().getDate(); 
					
					TheseModel tm = new TheseModel(titre, dt, currentCnx); 
					
					try {
						
						tm.UpdateThese(); 
						mtv.triggerMessage("These modifié avec succées", "Modifier These - Message"); 
						
					}catch(Exception ex) {
						
						ex.printStackTrace();
						mtv.triggerErrorMessage("Une erreur est survenue lors de la mis à jour de la these", "Modifier These - Erreur"); 
						
					}
					
				}
			});

		}

	public void initWindow() {
		
		int row = ctv.getTblThese().getSelectedRow(); 
		
		String titre = ctv.getTblTheseModel().getValueAt(row, 0).toString().trim(); 
		String dtSoutenance = ctv.getTblTheseModel().getValueAt(row, 1).toString().trim(); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		Date dt = null; 
		
		try {
			
			dt = sdf.parse(dtSoutenance);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
			ctv.triggerErrorMessage("Une erreur est surevenue lors de la lecture des données", "Modifier These - Erreur");
		} 
		
		mtv.getTxtTitre().setText(titre);
		mtv.getDtSoutenance().setDate(dt);
		
	}
	
}

