package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppiumTest  {
	
	WebDriver androidDriver=BaseTest.getDriver();
	Double d1=Double.parseDouble(BaseTest.i1);
	Double d2=Double.parseDouble(BaseTest.i2);  
	    
	public void enterInput() {		
		androidDriver.findElement(By.xpath("//android.widget.Button[@index='4']")).click();
		androidDriver.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys(BaseTest.i1);
		androidDriver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys(BaseTest.i2);
	}
	
	
	public String output() {
		String res=androidDriver.findElement(By.xpath("//android.widget.TextView[@index='2']")).getText();
		return res;	
	}
   
    @Test
    public void add() throws InterruptedException {
		enterInput();		
		androidDriver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
		String add=output();	
		
		Double i=d1+d2;
		String res=Double.toString(i);
		System.out.println("Addition result is "+add);
	    String result[]= add.split("=");
	    assertEquals(" "+res+"0", result[1]);
    }
    
    @Test
    public void subtract() throws InterruptedException {			
		enterInput();		
		androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
		String sub=output();	
	  
		Double i=d1-d2;
		String res=Double.toString(i);
		System.out.println("Subtraction result is "+sub);
	    String result[]= sub.split("=");
	    assertEquals(" "+res+"0", result[1]);
     }
    
     @Test
     public void multiply() throws InterruptedException {	
    	enterInput();		
		androidDriver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
		String mul=output();
		
		Double i=d1*d2;
		String res=Double.toString(i);
		System.out.println("Multiplication result is "+mul);
	    String result[]= mul.split("=");
        assertEquals(" "+res+"0", result[1]);
      }
    
      @Test
	  public void division() throws InterruptedException {		
    	enterInput();		
		androidDriver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
		String div=output();
		
		Double i=d1/d2;
		String res=Double.toString(i);
		System.out.println("Division result is "+div);
	    String result[]= div.split("=");
        assertEquals(" "+res+"0", result[1]);
	          
	     }
    
      @Test
      public void noinput() throws InterruptedException {		
	    androidDriver.findElement(By.xpath("//android.widget.Button[@index='4']")).click();
		System.out.println("Reset");
		androidDriver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
		String res=output();
		System.out.println("No input result is "+res);
    }
 }