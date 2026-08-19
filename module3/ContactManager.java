import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 

        contacts.put("Marvin Gaye", new Contact("Marvin Gaye", "+1 415 564 0700"));
        contacts.put("Alicia Keys", new Contact("Alicia Keys", "+1 555 900 8122"));
        contacts.put("Steph Curry", new Contact("Steph Curry", "+1 510 657 3345"));
        contacts.put("Gordon Ramsay", new Contact("Gordon Ramsay", "+1 306 234 5555"));
        contacts.put("Steve Irwin", new Contact("Steve Irwin", "+1 345 678 9122"));

 
        // Step 5: look up a contact 

        Contact marvin = contacts.get("Marvin Gaye");
        
        if (marvin == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(marvin);
        }

        Contact missing = contacts.get("Beyonce");

        if (missing == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missing);
        }
 
        // Step 6: print sorted list

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName())); 

        System.out.println("All Contacts");
        System.out.println();

        //print every contact on newl
        for (Contact c : sorted) {
            System.out.println(c);
        }

    } 
}