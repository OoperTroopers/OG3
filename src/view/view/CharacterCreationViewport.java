/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.view;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import view.tools.ImagePaths;

import view.tools.Text;

/**
 *
 * @author Doherty
 */
public class CharacterCreationViewport extends Viewport {

	private ActionListener smasherListener;
	private ActionListener sneakListener;
	private ActionListener summonerListener;
	
    /**
     * Creates new form CharacterCreationViewport
     */
    public CharacterCreationViewport(ActionListener smasherListener, ActionListener sneakListener, ActionListener summonerListener) {
        this.smasherListener = smasherListener;
        this.sneakListener = sneakListener;
        this.summonerListener = summonerListener;
    	initComponents();
    	setListeners();
    }
    
    private void setListeners() {
        smasherButton.addActionListener(smasherListener);
        sneakButton.addActionListener(sneakListener);
        summonerButton.addActionListener(summonerListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        smasherPictureLabel = new javax.swing.JLabel();
        sneakPictureLabel = new javax.swing.JLabel();
        summonerPictureLabel = new javax.swing.JLabel();
        smasherLabel = new javax.swing.JLabel();
        sneakLabel = new javax.swing.JLabel();
        summonerLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        summonerButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        sneakButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        smasherButton = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(500, 500));

        smasherPictureLabel.setBackground(new java.awt.Color(0, 0, 0));
        smasherPictureLabel.setIcon(new ImageIcon(ImagePaths.SMASHER));
        smasherPictureLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 2, 2, new java.awt.Color(0, 0, 0)));
        smasherPictureLabel.setMaximumSize(new java.awt.Dimension(166, 250));
        smasherPictureLabel.setMinimumSize(new java.awt.Dimension(166, 250));
        smasherPictureLabel.setOpaque(true);
        smasherPictureLabel.setPreferredSize(new java.awt.Dimension(166, 250));

        sneakPictureLabel.setBackground(new java.awt.Color(0, 0, 0));
        sneakPictureLabel.setIcon(new ImageIcon(ImagePaths.SNEAK));
        sneakPictureLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        sneakPictureLabel.setMaximumSize(new java.awt.Dimension(166, 250));
        sneakPictureLabel.setMinimumSize(new java.awt.Dimension(166, 250));
        sneakPictureLabel.setOpaque(true);
        sneakPictureLabel.setPreferredSize(new java.awt.Dimension(166, 250));

        summonerPictureLabel.setBackground(new java.awt.Color(0, 0, 0));
        summonerPictureLabel.setIcon(new ImageIcon(ImagePaths.SUMMONER));
        summonerPictureLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 4, new java.awt.Color(0, 0, 0)));
        summonerPictureLabel.setMaximumSize(new java.awt.Dimension(166, 250));
        summonerPictureLabel.setMinimumSize(new java.awt.Dimension(166, 250));
        summonerPictureLabel.setOpaque(true);
        summonerPictureLabel.setPreferredSize(new java.awt.Dimension(166, 250));

        smasherLabel.setBackground(new java.awt.Color(255, 0, 0));
        smasherLabel.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        smasherLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        smasherLabel.setText("<html>" + Text.smasherDescription + "</html>");
        smasherLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 2, 2, new java.awt.Color(0, 0, 0)));
        smasherLabel.setMaximumSize(new java.awt.Dimension(166, 100));
        smasherLabel.setMinimumSize(new java.awt.Dimension(166, 100));
        smasherLabel.setOpaque(true);
        smasherLabel.setPreferredSize(new java.awt.Dimension(166, 100));

        sneakLabel.setBackground(new java.awt.Color(255, 255, 0));
        sneakLabel.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        sneakLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sneakLabel.setText("<html>" + Text.sneakDescription + "</html>");
        sneakLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        sneakLabel.setMaximumSize(new java.awt.Dimension(166, 100));
        sneakLabel.setMinimumSize(new java.awt.Dimension(166, 100));
        sneakLabel.setOpaque(true);
        sneakLabel.setPreferredSize(new java.awt.Dimension(166, 100));

        summonerLabel.setBackground(new java.awt.Color(0, 255, 255));
        summonerLabel.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        summonerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        summonerLabel.setText("<html>" + Text.summonerDescription + "</html>");
        summonerLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 4, new java.awt.Color(0, 0, 0)));
        summonerLabel.setMaximumSize(new java.awt.Dimension(166, 100));
        summonerLabel.setMinimumSize(new java.awt.Dimension(166, 100));
        summonerLabel.setOpaque(true);
        summonerLabel.setPreferredSize(new java.awt.Dimension(166, 100));

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 4, 4, new java.awt.Color(0, 0, 0)));

        summonerButton.setBackground(new java.awt.Color(0, 255, 255));
        summonerButton.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        summonerButton.setText("Summoner");
        summonerButton.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(summonerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(summonerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 4, 2, new java.awt.Color(0, 0, 0)));

        sneakButton.setBackground(new java.awt.Color(255, 255, 0));
        sneakButton.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        sneakButton.setText("Sneak");
        sneakButton.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sneakButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sneakButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 2, new java.awt.Color(0, 0, 0)));

        smasherButton.setBackground(new java.awt.Color(255, 0, 0));
        smasherButton.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        smasherButton.setText("Smasher");
        smasherButton.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(smasherButton, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(smasherButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(smasherLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(smasherPictureLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sneakPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(sneakLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(summonerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(summonerPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(smasherPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(sneakPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(summonerPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sneakLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(summonerLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(smasherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton smasherButton;
    private javax.swing.JLabel smasherLabel;
    private javax.swing.JLabel smasherPictureLabel;
    private javax.swing.JButton sneakButton;
    private javax.swing.JLabel sneakLabel;
    private javax.swing.JLabel sneakPictureLabel;
    private javax.swing.JButton summonerButton;
    private javax.swing.JLabel summonerLabel;
    private javax.swing.JLabel summonerPictureLabel;
    // End of variables declaration//GEN-END:variables
    
	@Override
	void visit(ViewportStack viewportStack) {
		// TODO Auto-generated method stub
		
	}
}
