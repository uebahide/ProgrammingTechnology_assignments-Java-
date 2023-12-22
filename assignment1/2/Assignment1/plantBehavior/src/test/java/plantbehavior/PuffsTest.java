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
public class PuffsTest {
    
    
    @Test
    public void testGetName() {
        assertEquals("test", new Puffs("test", 5).getName());
    }

    /**
     * Test of getNutrients method, of class Plant.
     */
    @Test
    public void testGetNutrients() {
        assertEquals(5, new Puffs("test", 5).getNutrients());
    }

    /**
     * Test of isLiving method, of class Plant.
     */
    @Test
    public void testIsLiving() {
        assertTrue(new Puffs("test", 5).isLiving());
    }
   
    /**
     * Test of Metabolism method, of class Puffs.
     */
    @Test
    public void testMetabolismWithPositiveLessThan10Nutrients() {
        Puffs p = new Puffs("test", 5);
        p.Metabolism(alpha.instance());
        assertEquals(7, p.getNutrients());
        assertTrue(p.isLiving());
    }
    @Test
    public void testMetabolismWithNegativeNutrients() {
        Puffs p = new Puffs("test", -10);
        p.Metabolism(alpha.instance());
        assertEquals(0, p.getNutrients());
        assertFalse(p.isLiving());
    }
    @Test
    public void testMetabolismWithGreaterThan10Nutrients() {
        Puffs p = new Puffs("test", 20);
        p.Metabolism(alpha.instance());
        assertEquals(22, p.getNutrients());
        assertFalse(p.isLiving());
    }

    /**
     * Test of radiationNeed method, of class Puffs.
     */
    @Test
    public void testRadiationNeedWithLiving() {
        assertEquals(5, new Puffs("test", 5).radiationNeed());
    }
    @Test
    public void testRadiationNeedWithNotLiving() {
        assertEquals(0, new Puffs("test", -10).radiationNeed());
    }

    /**
     * Test of toString method, of class Puffs.
     */
    @Test
    public void testToString() {
        assertEquals("test : Puffs, 4", new Puffs("test", 4).toString());
    }
    
}
