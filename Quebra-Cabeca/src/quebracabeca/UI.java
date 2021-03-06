
package quebracabeca;

import java.io.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;


/**
 *Object responsible for the UI
 *Instantiates the Game Object
 */
public class UI extends javax.swing.JFrame{
    
    JButton buttons[][]= new JButton[4][4];
    Game game = new Game();
    
    //Panel to show the Puzzle Answer
    javax.swing.JLabel lblAnswer;
    
    public UI() {
        initComponents();

        buttons[0][0]=jButton1;
        buttons[0][1]=jButton2;
        buttons[0][2]=jButton3;
        buttons[0][3]=jButton4;
        buttons[1][0]=jButton5;
        buttons[1][1]=jButton6;
        buttons[1][2]=jButton7;
        buttons[1][3]=jButton8;
        buttons[2][0]=jButton9;
        buttons[2][1]=jButton10;
        buttons[2][2]=jButton11;
        buttons[2][3]=jButton12;
        buttons[3][0]=jButton13;
        buttons[3][1]=jButton14;
        buttons[3][2]=jButton15;
        buttons[3][3]=jButton16;
        
        jTextArea1.setText(game.getRanking());
    }
    
    /**
     *Load images on the board.
     */
    private void loadImages(){
        int value;
        for(int i = 0; i<=3; i++){
            for(int j = 0; j<=3;j++){
                value = game.getRealValue(game.getPositionN(i,j));
                
                buttons[i][j].setText("");
                
                Icon icone = new ImageIcon(game.getImgFolder() + value + ".jpg");
                buttons[i][j].setIcon(icone);
            }
        }
        
        lblAnswer = new javax.swing.JLabel();
        jPanel1.add(lblAnswer, 0);
        lblAnswer.setBounds(10, 10, 240, 240);
        lblAnswer.setIcon(new ImageIcon(game.getImgFolder() + "Resultado.jpg"));
        lblAnswer.setVisible(false);
    }
    
    /**
     *Method to save the game in a disk.
     *@Throws saveGame, one exception can happen during the saving process.
     */
    private void saveGame(){        
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(this);
        System.out.println(returnVal);
        if(returnVal==0){           
            try {       
                File file = fc.getSelectedFile();
                FileOutputStream fOut = new FileOutputStream(file);
                ObjectOutputStream objOut = new ObjectOutputStream(fOut);
                objOut.writeObject(game);
            } catch (Exception e) {
                System.out.println("Error saving the game :" + e.getMessage());
                System.out.println(e.getCause());
            } 
        }
    }
    
    /**
     *M�thod to load the game saved on disk.
     *@return true if the game is properly loaded
     *@throws
     */            
    private boolean loadGame(){
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if(returnVal==0){
            try {
                File file = fc.getSelectedFile();
                FileInputStream fIn = new FileInputStream(file);
                ObjectInputStream objIn = new ObjectInputStream(fIn);
                game=(Game)objIn.readObject();
            } catch (Exception e) {
                System.out.println("Error loading file :" + e.getMessage());
                System.out.println(e.getCause());
            }
            return true;
        }
        return false;
    }
      
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton35 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("QUEBRA CABE�A DE M�O");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 590, 20);

        jButton36.setText("Limpar Ranking");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton36);
        jButton36.setBounds(300, 360, 290, 20);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(300, 140, 290, 220);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Ranking");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(300, 110, 290, 30);

        jButton31.setText("Novo Jogo");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton31);
        jButton31.setBounds(200, 80, 110, 23);

        jButton20.setText("Embaralhar Impar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton20);
        jButton20.setBounds(30, 80, 150, 23);

        jButton18.setText("Embaralhar Par");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton18);
        jButton18.setBounds(30, 60, 150, 23);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("1");
        jButton1.setFocusable(false);
        jButton1.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton1.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton1.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 60, 60);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("2");
        jButton2.setFocusable(false);
        jButton2.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton2.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton2.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(70, 10, 60, 60);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setText("3");
        jButton3.setFocusable(false);
        jButton3.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton3.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton3.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(130, 10, 60, 60);

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setText("4");
        jButton4.setFocusable(false);
        jButton4.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton4.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton4.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(190, 10, 60, 60);

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setText("5");
        jButton5.setFocusable(false);
        jButton5.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton5.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton5.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(10, 70, 60, 60);

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setText("6");
        jButton6.setFocusable(false);
        jButton6.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton6.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton6.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(70, 70, 60, 60);

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setText("7");
        jButton7.setFocusable(false);
        jButton7.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton7.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton7.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(130, 70, 60, 60);

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setText("8");
        jButton8.setFocusable(false);
        jButton8.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton8.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton8.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(190, 70, 60, 60);

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setText("9");
        jButton9.setFocusable(false);
        jButton9.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton9.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton9.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(10, 130, 60, 60);

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setText("10");
        jButton10.setFocusable(false);
        jButton10.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton10.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton10.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(70, 130, 60, 60);

        jButton15.setBackground(new java.awt.Color(204, 204, 204));
        jButton15.setText("15");
        jButton15.setFocusable(false);
        jButton15.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton15.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton15.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15);
        jButton15.setBounds(130, 190, 60, 60);

        jButton14.setBackground(new java.awt.Color(204, 204, 204));
        jButton14.setText("14");
        jButton14.setFocusable(false);
        jButton14.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton14.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton14.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14);
        jButton14.setBounds(70, 190, 60, 60);

        jButton13.setBackground(new java.awt.Color(204, 204, 204));
        jButton13.setText("13");
        jButton13.setFocusable(false);
        jButton13.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton13.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton13.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13);
        jButton13.setBounds(10, 190, 60, 60);

        jButton12.setBackground(new java.awt.Color(204, 204, 204));
        jButton12.setText("12");
        jButton12.setFocusable(false);
        jButton12.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton12.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton12.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12);
        jButton12.setBounds(190, 130, 60, 60);

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setText("11");
        jButton11.setFocusable(false);
        jButton11.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton11.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton11.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(130, 130, 60, 60);

        jButton16.setBackground(new java.awt.Color(204, 204, 204));
        jButton16.setFocusable(false);
        jButton16.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton16.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton16.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPieceActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16);
        jButton16.setBounds(190, 190, 60, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 110, 260, 260);

        jCheckBox1.setText("Visualizar resposta");
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBox1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseReleased(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(10, 370, 260, 15);

        jButton35.setText("Cancelar");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton35);
        jButton35.setBounds(180, 390, 100, 23);

        jButton21.setText("Salvar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton21);
        jButton21.setBounds(280, 390, 110, 23);

        jButton32.setText("Abrir Jogo");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton32);
        jButton32.setBounds(200, 50, 110, 23);

        setSize(new java.awt.Dimension(608, 457));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        saveGame();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        game.cleanRanking();
        jTextArea1.setText(game.getRanking());
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        game.startGame();
        selectImage();
        loadImages();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void selectImage()
    {
       String folder = new String();
        
        File path = new File(".");

        try {
            folder = path.getCanonicalPath() + "\\Imagens\\";
        } catch(Exception e) {
        }
        folder = folder + "Numeros";
        folder = folder + "\\";
        
        game.setImgFolder(folder);
    }
    
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        game.setShuffleTipe(2);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        game.setShuffleTipe(1);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButtonPieceActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPieceActionPerformed
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (evt.getSource() == buttons[i][j]) {
                    int valueTo, colTo, linTo;

                    valueTo = game.getMovePice(game.getPositionN(i, j));
                    
                    System.out.println("value TO = " + valueTo);

                    if (valueTo == -1) {
                        //Piece could not be moved!
                    } else if (valueTo == -2) {
                        //Winner!
                    } else {
                        colTo = game.getCol(valueTo);
                        linTo = game.getLine(valueTo);

                        Icon icone = buttons[linTo][colTo].getIcon();
                        buttons[linTo][colTo].setIcon(buttons[i][j].getIcon());
                        buttons[i][j].setIcon(icone);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonPieceActionPerformed

    
    private void jCheckBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MousePressed
        lblAnswer.setVisible(true);        
        jCheckBox1.setSelected(true);
    }//GEN-LAST:event_jCheckBox1MousePressed

    private void jCheckBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseReleased
        lblAnswer.setVisible(false);
        jCheckBox1.setSelected(false);
    }//GEN-LAST:event_jCheckBox1MouseReleased

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        loadGame();
        loadImages();
    }//GEN-LAST:event_jButton32ActionPerformed
                                                                                    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
}
