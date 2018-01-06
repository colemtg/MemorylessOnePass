import java.util.Random;

public class GeneratePass {
    private final Integer hashPass;
    private final Integer hashSite;
    private final Long combined;
    private final String password;
    private final Site site;
    private final Random random;

    public GeneratePass(Integer hashPass, Site site) {
        this.hashPass = hashPass;
        this.site = site;
        hashSite=site.getName().hashCode();
        combined=interweeve(this.hashPass,hashSite);
        random = new Random(combined);
        password=genPass(random,site);
    }
    private Long interweeve(Integer one, Integer two)
    {
        String tempOut="";
        String hashP=Integer.toString(Math.abs(one));
        String hashS=Integer.toString(Math.abs(two));

        if(hashP.length()>hashS.length())
        {
            for(int i=0; i<hashS.length(); i++)
            {
                tempOut=tempOut+hashP.substring(i,i+1)+hashS.substring(i,i+1);
            }
            tempOut=tempOut+hashP.substring(hashS.length()-1,hashP.length());
        }
        else
        {
            for(int i=0; i<hashP.length(); i++)
            {
                tempOut=tempOut+hashP.substring(i,i+1)+hashS.substring(i,i+1);
            }
            tempOut=tempOut+hashS.substring(hashP.length()-1,hashS.length());
        }

        return Long.valueOf(tempOut.substring(0,16));
    }
    private String genPass(Random random,Site site)
    {
        String pass="";
        int capitalPos=-1;
        int numberPos=-1;
        int specialPos=-1;
        int length = (Math.abs(random.nextInt())%(Math.abs(site.getMaxLength()-site.getMinLength())))+site.getMinLength();
        if(site.isCapital())
        {
            capitalPos = (Math.abs(random.nextInt())%length);
        }
        if(site.isSpecialChar())
        {
            specialPos = (Math.abs(random.nextInt())%length);
            while(specialPos==capitalPos)
            {
                specialPos = (Math.abs(random.nextInt())%length);
            }
        }
        if(site.isNumber())
        {
            numberPos = (Math.abs(random.nextInt())%length);
            while(numberPos==capitalPos || numberPos==specialPos)
            {
                numberPos = (Math.abs(random.nextInt())%length);
            }
        }

        System.out.println(length);
        for(int i=0; i<length;i++)
        {
            if(i==capitalPos)
            {
                pass = pass + (char)((Math.abs(random.nextInt())%26)+65);
            }
            else if(i==numberPos)
            {
                pass = pass + (char)((Math.abs(random.nextInt())%10)+48);
            }
            else if(i==specialPos)
            {
                int choice = Math.abs(random.nextInt())%8;
                if(choice==0) pass = pass + '!';
                else if(choice==1) pass = pass + '#';
                else if(choice==2) pass = pass + '$';
                else if(choice==3) pass = pass + '%';
                else if(choice==4) pass = pass + '^';
                else if(choice==5) pass = pass + '&';
                else if(choice==6) pass = pass + '*';
                else if(choice==7) pass = pass + '@';
            }
            else
            {
                pass=pass+(char)((Math.abs(random.nextInt())%26)+97);
            }

        }
        return pass;
    }

    @Override
    public String toString() {
        return "Site = " + site.getName() +// "\n" + "HashPass = " + Integer.toString(hashPass) +
                //"\n" + "HashSite = " + Integer.toString(hashSite) +
                //"\n" + "Combined = " + combined +
                '\n' + "min length = " + site.getMinLength() +
                '\n' + "max length = " + site.getMaxLength() +
                '\n' + "contains number? = " + site.isNumber() +
                '\n' + "contains capital? = " + site.isCapital() +
                '\n' + "contains special char? = " + site.isSpecialChar() +
                "\n" + "password = " + password;
    }
}
