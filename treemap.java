// $Id: treemap.java,v 1.1 2011-01-28 19:52:24-08 - - $
// Stewart Bracken
// bbracken@ucsc.edu

import static java.lang.System.*;

class treemap <key_t extends Comparable <key_t>, value_t> {

   private class node {
      key_t key;
      value_t value;
      node left;
      node right;
   }
   private node root;

   private void debug_dump_rec (node tree, int depth) {
      //throw new UnsupportedOperationException ();
      //example code
      treemap <String, queue <Integer>> curr = root;
      while(curr!=null) {
         int cmp = curr.key.compareTo (key);
         out.printf ("curr=%s->{\"%s\", %s, %s}%n",
                             id(curr), curr.item, id(curr.left), id(curr.right));
         if (cmp == 0) return curr;
         if (cmp < 0) curr = curr.right;
            else curr = curr.left;
      }
      return null;
   }

   private void do_visit_rec (visitor <key_t, value_t> visit_fn,
                              node tree) {
      throw new UnsupportedOperationException ();
   }

   public value_t get (key_t key) {
      throw new UnsupportedOperationException ();
   }

   public value_t put (key_t key, value_t value) {
      //throw new UnsupportedOperationException ();
      //node newnode = new node();
      //newnode.key = key;
      //newnode.value = value;
      if (root == null) {
         node newnode = new node();
         newnode.key = key;
         newnode.value = value;
         root = newnode;
         return null;
      }
      //left
      //current
      //right
      treemap <String, queue <Integer>> curr = root;
      while (curr!=null){
         int cmp = curr.key.compareTo(key)
         if ( cmp == 0 ) {
            curr.key = key;
            return curr.key;
         } else if (cmp < 0) curr = ;
      }
      

   }

   public void debug_dump () {
      debug_dump_rec (root, 0);
   }

   public void do_visit (visitor <key_t, value_t> visit_fn) {
      do_visit_rec (visit_fn, root);
   }

}
