public class Decimal2Binary
{   
    public String D2B(long s)
    {
        String temp = "";
        long tmp = s;
        if (s == 0) return "0";
        else if (s == 1) return "1";

        while(tmp!=1)
        {
            temp+=Long.toString(tmp%2);
            tmp/=2;
        }
        temp+="1";

        String b = "";

        for (long i = temp.length() - 1; i >= 0; i--)
            b += temp.charAt((int)i);

        return b;
    }
    public static void main(String args[])
    {
        Decimal2Binary obj = new Decimal2Binary();
        long ln = 31232;
        System.out.println("Decimal: "+ln+"\nBinary: "+ obj.D2B(ln));
    }
}
