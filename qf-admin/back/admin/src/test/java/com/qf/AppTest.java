package com.qf;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;

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
        List<String> list1 = Arrays.asList();
        List<String> list2 = Arrays.asList();

        // 使用Stream API判断list1是否包含list2的所有元素
        boolean containsAll = list2.stream().allMatch(list1::contains);

        System.out.println("list1是否包含list2的所有元素: " + containsAll);
    }
}
