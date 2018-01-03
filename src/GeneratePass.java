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
        String hashP=Integer.toString(one);
        String hashS=Integer.toString(two);

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

        return Long.valueOf(tempOut);
    }
    private String genPass(Random random,Site site)
    {
        String pass="";
        int length = (Math.abs(random.nextInt())%(Math.abs(site.getMaxLength()-site.getMinLength())))+site.getMinLength();
        System.out.println(length);
        for(int i=0; i<length;i++)
        {
            pass=pass+(char)((Math.abs(random.nextInt())%26)+97);
        }
        return pass;
    }

    @Override
    public String toString() {
        return "Site = " + site.getName() + "\n" + "HashPass = " + Integer.toString(hashPass) +
                "\n" + "HashSite = " + Integer.toString(hashSite) +
                "\n" + "Combined = " + combined +
                "\n" + "password = " + password;
    }
}
