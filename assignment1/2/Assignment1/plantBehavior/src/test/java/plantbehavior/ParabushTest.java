/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package plantbehavior;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author uewashuuwa
 */
public class ParabushTest {
    
    @Test
    public void testGetName() {
        assertEquals("test", new Parabush("test", 5).getName());
    }

    /**
     * Test of getNutrients method, of class Plant.
     */
    @Test
    public void testGetNutrients() {
        assertEquals(5, new Parabush("test", 5).getNutrients());
    }

    /**
     * Test of isLiving method, of class Plant.
     */
    @Test
    public void testIsLiving() {
        assertTrue(new Parabush("test", 5).isLiving());
    }

    /**
     * Test of Metabolism method, of class Parabush.
     */
    @Test
    public void testMetabolismWithPositiveNutrients() {
        Parabush p = new Parabush("test", 5);
        p.Metabolism(alpha.instance());
        assertEquals(6, p.getNutrients());
        assertTrue(p.isLiving());
    }
    @Test
    public void testMetabolismWithNegativeNutrients() {
        Parabush p = new Parabush("test", -10);
        p.Metabolism(alpha.instance());
        assertEquals(0, p.getNutrients());
        assertFalse(p.isLiving());
    }

    /**
     * Test of radiationNeed method, of class Parabush.
     */
    @Test
    public void testRadiationNeed(){
        assertEquals(0, new Parabush("test", 10).radiationNeed());
    }
    /**
     * Test of toString method, of class Parabush.
     */
    @Test
    public void testToString() {
        assertEquals("test : Parabush, 4", new Parabush("test", 4).toString());
    }
    
}
