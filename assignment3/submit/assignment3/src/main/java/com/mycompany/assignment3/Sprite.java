/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author uewashuuwa
 */
abstract class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int max;
    
    protected Sprite(int width, int height, int level){
        this.width = width;
        this.height = height;
        this.max = level+3;
    }
    
    public ImageIcon createResizedIcon(){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Draw a yellow circle in the center of the image
        setColor(g2d);
        createShape(g2d);
        g2d.dispose();

        return new ImageIcon(image);
    }
    
    protected abstract void setColor(Graphics2D g2d);
    protected abstract void createShape(Graphics2D g2d);
    
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public void moveRight(){
        if(x < max){
            x += 1;
        }
    }
    public void moveLeft(){
        if(x > 0){
            x -= 1;
        }
    }
    public void moveUp(){
        if(y > 0){
            y -= 1;
        }
    }
    public void moveDown(){
        if(y < max){
            y += 1;
        }
    }
}

class Bear extends Sprite{   
    
    public Bear(int width, int height, int level){
        super(width, height, level);
        x = 0;
        y = 0;
    }
    
    @Override
    protected void setColor(Graphics2D g2d){
        g2d.setColor(Color.YELLOW);
    }
    
    @Override
    protected void createShape(Graphics2D g2d){
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(width, height) / 2;
        g2d.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }
}

class Ranger extends Sprite{
    public Ranger(int width, int height, int level, int x, int y){
        super(width, height, level);
        this.x = x;
        this.y = y;
    }
    @Override
    protected void setColor(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
    }
    
    @Override
    protected void createShape(Graphics2D g2d){
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = width / 4;
        int sides = 6;  // 六角形

        int[] xPoints = new int[sides];
        int[] yPoints = new int[sides];

        // 六角形の各頂点の座標を計算
        for (int i = 0; i < sides; i++) {
            double angle = 2.0 * Math.PI * i / sides;
            xPoints[i] = (int) (centerX + radius * Math.cos(angle));
            yPoints[i] = (int) (centerY + radius * Math.sin(angle));
        }

        // トゲトゲの形状を描画
        Polygon spikeyPolygon = createSpikeyPolygon(xPoints, yPoints);
        g2d.drawPolygon(spikeyPolygon);
    }
    
    private Polygon createSpikeyPolygon(int[] xPoints, int[] yPoints) {
        Polygon spikeyPolygon = new Polygon();

        for (int i = 0; i < xPoints.length; i++) {
            spikeyPolygon.addPoint(xPoints[i], yPoints[i]);
            // トゲを追加
            spikeyPolygon.addPoint(xPoints[i] + 5, yPoints[i] + 20);
        }

        return spikeyPolygon;
    }
}

class Obstacle extends Sprite{
    public Obstacle(int width, int height, int level){
        super(width, height, level);
    }
    
    @Override
    protected void setColor(Graphics2D g2d){
        g2d.setColor(Color.WHITE);
    }
    
    @Override
    protected void createShape(Graphics2D g2d){
        int centerX = width / 2;
        int centerY = height / 2;
        int rectangleWidth = width / 2;
        int rectangleHeight = height / 2;
        g2d.fillRect(centerX - rectangleWidth / 2, centerY - rectangleHeight / 2, rectangleWidth, rectangleHeight);
    }
}

class Basket extends Sprite{
    public Basket(int width, int height, int level){
        super(width, height, level);
    }
    
    @Override
    protected void setColor(Graphics2D g2d){
        g2d.setColor(Color.PINK);
    }
    @Override
    protected void createShape(Graphics2D g2d) {
        int centerX = width / 2;
        int centerY = height / 2;
        int outerRadius = Math.min(width, height) / 2;
        int innerRadius = outerRadius / 2; // Adjust the inner radius based on your preference
        int numPoints = 5; // A 5-pointed star

        int[] xPoints = new int[2 * numPoints];
        int[] yPoints = new int[2 * numPoints];

        for (int i = 0; i < 2 * numPoints; i++) {
            double angle = Math.PI / numPoints * i;
            int radius = (i % 2 == 0) ? outerRadius : innerRadius;
            xPoints[i] = (int) (centerX + radius * Math.cos(angle));
            yPoints[i] = (int) (centerY + radius * Math.sin(angle));
        }

        g2d.fillPolygon(xPoints, yPoints, 2 * numPoints);
    }
}
