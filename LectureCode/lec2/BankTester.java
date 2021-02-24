/**
 * Simple driver to exercise the PiggyBank class
 * Created by Sally Goldin, 23 Jan 2020, for CPE343
 */
public class BankTester
{
    public static void main(String args[])
    {
	PiggyBank redBank;
	PiggyBank greenBank;
	PiggyBank blueBank;
	PiggyBank yellowBank;

	redBank = new PiggyBank("Jeff","red");
	redBank.printBankInfo();
	redBank.insertMoney(230);
	PiggyBank.summarizeBanks();
	redBank.insertMoney(100);
	redBank.printBankInfo();
	PiggyBank.summarizeBanks();

	greenBank = new PiggyBank("Sue","green");
	blueBank = new PiggyBank("Fred","blue");
	blueBank.printBankInfo();
	blueBank.insertMoney(870);
	blueBank.printBankInfo();
	PiggyBank.summarizeBanks();

	greenBank.printBankInfo();
	greenBank.insertMoney(400);
	greenBank.printBankInfo();
	PiggyBank.summarizeBanks();

	yellowBank = new PiggyBank("Mary","yellow");
	yellowBank.insertMoney(10);
	yellowBank.printBankInfo();
	PiggyBank.summarizeBanks();
    }

}
