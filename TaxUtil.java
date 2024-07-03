//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class TaxUtil {

    public double calculateTax(double amount,double rate) {
        return amount * rate;
    }
     public static void main(String []args)
     {
         TaxUtil tl=new TaxUtil();
         double tax=tl.calculateTax(2000,0.15);
         System.out.println(tax);
     }
}