package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VerifierDispoExemplaireView;
import view.VerifierExemplaireEnCoursView;

public class VerifierExemplaireEnCoursController extends Controller{
	
	private VerifierExemplaireEnCoursView verEx; 
	
	public VerifierExemplaireEnCoursController(VerifierExemplaireEnCoursView verEx) {
		
		this.verEx = verEx; 
		
	}
	
	@Override
	public void initController() {
		
		this.verEx.getBtnContinuer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VerifierDispoExemplaireView verDispoEx = new VerifierDispoExemplaireView(); 
				VerifierDispoExemplaireController verDispoExController = new VerifierDispoExemplaireController(verDispoEx); 
				verDispoExController.initController();
				
				
			}
		});
		
	}
	
	
	
}
