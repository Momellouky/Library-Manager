package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.EnregistrerEmpruntView;
import view.VerifierDispoExemplaireView;
import view.VerifierExemplaireEnCoursView;

import model.Connexion;
import model.EmpruntModel;

public class VerifierExemplaireEnCoursController extends Controller{
	
	private VerifierExemplaireEnCoursView verEx; 
	private Connexion cnxModel; 
	
	public VerifierExemplaireEnCoursController(VerifierExemplaireEnCoursView verEx, Connexion cnxModel) {
		
		this.verEx = verEx; 
		this.cnxModel = cnxModel; 
		
	}

	
	@Override
	public void initController() {
		
		this.verEx.getBtnContinuer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VerifierDispoExemplaireView verDispoEx = new VerifierDispoExemplaireView(); 
				VerifierDispoExemplaireController verDispoExController = new VerifierDispoExemplaireController(verDispoEx, verEx, cnxModel); 
				verDispoExController.initController();
				
				
			}
		});
		
		this.verEx.getBtnSearch().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cin = verEx.getTxtCin().getText(); 
				
				EmpruntModel em = new EmpruntModel(cnxModel); 
				
				Object [] data = new Object[3]; 
				
				verEx.getEmpruntDefaultModel().setRowCount(0);
				
				if(verEx.getBtnContinuer().isEnabled() == true) {
					verEx.getBtnContinuer().setEnabled(false); 
				}
				
				if( cin.length() == 0 ) {
					
					JOptionPane.showConfirmDialog(verEx, "Saisir le cin" , "Alerte", JOptionPane.WARNING_MESSAGE); 
				}else {
					ResultSet rs = em.getCurrentEmprunt(cin); 
					
					try {
						
//						rs.absolute(1); 
				
						
						if(rs.next() == false) {
							
							JOptionPane.showMessageDialog(verEx, "Aucun usager avec le cin saisie.", "Alerte", JOptionPane.WARNING_MESSAGE);
							
						}
						else {
							
							data[0] = rs.getString(1); 
							data[1] = rs.getString(2); 
							data[2] = rs.getString(3); 
							verEx.getEmpruntDefaultModel().insertRow(0,data); 
							
						}
						
						verEx.getLblNbrEmprunt().setText(
								verEx.getEmpruntDefaultModel().getRowCount() + ""
								); 
						
						if( verEx.getEmpruntDefaultModel().getRowCount() != 0
								&&
								verEx.getEmpruntDefaultModel().getRowCount() < 2) {
							verEx.getBtnContinuer().setEnabled(true);
						}
					
					}catch(SQLException ex) {
						ex.printStackTrace(); 
					}
					
				}
			}
				
				
		});
		
		
		this.verEx.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				verEx.dispose();
				
			}
		});
		
	}
	
	
	
}
