/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package votecounter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.JOptionPane;

/**
 *
 * @author shardul
 */
public class VoteCounter extends javax.swing.JFrame {

    private static int step = 0;
    private static int voters = 0;
    private static final int CATEGORIES = 6;
    private static final int CANDIDATES = 4;
    private static String house;
    private final static String[] categories = {"Head Boy", "Head Girl", "Sports Prefect Boy", "Sports Prefect Girl", "House Captain", "House Vice Captain"};
    private final static String[] houseOptions = {"Jaguar", "Sher", "Puma", "Cheetah"};
    private final static String[] headBoy = {"Arjun", "Beena", "Chhaya", "Dhruv"};
    private final static String[] headGirl = {"Arjun", "Beena", "Chhaya", "Dhruv"};
    private final static String[] sportsBoy = {"Arjun", "Beena", "Chhaya", "Dhruv"};
    private final static String[] sportsGirl = {"Arjun", "Beena", "Chhaya", "Dhruv"};
    private final static String[][] houseCaptain = {{"Arjun", "Beena", "Chhaya", "Dhruv"},
        {"Arjun", "Beena", "Chhaya", "Dhruv"},
        {"Arjun", "Beena", "Chhaya", "Dhruv"},
        {"Arjun", "Beena", "Chhaya", "Dhruv"}};
    private final static String[][] houseViceCaptain = {{"Arjun", "Beena", "Chhaya", "Dhruv"},
        {"Arjun", "Beena", "Chhaya", "Dhruv"},
        {"Arjun", "Beena", "Chhaya", "Dhruv"},
        {"Arjun", "Beena", "Chhaya", "Dhruv"}};
    private static String[][] nominees = {headBoy, headGirl, sportsBoy, sportsGirl,
        houseCaptain[0], houseCaptain[1], houseCaptain[2], houseCaptain[3],
        houseViceCaptain[0], houseViceCaptain[1], houseViceCaptain[2], houseViceCaptain[3]};
    private static int[][] votes = new int[12][CANDIDATES];
    private static String[][] options = new String[CATEGORIES][CANDIDATES];
    private static final long serialVersionUID = 1L;
    private static final Path path = Paths.get("results.txt");

    /**
     * Creates new form VoteCounter
     */
    public VoteCounter() {
        initComponents();
        chooseHouse();
        initOptions();
        showOptions();
    }

    private void writeFile (String text) {
        try (BufferedWriter bw = Files.newBufferedWriter(path, java.nio.charset.StandardCharsets.UTF_8, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            bw.write(text);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    private void chooseHouse() {
        house = (String) JOptionPane.showInputDialog(this, "Choose your house:", "Choose House", JOptionPane.PLAIN_MESSAGE, null, houseOptions, "Jaguar");
        if (house != null) {
            voters++;
        }
    }

    private void initOptions() {
        for (int i = 0; i < CATEGORIES; i++) {
            for (int j = 0; j < CANDIDATES; j++) {
                switch (i) {
                    case 0:
                        options[i][j] = headBoy[j];
                        break;
                    case 1:
                        options[i][j] = headGirl[j];
                        break;
                    case 2:
                        options[i][j] = sportsBoy[j];
                        break;
                    case 3:
                        options[i][j] = sportsGirl[j];
                        break;
                    case 4:
                        switch (house) {
                            case "Jaguar":
                                options[i][j] = houseCaptain[0][j];
                                break;
                            case "Sher":
                                options[i][j] = houseCaptain[1][j];
                                break;
                            case "Puma":
                                options[i][j] = houseCaptain[2][j];
                                break;
                            case "Cheetah":
                                options[i][j] = houseCaptain[3][j];
                                break;
                        }
                        break;
                    case 5:
                        switch (house) {
                            case "Jaguar":
                                options[i][j] = houseViceCaptain[0][j];
                                break;
                            case "Sher":
                                options[i][j] = houseViceCaptain[1][j];
                                break;
                            case "Puma":
                                options[i][j] = houseViceCaptain[2][j];
                                break;
                            case "Cheetah":
                                options[i][j] = houseViceCaptain[3][j];
                                break;
                        }
                        break;
                }
            }
//            results[i] = Paths.get(categories[i].concat(".txt"));
        }
    }

    private void showOptions() {
        category.setText(categories[step]);
        opt0.setText(options[step][0]);
        opt1.setText(options[step][1]);
        opt2.setText(options[step][2]);
        opt3.setText(options[step][3]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        introPane = new javax.swing.JScrollPane();
        intro = new javax.swing.JTextArea();
        category = new javax.swing.JLabel();
        opt0 = new javax.swing.JButton();
        opt1 = new javax.swing.JButton();
        opt2 = new javax.swing.JButton();
        opt3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        choose = new javax.swing.JMenuItem();
        show = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        intro.setEditable(false);
        intro.setBackground(new java.awt.Color(238, 238, 238));
        intro.setColumns(20);
        intro.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        intro.setLineWrap(true);
        intro.setRows(4);
        intro.setText("Welcome to the voting program! Click on the name you would like to vote for in the category displayed. Thank you!");
        intro.setWrapStyleWord(true);
        intro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        introPane.setViewportView(intro);

        category.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        category.setText("Category");

        opt0.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        opt0.setText("One");
        opt0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt0ActionPerformed(evt);
            }
        });

        opt1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        opt1.setText("Two");
        opt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1ActionPerformed(evt);
            }
        });

        opt2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        opt2.setText("Three");
        opt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt2ActionPerformed(evt);
            }
        });

        opt3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        opt3.setText("Four");
        opt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        choose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        choose.setText("Next Voter");
        choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseActionPerformed(evt);
            }
        });
        jMenu1.add(choose);

        show.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        show.setText("Show Results");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        jMenu1.add(show);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(introPane)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opt0)
                    .addComponent(opt2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(opt3)
                    .addComponent(opt1))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(category)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(introPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(category)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opt0)
                    .addComponent(opt1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opt2)
                    .addComponent(opt3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opt0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt0ActionPerformed
        // record vote

        switch (category.getText()) {
            case "Head Boy":
                votes[0][0]++;
                break;
            case "Head Girl":
                votes[1][0]++;
                break;
            case "Sports Prefect Boy":
                votes[2][0]++;
                break;
            case "Sports Prefect Girl":
                votes[3][0]++;
                break;
            case "House Captain":
                switch (house) {
                    case "Jaguar":
                        votes[4][0]++;
                        break;
                    case "Sher":
                        votes[5][0]++;
                        break;
                    case "Puma":
                        votes[6][0]++;
                        break;
                    case "Cheetah":
                        votes[7][0]++;
                        break;
                }
                break;
            case "House Vice Captain":
                switch (house) {
                    case "Jaguar":
                        votes[8][0]++;
                        break;
                    case "Sher":
                        votes[9][0]++;
                        break;
                    case "Puma":
                        votes[10][0]++;
                        break;
                    case "Cheetah":
                        votes[11][0]++;
                        break;
                }
                break;
        }

        step++;
        if (step == 6) {
            JOptionPane.showMessageDialog(this, "Thank You! Your votes have been recorded.", "Exit", JOptionPane.INFORMATION_MESSAGE);
            step = 0;
            chooseHouse();
        }

        if (house != null) {
            initOptions();
            showOptions();
        }
    }//GEN-LAST:event_opt0ActionPerformed

    private void opt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1ActionPerformed
        // record vote
        switch (category.getText()) {
            case "Head Boy":
                votes[0][1]++;
                break;
            case "Head Girl":
                votes[1][1]++;
                break;
            case "Sports Prefect Boy":
                votes[2][1]++;
                break;
            case "Sports Prefect Girl":
                votes[3][1]++;
                break;
            case "House Captain":
                switch (house) {
                    case "Jaguar":
                        votes[4][1]++;
                        break;
                    case "Sher":
                        votes[5][1]++;
                        break;
                    case "Puma":
                        votes[6][1]++;
                        break;
                    case "Cheetah":
                        votes[7][1]++;
                        break;
                }
                break;
            case "House Vice Captain":
                switch (house) {
                    case "Jaguar":
                        votes[8][1]++;
                        break;
                    case "Sher":
                        votes[9][1]++;
                        break;
                    case "Puma":
                        votes[10][1]++;
                        break;
                    case "Cheetah":
                        votes[11][1]++;
                        break;
                }
                break;
        }

        step++;
        if (step == 6) {
            JOptionPane.showMessageDialog(this, "Thank You! Your votes have been recorded.", "Exit", JOptionPane.INFORMATION_MESSAGE);
            step = 0;
            chooseHouse();
        }

        if (house != null) {
            initOptions();
            showOptions();
        }
    }//GEN-LAST:event_opt1ActionPerformed

    private void opt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt2ActionPerformed
        // record vote
        switch (category.getText()) {
            case "Head Boy":
                votes[0][2]++;
                break;
            case "Head Girl":
                votes[1][2]++;
                break;
            case "Sports Prefect Boy":
                votes[2][2]++;
                break;
            case "Sports Prefect Girl":
                votes[3][2]++;
                break;
            case "House Captain":
                switch (house) {
                    case "Jaguar":
                        votes[4][2]++;
                        break;
                    case "Sher":
                        votes[5][2]++;
                        break;
                    case "Puma":
                        votes[6][2]++;
                        break;
                    case "Cheetah":
                        votes[7][2]++;
                        break;
                }
                break;
            case "House Vice Captain":
                switch (house) {
                    case "Jaguar":
                        votes[8][2]++;
                        break;
                    case "Sher":
                        votes[9][2]++;
                        break;
                    case "Puma":
                        votes[10][2]++;
                        break;
                    case "Cheetah":
                        votes[11][2]++;
                        break;
                }
                break;
        }

        step++;
        if (step == 6) {
            JOptionPane.showMessageDialog(this, "Thank You! Your votes have been recorded.", "Exit", JOptionPane.INFORMATION_MESSAGE);
            step = 0;
            chooseHouse();
        }

        if (house != null) {
            initOptions();
            showOptions();
        }
    }//GEN-LAST:event_opt2ActionPerformed

    private void opt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt3ActionPerformed
        // record vote
        switch (category.getText()) {
            case "Head Boy":
                votes[0][3]++;
                break;
            case "Head Girl":
                votes[1][3]++;
                break;
            case "Sports Prefect Boy":
                votes[2][3]++;
                break;
            case "Sports Prefect Girl":
                votes[3][3]++;
                break;
            case "House Captain":
                switch (house) {
                    case "Jaguar":
                        votes[4][3]++;
                        break;
                    case "Sher":
                        votes[5][3]++;
                        break;
                    case "Puma":
                        votes[6][3]++;
                        break;
                    case "Cheetah":
                        votes[7][3]++;
                        break;
                }
                break;
            case "House Vice Captain":
                switch (house) {
                    case "Jaguar":
                        votes[8][3]++;
                        break;
                    case "Sher":
                        votes[9][3]++;
                        break;
                    case "Puma":
                        votes[10][3]++;
                        break;
                    case "Cheetah":
                        votes[11][3]++;
                        break;
                }
                break;
        }

        step++;
        if (step == 6) {
            JOptionPane.showMessageDialog(this, "Thank You! Your votes have been recorded.", "Exit", JOptionPane.INFORMATION_MESSAGE);
            step = 0;
            chooseHouse();
        }

        if (house != null) {
            initOptions();
            showOptions();
        }
    }//GEN-LAST:event_opt3ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        writeFile("Number of voters: " + voters);
        writeFile("");
        writeFile("");
        
        for (int i = 0; i < 12; i++) {
            switch (i) {
                case 0:
                    writeFile("Head Boy:");
                    break;
                case 1:
                    writeFile("Head Girl:");
                    break;
                case 2:
                    writeFile("Sports Prefect Boy:");
                    break;
                case 3:
                    writeFile("Sports Prefect Girl:");
                    break;
                case 4:
                    writeFile("Jaguar House Captain:");
                    break;
                case 5:
                    writeFile("Sher House Captain:");
                    break;
                case 6:
                    writeFile("Puma House Captain:");
                    break;
                case 7:
                    writeFile("Cheetah House Captain:");
                    break;
                case 8:
                    writeFile("Jaguar House Vice Captain:");
                    break;
                case 9:
                    writeFile("Sher House Vice Captain:");
                    break;
                case 10:
                    writeFile("Puma House Vice Captain:");
                    break;
                case 11:
                    writeFile("Cheetah House Vice Captain:");
                    break;
            }
            for (int j = 0; j < CANDIDATES; j++) {
                writeFile(nominees[i][j] + " -- " + votes[i][j]);
            }
            writeFile("");
            writeFile("");
        }
    }//GEN-LAST:event_showActionPerformed

    private void chooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseActionPerformed
        chooseHouse();
        initOptions();
        showOptions();
    }//GEN-LAST:event_chooseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VoteCounter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteCounter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteCounter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteCounter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VoteCounter().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel category;
    private javax.swing.JMenuItem choose;
    private javax.swing.JMenuItem exit;
    private javax.swing.JTextArea intro;
    private javax.swing.JScrollPane introPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton opt0;
    private javax.swing.JButton opt1;
    private javax.swing.JButton opt2;
    private javax.swing.JButton opt3;
    private javax.swing.JMenuItem show;
    // End of variables declaration//GEN-END:variables
}
