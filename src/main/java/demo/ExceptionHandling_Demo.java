package demo;

public class ExceptionHandling_Demo {

    public static void main(String[] args) {
        try {
            System.out.println("Hello World...!");
            int i = 1/0;
            System.out.println("Completed");
        } catch (Exception e) {
            System.out.println("There was an error inside Try block. The error is: " + e.getMessage());
            System.out.println("The error's cause is: " + e.getCause());
            e.printStackTrace();
        }
        finally {
            System.out.println("Your process is completed");
        }
    }

}
