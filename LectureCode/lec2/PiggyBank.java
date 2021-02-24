/**
 * PiggyBank example showing concurrent use of both instance
 * and static data and methods.
 *
 * Created by Sally Goldin, 23 Jan 2020, for CPE 343
 */
public class PiggyBank
{
    /** Owner of this bank */
    private String owner;
    
    /** Color of this bank */
    private String color;  /* in notes this is a Color object from java.awt */
    
    /** how much money is in this bank */
    private int currentAmount = 0;

    /** Total number of banks created so far */
    private static int bankCount = 0;

    /** Total money in all the banks */
    private static int totalMoney = 0;

    /**
     * Constructor creates a new bank. Also increments the
     * counter for banks.
     * @param ownerName    Name of the owner
     * @param colorName    String version of color
     */
    public PiggyBank(String ownerName, String colorName)
    {
	System.out.println("Creating new piggy bank...");
	owner = ownerName;
	color = colorName;
	bankCount++;
    }

    /**
     * Add money to this bank instance.
     * Also updates the static total 
     * @param amount   How much to add
     */
    public void insertMoney(int amount)
    {
	System.out.println(color + " bank - inserting " + amount + "...");
	currentAmount += amount;
	totalMoney += amount;
    }

    /**
     * print information about this bank 
     */
    public void printBankInfo()
    {
	System.out.println("Bank information\n\tOwner is " + owner);
	System.out.println("\tColor is " + color);
	System.out.println("\tCurrently this bank holds " + currentAmount + " baht");
    }

    /**
     * Print global information about the banks
     */
    public static void summarizeBanks()
    {
	System.out.println("Summary\n\tCurrently there are " + bankCount + " piggy banks");
	System.out.println("\tGrand total in all banks is " + totalMoney + " baht");
    }
}
