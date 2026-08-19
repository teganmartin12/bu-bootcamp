import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 

    Contact c;
 
    @BeforeEach
    void setUp() {
        c = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

  @Test 
  void constructor_setsNameCorrectly() { 
    //Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("Ada Lovelace", c.getName()); 
  } 

  @Test
  void constructor_setsPhoneCorrectly() { 
    assertEquals("+1 617 555 0101", c.getPhone()); 
  }
 
 @Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    Contact c = new Contact("Chris Evans", "555-0001"); 
    assertTrue(c.toString().contains("Chris Evans"));
  } 
 
  @Test
  void toString_containsPhone() {
    Contact c = new Contact("Chris Evans", "555-0001");
    assertTrue(c.toString().contains("555-0001"));
  }

  @Test
    void twoContacts_withSameName_areIndependentObjects() {
        Contact c = new Contact("Chris Evans", "555-0001");
        Contact c1 = new Contact("Chris Evans", "555-0001");

        //checking they are diff objects
        assertNotSame(c, c1);

        //checking that the name and phone num are the same
        assertEquals(c.getName(), c1.getName());
        assertEquals(c.getPhone(), c1.getPhone());
    }
} 