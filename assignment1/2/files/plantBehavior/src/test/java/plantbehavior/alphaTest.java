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
public class alphaTest {
    
    /**
     * Test of instance method, of class alpha.
     */
    

    /**
     * Test of ChangePuffs method, of class alpha.
     */
    @Test
    public void testChangePuffs() {
        assertEquals(2, alpha.instance().ChangePuffs());
    }


    /**
     * Test of ChangeDeltatree method, of class alpha.
     */
    @Test
    public void testChangeDeltatree() {
        assertEquals(-3, alpha.instance().ChangeDeltatree());
    }

    /**
     * Test of ChangeParabush method, of class alpha.
     */
    @Test
    public void testChangeParabush() {
        assertEquals(1, alpha.instance().ChangeParabush());
    }

    /**
     * Test of toString method, of class alpha.
     */
    @Test
    public void testToString() {
        assertEquals("alpha", alpha.instance().toString());
    }
    
}
