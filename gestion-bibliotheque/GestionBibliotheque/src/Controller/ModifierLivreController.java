package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Connexion;
import model.LivreModel;
import view.ConsulterLivreView;
import view.ModifierLivreView;

public class ModifierLivreController extends Controller{
	
	private ModifierLivreView livreView;
	private ConsulterLivreView clv; 
	private Connexion currentCnx; 
	
	public ModifierLivreController(ModifierLivreView livreView,ConsulterLivreView clv, Connexion currentCnx) {
		
		this.livreView = livreView; 
		this.currentCnx = currentCnx; 
		this.clv = clv; 
		
	}
	
	public void initController() {
		
		try {
			
			initWindow();
			
		}catch(ParseException ex) {
			
			livreView.triggerErrorMessage("Une erreur est survenue lors de la lecture des données.", "Modifier Livre - Erreur"); 
			
		}
		
		livreView.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				livreView.dispose(); 
				
			}
		});
		
		
		livreView.getBtnModifier().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String isbn = livreView.getTxtISBN().getText().trim(); 
				String titre = livreView.getTxtTitre().getText().trim(); 
				Date dt = livreView.getDtEdition().getDate(); 
				String resume = livreView.getTxtAreaResume().getText().trim(); 
				
				LivreModel lm = new LivreModel(isbn, titre, dt, resume  ,currentCnx); 
				
				try {
					
					lm.updateLivre();
					livreView.showMessage("Livre modifier avec succés","Modifier Livre - Message"); 
					
				}catch(Exception ex) {
					
					ex.printStackTrace(); 
					livreView.triggerErrorMessage("Une erreur est survenue lors de la modification", "Modifier Livre - Erreur"); 
					
				}
				
			}
		});
		
		
	}
	
	private void initWindow() throws ParseException{
		
		int row = clv.getTblLivre().getSelectedRow(); 
//		int column = clv.getTblLivre().getSelectedColumn() ; 
		int column = 0; 
		
		livreView.getTxtISBN().setText(
				clv.getTblModelLivre().getValueAt(row, column++).toString()
				);
		
		
		livreView.getTxtTitre().setText(
				clv.getTblModelLivre().getValueAt(row, column++).toString()
				);
		
		String selectedDate = clv.getTblModelLivre().getValueAt(row, column++).toString();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = null; 
		try {
			
			date = sdf.parse(selectedDate); 
			
		}catch(ParseException ex) {
			
			ex.printStackTrace(); 
			throw new ParseException("", 0); 
			
		}
		
		livreView.getDtEdition().setDate(date); 
		
		try {
			livreView.getTxtAreaResume().setText(getResume(
					 clv.getTblModelLivre().getValueAt(row, 0).toString()
					));
			
		}catch(Exception ex) {
			ex.printStackTrace();
			livreView.triggerErrorMessage("Une erreur est survenue lors de la lecture des données", "Modifier Livre - Erreur");
		}
		
	}
	
	private String getResume(String isbn) throws Exception {
		
		
		ResultSet rs = null; 
		String resume = new String(); 
		
		try {
			System.out.println(isbn);
			LivreModel lm = new LivreModel(isbn, currentCnx); 
			rs = lm.resumeLivre(); 
			
			if(rs.next() == false )
				throw new Exception(); 
			
			do {
				
				resume = rs.getString("resume"); 
				
			}while(rs.next()); 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			livreView.triggerErrorMessage("Une erreur est survenue lors de la lecture des données", "Modifer Livre - Erreur");
			
		}
		System.out.println(resume);
		return resume; 
		
	}
}
