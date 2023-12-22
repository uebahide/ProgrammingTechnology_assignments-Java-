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
public class DeltatreeTest {
    
   @Test
    public void testGetName() {
        assertEquals("test", new Deltatree("test", 5).getName());
    }

    /**
     * Test of getNutrients method, of class Plant.
     */
    @Test
    public void testGetNutrients() {
        assertEquals(5, new Deltatree("test", 5).getNutrients());
    }

    /**
     * Test of isLiving method, of class Plant.
     */
    @Test
    public void testIsLiving() {
        assertTrue(new Deltatree("test", 5).isLiving());
    }

    /**
     * Test of Metabolism method, of class Deltatree.
     */
    @Test
    public void testMetabolismWithPositiveNutrients() {
        Deltatree p = new Deltatree("test", 5);
        p.Metabolism(alpha.instance());
        assertEquals(2, p.getNutrients());
        assertTrue(p.isLiving());
    }
    @Test
    public void testMetabolismWithNegativeNutrients() {
        Deltatree p = new Deltatree("test", -10);
        p.Metabolism(alpha.instance());
        assertEquals(0, p.getNutrients());
        assertFalse(p.isLiving());
    }

    /**
     * Test of radiationNeed method, of class Deltatree.
     */
    @Test
    public void testRadiationNeedWithLivingBetween5and10Nutrients() {
        assertEquals(-1, new Deltatree("test", 10).radiationNeed());
    }
    @Test
    public void testRadiationNeedWithLivingBetween1and4Nutrients() {
        assertEquals(-4, new Deltatree("test", 2).radiationNeed());
    }
    
    @Test
    public void testRadiationNeedWithNotLivingLessThanEqual0Nutrients() {
        assertEquals(0, new Deltatree("test", 0).radiationNeed());
    }
    @Test
    public void testRadiationNeedWithNotLivingGreaterThan10Nutrients() {
        assertEquals(0, new Deltatree("test", 11).radiationNeed());
    }
    

    /**
     * Test of toString method, of class Deltatree.
     */
    @Test
    public void testToString() {
        Deltatree p = new Deltatree("test", 4);
        assertEquals("test : Deltatree, 4", p.toString());
    }
    
}
