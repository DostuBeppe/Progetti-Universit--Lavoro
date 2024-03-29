package prim;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerJUnit {


    public static void main(String [] args){
        Result rs= JUnitCore.runClasses(TestJUnit.class);
        for(Failure fail: rs.getFailures())
            System.out.println(fail.toString());
        System.out.println(rs.wasSuccessful());
    }
}
