/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author HP
 */
public class HomeAssistantView extends javax.swing.JFrame {

    /**
     * Creates new form HomeAssistantView
     */
    public HomeAssistantView() {
       
    	initComponents();
        
    	initView(); 
    	
    	setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuDocument = new javax.swing.JMenu();
        menuItemConsulterLivre = new javax.swing.JMenuItem();
        menuItemConsulterThese = new javax.swing.JMenuItem();
        menuItemUpdateDocs = new javax.swing.JMenuItem();
        menuUsager = new javax.swing.JMenu();
        menuItemConsulterEns = new javax.swing.JMenuItem();
        menuItemConsulterEtudiant = new javax.swing.JMenuItem();
        menuItemUpdateUsers = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));

        menuDocument.setText("Document");

        menuItemConsulterLivre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemConsulterLivre.setText("Consulter Livres");
        menuDocument.add(menuItemConsulterLivre);

        menuItemConsulterThese.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemConsulterThese.setText("Consulter Th�se");
        menuDocument.add(menuItemConsulterThese);

        menuItemUpdateDocs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemUpdateDocs.setText("Mise � Jour Des Documents");
        menuDocument.add(menuItemUpdateDocs);

        jMenuBar1.add(menuDocument);

        menuUsager.setText("Usager");

        menuItemConsulterEns.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemConsulterEns.setText("Consulter Enseignant");
        menuUsager.add(menuItemConsulterEns);

        menuItemConsulterEtudiant.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemConsulterEtudiant.setText("Consulter Etudiant");
        menuUsager.add(menuItemConsulterEtudiant);

        menuItemUpdateUsers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemUpdateUsers.setText("Mise � jours des Usages");
        menuUsager.add(menuItemUpdateUsers);

        jMenuBar1.add(menuUsager);

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
    public void initView( ) {
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeAssistantView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeAssistantView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeAssistantView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeAssistantView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    
    
    public javax.swing.JMenuBar getjMenuBar1() {
		return jMenuBar1;
	}

	public javax.swing.JMenu getMenuDocument() {
		return menuDocument;
	}

	public javax.swing.JMenuItem getMenuItemConsulterEns() {
		return menuItemConsulterEns;
	}

	public javax.swing.JMenuItem getMenuItemConsulterEtudiant() {
		return menuItemConsulterEtudiant;
	}

	public javax.swing.JMenuItem getMenuItemConsulterLivre() {
		return menuItemConsulterLivre;
	}

	public javax.swing.JMenuItem getMenuItemConsulterThese() {
		return menuItemConsulterThese;
	}

	public javax.swing.JMenu getMenuUsager() {
		return menuUsager;
	}



	public javax.swing.JMenuItem getMenuItemUpdateDocs() {
		return menuItemUpdateDocs;
	}

	public javax.swing.JMenuItem getMenuItemUpdateUsers() {
		return menuItemUpdateUsers;
	}



	// Variables declaration - do not modify                     
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuDocument;
    private javax.swing.JMenuItem menuItemConsulterEns;
    private javax.swing.JMenuItem menuItemConsulterEtudiant;
    private javax.swing.JMenuItem menuItemConsulterLivre;
    private javax.swing.JMenuItem menuItemConsulterThese;
    private javax.swing.JMenuItem menuItemUpdateDocs;
    private javax.swing.JMenuItem menuItemUpdateUsers;
    private javax.swing.JMenu menuUsager;
    // End of variables declaration                   
}
