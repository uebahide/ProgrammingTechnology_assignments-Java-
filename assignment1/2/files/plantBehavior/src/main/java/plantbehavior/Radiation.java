/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantbehavior;

/**
 *
 * @author uewashuuwa
 */
abstract class Radiation {
    protected abstract int ChangePuffs();
    protected abstract int ChangeDeltatree();
    protected abstract int ChangeParabush();
    
    protected String toString(String type){
        return type;
    }
}

class alpha extends Radiation{
    private static alpha instance = null;
    
    private alpha(){}
    public static alpha instance(){
        if(instance == null){
            instance = new alpha();
        }
        return instance;
    }
    public void Destroy(){
        instance = null;
    }
    
    @Override
    public int ChangePuffs(){
        return 2;
    }
    @Override
    public int ChangeDeltatree(){
        return -3;
    }
    @Override
    public int ChangeParabush(){
        return 1;
    }
    
    @Override
    public String toString(){
        return super.toString("alpha");
    }
}
class delta extends Radiation{
    private static delta instance = null;
    
    private delta(){}
    public static delta instance(){
        if(instance == null){
            instance = new delta();
        }
        return instance;
    }
    public void Destroy(){
        instance = null;
    }
    
    @Override
    public int ChangePuffs(){
        return -2;
    }
    @Override
    public int ChangeDeltatree(){
        return 4;
    }
    @Override
    public int ChangeParabush(){
        return 1;
    }
    
    @Override
    public String toString(){
        return super.toString("delta");
    }
}
class noRadiation extends Radiation{
    private static noRadiation instance = null;
    
    private noRadiation(){}
    public static noRadiation instance(){
        if(instance == null){
            instance = new noRadiation();
        }
        return instance;
    }
    public void Destroy(){
        instance = null;
    }
    
    @Override
    public int ChangePuffs(){
        return -1;
    }
    @Override
    public int ChangeDeltatree(){
        return -1;
    }
    @Override
    public int ChangeParabush(){
        return -1;
    }
    
    @Override
    public String toString(){
        return super.toString("no Radiation");
    }
}
