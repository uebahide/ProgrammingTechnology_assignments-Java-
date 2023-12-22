/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author uewashuuwa
 */
// GenerateStage.java
public class GenerateStage {
    private static final int CELL_SIZE = 50;
    public static ArrayList<int[]> BasketCoordinates;
    public static ArrayList<int[]> ObstacleCoordinates;
    public static ArrayList<int[]> RangerCoordinates;
    
    public static javax.swing.JPanel generateStage(int level) {
        ObstacleCoordinates = new ArrayList<>();
        RangerCoordinates = new ArrayList<>();
        BasketCoordinates = new ArrayList<>();
        System.out.println("generateStage called with level: " + level);
        switch(level){
            case 1:
                BasketCoordinates.add(new int[]{4,4});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{2,2});
                RangerCoordinates.add(new int[]{3,3});
                break;
            case 2:
                BasketCoordinates.add(new int[]{5,5});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{2,3});
                RangerCoordinates.add(new int[]{3,4});
                break;
            case 3:
                BasketCoordinates.add(new int[]{6,6});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{3,3});
                RangerCoordinates.add(new int[]{3,4});
                break;
            case 4:
                BasketCoordinates.add(new int[]{7,7});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{3,3});
                RangerCoordinates.add(new int[]{3,4});
                break;
            case 5:
                BasketCoordinates.add(new int[]{8,8});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{4,4});
                RangerCoordinates.add(new int[]{3,5});
                break;
            case 6:
                BasketCoordinates.add(new int[]{9,9});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{5,5});
                RangerCoordinates.add(new int[]{3,7});
                break;
            case 7:
                BasketCoordinates.add(new int[]{10,10});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{7,7});
                RangerCoordinates.add(new int[]{3,8});
                break;
            case 8:
                BasketCoordinates.add(new int[]{11,11});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{7,7});
                RangerCoordinates.add(new int[]{3,8});
                break;
            case 9:
                BasketCoordinates.add(new int[]{12,12});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{6,8});
                RangerCoordinates.add(new int[]{3,9});
                break;
            case 10:
                BasketCoordinates.add(new int[]{13,13});
                BasketCoordinates.add(new int[]{3,2});
                ObstacleCoordinates.add(new int[]{8,8});
                RangerCoordinates.add(new int[]{3,7});
                break;
                
        }
        return generateGrid(level+4, level+4, level);
    }

    private static javax.swing.JPanel generateGrid(int rows, int cols, int level) {
        // 新しい JPanel を GridLayout で作成
        javax.swing.JPanel gridPanel = new javax.swing.JPanel(new java.awt.GridLayout(rows, cols));

        // JLabel を作成し、gridPanel に追加
        for (int i = 0; i < rows * cols; i++) {
            javax.swing.JLabel cell = new javax.swing.JLabel();
            cell.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));
            cell.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // テキストを中央に配置
            cell.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
            cell.setPreferredSize(new java.awt.Dimension(50, 50)); // 好みに応じて適切なサイズを設定
            
            gridPanel.add(cell);
        }

        
        
        return gridPanel;
    }
}

