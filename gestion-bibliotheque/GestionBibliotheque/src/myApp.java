

import controller.Controller;
import controller.HomeAssistantController;
import controller.HomeBibController;
import controller.LoginController;
import view.HomeAssistantView;
import view.HomeBibliothecaireView;
import view.LoginView;

public class myApp {

	public static void main(String[] args) {
		
//		HomeBibliothecaireView 	homeBibliothecaireViewnew = new HomeBibliothecaireView();
//		HomeBibController c = new HomeBibController(homeBibliothecaireViewnew); 
//		c.initController();
//		
//		HomeAssistantView clv = new HomeAssistantView(); 
//		HomeAssistantController clvController = new HomeAssistantController(clv); 
//		clvController.initController();
		
		LoginView lv = new LoginView(); 
		LoginController lc = new LoginController(lv); 
		lc.initController();
		
	}
	
}
