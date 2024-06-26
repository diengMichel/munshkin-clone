package GUI;

import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JPanel;
import midiwar.CultistPlayer;
import midiwar.Midiwar;
import midiwar.Player;
import midiwar.Treasure;

import javax.swing.JOptionPane;

public class PlayerView extends javax.swing.JPanel {

    private Player playerModel;
    private Midiwar midiwarModel;
    
    public void setPlayer (Player p)
    {
        playerModel = p;
        
        playerName.setText(playerModel.getName());
        playerLevel.setText(Integer.toString(playerModel.getLevels()));
        combatLevel.setText(Integer.toString(playerModel.getCombatLevel()));
        
        boolean canSteal = playerModel.canISteal();
        String stealText;
        
        if (canSteal)
        {
            stealText = "You CAN steal from " + playerModel.getEnemy();
        }
        else
        {
            stealText = "You CANNOT steal";
        }
        ableToSteal.setText(stealText);
        
        pendingBadConsequence.setPendingBadConsequenceView(p.getPendingBadConsequence());
                
        if (playerModel instanceof CultistPlayer)
            isCultist.setText("CULTIST player");
        else
            isCultist.setText("STANDARD player");
        
        numberOfCultists.setText(Integer.toString(CultistPlayer.getTotalCultistPlayers()));
        
        this.fillTreasurePanel(visibleTreasures,playerModel.getVisibleTreasures());
        this.fillTreasurePanel(hiddenTreasures,playerModel.getHiddenTreasures());
        
        // Buttons
        discardButton.setEnabled(true);
        discardAllButton.setEnabled(true);
        makeVisibleButton.setEnabled(true);
        
        if (playerModel.getHiddenTreasures().isEmpty())
        {
            makeVisibleButton.setEnabled(false);
            if (playerModel.getVisibleTreasures().isEmpty()) {
                discardButton.setEnabled(false);
                discardAllButton.setEnabled(false);
            }
        }
        
        repaint();
        revalidate();
    }
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) 
    {
        aPanel.removeAll();
        
        for (Treasure t : aList) {
           TreasureView aTreasureView = new TreasureView();
           aTreasureView.setTreasure (t);
           aTreasureView.setVisible (true);
           aPanel.add (aTreasureView);
        }
        
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    /*
    Setter for midiwarModel
    */
    public void setMidiwarModel(Midiwar n)
    {
        midiwarModel = n;
    }
    
    /*
    * Returns an ArrayList with the selected treasures
    */
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel)
    {
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        
        for (Component c : aPanel.getComponents())
        {
           tv = (TreasureView) c;
           if (tv.isSelected())
              output.add (tv.getTreasure());
        }
        
        return output;
    }
    
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
        playerCPImg.setBackground("src/images/PlayerCPBackground.png");
        repaint();
    }
    
    public void ChangeStealButton (boolean value)
    {
        if (value)
        {
            if (playerModel.canISteal())
                stealButton.setEnabled(true);
        }
        else
            stealButton.setEnabled(false);
    }
    
    public void ChangeMakeVisibleButton (boolean value)
    {
        if (value) {
            if (playerModel.getHiddenTreasures().size() > 0)
                makeVisibleButton.setEnabled(true);
        }
        else
            makeVisibleButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        isCultist = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        totalCultistsText = new javax.swing.JLabel();
        numberOfCultists = new javax.swing.JLabel();
        stealButton = new javax.swing.JButton();
        makeVisibleButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        discardAllButton = new javax.swing.JButton();
        ableToSteal = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        playerCPImg = new utilities.JPanelBackground();
        player_attributes = new javax.swing.JPanel();
        playerLevelLabel = new javax.swing.JLabel();
        combatLevelLabel = new javax.swing.JLabel();
        playerLevel = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        pendingBadConsequence = new GUI.PendingBadConsequenceView();

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));

        isCultist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        isCultist.setText("Cultist Player?");

        visibleTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Visible treasures", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(153, 153, 153))); // NOI18N
        visibleTreasures.setPreferredSize(new java.awt.Dimension(538, 169));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Hidden treasures", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(153, 153, 153))); // NOI18N
        hiddenTreasures.setPreferredSize(new java.awt.Dimension(567, 169));

        totalCultistsText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalCultistsText.setText("Total number of cultists:");

        numberOfCultists.setText("0");

        stealButton.setText("Steal Treasure");
        stealButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealButtonActionPerformed(evt);
            }
        });

        makeVisibleButton.setText("Make Visible");
        makeVisibleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleButtonActionPerformed(evt);
            }
        });

        discardButton.setText("Discard Treasure");
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        discardAllButton.setText("Discard All Treasures");
        discardAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllButtonActionPerformed(evt);
            }
        });

        ableToSteal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ableToSteal.setText("Can I steal?");

        playerName.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        playerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerName.setText("Name");

        player_attributes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        player_attributes.setOpaque(false);

        playerLevelLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        playerLevelLabel.setForeground(new java.awt.Color(51, 204, 255));
        playerLevelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerLevelLabel.setText("Player level");

        combatLevelLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        combatLevelLabel.setForeground(new java.awt.Color(51, 204, 255));
        combatLevelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        combatLevelLabel.setText("Combat level");

        playerLevel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        playerLevel.setForeground(new java.awt.Color(51, 204, 255));
        playerLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerLevel.setText("0");

        combatLevel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        combatLevel.setForeground(new java.awt.Color(51, 204, 255));
        combatLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        combatLevel.setText("0");

        javax.swing.GroupLayout player_attributesLayout = new javax.swing.GroupLayout(player_attributes);
        player_attributes.setLayout(player_attributesLayout);
        player_attributesLayout.setHorizontalGroup(
            player_attributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player_attributesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player_attributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(player_attributesLayout.createSequentialGroup()
                        .addGroup(player_attributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(playerLevelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(playerLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(player_attributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(player_attributesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(combatLevelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(player_attributesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combatLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(player_attributesLayout.createSequentialGroup()
                        .addComponent(pendingBadConsequence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        player_attributesLayout.setVerticalGroup(
            player_attributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player_attributesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(player_attributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerLevelLabel)
                    .addComponent(combatLevelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(player_attributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pendingBadConsequence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout playerCPImgLayout = new javax.swing.GroupLayout(playerCPImg);
        playerCPImg.setLayout(playerCPImgLayout);
        playerCPImgLayout.setHorizontalGroup(
            playerCPImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(player_attributes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        playerCPImgLayout.setVerticalGroup(
            playerCPImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(player_attributes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(isCultist, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ableToSteal, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(totalCultistsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberOfCultists))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(discardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stealButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(discardAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, Short.MAX_VALUE)
                                        .addComponent(makeVisibleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(playerCPImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerCPImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(makeVisibleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(stealButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(discardAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isCultist)
                    .addComponent(ableToSteal)
                    .addComponent(totalCultistsText, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfCultists))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeVisibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleButtonActionPerformed
        ArrayList selHidden = getSelectedTreasures(hiddenTreasures);
        midiwarModel.makeTreasuresVisible(selHidden);
        setPlayer(midiwarModel.getCurrentPlayer());
        
        if (playerModel.getHiddenTreasures().size() == 0)
            makeVisibleButton.setEnabled(false);
    }//GEN-LAST:event_makeVisibleButtonActionPerformed
    
    private void stealButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealButtonActionPerformed
        Treasure stolen = playerModel.stealTreasure();
        
        GeneralDialog generalDialog = new GeneralDialog(null, false);
        if (stolen == null)
        {
            generalDialog.setGeneralDialog("There are no treasures to steal.", "Error", 'e');
        }
        else
        {
            setPlayer(midiwarModel.getCurrentPlayer());
            stealButton.setEnabled(false);
            generalDialog.setGeneralDialog("You have stolen: " + stolen.getName(), "Treasure stolen", 'i');
            makeVisibleButton.setEnabled(true);
        }
        
        generalDialog.setVisible(true);
    }//GEN-LAST:event_stealButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        ArrayList selectedHidden = getSelectedTreasures(hiddenTreasures);
        ArrayList selectedVisible = getSelectedTreasures(visibleTreasures);
        
        for (Object aTreasure : selectedHidden)
            playerModel.discardHiddenTreasure((Treasure) aTreasure);
        for (Object aTreasure : selectedVisible)
            playerModel.discardVisibleTreasure((Treasure) aTreasure);
        
        setPlayer(midiwarModel.getCurrentPlayer());
        
        if ((playerModel.getHiddenTreasures().size() == 0) &&
                playerModel.getVisibleTreasures().size() == 0)
        {
            discardButton.setEnabled(false);
            discardAllButton.setEnabled(false);
        }
    }//GEN-LAST:event_discardButtonActionPerformed

    private void discardAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllButtonActionPerformed
        playerModel.discardAllTreasures();
        setPlayer(midiwarModel.getCurrentPlayer());
        
        discardAllButton.setEnabled(false);
        discardButton.setEnabled(false);
        makeVisibleButton.setEnabled(false);
    }//GEN-LAST:event_discardAllButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ableToSteal;
    private javax.swing.JLabel combatLevel;
    private javax.swing.JLabel combatLevelLabel;
    private javax.swing.JButton discardAllButton;
    private javax.swing.JButton discardButton;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel isCultist;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton makeVisibleButton;
    private javax.swing.JLabel numberOfCultists;
    private GUI.PendingBadConsequenceView pendingBadConsequence;
    private utilities.JPanelBackground playerCPImg;
    private javax.swing.JLabel playerLevel;
    private javax.swing.JLabel playerLevelLabel;
    private javax.swing.JLabel playerName;
    private javax.swing.JPanel player_attributes;
    private javax.swing.JButton stealButton;
    private javax.swing.JLabel totalCultistsText;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
