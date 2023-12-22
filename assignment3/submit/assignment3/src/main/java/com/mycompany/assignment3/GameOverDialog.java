/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author uewashuuwa
 */
public class GameOverDialog extends JDialog {
    private JTextField nameField;

    public GameOverDialog(JFrame parent, String title, String message, int score) {
        super(parent, title, true);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(message);
        panel.add(label, BorderLayout.NORTH);

        // スコア表示
        JLabel scoreLabel = new JLabel("Your Score: " + score);
        panel.add(scoreLabel, BorderLayout.CENTER);

        // 名前入力欄
        nameField = new JTextField("Your Name");
        panel.add(nameField, BorderLayout.CENTER);  // ← ここを修正

        // OKボタン
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ここでデータベースにスコアと名前を送信する処理を追加
                insertScoreToDatabase(getPlayerName(), score);
                // ダイアログを閉じる
                dispose();
//                getParent().setEnabled(true);
                goToStartScreen();
            }
        });
        panel.add(okButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
        setResizable(false);
        setVisible(true);
    }

    public String getPlayerName() {
        return nameField.getText();
    }
    
    public void goToStartScreen() {
        // StartScreen に戻る処理をここに追加
        StartScreen startScreen = new StartScreen();
        startScreen.setVisible(true);
        // 現在のダイアログを閉じる
        dispose();
    }
    
    private void insertScoreToDatabase(String playerName, int playerScore) {
        String url = "jdbc:mysql://localhost:3306/scores"; // データベースのURL
        String user = "hidekazu"; // データベースのユーザー名
        String password = "12345678"; // データベースのパスワード

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String insertQuery = "INSERT INTO data (score, name) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, playerScore);
                preparedStatement.setString(2, playerName);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // エラー処理を追加するか、ログに出力するなどの対応を行うことができます
        }
    }
}
