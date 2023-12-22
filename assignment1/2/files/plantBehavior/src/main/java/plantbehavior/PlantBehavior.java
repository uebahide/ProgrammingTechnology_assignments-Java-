/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package plantbehavior;

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
public class PlantBehavior {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = sc.nextLine();
        
        File file = new File(filename);
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            int num = Integer.parseInt(bf.readLine());
            
            //initiate plants.
            ArrayList<Plant> plants = new ArrayList<>();
            for(int i = 0; i<num; i++){
                String str = bf.readLine();
                String[] data = str.split(" ");
                String name = data[0];
                String token = data[1];
                int nutrients = Integer.parseInt(data[2]);
                
                switch(token){
                    case "p" -> plants.add(new Puffs(name, nutrients));
                    case "d" -> plants.add(new Deltatree(name, nutrients));
                    case "b" -> plants.add(new Parabush(name, nutrients));
                }
            }
            
            int day = Integer.parseInt(bf.readLine());
            Radiation r = noRadiation.instance();
            int radiationNeed = 0;//first day is no radiation.
            
            //simulation starts
            System.out.println("-----Start condition----");
            System.out.println("Radiation: " + r);
            System.out.println("(Plants detail)");
            for(Plant p : plants){
                System.out.println(p);
            }
            System.out.println("------------------------");
            for(int i = 0; i < day; i++){
                
                //Plant's metabolism of each day.
                for(Plant p : plants){
                    if(p.isLiving()){
                        p.Metabolism(r);
                        radiationNeed += p.radiationNeed();
                    }
                }
                System.out.println("-----"+(i+1)+"th day's condition----");
                System.out.println("Radiation: " + r);
                System.out.println("(Plants detail)");
                for(Plant p : plants){
                    System.out.println(p);
                }
                System.out.println("---------------------------");
                //Decide the radiation of the next day.
                if(radiationNeed >= 3){
                    r = alpha.instance();
                }else if(radiationNeed <= -3){
                    r = delta.instance();
                }else{
                    r = noRadiation.instance();
                }
            }
            System.out.println("");
            System.out.println("------Living plants------");
            for(Plant p : plants){
                if(p.isLiving()){
                    System.out.println(p);
                }
            }
                
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
             System.out.println(e.getMessage());
        }
        
    }
}
