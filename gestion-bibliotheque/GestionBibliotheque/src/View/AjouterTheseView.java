package view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class AjouterTheseView extends javax.swing.JFrame {

    /**
     * Creates new form AjouterTheseView
     */
    public AjouterTheseView() {
    	
    	initComponents();
 	    initView();
 	    
        ImageIcon img = new ImageIcon(getClass().getResource("/ressources/icon.png"));
        setIconImage(img.getImage());
 	    
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblTitre = new javax.swing.JLabel();
        txtTitre = new javax.swing.JTextField();
        lblNom = new javax.swing.JLabel();
        btnAjouter = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        txtNom = new javax.swing.JTextField();
        lblPrenom = new javax.swing.JLabel();
        txtPrenom = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        txtDateS = new JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitre.setText("Titre :");

        lblNom.setText("Nom auteur :");

        btnAjouter.setText("Ajouter");

        btnAnnuler.setText("Annuler");

        lblPrenom.setText("Prenom auteur :");

        lblDate.setText("Date de soutenance :");
        
        setTitle("Ajouter These");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitre)
                            .addComponent(lblNom)
                            .addComponent(lblPrenom)
                            .addComponent(lblDate))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitre)
                            .addComponent(txtNom, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtPrenom)
                            .addComponent(txtDateS)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAjouter)))
                .addGap(18, 18, 18)
                .addComponent(btnAnnuler)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitre)
                    .addComponent(txtTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrenom)
                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(txtDateS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjouter)
                    .addComponent(btnAnnuler))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public void initView() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjouterTheseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterTheseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterTheseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterTheseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
  
       
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblTitre;
    private JDateChooser txtDateS;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JTextField txtTitre;
	public javax.swing.JButton getBtnAjouter() {
		return btnAjouter;
	}

	public void setBtnAjouter(javax.swing.JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	public javax.swing.JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public void setBtnAnnuler(javax.swing.JButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	public javax.swing.JLabel getLblDate() {
		return lblDate;
	}

	public void setLblDate(javax.swing.JLabel lblDate) {
		this.lblDate = lblDate;
	}

	public javax.swing.JLabel getLblNom() {
		return lblNom;
	}

	public void setLblNom(javax.swing.JLabel lblNom) {
		this.lblNom = lblNom;
	}

	public javax.swing.JLabel getLblPrenom() {
		return lblPrenom;
	}

	public void setLblPrenom(javax.swing.JLabel lblPrenom) {
		this.lblPrenom = lblPrenom;
	}

	public javax.swing.JLabel getLblTitre() {
		return lblTitre;
	}

	public void setLblTitre(javax.swing.JLabel lblTitre) {
		this.lblTitre = lblTitre;
	}

	public JDateChooser getTxtDateS() {
		return txtDateS;
	}

	public void setTxtDateS(JDateChooser txtDateS) {
		this.txtDateS = txtDateS;
	}

	public javax.swing.JTextField getTxtNom() {
		return txtNom;
	}

	public void setTxtNom(javax.swing.JTextField txtNom) {
		this.txtNom = txtNom;
	}

	public javax.swing.JTextField getTxtPrenom() {
		return txtPrenom;
	}

	public void setTxtPrenom(javax.swing.JTextField txtPrenom) {
		this.txtPrenom = txtPrenom;
	}

	public javax.swing.JTextField getTxtTitre() {
		return txtTitre;
	}

	public void setTxtTitre(javax.swing.JTextField txtTitre) {
		this.txtTitre = txtTitre;
	}

	public void triggerErrorMessage( String msj, String title, int errorMessage) {
		
		JOptionPane.showMessageDialog(this, msj, title, errorMessage);
		
	}

	public void showMessage(String msj, String title, int informationMessage) {
		
		JOptionPane.showMessageDialog(this, msj, title, informationMessage);
	}
       
    
}
