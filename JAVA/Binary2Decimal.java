public class Binary2Decimal
{
    public long B2D(String s)
    {
        long d = 0;
        for (long i = s.length()-1; i>=0; i--)
            d += ((long)s.charAt((int)i) - (long)'0')*Math.pow(2,s.length()-1-i);
        return d;
    }
    
    public static void main(String args[])
    {
        Binary2Decimal obj = new Binary2Decimal();
        String str = "1010101001010101010101";
        System.out.println("Binary: "+str+"\nDecimal: "+obj.B2D(str));
    }
}