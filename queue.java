<<<<<<< HEAD
// $Id: queue.java,v 1.10 2011-02-14 12:51:12-08 - - $
// Stewart Bracken
// bbracken@ucsc.edu
=======
// $Id: queue.java,v 1.1 2011-01-28 19:52:24-08 - - $
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1

import java.util.Iterator;
import java.util.NoSuchElementException;

class queue <item_t> implements Iterable <item_t> {

   private class node {
      item_t item;
      node link;
   }
   private node head = null;
   private node tail = null;

   public boolean isempty () {
      return head == null;
   }

   public void insert (item_t newitem) {
      node newnode = new node();
      newnode.item = newitem;
      newnode.link = null;
      if (head == null) head = newnode;
<<<<<<< HEAD
         else tail.link = newnode;
      tail = newnode;
      return;
   }

   // I couldn't figure out how to create a new iterator
   // with the given code. Though I did complete the iterator
   // class code.
=======
         else rear.link = newnode;
      rear = newnode;
      return;
   }

>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
   public Iterator <item_t> iterator () {
      return new itor ();
   }

   class itor implements Iterator <item_t> {
      node next = head;
      public boolean hasNext () {
         return next != null;
      }
      public item_t next () {
         if (! hasNext ()) throw new NoSuchElementException ();
         item_t result = next.item;
         next = next.link;
         return result;
      }
      public void remove () {
<<<<<<< HEAD
         if ( isempty() ) return;
         if ( head != null ) head = head.link;
         if ( head == null ) tail = null;
=======
         throw new UnsupportedOperationException ();
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
      }
   }

}
