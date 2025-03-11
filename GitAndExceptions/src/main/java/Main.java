public class Main {
    public static void main(String[] args) {

        try {
            someException();
        } catch (SomeException se){
            System.out.println(se.getMessage());
        }
    }

    public static void someException() throws SomeException{
        throw new SomeException();
    }
}