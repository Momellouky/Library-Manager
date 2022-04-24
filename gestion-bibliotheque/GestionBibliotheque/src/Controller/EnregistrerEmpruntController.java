package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;

import model.Connexion;
import model.EmpruntModel;
import model.UsagerModel;
import view.EnregistrerEmpruntView;
import view.VerifierDispoExemplaireView;
import view.VerifierExemplaireEnCoursView;

public class EnregistrerEmpruntController extends Controller{
	
	private EnregistrerEmpruntView enrEmpView; 
	private VerifierDispoExemplaireView verDispoView; 
	private VerifierExemplaireEnCoursView verExView; 
	private Connexion currentCnx; 
	String numInv ; 
	
	public EnregistrerEmpruntController(EnregistrerEmpruntView enrEmpView, VerifierDispoExemplaireView verDispoView, VerifierExemplaireEnCoursView verExView , Connexion currentCnx, String numInvantaire) {
		
		this.enrEmpView = enrEmpView; 
		this.verDispoView =  verDispoView;
		this.verExView = verExView; 
		this.currentCnx = currentCnx;
		this.numInv = numInvantaire; 
		
	}
	
	@Override
	public void initController() {
		
		UsagerModel um = new UsagerModel(currentCnx); 
		
		setUsagerInfo(um);
		
		setEmpruntInfo(um);
		
		changeLblNames(); 
		
		setExemplaireOrTheseData(); 
		
		if(verDispoView.getRadioThese().isSelected() == true) {
			
			enrEmpView.getTxtThird().setVisible(false);
			
		}
		
		this.enrEmpView.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				enrEmpView.dispose(); 
				
			}
		});
		
		this.enrEmpView.getDtDateEmprunt().addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				
				Date correctDate = enrEmpView.getDtDateEmprunt().getDate(); 

				Calendar c = new GregorianCalendar();  
				c.setTime(correctDate); 
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); ;				
				
				if(um.isEnseignant(enrEmpView.getLblCin().getText()) == true ) {
					
					c.add(Calendar.DAY_OF_YEAR, 15); 
					
				}else if( um.isEtudiant(enrEmpView.getTxtCin().getText()) == true ){
					
					c.add(Calendar.DAY_OF_YEAR, 7); 
					
				}
				
				correctDate = c.getTime(); 
				
			    enrEmpView.getTxtDatePrevueRetour().setText(sdf.format(correctDate)); 
				
				
				
			}
		});
		
		this.enrEmpView.getBtnEnregister().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(verDispoView.getRadioExemplaire().isSelected() == true) {
					
					String cin = enrEmpView.getTxtCin().getText(); 
					Date dtEmprunte = enrEmpView.getDtDateEmprunt().getDate(); 
					
					EmpruntModel em = new EmpruntModel(currentCnx);
					
					try {
						
						em.insertEmpruntExemplaire(cin, numInv, dtEmprunte); 
						JOptionPane.showMessageDialog(enrEmpView, "Emprunt est enregistrer", "Enregistrement", JOptionPane.INFORMATION_MESSAGE); 
					
					}catch(Exception ex) {
						
						JOptionPane.showMessageDialog(enrEmpView, "Emprunt n'est pas enregistrer", "Enregistrement", JOptionPane.INFORMATION_MESSAGE); 

						
					}
					
					
				}
				if(verDispoView.getRadioThese().isSelected() == true ) {
					

					String cin = enrEmpView.getTxtCin().getText().trim(); 
					Date dtEmprunte = enrEmpView.getDtDateEmprunt().getDate(); 
					numInv = enrEmpView.getTxtFirst().getText().trim(); // titre du these
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					String dateEm = sdf.format(dtEmprunte); 
					EmpruntModel em = new EmpruntModel(currentCnx);
					
					try {
						System.out.println(dtEmprunte);
						em.insertEmpruntThese(cin, numInv, dateEm); 
						JOptionPane.showMessageDialog(enrEmpView, "Emprunt est enregistrer", "Enregistrement", JOptionPane.INFORMATION_MESSAGE); 
					
					}catch(Exception ex) {
						
						ex.printStackTrace();
						JOptionPane.showMessageDialog(enrEmpView, "Emprunt n'est pas enregistrer", "Enregistrement", JOptionPane.ERROR_MESSAGE); 

						
					}
					
					
				}
				
				
			}
		});
	}
	
	private void setUsagerInfo(UsagerModel um) {
		
		ResultSet rs = um.getUsager(verExView.getTxtCin().getText()); 
		
		try {
			
			while(rs.next()) {
				
				enrEmpView.getTxtCin().setText(rs.getString(1));
				enrEmpView.getTxtNom().setText(rs.getString(2));
				enrEmpView.getTxtPrenom().setText(rs.getString(3));
				
			}
			
		}catch(SQLException ex) {
			
			ex.printStackTrace();
			
		}
		
	}
	
	private void setEmpruntInfo(UsagerModel um) {
		
		Calendar todayDate = Calendar.getInstance(); // starts with today's date and time
		Date today = todayDate.getTime();  
		Calendar datePrevueRetour = null; 
		
		enrEmpView.getDtDateEmprunt().setDate(today);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
//		
//		Date d = new Date(); 
//		
//		c = new GregorianCalendar(); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date


		
		System.out.println(enrEmpView.getTxtCin().getText());
		if(um.isEnseignant(enrEmpView.getTxtCin().getText()) == true ) {
			
			System.out.println("Ense");
			c.add(Calendar.DATE, 15); 
			
		}else if( um.isEtudiant(enrEmpView.getTxtCin().getText()) == true ){
			
			System.out.println("Etudiant");
			c.add(Calendar.DATE, 7); 
			
		}
		
		String output = sdf.format(c.getTime());
		System.out.println(output);
		
	    enrEmpView.getTxtDatePrevueRetour().setText(output); 
	    
	}
	
	private void changeLblNames() {
		
		if(verDispoView.getRadioExemplaire().isSelected() == true) {
			
			enrEmpView.getLblFirst().setText("ISBN");
			enrEmpView.getLblSecond().setText("Titre");
			enrEmpView.getLblThird().setText("Auteur");
			
		}else if(verDispoView.getRadioThese().isSelected() == true) {
			
			enrEmpView.getLblFirst().setText("Titre");
			enrEmpView.getLblSecond().setText("Auteur");
			enrEmpView.getLblThird().setText(null);
			
		}
		
	}
	
	private void setExemplaireOrTheseData() {
		
		if(verDispoView.getRadioExemplaire().isSelected() == true) {
			
			enrEmpView.getTxtFirst().setText(verDispoView.getTxtTitre().getText());
			enrEmpView.getTxtSecond().setText(verDispoView.getLblSecondText().getText());
			enrEmpView.getTxtThird().setText(verDispoView.getLblThirdText().getText());
			
		}else if(verDispoView.getRadioThese().isSelected() == true) {
			
			enrEmpView.getTxtFirst().setText(verDispoView.getTxtTitre().getText());
			
			enrEmpView.getTxtSecond().setText(verDispoView.getLblSecondText().getText());
			enrEmpView.getTxtThird().setText(null);
			
		}
		
	}
	
}
