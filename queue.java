// $Id: queue.java,v 1.10 2011/02/14 20:51:12 - - bbracken $
// Stewart Bracken
// bbracken@ucsc.edu

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
         else tail.link = newnode;
      tail = newnode;
      return;
   }

   // I couldn't figure out how to create a new iterator
   // with the given code. Though I did complete the iterator
   // class code.
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
         if ( isempty() ) return;
         if ( head != null ) head = head.link;
         if ( head == null ) tail = null;
      }
   }

}
