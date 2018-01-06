import java.util.HashMap;
import java.util.Scanner;

public class Load {
    public static void main (String args[])
    {
        HashMap<String,Site> choices = new HashMap<>();
        choices.put("test",new Site("test",5,8,false,false,false));

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Site:");
        String siteName = input.next().toLowerCase();
        while(!choices.containsKey(siteName))
        {
            System.out.println("Sorry, Site not found");
            System.out.println("Enter the Site:");
            siteName = input.next();
        }
        System.out.println("Enter your master password");
        String pass= input.next();
        GeneratePass testGen = new GeneratePass(pass.hashCode(),choices.get(siteName));
        System.out.println(testGen.toString());
    }
}
