import org.testng.annotations.Test;

/**
 * Created by akshay.pokley on 8/30/2017.
 */
public class Example {

@Test(priority=3)
public void fst()
{
    System.out.println("I am first ");
}


    @Test(priority=1)
    public void snd()
    {
        System.out.println("I am second ");
    }


    @Test(priority=2)
    public void finalw()
    {
        System.out.println("I am final  ");
    }
}