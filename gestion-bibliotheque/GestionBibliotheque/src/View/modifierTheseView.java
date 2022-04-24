/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class modifierTheseView extends javax.swing.JFrame {

	
    public modifierTheseView() {
      
    	initComponents();
    	
    	initView(); 
    	
        ImageIcon img = new ImageIcon(getClass().getResource("/ressources/icon.png"));
        setIconImage(img.getImage());
    	
    	setVisible(true);
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {


        panel = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        lblDtSoutenance = new javax.swing.JLabel();
        txtTitre = new javax.swing.JTextField(50);
        dtSoutenance = new com.toedter.calendar.JDateChooser();
        btnAnnuler = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modifier These");
//        setPreferredSize(new java.awt.Dimension(1100, 272));

        lblTitre.setText("Titre: ");

        lblDtSoutenance.setText("Date de soutenance: ");

        btnAnnuler.setText("Annuler");

        btnModifier.setMnemonic('M');
        btnModifier.setText("Modifier");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(btnModifier)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnnuler))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDtSoutenance, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTitre)
                            .addComponent(dtSoutenance, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitre)
                    .addComponent(txtTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDtSoutenance)
                    .addComponent(dtSoutenance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnnuler)
                    .addComponent(btnModifier))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(modifierTheseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifierTheseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifierTheseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifierTheseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    
    
    


	public javax.swing.JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public javax.swing.JButton getBtnModifier() {
		return btnModifier;
	}

	public com.toedter.calendar.JDateChooser getDtSoutenance() {
		return dtSoutenance;
	}

	public javax.swing.JPanel getPanel() {
		return panel;
	}

	public javax.swing.JLabel getLblDtSoutenance() {
		return lblDtSoutenance;
	}

	public javax.swing.JLabel getLblTitre() {
		return lblTitre;
	}

	public javax.swing.JTextField getTxtTitre() {
		return txtTitre;
	}






	// Variables declaration - do not modify                     
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnModifier;
    private com.toedter.calendar.JDateChooser dtSoutenance;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel lblDtSoutenance;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JTextField txtTitre;
    // End of variables declaration       
    
    
	public void triggerErrorMessage(String msj, String title) {
		
		JOptionPane.showMessageDialog(this, msj, title, JOptionPane.ERROR_MESSAGE);
		
	}

	public void triggerMessage(String msj, String title) {
		
		JOptionPane.showMessageDialog(this, msj, title, JOptionPane.INFORMATION_MESSAGE);
		
	}
}
