
public class Npe{
    private static final int milliseconds = 5000;
    public static void main(String[] args){
        System.out.println("Sleeping " + milliseconds + " seconds");
        try{
            Thread.sleep(milliseconds);
        } catch(Exception e){}
        
        System.out.println("End of sleep... Will throw a NullPointerException now");
        String n = null;
        n.length();
    }
}