public class MainDemo {
    public static void main(String[] args) {

        for (int a = 0; a < args.length; a ++) {
            
            int Score = Integer.parseInt(args[a]);
            System.out.println("####" + args[a]);
        }
    }
}
