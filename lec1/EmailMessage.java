import java.util.ArrayList;
/**
 *  EmailMessage class that initail date, hold  the to address, from address,
 *  ,subject line and massage. And also should print out the entire message to
 *  the terminal as shown above.
 *
 *  Created by Thitiporn Sukpartcharoen, 16 January 2020 for CPE 343
 */

public class EmailMessage
{
    // Create an string to get created date and time
    String dateTime = IOUtils.getDateTime();
    String toAddress;
    String fromAddress;
    String subjectLine;
    // Create an ArrayList that holds massage to String
    ArrayList<String> buffer = new ArrayList<String>();

    /**
     * Asks for an toAddess and set it as the value of the function
     */
    public void setToAddress(String to)
    {
        toAddress = to;
    }

    /**
     * Asks for an fromAddess and set it as the value of the function
     */
    public void setFromAddress(String from)
    {
        fromAddress = from;
    }

    /**
     * Asks for an setSubject and set it as the value of the function
     */
    public void setSubject(String subject)
    {
        subjectLine = subject;
    }

    /**
     * Asks for an massage and add it to arrayList of the function
     */
    public void addToBody(String line)
    {
        buffer.add(line);
    }

    /**
     * Print out the full email to the terminal
     */
    public void send()
    {
        // Create an string to get sent date and time
        String sentDateTime = IOUtils.getDateTime();
        System.out.println("----------------------------------­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­");
        System.out.println("[" + "Message created at"+ dateTime +"]");
        System.out.println("----------------------------------­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­");
        System.out.println("TO­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­: \t­"+ toAddress);
        System.out.println("FROM­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­: \t­"+ fromAddress);
        System.out.println("SU­­BJECT­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­: \t­"+ subjectLine);
        // Looping buffer arrayList to show massage
        buffer.forEach((n) -> System.out.println(n));
        System.out.println("----------------------------------­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­");
        System.out.println("[" + "Message sent at"+ sentDateTime +"]");
        System.out.println("----------------------------------­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­");
    }
    /**
     * Return ToAddress
     */
    public String getToAddress()
    {
        return this.toAddress;
    }
}