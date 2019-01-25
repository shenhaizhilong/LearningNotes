package test.javavm; 

import javavm.DirectByteBufferCleaner;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.nio.ByteBuffer;

/** 
* DirectByteBufferCleaner Tester. 
* 
* @author <Authors name> 
* @since <pre>06/21/2018</pre> 
* @version 1.0 
*/ 
public class DirectByteBufferCleanerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: clean(final ByteBuffer byteBuffer) 
* 
*/ 
@Test
public void testClean() {
//TODO: Test goes here...

    int count = 5;
    while (count-->0)
    {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1000*1024*1024);
        System.out.println("Allocated ");
        sleep(1000*5);
        DirectByteBufferCleaner.clean(buffer);
        System.out.println("freed ");
        sleep(1000*5);

    }


}

public static void sleep(long i)
{
    try{
        Thread.sleep(i);
    }catch (Exception ex)
    {
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }
}


} 
