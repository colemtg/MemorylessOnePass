public class Load {
    public static void main (String args[])
    {
        Site test = new Site("hearthpwn",6,10,false,false,false);
        String pass= "greetingsTraveler";
        //Integer.parseInt("9395156624392822");
        GeneratePass testGen = new GeneratePass(pass.hashCode(),test);
        System.out.println(testGen.toString());
    }
}
