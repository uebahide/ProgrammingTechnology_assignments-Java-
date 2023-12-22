/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantbehavior;

/**
 *
 * @author uewashuuwa
 */
public abstract class Plant {
    protected String name;
    protected Integer nutrients ;
    protected boolean living;

    protected Plant(String name, Integer nutrients) {
        this.name = name;
        this.nutrients = nutrients;
        if(nutrients > 0){
            this.living = true;
        }
        else{
            this.living = false;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getNutrients() {
        return nutrients;
    }

    public boolean isLiving() {
        return living;
    }
    
    protected abstract void Metabolism(Radiation r);
    protected abstract int radiationNeed();
    
    public String toString(String type){
        return name + " : " + type + ", " + nutrients;
    }
}

class Puffs extends Plant{

    public Puffs(String name, Integer nutrients) {
        super(name, nutrients);
        if(nutrients > 10){
            this.living = false;
        }
    }
    
    @Override
    public void Metabolism(Radiation r){
        nutrients += r.ChangePuffs();
        if(nutrients <= 0 || nutrients > 10){
            living = false;
            if(nutrients < 0){
                nutrients = 0;
            }
        }
    }
    
    @Override
    protected int radiationNeed(){
        if(!isLiving()){
            return 0;
        }
        
        return 10 - nutrients;
    }
    
    @Override
    public String toString(){
        return super.toString("Puffs");
    }
}
class Deltatree extends Plant{

    public Deltatree(String name, Integer nutrients) {
        super(name, nutrients);
    }
    
    @Override
    public void Metabolism(Radiation r){
        nutrients += r.ChangeDeltatree();
        if(nutrients <= 0){
            living = false;
            nutrients = 0;
        }
    }
    
    @Override
    protected int radiationNeed(){
        if(!isLiving()){
            return 0;
        }
        
        if(nutrients < 5){
            return -4;
        }else if(nutrients <= 10){
            return -1;
        }
        
        return 0;
    }
    
    @Override
    public String toString(){
        return super.toString("Deltatree");
    }
}
class Parabush extends Plant{

    public Parabush(String name, Integer nutrients) {
        super(name, nutrients);
    }
    
    @Override
    public void Metabolism(Radiation r){
        nutrients += r.ChangeParabush();
        if(nutrients <= 0){
            living = false;
            nutrients = 0;
        }
    }
    
    @Override
    public int radiationNeed(){
        return 0;
    }
    
    @Override
    public String toString(){
        return super.toString("Parabush");
    }
}
