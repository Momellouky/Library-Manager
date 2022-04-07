package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EnregistrerEmpruntView;
import view.VerifierDispoExemplaireView;
import view.VerifierExemplaireEnCoursView;

public class VerifierDispoExemplaireController extends Controller{
	
	private VerifierDispoExemplaireView verExView; 
	
	public VerifierDispoExemplaireController(VerifierDispoExemplaireView verExView) {
		
		this.verExView = verExView; 
		
	}
	
	@Override
	public void initController() {
		
		this.verExView.getBtnEmprunter().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		
				EnregistrerEmpruntView enrEmpView = new EnregistrerEmpruntView(); 
				
				
			}
		});
		
	}
	
}
