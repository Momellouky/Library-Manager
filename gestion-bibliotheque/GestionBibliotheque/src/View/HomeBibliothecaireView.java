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
        
        ImageIcon img = new ImageIcon(getClass().getResource("/ressources/icon.png"));
        setIconImage(img.getImage());
        
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
         retardJrs = new javax.swing.JMenuItem();
         retardMois = new javax.swing.JMenuItem();
         menuRetourEmprunt = new javax.swing.JMenu();
         menuItemRetourExemplaire = new javax.swing.JMenuItem();
         menuItemRetourThese = new javax.swing.JMenuItem();

         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
         ImageIcon img = new ImageIcon(getClass().getResource("/ressources/bg.jpg"));
         JLabel lblBg = new JLabel(img); 
         this.setContentPane(lblBg); 
         setTitle("Home - Bibliotheque");

         enrEmpruntMenu.setText("Enregistrer Emprunte");

         newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
         newMenuItem.setText("Nouveau Emprunt");
         enrEmpruntMenu.add(newMenuItem);

         jMenuBar1.add(enrEmpruntMenu);

         gestionRetardMenu.setText("Gestion Retard");

         retardJrs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
         retardJrs.setText("Retard 2 jours");
         gestionRetardMenu.add(retardJrs);

         retardMois.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
         retardMois.setText("Retard 1 Mois");
         gestionRetardMenu.add(retardMois);

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

    


	public javax.swing.JMenu getEnrEmpruntMenu() {
		return enrEmpruntMenu;
	}


	public javax.swing.JMenu getGestionRetardMenu() {
		return gestionRetardMenu;
	}


	public javax.swing.JMenuBar getjMenuBar1() {
		return jMenuBar1;
	}


	public javax.swing.JMenuItem getMenuItemRetourExemplaire() {
		return menuItemRetourExemplaire;
	}


	public javax.swing.JMenuItem getMenuItemRetourThese() {
		return menuItemRetourThese;
	}


	public javax.swing.JMenu getMenuRetourEmprunt() {
		return menuRetourEmprunt;
	}


	public javax.swing.JMenuItem getNewMenuItem() {
		return newMenuItem;
	}


	public javax.swing.JMenuItem getRetardJrs() {
		return retardJrs;
	}


	public javax.swing.JMenuItem getRetardMois() {
		return retardMois;
	}




	// Variables declaration - do not modify                     
    private javax.swing.JMenu enrEmpruntMenu;
    private javax.swing.JMenu gestionRetardMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemRetourExemplaire;
    private javax.swing.JMenuItem menuItemRetourThese;
    private javax.swing.JMenu menuRetourEmprunt;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenuItem retardJrs;
    private javax.swing.JMenuItem retardMois;
    // End of variables declaration            
	
}
