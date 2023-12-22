/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.creaturerace;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author uewashuuwa
 */
public class CreatureRace {
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("file name: ");
        File file = new File(sc.nextLine());
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String line = bf.readLine();
            int n = Integer.parseInt(line);
            ArrayList<Creature> creatures = new ArrayList<>();
            for(int i = 0; i < n; i++){
                line = bf.readLine();
                String[] data = line.split(" ");
                String name = data[0];
                String type = data[1];
                int water = Integer.parseInt(data[2]);
                switch(type){
                    case "r": creatures.add(new Sandrunner(name, water)); break;
                    case "s": creatures.add(new Sponge(name, water)); break;
                    case "w": creatures.add(new Walker(name, water)); break;
                }
            }
            ArrayList<Day> days = new ArrayList<>();
            line = bf.readLine();
            String[] chars = line.split("");
            for(String c : chars){
                switch(c){
                    case "s" : days.add(new Sunny());
                    case "c" : days.add(new Cloudy());
                    case "r" : days.add(new Rainy());
                }
            }
            
            for(Creature creature : creatures){
                creature.race(days);
            }
            
            Creature elem = creatures.get(0);
            int max = elem.getDistance();
            for(Creature creature: creatures){
                if(creature.isAlive() && max < creature.getDistance()){
                    elem = creature;
                    max = elem.getDistance();
                }
            }
            System.out.println("Winner: " + elem);
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
}
