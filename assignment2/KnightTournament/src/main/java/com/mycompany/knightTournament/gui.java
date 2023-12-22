/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.knightTournament;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

//for(int i = 0; i < boardSize; i++){
//    for (int j = 0; j < boardSize; j++) {
//        originalColors[i][j] = Color.YELLOW;
//    }
//}

/**
 *
 * @author uewashuuwa
 */


public class gui extends javax.swing.JFrame {

    private int boardSize;
    private JLabel[][] labels; 
    private int whiteKnightRow;
    private int whiteKnightCol;
    private int blackKnightRow;
    private int blackKnightCol;
    private Color[][] originalColors;
    private int count = 0;
    /**
     * Creates new form gui
     */
    public gui() {
        initComponents();
        boardSize = BoardSizePrompt.promptForBoardSize();
        createGridLabels();
        adjustGuiSize();
  
       
        whiteKnightRow = 0;
        whiteKnightCol = 0;
        blackKnightRow = boardSize-1;
        blackKnightCol = boardSize-1;
        
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move the cursor to the cell above
                if (currentRow > 0) {
                    moveCursor(currentRow - 1, currentCol);
                }
            }
        });
        
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move the cursor to the cell on the right
                if (currentCol < boardSize - 1) {
                    moveCursor(currentRow, currentCol + 1);
                }
            }
        });
        
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move the cursor to the cell below
                if (currentRow < boardSize - 1) {
                    moveCursor(currentRow + 1, currentCol);
                }
            }
        });
        
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move the cursor to the cell on the left
                if (currentCol > 0) {
                    moveCursor(currentRow, currentCol - 1);
                }
            }
        });
        
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move the cursor to the cell on the left
                if(count % 2 == 0){
                    moveWhiteKnight();
                }
                else{
                    moveBlackKnight();
                }
            }
        });
    }

    private void createGridLabels() {
        jPanel1.setLayout(new GridLayout(boardSize, boardSize));
        labels = new JLabel[boardSize][boardSize];
        originalColors = new Color[boardSize][boardSize];  // 新しく追加

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                labels[i][j] = new JLabel("", SwingConstants.CENTER);
                labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                labels[i][j].setOpaque(true);

                // 各セルの元の色を保存
                originalColors[i][j] = Color.GRAY;

                labels[i][j].setBackground(originalColors[i][j]);
                labels[i][j].setPreferredSize(new Dimension(50, 50));
                jPanel1.add(labels[i][j]);
            }
        }
        labels[0][0].setBackground(Color.YELLOW);

        labels[0][0].setIcon(createCircleIcon(Color.WHITE));
        originalColors[0][0] = Color.WHITE;

        // 黒いナイトをlabels[n-1][n-1]に配置
        labels[boardSize - 1][boardSize - 1].setBackground(Color.BLACK);
        labels[boardSize - 1][boardSize - 1].setIcon(createCircleIcon(Color.BLACK));
        originalColors[boardSize - 1][boardSize - 1] = Color.BLACK;
        
//        for(int i = 0; i < boardSize; i++){
//            for (int j = 0; j < boardSize; j++) {
//                originalColors[i][j] = Color.YELLOW;
//                labels[i][j].setBackground(Color.YELLOW);
//            }
//        }
    }
    
    private ImageIcon createCircleIcon(Color color) {
      int size = 50;  // Circle size
      BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2d = image.createGraphics();

      // Draw the circle with the specified color
      g2d.setColor(color);
      g2d.fillOval(0, 0, size, size);

      // Draw a red border around the circle
      g2d.setColor(Color.RED);
      g2d.drawOval(0, 0, size - 1, size - 1);

      g2d.dispose();
      return new ImageIcon(image);
    }
    
    private void adjustGuiSize() {
        int preferredSize = 8 * 70; // Assuming each cell is 50x50
        int margin = 100; // Additional margin
        int totalSize = preferredSize + margin;

        setSize(totalSize, totalSize);
    }

    private int currentRow = 0;
    private int currentCol = 0;

    private void moveCursor(int newRow, int newCol) {
    // Reset the background color of the current label to its original color
        labels[currentRow][currentCol].setBackground(originalColors[currentRow][currentCol]);

        // Update the current row and column
        currentRow = newRow;
        currentCol = newCol;

        // Set a different background color for the new label to indicate the cursor
        labels[currentRow][currentCol].setBackground(Color.YELLOW);
    }
    
    private void moveWhiteKnight() {
        // Update the white knight coordinates
        int rowDiff = Math.abs(currentRow - whiteKnightRow);
        int colDiff = Math.abs(currentCol - whiteKnightCol);
        if(rowDiff < 3 && colDiff < 3 && rowDiff + colDiff == 3){
            // Remove the icon from the current position and set background color to white
            labels[whiteKnightRow][whiteKnightCol].setIcon(null);
            whiteKnightRow = currentRow;
            whiteKnightCol = currentCol;

            // Set the icon to the new position
            labels[whiteKnightRow][whiteKnightCol].setIcon(createCircleIcon(Color.WHITE));
            labels[whiteKnightRow][whiteKnightCol].setBackground(Color.WHITE);
            originalColors[whiteKnightRow][whiteKnightCol] = Color.WHITE;
            count++;
            moveCursor(blackKnightRow, blackKnightCol);
            check(whiteKnightRow, whiteKnightCol);
        }
    }
    
    private void moveBlackKnight() {
        int rowDiff = Math.abs(currentRow - blackKnightRow);
        int colDiff = Math.abs(currentCol - blackKnightCol);
        if(rowDiff < 3 && colDiff < 3 && rowDiff + colDiff == 3){
            // Remove the icon from the current position and set background color to black
            labels[blackKnightRow][blackKnightCol].setIcon(null);
        
            // Update the black knight coordinates
            blackKnightRow = currentRow;
            blackKnightCol = currentCol;

            // Set the icon to the new position
            labels[blackKnightRow][blackKnightCol].setIcon(createCircleIcon(Color.BLACK));
            labels[blackKnightRow][blackKnightCol].setBackground(Color.BLACK);
            originalColors[blackKnightRow][blackKnightCol] = Color.BLACK ;
            count++;
            moveCursor(whiteKnightRow, whiteKnightCol);
            check(blackKnightRow, blackKnightCol);
        }
    }
    
    private void check(int row, int col){
        checkChain(row, col);
        checkIsAllNotGray();
    }
    
    private void checkIsAllNotGray(){
        int grayCount = 0;
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(originalColors[i][j] == Color.GRAY){
                    grayCount += 1;
                }
            }
        }
        
        if(grayCount == 0){
            finishGame(Color.GRAY);
        }
    }
    
    private void checkChain(int row, int col){
        List<int[]> coordinates = new ArrayList<>();
        
        checkAroundCell(row, col, coordinates);
        if(coordinates.size() >= 4){
            finishGame(originalColors[row][col]);
        }
    }
    
    private void finishGame(Color color){
        String winner;
        if(color == Color.BLACK){
            winner = "black";
        }else if(color == Color.WHITE){
            winner = "white";
        }else{
            winner = "gray";
        }
        String message;
        if("gray".equals(winner)){
            message = "draw \nDo you want to restart the game?";
        }
        else{
            message = "Winner: " + winner + "\nDo you want to restart the game?";
        }

        int choice = JOptionPane.showOptionDialog(
                this, message, "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, new Object[]{"Restart", "Exit"}, "Restart");

        if (choice == JOptionPane.YES_OPTION) {
            restartGame();
        } else {
            System.exit(0);
        }
    }
    
    private void restartGame() {
        // ここでゲームをリセットする処理を追加
        count = 0;
        // 他の必要なリセット処理を追加するかもしれません
        // ...

        // 画面上の表示もリセットする必要がある場合
        resetBoard();
    }

    // resetBoard メソッドの追加
    private void resetBoard() {
        // ボードの状態を初期化
        for(int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++) {
                originalColors[i][j] = Color.GRAY;
            }
        }
        originalColors[0][0] = Color.WHITE;
        originalColors[boardSize-1][boardSize-1] = Color.BLACK;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                labels[i][j].setIcon(null);
                labels[i][j].setBackground(originalColors[i][j]);
            }
        }

        // ナイトの初期位置を再設定
        whiteKnightRow = 0;
        whiteKnightCol = 0;
        blackKnightRow = boardSize - 1;
        blackKnightCol = boardSize - 1;

        labels[0][0].setIcon(createCircleIcon(Color.WHITE));
        labels[boardSize - 1][boardSize - 1].setIcon(createCircleIcon(Color.BLACK));

        // カーソルの初期位置を再設定
        moveCursor(0, 0);

        // ゲームの状態に応じて必要な初期化処理を追加
        // ...
    }
    
    private void checkAroundCell(int row, int col, List<int[]> coordinates){
        if(!containsCell(coordinates ,new int[]{row, col})){
            coordinates.add(new int[]{row, col});
            Color color = originalColors[row][col];
            
            if(isValidCell(row-1, col) && originalColors[row-1][col] == color){
                checkAroundCell(row-1, col, coordinates);
            }
            if(isValidCell(row+1, col) && originalColors[row+1][col] == color){
                checkAroundCell(row+1, col, coordinates);
            }
            if(isValidCell(row, col-1) && originalColors[row][col-1] == color){
                checkAroundCell(row, col-1, coordinates);
            }
            if(isValidCell(row, col+1) && originalColors[row][col+1] == color){
                checkAroundCell(row, col+1, coordinates);
            }
            if(isValidCell(row-1, col-1) && originalColors[row-1][col-1] == color){
                checkAroundCell(row-1, col-1, coordinates);
            }   
            if(isValidCell(row-1, col+1) && originalColors[row-1][col+1] == color){
                checkAroundCell(row-1, col+1, coordinates);
            }
            if(isValidCell(row+1, col-1) && originalColors[row+1][col-1] == color){
                checkAroundCell(row+1, col-1, coordinates);
            }
            if(isValidCell(row+1, col+1) && originalColors[row+1][col+1] == color){
                checkAroundCell(row+1, col+1, coordinates);
            }
        }
    }
    
    private boolean containsCell(List<int[]> coordinates, int[] cell) {
        for (int[] c : coordinates) {
            if (Arrays.equals(c, cell)) {
                return true;
            }
        }
        return false;
    }
    
    
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < boardSize && col >= 0 && col < boardSize;
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );

        jButton1.setText("↑");

        jButton2.setText("→");

        jButton3.setText("↓");

        jButton4.setText("←");

        jButton6.setText("move");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
