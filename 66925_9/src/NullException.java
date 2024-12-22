
public class NullException {
    static Integer genException(){
        Integer i = null;
                return i;
    }
}
class Exc{
    public static void main(String[] args){
        try{
            Integer j = NullException.genException();
            j.toString();
        }
        catch(NullPointerException e){
            System.out.println("null");
            System.out.println("\n"+ e );
            System.out.println("\nThe call stack:");
            e.printStackTrace();
        }
    }
}