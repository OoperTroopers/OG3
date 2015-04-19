/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.view;

import controller.ScreenNavigation;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import view.tools.Constants;
import view.tools.ImagePaths;
import view.tools.Text;

/**
 *
 * @author Doherty
 */
public class PauseMenuViewport extends Viewport {
    
    public static PauseMenuViewport pauseMenuViewport = new PauseMenuViewport();
    /**
     * Creates new form PauseMenuViewport2
     */
    public PauseMenuViewport() {
        initComponents();
        this.setPreferredSize(new Dimension(Constants.VIEW_WIDTH, Constants.VIEW_HEIGHT));
    }
    
    @Override
    public void visit(ViewportStack viewportStack) {
        viewportStack.add(this);
    }
    
    public static PauseMenuViewport getInstance() {
        return pauseMenuViewport;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        inventoryButtonPanel = new javax.swing.JPanel();
        inventoryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        catPictureLabel = new javax.swing.JLabel();
        backButtonPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        exitButtonPanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        statsButtonPanel = new javax.swing.JPanel();
        statsButton = new javax.swing.JButton();
        saveGamePanel = new javax.swing.JPanel();
        saveGameButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 1, 1, new java.awt.Color(0, 0, 0)));
        setName(""); // NOI18N

        inventoryButtonPanel.setBackground(new java.awt.Color(0, 255, 255));

        inventoryButton.setBackground(new java.awt.Color(0, 255, 255));
        inventoryButton.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        inventoryButton.setText(Text.inventoryButton);
        inventoryButton.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 2, 2, new java.awt.Color(0, 0, 0)));
        inventoryButton.setOpaque(false);
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inventoryButtonPanelLayout = new javax.swing.GroupLayout(inventoryButtonPanel);
        inventoryButtonPanel.setLayout(inventoryButtonPanelLayout);
        inventoryButtonPanelLayout.setHorizontalGroup(
            inventoryButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryButtonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        inventoryButtonPanelLayout.setVerticalGroup(
            inventoryButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryButtonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(Text.pauseMenuBanner);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        catPictureLabel.setOpaque(true);
        catPictureLabel.setIcon(new ImageIcon(ImagePaths.MAGIC_CAT));

        backButtonPanel.setBackground(new java.awt.Color(0, 255, 0));

        backButton.setBackground(new java.awt.Color(0, 255, 0));
        backButton.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        backButton.setText(Text.backButton);
        backButton.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 2, 2, new java.awt.Color(0, 0, 0)));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backButtonPanelLayout = new javax.swing.GroupLayout(backButtonPanel);
        backButtonPanel.setLayout(backButtonPanelLayout);
        backButtonPanelLayout.setHorizontalGroup(
            backButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(backButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backButtonPanelLayout.createSequentialGroup()
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        backButtonPanelLayout.setVerticalGroup(
            backButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(backButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        exitButtonPanel.setBackground(new java.awt.Color(255, 0, 0));

        exitButton.setBackground(new java.awt.Color(255, 0, 0));
        exitButton.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        exitButton.setText(Text.exitGameButton);
        exitButton.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 2, 2, new java.awt.Color(0, 0, 0)));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exitButtonPanelLayout = new javax.swing.GroupLayout(exitButtonPanel);
        exitButtonPanel.setLayout(exitButtonPanelLayout);
        exitButtonPanelLayout.setHorizontalGroup(
            exitButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        exitButtonPanelLayout.setVerticalGroup(
            exitButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitButtonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        statsButtonPanel.setBackground(new java.awt.Color(255, 0, 255));

        statsButton.setBackground(new java.awt.Color(255, 0, 255));
        statsButton.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        statsButton.setText(Text.statsButton);
        statsButton.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 2, 2, new java.awt.Color(0, 0, 0)));
        statsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statsButtonPanelLayout = new javax.swing.GroupLayout(statsButtonPanel);
        statsButtonPanel.setLayout(statsButtonPanelLayout);
        statsButtonPanelLayout.setHorizontalGroup(
            statsButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        statsButtonPanelLayout.setVerticalGroup(
            statsButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        saveGamePanel.setBackground(new java.awt.Color(255, 255, 0));

        saveGameButton.setBackground(new java.awt.Color(255, 255, 0));
        saveGameButton.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        saveGameButton.setText(Text.saveGameButton);
        saveGameButton.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 2, 2, new java.awt.Color(0, 0, 0)));
        saveGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout saveGamePanelLayout = new javax.swing.GroupLayout(saveGamePanel);
        saveGamePanel.setLayout(saveGamePanelLayout);
        saveGamePanelLayout.setHorizontalGroup(
            saveGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saveGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        saveGamePanelLayout.setVerticalGroup(
            saveGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saveGameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButtonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryButtonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButtonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveGamePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statsButtonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(catPictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(catPictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(backButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventoryButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statsButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveGamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(inventoryButtonPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(catPictureLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(backButtonPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(exitButtonPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(statsButtonPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(saveGamePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ScreenNavigation.backButtonHandler();
    }//GEN-LAST:event_backButtonActionPerformed

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        ScreenNavigation.genericButtonHandler(InventoryViewport.getInstance());
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void statsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsButtonActionPerformed
        ScreenNavigation.genericButtonHandler(ExtendedStatsViewport.getInstance());
    }//GEN-LAST:event_statsButtonActionPerformed

    private void saveGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameButtonActionPerformed
        //ScreenNavigation.genericButtonHandler(SaveGameViewport.getInstance());
    }//GEN-LAST:event_saveGameButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        ScreenNavigation.exitToMainMenuButtonHandler();
    }//GEN-LAST:event_exitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel backButtonPanel;
    private javax.swing.JLabel catPictureLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel exitButtonPanel;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JPanel inventoryButtonPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton saveGameButton;
    private javax.swing.JPanel saveGamePanel;
    private javax.swing.JButton statsButton;
    private javax.swing.JPanel statsButtonPanel;
    // End of variables declaration//GEN-END:variables

}
