package com.qf;

import com.qf.common.util.SingletonRegistry;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public static void main(String[] args) {
        SingletonRegistry registry = SingletonRegistry.getInstance();
        BCryptPasswordEncoder encoder = registry.getPasswordEncoder();
        boolean matches = encoder.matches("123455", "123455");
        System.out.println(matches);
    }
}
