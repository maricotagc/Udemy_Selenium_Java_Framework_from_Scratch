package grouping;

import org.testng.annotations.Test;

public class Grouping {

    @Test (groups = {"Sanity"})
    public void test1 () {
        System.out.println("This is test 1");
    }

    @Test (groups = {"Smoke"})
    public void test2 () {
        System.out.println("This is test 2");
    }

    @Test (groups = {"Sanity"})
    public void test3 () {
        System.out.println("This is test 3");
    }

    @Test (groups = {"Sanity", "Smoke"})
    public void test4 () {
        System.out.println("This is test 4");
    }
}
