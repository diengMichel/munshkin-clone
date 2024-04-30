package GUI;

import midiwar.Treasure;
import midiwar.TreasureKind;

public class TreasureView extends javax.swing.JPanel {

    private Treasure treasureModel;
    private boolean selected = false;
    
    /*
    * Refreshs the view to the model indicated
    */
    public void setTreasure (Treasure t)
    {
        treasureModel = t;
        treasureName.setText(treasureModel.getName());
        
        TreasureKind type = treasureModel.getType();
        
        switch (type)
        {
            case ONEHAND:
                treasureKind.setText("ONE HAND");
                break;
            case BOTHHANDS:
                treasureKind.setText("BOTH HANDS");
                break;
            case SHOES:
                treasureKind.setText("SHOES");
                break;
            case HELMET:
                treasureKind.setText("HELMET");
                break;
            case ARMOR:
                treasureKind.setText("ARMOR");
                break;
        }
        
        level.setText(Integer.toString(treasureModel.getBonus()));
        repaint();
    }
    
    /*
    Returns if the treasure is selected by the user
    */
    public boolean isSelected ()
    {
        return selected;
    }
    
    /*
    Returns this treasure
    */
    public Treasure getTreasure()
    {
        return treasureModel;
    }
    
    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treasureName = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        level = new javax.swing.JLabel();
        treasureKind = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(59, 50));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setBorder(null);

        treasureName.setEditable(false);
        treasureName.setBackground(new java.awt.Color(204, 204, 204));
        treasureName.setColumns(20);
        treasureName.setLineWrap(true);
        treasureName.setRows(3);
        treasureName.setText("text");
        treasureName.setWrapStyleWord(true);
        treasureName.setBorder(null);
        treasureName.setFocusable(false);
        jScrollPane1.setViewportView(treasureName);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        level.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        level.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level.setText("Lvl");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(level, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(level)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        treasureKind.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        treasureKind.setText("Type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(treasureKind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(treasureKind)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (selected)
        {
            selected = false;
            setBackground(new java.awt.Color(204,204,204));
            jPanel1.setBackground(new java.awt.Color(204,204,204));
            jPanel3.setBackground(new java.awt.Color(204,204,204));
            treasureName.setBackground(new java.awt.Color(204,204,204));
            repaint();
        }
        else
        {
            selected = true;
            setBackground(new java.awt.Color(153,204,255));
            jPanel1.setBackground(new java.awt.Color(153,204,255));
            jPanel3.setBackground(new java.awt.Color(153,204,255));
            treasureName.setBackground(new java.awt.Color(153,204,255));
            repaint();
        }
            
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel level;
    private javax.swing.JLabel treasureKind;
    private javax.swing.JTextArea treasureName;
    // End of variables declaration//GEN-END:variables
}
