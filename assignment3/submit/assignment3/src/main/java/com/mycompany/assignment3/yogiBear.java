/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assignment3;

import static com.mycompany.assignment3.GenerateStage.BasketCoordinates;
import static com.mycompany.assignment3.GenerateStage.ObstacleCoordinates;
import static com.mycompany.assignment3.GenerateStage.RangerCoordinates;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author uewashuuwa
 */
public class yogiBear extends javax.swing.JFrame{
    private int level = 1;
    private int score = 0;
    private int life = 3;
    private javax.swing.JPanel gridPanel;
    private javax.swing.JLabel spriteLabel;
    private Bear bear;
    private Basket basket;
    private Obstacle obstacle;
    private ArrayList<Ranger> rangers;
    private ImageIcon bearIcon;
    private Timer gameTimer;
    private int elapsedTime;

    
    /**
     * Creates new form yogiBear
     */
    public yogiBear() {
        initComponents();
        gameTimer = new Timer(1000, e -> updateElapsedTime());
        elapsedTime = 0;
        // Start the timer
        gameTimer.start();
        updateStage();
    }
    
    private void updateElapsedTime() {
        // This method is called every second by the timer
        elapsedTime++;
        // You can perform any time-related updates or checks here
        // For example, you can display the elapsed time on the UI
        // using a JLabel or any other component.
        // jLabelElapsedTime.setText("Elapsed Time: " + elapsedTime + " seconds");
    }
    
    private void clearGrid() {
        if(gridPanel != null){
            for(int i = 0; i < (level+3)*(level+3); i++){
                javax.swing.JLabel cell = (javax.swing.JLabel) gridPanel.getComponent(i);
                cell.setIcon(null);
                
            }
        }
    }
    
    private void rebuildStage(){
        clearGrid();
        rangers = new ArrayList<>();
        this.gridPanel = GenerateStage.generateStage(level);
        bear = new Bear(40, 40, level);
        basket = new Basket(40, 40, level);
        obstacle = new Obstacle(40, 40, level);
        bearIcon = bear.createResizedIcon();
        gridPanel.revalidate();
        gridPanel.repaint();
        updateBearPosition(0,0);
        updateObstaclePosition();
        updateBusketPosition();
        initRangerPosition();
        
        gridPanel.setFocusable(true);
        gridPanel.requestFocusInWindow();

        // KeyListenerを追加
        gridPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // 必要に応じて実装
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 必要に応じて実装
            }
        });
        this.setLayout(new java.awt.BorderLayout());
        this.add(gridPanel, java.awt.BorderLayout.CENTER);

                // frame を調整
        this.pack();
//        // 画面中央に配置
        this.setLocationRelativeTo(null);
    }
    
    private void updateStage(){
        clearGrid();
        rangers = new ArrayList<>();
        bear = new Bear(40, 40, level);
        basket = new Basket(40, 40, level);
        obstacle = new Obstacle(40, 40, level);
        bearIcon = bear.createResizedIcon();
        this.gridPanel = GenerateStage.generateStage(level);
        updateBearPosition(0,0);
        updateObstaclePosition();
        updateBusketPosition();
        initRangerPosition();
        
        gridPanel.setFocusable(true);
        gridPanel.requestFocusInWindow();

        // KeyListenerを追加
        gridPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // 必要に応じて実装
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 必要に応じて実装
            }
        });
        // frame のレイアウトを BorderLayout に設定し、gridPanel を中央に追加
        this.setLayout(new java.awt.BorderLayout());
        this.add(gridPanel, java.awt.BorderLayout.CENTER);
        // frame を調整
        this.pack();
        // 画面中央に配置
        this.setLocationRelativeTo(null);
        // frame を表示
        this.setVisible(true);
    }
    
    private void eraseBear(int x, int y) {
        int index = x + y * (level + 4);
        if (index >= 0 && index < gridPanel.getComponentCount()) {
            javax.swing.JLabel cell = (javax.swing.JLabel) gridPanel.getComponent(index);
            cell.setIcon(null);
        }
    }
    
    private void updateObstaclePosition(){
        for(int[] coordinate : ObstacleCoordinates){
            ImageIcon obstacleIcon = obstacle.createResizedIcon();
            int x = coordinate[0];
            int y = coordinate[1];
            javax.swing.JLabel cell = (javax.swing.JLabel) gridPanel.getComponent(x+y*(level+4));
            cell.setIcon(obstacleIcon);
        }
    }
    
    private void updateBusketPosition(){
        for(int[] coordinate : BasketCoordinates){
            System.out.println(coordinate[0]);
            System.out.println(coordinate[1]);
            ImageIcon basketIcon = basket.createResizedIcon();
            int x = coordinate[0];
            int y = coordinate[1];
            javax.swing.JLabel cell = (javax.swing.JLabel) gridPanel.getComponent(x+y*(level+4));
            cell.setIcon(basketIcon);
        }
    }
    
    private void updateBearPosition(int x, int y) {
        
        spriteLabel = new javax.swing.JLabel();
        spriteLabel.setIcon(bearIcon);

        // gridPanelにspriteを追加
        javax.swing.JLabel cell = (javax.swing.JLabel) gridPanel.getComponent(x + y * (level+4));
        cell.setIcon(bearIcon);
        // 更新を反映
        gridPanel.revalidate();
        gridPanel.repaint();
    }
    
    private void initRangerPosition(){ 
        for(int[] coordinate : RangerCoordinates){
            
            int x = coordinate[0];
            int y = coordinate[1];
            Ranger ranger = new Ranger(40, 40, level, x, y);
            rangers.add(ranger);
            ImageIcon rangerIcon = ranger.createResizedIcon();
            javax.swing.JLabel cell = (javax.swing.JLabel) gridPanel.getComponent(x+y*(level+4));
            cell.setIcon(rangerIcon);
        }
    }
    
    private void updateRangerPosition(){
        for(Ranger ranger : rangers){
           
            int x = ranger.getX();
            int newX = x;
            int y = ranger.getY();
            Random random = new Random();
            int randomChoice = random.nextInt(2);
            if(randomChoice == 0){
                if(x < level+3){
                    newX = x+1;
                }
            }else{
                if(x > 0){
                    newX = x-1;                    
                }
            }
            ImageIcon rangerIcon = ranger.createResizedIcon();
            javax.swing.JLabel oldCell = (javax.swing.JLabel) gridPanel.getComponent(x+y*(level+4));
            oldCell.setIcon(null);
            javax.swing.JLabel newCell = (javax.swing.JLabel) gridPanel.getComponent(newX+y*(level+4));
            newCell.setIcon(rangerIcon);
            ranger.setX(newX);
        }
    }
    
    private void stopGame() {
        gameTimer.stop();
        // ゲームの停止処理を実装
        // 例: キーイベントのリスナーを無効化する
        gridPanel.removeKeyListener(gridPanel.getKeyListeners()[0]);
    }
   
    private void showGameOverDialog() {
       // Display game over dialog with elapsed time
        new GameOverDialog(this, "Game Over", "Game Over! Your Score: " + score + "\nElapsed Time: " + elapsedTime + " seconds", score);
        this.dispose();
    }
    
    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        eraseBear(bear.getX(), bear.getY());
        boolean l = true;
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                // 左矢印が押されたときの処理
                for(int[] coordinate : ObstacleCoordinates){
                    if(Arrays.equals(coordinate, new int[]{bear.getX()-1, bear.getY()})){
                        l = false;
                    }
                }
                if(l){
                    bear.moveLeft();
                } 
                break;
            case KeyEvent.VK_RIGHT:
                // 右矢印が押されたときの処理
                for(int[] coordinate : ObstacleCoordinates){
                    if(Arrays.equals(coordinate, new int[]{bear.getX()+1, bear.getY()})){
                        l = false;
                    }
                }
                if(l){
                    bear.moveRight();
                }
                break;
            case KeyEvent.VK_UP:
                // 上矢印が押されたときの処理
                for(int[] coordinate : ObstacleCoordinates){
                    if(Arrays.equals(coordinate, new int[]{bear.getX(), bear.getY()-1})){
                        l = false;
                    }
                }
                if(l){
                    bear.moveUp();
                }
                break;
            case KeyEvent.VK_DOWN:
                // 下矢印が押されたときの処理
                for(int[] coordinate : ObstacleCoordinates){
                    if(Arrays.equals(coordinate, new int[]{bear.getX(), bear.getY()+1})){
                        l = false;
                    }
                }
                if(l){
                    bear.moveDown();
                }
                break;
        }
        updateBearPosition(bear.getX(), bear.getY());
        updateRangerPosition();
        ArrayList<Integer> removes = new ArrayList<>();
        int i = 0;
        for(Ranger ranger: rangers){
            int rangerX = ranger.getX();
            int rangerY = ranger.getY();
            
            int bearX = bear.getX();
            int bearY = bear.getY();
            
            if((Math.abs(rangerX - bearX) + Math.abs(rangerY - bearY)) <= 1){
                life--;
                if(life == 0){
                    stopGame();
                    showGameOverDialog();
                }else{
                    updateBearPosition(0, 0);
                    eraseBear(bearX, bearY);
                    if(bearX == rangerX && bearY == rangerY){
                      javax.swing.JLabel cell = (javax.swing.JLabel) gridPanel.getComponent(rangerX + rangerY * (level+4));
                      cell.setIcon(ranger.createResizedIcon());
                    }
                    for(int[] coordinates : GenerateStage.BasketCoordinates){
                        int x = coordinates[0];
                        int y = coordinates[1];
                        if(bear.getX() == x && bear.getY() == y){
                            removes.add(i);
                            score++;
                        }
                        i++;
                    }
                    
                    bear.setX(0);
                    bear.setY(0);
                }
                
            }
        }
        for(int[] coordinates : GenerateStage.BasketCoordinates){
            int x = coordinates[0];
            int y = coordinates[1];
            if(bear.getX() == x && bear.getY() == y){
                removes.add(i);
                score++;
            }
            i++;
        }
        for(int j : removes){
            GenerateStage.BasketCoordinates.remove(j);
        }
        if(GenerateStage.BasketCoordinates.isEmpty()){
            if(level < 10){
                level++;
                rebuildStage();
            }else if(level == 10){
                stopGame();
                showGameOverDialog();
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(yogiBear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(yogiBear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(yogiBear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(yogiBear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new yogiBear().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
