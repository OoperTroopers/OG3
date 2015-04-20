/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.statistics.Statistics;

/**
 *
 * @author Doherty
 */
public class ExtendedStatsViewport extends Viewport {

    private ActionListener backListener;  
    private Statistics stats;
    
    /**
     * Creates new form ExtendedStatsViewport
     */
    public ExtendedStatsViewport(ActionListener backListener, Statistics stats) {
        initComponents();
        this.stats = stats;
        this.backListener = backListener;
        backButton.addActionListener(this.backListener);
        updateLabels();       
        this.repaint();
    }
    
    @Override
    void visit(ViewportStack viewportStack) {
        viewportStack.add(this);
    }
    
    private void updateLabels() {
        healthLabel.setText(" " + stats.getCurrentHealth() + "/" + stats.getDerivedStats().getMaxHealth());
        manaLabel.setText(" " + stats.getCurrentMana() + "/" + stats.getDerivedStats().getMaxMana());
        livesLeftLabel.setText(" " + stats.getLivesLeft());
        
        strengthLabel.setText(" " + stats.getPrimaryStats().getStrength());
        agilityLabel.setText(" " + stats.getPrimaryStats().getAgility());
        intellectLabel.setText(" " + stats.getPrimaryStats().getIntellect());
        hardinessLabel.setText(" " + stats.getPrimaryStats().getHardiness());
        movementLabel.setText(" " + stats.getPrimaryStats().getMovement());
        
        offenseLabel.setText(" " + stats.getOffensiveRating());
        defenseLabel.setText(" " + stats.getDefensiveRating());
        armorLabel.setText(" " + stats.getArmorRating());
        
        goldLabel.setText(" " + stats.getCurrentGold());
        experienceLabel.setText(" " + stats.getCurrentExperience());
        levelLabel.setText(" " + stats.getCurrentLevel());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        healthLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        manaLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        livesLeftLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        strengthLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        agilityLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        intellectLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        hardinessLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        movementLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        offenseLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        defenseLabel = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        armorLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        goldLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        experienceLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Health: ");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        healthLabel.setBackground(new java.awt.Color(255, 0, 0));
        healthLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        healthLabel.setText(" 0");
        healthLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        healthLabel.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mana: ");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel3.setOpaque(true);

        manaLabel.setBackground(new java.awt.Color(255, 0, 0));
        manaLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        manaLabel.setText(" 0");
        manaLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        manaLabel.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(255, 0, 0));
        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Lives Left: ");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 3, 1, new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);

        livesLeftLabel.setBackground(new java.awt.Color(255, 0, 0));
        livesLeftLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        livesLeftLabel.setText(" 0");
        livesLeftLabel.setToolTipText("");
        livesLeftLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 4, new java.awt.Color(0, 0, 0)));
        livesLeftLabel.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(255, 255, 0));
        jLabel13.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Strength: ");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel13.setOpaque(true);

        strengthLabel.setBackground(new java.awt.Color(255, 255, 0));
        strengthLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        strengthLabel.setText(" 0");
        strengthLabel.setToolTipText("");
        strengthLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        strengthLabel.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(255, 255, 0));
        jLabel8.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Agility: ");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel8.setOpaque(true);

        agilityLabel.setBackground(new java.awt.Color(255, 255, 0));
        agilityLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        agilityLabel.setText(" 0");
        agilityLabel.setToolTipText("");
        agilityLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        agilityLabel.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(255, 255, 0));
        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Intellect: ");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel10.setOpaque(true);

        intellectLabel.setBackground(new java.awt.Color(255, 255, 0));
        intellectLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        intellectLabel.setText(" 0");
        intellectLabel.setToolTipText("");
        intellectLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        intellectLabel.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(255, 255, 0));
        jLabel12.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Hardiness: ");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel12.setOpaque(true);

        hardinessLabel.setBackground(new java.awt.Color(255, 255, 0));
        hardinessLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        hardinessLabel.setText(" 0");
        hardinessLabel.setToolTipText("");
        hardinessLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        hardinessLabel.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(255, 255, 0));
        jLabel16.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Movement: ");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 3, 1, new java.awt.Color(0, 0, 0)));
        jLabel16.setOpaque(true);

        movementLabel.setBackground(new java.awt.Color(255, 255, 0));
        movementLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        movementLabel.setText(" 0");
        movementLabel.setToolTipText("");
        movementLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 4, new java.awt.Color(0, 0, 0)));
        movementLabel.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(0, 255, 0));
        jLabel17.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Offensive Rating: ");
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel17.setOpaque(true);

        offenseLabel.setBackground(new java.awt.Color(0, 255, 0));
        offenseLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        offenseLabel.setText(" 0");
        offenseLabel.setToolTipText("");
        offenseLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        offenseLabel.setOpaque(true);

        jLabel19.setBackground(new java.awt.Color(0, 255, 0));
        jLabel19.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Defensive Rating: ");
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel19.setOpaque(true);

        defenseLabel.setBackground(new java.awt.Color(0, 255, 0));
        defenseLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        defenseLabel.setText(" 0");
        defenseLabel.setToolTipText("");
        defenseLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        defenseLabel.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(0, 255, 0));
        jLabel21.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Armor Rating: ");
        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 3, 1, new java.awt.Color(0, 0, 0)));
        jLabel21.setOpaque(true);

        armorLabel.setBackground(new java.awt.Color(0, 255, 0));
        armorLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        armorLabel.setText(" 0");
        armorLabel.setToolTipText("");
        armorLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 4, new java.awt.Color(0, 0, 0)));
        armorLabel.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(0, 255, 255));
        jLabel11.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Gold: ");
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel11.setOpaque(true);

        goldLabel.setBackground(new java.awt.Color(0, 255, 255));
        goldLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        goldLabel.setText(" 0");
        goldLabel.setToolTipText("");
        goldLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        goldLabel.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(0, 255, 255));
        jLabel7.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Experience: ");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);

        experienceLabel.setBackground(new java.awt.Color(0, 255, 255));
        experienceLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        experienceLabel.setText(" 0");
        experienceLabel.setToolTipText("");
        experienceLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 4, new java.awt.Color(0, 0, 0)));
        experienceLabel.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 255, 255));
        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Level: ");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 4, 4, 1, new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);

        levelLabel.setBackground(new java.awt.Color(0, 255, 255));
        levelLabel.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        levelLabel.setText(" 0");
        levelLabel.setToolTipText("");
        levelLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 4, 4, new java.awt.Color(0, 0, 0)));
        levelLabel.setOpaque(true);

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        backButton.setText("Back");
        backButton.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 1, 1, new java.awt.Color(0, 0, 0)));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("STATISTICS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(healthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(manaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(livesLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(strengthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(agilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(intellectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hardinessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(movementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(offenseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(defenseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(armorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(goldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(experienceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(livesLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strengthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intellectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hardinessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offenseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defenseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(armorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(experienceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agilityLabel;
    private javax.swing.JLabel armorLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel defenseLabel;
    private javax.swing.JLabel experienceLabel;
    private javax.swing.JLabel goldLabel;
    private javax.swing.JLabel hardinessLabel;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JLabel intellectLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel livesLeftLabel;
    private javax.swing.JLabel manaLabel;
    private javax.swing.JLabel movementLabel;
    private javax.swing.JLabel offenseLabel;
    private javax.swing.JLabel strengthLabel;
    // End of variables declaration//GEN-END:variables


}
