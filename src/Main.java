public class Main {
    public static void main(String[] args) {
        Fighter f1=new Fighter("A",100,10,85,50);
        Fighter f2=new Fighter("B",100,15,85,50);

        Match match=new Match(f1,f2,60,100);
        match.run();


    }
}