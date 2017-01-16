package com.ee.fizzbuzz.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;

import com.ee.fizzbuzz.FizzBuzz;

  
@RunWith(Parameterized.class)
public class FizzBuzzTests {
  
  @Parameter
  public int input;

  @Parameter(value = 1)
  public String expected;
  
  
  // creates the test data
  @Parameters(name= "{index}: report[1,{0}]={1}")
  public static Collection<Object[]> data() {
      Object[][] data = 
        new Object[][] { { 20 , 
                          "fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10 "},
                        { 1 , 
                          "fizz: 0 buzz: 0 fizzbuzz: 0 lucky: 0 integer: 1 "},
                        { 4 , 
                          "fizz: 0 buzz: 0 fizzbuzz: 0 lucky: 1 integer: 3 "}
                          };
      return Arrays.asList(data);
  }

  
  @Test
  public void reportTests() {
    FizzBuzz.continuousLuckyFizzBuzz(1,input);
    assertEquals("continuousLuckyFizzBuzz", expected, FizzBuzz.getReport());   
  }

  
  @Test
  public void counterTests() {
    // assert statements
    FizzBuzz.luckyFizzBuzz(3);
    FizzBuzz.luckyFizzBuzz(13);
    FizzBuzz.luckyFizzBuzz(-32);
    assertEquals("report - " + FizzBuzz.LUCKY, 
                  3, FizzBuzz.getReportCounter(FizzBuzz.LUCKY));
    
    FizzBuzz.luckyFizzBuzz(15);
    FizzBuzz.luckyFizzBuzz(30);
    FizzBuzz.luckyFizzBuzz(45);
    FizzBuzz.luckyFizzBuzz(0);

    assertEquals("report - " + FizzBuzz.FIZZBUZZ, 
                 3 , FizzBuzz.getReportCounter(FizzBuzz.FIZZBUZZ));
    
    FizzBuzz.luckyFizzBuzz(6);
    FizzBuzz.luckyFizzBuzz(9);
    FizzBuzz.luckyFizzBuzz(12);
    FizzBuzz.luckyFizzBuzz(15);
    FizzBuzz.luckyFizzBuzz(18);
    
    assertEquals("report - " + FizzBuzz.FIZZ, 
                 4, FizzBuzz.getReportCounter(FizzBuzz.FIZZ));   
    
    FizzBuzz.luckyFizzBuzz(5);

    assertEquals("report - " + FizzBuzz.BUZZ, 
                 1, FizzBuzz.getReportCounter(FizzBuzz.BUZZ));   

  }
    
    @Test
    public void fizzBuzzTests() {

      // assert statements
      assertEquals("fizzBuzz(1)", "1", FizzBuzz.fizzBuzz(1));
      assertEquals("fizzBuzz(2)", "2", FizzBuzz.fizzBuzz(2));
      assertEquals("fizzBuzz(3)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(3));
      assertEquals("fizzBuzz(15)", FizzBuzz.FIZZBUZZ, FizzBuzz.fizzBuzz(15));
      assertEquals("fizzBuzz(4)", "4", FizzBuzz.fizzBuzz(4));
      assertEquals("fizzBuzz(5)", FizzBuzz.BUZZ, FizzBuzz.fizzBuzz(5));
      assertEquals("fizzBuzz(6)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(6));
      assertEquals("fizzBuzz(9)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(9));
      assertEquals("fizzBuzz(10)", FizzBuzz.BUZZ, FizzBuzz.fizzBuzz(10));
      assertEquals("fizzBuzz(11)", "11", FizzBuzz.fizzBuzz(11));
      assertEquals("fizzBuzz(12)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(12));
      
      assertEquals("fizzBuzz(21)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(21));
      assertEquals("fizzBuzz(25)", FizzBuzz.BUZZ, FizzBuzz.fizzBuzz(25));
      assertEquals("fizzBuzz(30)", FizzBuzz.FIZZBUZZ, FizzBuzz.fizzBuzz(30));
      
      assertEquals("fizzBuzz(0)", FizzBuzz.FIZZBUZZ, FizzBuzz.fizzBuzz(0));
      assertEquals("fizzBuzz(MAXINT)", String.valueOf(Integer.MAX_VALUE), FizzBuzz.fizzBuzz(Integer.MAX_VALUE));
      assertEquals("fizzBuzz(MAXINT+1)", String.valueOf(Integer.MIN_VALUE), FizzBuzz.fizzBuzz(Integer.MAX_VALUE+1));

      assertEquals("fizzBuzz(-1)", "-1", FizzBuzz.fizzBuzz(-1));
      assertEquals("fizzBuzz(-3)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(-3));
      assertEquals("fizzBuzz(-5)", FizzBuzz.BUZZ, FizzBuzz.fizzBuzz(-5));
      assertEquals("fizzBuzz(-15)", FizzBuzz.FIZZBUZZ, FizzBuzz.fizzBuzz(-15));
      
    }
    
    
    @Test
    public void continuousfizzBuzzTests() {
      assertEquals("continuousFizzBuzz(1,20)", 
                    "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz ", 
                   FizzBuzz.continuousFizzBuzz(1,20));
      assertEquals("continuousFizzBuzz(1,1)",
                    FizzBuzz.fizzBuzz(1),
                   FizzBuzz.continuousFizzBuzz(1,1).trim());
      assertEquals("continuousFizzBuzz(1,0)",
                    "",
                   FizzBuzz.continuousFizzBuzz(1,0));
      assertEquals("continuousFizzBuzz(3,3)",
                    FizzBuzz.fizzBuzz(3),
                   FizzBuzz.continuousFizzBuzz(3,3).trim());
      assertEquals("continuousFizzBuzz(5,5)",
                    FizzBuzz.fizzBuzz(5),
                   FizzBuzz.continuousFizzBuzz(5,5).trim());
      assertEquals("continuousFizzBuzz(15,15)",
                    FizzBuzz.fizzBuzz(15),
                   FizzBuzz.continuousFizzBuzz(15,15).trim());
    }

    @Test
    public void luckyFizzBuzzTests() {

      assertEquals("luckyfizzBuzz(1)", FizzBuzz.fizzBuzz(1), FizzBuzz.luckyFizzBuzz(1));
      assertEquals("luckyfizzBuzz(2)", FizzBuzz.fizzBuzz(2), FizzBuzz.luckyFizzBuzz(2));
      assertEquals("luckyfizzBuzz(3)", FizzBuzz.LUCKY, FizzBuzz.luckyFizzBuzz(3));
      assertEquals("luckyfizzBuzz(4)", FizzBuzz.fizzBuzz(4), FizzBuzz.luckyFizzBuzz(4));
      assertEquals("luckyfizzBuzz(5)", FizzBuzz.fizzBuzz(5), FizzBuzz.luckyFizzBuzz(5));
      assertEquals("luckyfizzBuzz(15)", FizzBuzz.fizzBuzz(15), FizzBuzz.luckyFizzBuzz(15));
      assertEquals("luckyfizzBuzz(13)", FizzBuzz.LUCKY, FizzBuzz.luckyFizzBuzz(13));
      assertEquals("luckyfizzBuzz(30)", FizzBuzz.LUCKY, FizzBuzz.luckyFizzBuzz(30));
      assertEquals("luckyfizzBuzz(301)", FizzBuzz.LUCKY, FizzBuzz.luckyFizzBuzz(301));
      assertEquals("luckyfizzBuzz(303)", FizzBuzz.LUCKY, FizzBuzz.luckyFizzBuzz(303));
      assertEquals("luckyfizzBuzz(-31)", FizzBuzz.LUCKY, FizzBuzz.luckyFizzBuzz(-31));
    }

                          
    
    @Test
    public void continuousLuckyFizzBuzzTests() {
      assertEquals("continuousLuckyFizzBuzz(1,20)", 
                    "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz ", 
                   FizzBuzz.continuousLuckyFizzBuzz(1,20));
      assertEquals("continuousLuckyFizzBuzz(1,1)",
                    FizzBuzz.luckyFizzBuzz(1),
                   FizzBuzz.continuousLuckyFizzBuzz(1,1).trim());
      assertEquals("continuousLuckyFizzBuzz(1,0)",
                    "",
                   FizzBuzz.continuousLuckyFizzBuzz(1,0));
      assertEquals("continuousLuckyFizzBuzz(3,3)",
                    FizzBuzz.luckyFizzBuzz(3),
                   FizzBuzz.continuousLuckyFizzBuzz(3,3).trim());
      assertEquals("continuousLuckyFizzBuzz(5,5)",
                    FizzBuzz.luckyFizzBuzz(5),
                   FizzBuzz.continuousLuckyFizzBuzz(5,5).trim());
      assertEquals("continuousLuckyFizzBuzz(15,15)",
                    FizzBuzz.luckyFizzBuzz(15),
                   FizzBuzz.continuousLuckyFizzBuzz(15,15).trim());
    }

  
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(FizzBuzzTests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
