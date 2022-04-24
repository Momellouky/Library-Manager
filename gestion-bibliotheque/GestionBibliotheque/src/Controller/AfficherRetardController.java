package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.EmpruntModel;
import model.ExemplaireModel;
import model.TheseModel;
import view.AfficherRetardJrsView;


public class AfficherRetardController extends Controller{

	private AfficherRetardJrsView arv; 
	private EmpruntModel em; 


	public AfficherRetardController(AfficherRetardJrsView arv, EmpruntModel em) {
		super();
		this.arv = arv;
		this.em = em;
	}


	public void initController() {
		
		
		initWindow(); 
		
		arv.getBtnEnvRelance().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int row = arv.getTblRetard().getSelectedRow(); 
				
				if( ! (row < 0) ) {
					
					String cin = arv.getTblRetardModel().getValueAt(row, 0).toString().trim();
					String idEmprunt = arv.getTblRetardModel().getValueAt(row, 1).toString().trim();
					String dtEmpruntString = arv.getTblRetardModel().getValueAt(row, 2).toString().trim();
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					
					System.out.println("CIN: " + cin );
					System.out.println("idEmprunt: " + idEmprunt );
					System.out.println("dtEmpruntString: " + dtEmpruntString );
					
					try {
						
						Date dtEmprunt = sdf.parse(dtEmpruntString);
						
						System.out.println(dtEmprunt);
						
						if(idEmprunt.length() > 13 ) {
							
							em.envoyerRelanceThese(cin, idEmprunt, dtEmprunt); 
							
						}else {
							
							em.envoyerRelanceExemplaire(cin, idEmprunt, dtEmprunt); 
							
						}
						
						arv.showMessage("Relance envoyée avec succées", "Message",JOptionPane.INFORMATION_MESSAGE);
						
					} catch (ParseException e1) {
						
						e1.printStackTrace();
						arv.triggerErrorMessage("Une erreur est survenue lors de la lecture de la date d'emprunt", "Erreur", JOptionPane.ERROR_MESSAGE);
						
					}catch(Exception ex) {
						
						ex.printStackTrace();
						arv.triggerErrorMessage("Une erreur est survenue lors de la lecture de la date d'emprunt", "Erreur", JOptionPane.ERROR_MESSAGE);
						
					}
					
				
				}
				else {
					
					arv.showMessage("Selectionner un emprunt en retard", "Envoyer Relance", JOptionPane.ERROR_MESSAGE); 
					
				}
				
			}
		});
		
		
		
		
	
	}
	
	
	private void initWindow() {
		
		try {
			
			ResultSet rs = em.getRetardJrs(); 
			
			if(rs.next() == false) {
				arv.showMessage("Aucun emprunt en retard", "Message", JOptionPane.INFORMATION_MESSAGE);
				return ; 
			}
			
			Object [] data =  new Object[3]; 
			
			do {
				
				data[0] = rs.getString("cin"); 
				data[1] = rs.getString("numInvantaire"); 
				data[2] = rs.getString("dateEmprunt"); 
				
				arv.getTblRetardModel().addRow(data);
				
			}while(rs.next()); 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			arv.triggerErrorMessage("Une erreur est survenue lors de la recuperation des données", "Erreur", JOptionPane.ERROR_MESSAGE); 
			
		}
		
		
	}
}

