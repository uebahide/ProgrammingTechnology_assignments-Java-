/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creaturerace;

import com.mycompany.creaturerace.Sandrunner;
import com.mycompany.creaturerace.Sponge;
import com.mycompany.creaturerace.Walker;

/**
 *
 * @author uewashuuwa
 */
abstract class Day {
    protected abstract void ChangeSR(Sandrunner sr);
    protected abstract void ChangeSG(Sponge sg);
    protected abstract void ChangeWK(Walker wk);
}

class Sunny extends Day{

    @Override
    protected void ChangeSR(Sandrunner sr) {
        sr.modifyWater(-1);
        sr.modifyDistance(3);
    }

    @Override
    protected void ChangeSG(Sponge sg) {
        sg.modifyWater(-4);
        sg.modifyDistance(0);
    }

    @Override
    protected void ChangeWK(Walker wk) {
        wk.modifyWater(-2);
        wk.modifyDistance(1);
    }
    
}
class Cloudy extends Day{

    @Override
    protected void ChangeSR(Sandrunner sr) {
        sr.modifyWater(0);
        sr.modifyDistance(1);
    }

    @Override
    protected void ChangeSG(Sponge sg) {
        sg.modifyWater(-1);
        sg.modifyDistance(1);
    }

    @Override
    protected void ChangeWK(Walker wk) {
        wk.modifyWater(-1);
        wk.modifyDistance(2);
    }
    
}
class Rainy extends Day{

    @Override
    protected void ChangeSR(Sandrunner sr) {
        sr.modifyWater(3);
        sr.modifyDistance(0);
    }

    @Override
    protected void ChangeSG(Sponge sg) {
        sg.modifyWater(6);
        sg.modifyDistance(3);
    }

    @Override
    protected void ChangeWK(Walker wk) {
        wk.modifyWater(3);
        wk.modifyDistance(1);
    }
    
}
