package test.Day13; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* InterviewTest Tester. 
* 
* @author <Authors name> 
* @since <pre>9�� 6, 2022</pre> 
* @version 1.0 
*/ 
public class InterviewTestTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception {
    @Test
    Object o1 = true ? new Integer(1) : new Double(2.0);
    System.out.println(o1);

} 


} 
