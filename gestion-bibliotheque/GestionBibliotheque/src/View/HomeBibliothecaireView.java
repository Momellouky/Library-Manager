package view;

import javax.swing.*;
import java.awt.*; 

public class HomeBibliothecaireView extends JFrame{

	  /**
     * Creates new form HomeBibliothecaireView
     */
    public HomeBibliothecaireView() {
       
    	initComponents();
        
        initView(); 
        
        this.setSize(new Dimension(1200,700));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	  jMenuBar1 = new javax.swing.JMenuBar();
          enrEmpruntMenu = new javax.swing.JMenu();
          newMenuItem = new javax.swing.JMenuItem();
          gestionRetardMenu = new javax.swing.JMenu();
          menuItemAfficherRetard = new javax.swing.JMenuItem();
          menuRetourEmprunt = new javax.swing.JMenu();
          menuItemRetourExemplaire = new javax.swing.JMenuItem();
          menuItemRetourThese = new javax.swing.JMenuItem();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("Home - Bibliotheque");

          enrEmpruntMenu.setText("Enregistrer Emprunte");

          newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
          newMenuItem.setText("Nouveau Emprunt");
          enrEmpruntMenu.add(newMenuItem);

          jMenuBar1.add(enrEmpruntMenu);

          gestionRetardMenu.setText("Gestion Retard");

          menuItemAfficherRetard.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
          menuItemAfficherRetard.setText("Afficher Les retards");
          gestionRetardMenu.add(menuItemAfficherRetard);

          jMenuBar1.add(gestionRetardMenu);

          menuRetourEmprunt.setText("Retour Emprunt");

          menuItemRetourExemplaire.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
          menuItemRetourExemplaire.setText("Retour Exemplaire");
          menuRetourEmprunt.add(menuItemRetourExemplaire);

          menuItemRetourThese.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
          menuItemRetourThese.setText("Retour These");
          menuRetourEmprunt.add(menuItemRetourThese);

          jMenuBar1.add(menuRetourEmprunt);

          setJMenuBar(jMenuBar1);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGap(0, 400, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGap(0, 277, Short.MAX_VALUE)
          );

          pack();
    }                      

    /**
     * @param args the command line arguments
     */
    
    
    private void initView() {

		try {
		  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		      if ("Metal".equals(info.getName())) {
		          javax.swing.UIManager.setLookAndFeel(info.getClassName());
		          break;
		      }
		  }
		} catch (ClassNotFoundException ex) {
		  java.util.logging.Logger.getLogger(HomeBibliothecaireView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
		  java.util.logging.Logger.getLogger(HomeBibliothecaireView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
		  java.util.logging.Logger.getLogger(HomeBibliothecaireView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
		  java.util.logging.Logger.getLogger(HomeBibliothecaireView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		
		/* Create and display the form */
//		java.awt.EventQueue.invokeLater(new Runnable() {
//		  public void run() {
//		      new HomeBibliothecaireView().setVisible(true);
//		  }
//		});
    }

    public JMenuItem getNewEmpruntMenuItem() {
        return newMenuItem;
    }
    
    public JMenuItem getAfficherRetardMenuItem() {
        return menuItemAfficherRetard;
    }
    
    


    public javax.swing.JMenuItem getMenuItemRetourExemplaire() {
		return menuItemRetourExemplaire;
	}


	public javax.swing.JMenuItem getMenuItemRetourThese() {
		return menuItemRetourThese;
	}




	// Variables declaration - do not modify                     
    private javax.swing.JMenu enrEmpruntMenu;
    private javax.swing.JMenu gestionRetardMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemAfficherRetard;
    private javax.swing.JMenuItem menuItemRetourExemplaire;
    private javax.swing.JMenuItem menuItemRetourThese;
    private javax.swing.JMenu menuRetourEmprunt;
    private javax.swing.JMenuItem newMenuItem;
    // End of variables declaration            
	
}
