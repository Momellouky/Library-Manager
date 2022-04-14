package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Connexion;
import model.TheseModel;
import view.ConsulterTheseView;

public class ConsulterTheseController extends Controller{

	private ConsulterTheseView consulterTheseView; 
	private Connexion currentCnx;
	
	
	public ConsulterTheseController(ConsulterTheseView consulterTheseView, Connexion currentCnx) {
		super();
		this.consulterTheseView = consulterTheseView;
		this.currentCnx = currentCnx;
	} 
	
	public void initController() {
		
		getThese();
		
		consulterTheseView.getBtnSuprimer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedIndex = consulterTheseView.getTblThese().getSelectedRow(); 
				Object theseName = consulterTheseView.getTblTheseModel().getValueAt(selectedIndex, 0);
				
				int rep = consulterTheseView.ConfermToDelete("Vous etes sur de supprimer la these : " + theseName + " ? " , "Attention! "); 
				
				if(rep == JOptionPane.YES_OPTION) {
					
					try {
						
						TheseModel tm = new TheseModel(theseName.toString(), currentCnx); 
						
						try {
							
							tm.deleteThese(theseName.toString());
							
							consulterTheseView.showMessage("These suprimmée. ", "Supression these "); 
							
							getThese();
							
						}catch(Exception ex) {
							ex.printStackTrace(); 
							
							consulterTheseView.triggerErrorMessage("Une erreur est survenue lors de la execution de votre demande. ", "Supression these - Erreur ");
						}
						
					}catch(Exception ex) { 
						
						ex.printStackTrace();
						
					}
					
					
			}
		}});
		
	}
	
	public void getThese() {
		
		consulterTheseView.getTblTheseModel().setRowCount(0);
		
		try {
			
			ResultSet rs = currentCnx.requete("these"); 
			Object [] data = new Object[3]; 
			int row = 0; 
			
			if(rs.next() == false) {
				consulterTheseView.showMessage("Aucun livre trouvé", "Consulter These - information");
			}else {
				do {
					
					data[0] = rs.getString(1); 
					data[1] = rs.getString(2); 
//					data[2] = rs.getString(3);
					
					consulterTheseView.getTblTheseModel().insertRow(row, data);
					row++; 
					
				}while(rs.next()); 
			}
			
		}catch(Exception e) {
			
			consulterTheseView.triggerErrorMessage("Une erreur est survenu lors de chargement des données", "Consulter These - Erreur"); 
			e.printStackTrace(); 
			
		}
		
	}
	
}
