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
public class noRadiationTest {
    

    /**
     * Test of instance method, of class noRadiation.
     */
    

    /**
     * Test of ChangePuffs method, of class noRadiation.
     */
    @Test
    public void testChangePuffs() {
        assertEquals(-1, noRadiation.instance().ChangePuffs());
    }


    /**
     * Test of ChangeDeltatree method, of class noRadiation.
     */
    @Test
    public void testChangeDeltatree() {
        assertEquals(-1, noRadiation.instance().ChangeDeltatree());
    }

    /**
     * Test of ChangeParabush method, of class noRadiation.
     */
    @Test
    public void testChangeParabush() {
        assertEquals(-1, noRadiation.instance().ChangeParabush());
    }

    /**
     * Test of toString method, of class noRadiation.
     */
    @Test
    public void testToString() {
        assertEquals("no Radiation", noRadiation.instance().toString());
    }
    
}
