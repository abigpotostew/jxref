<<<<<<< HEAD
// $Id: treemap.java,v 1.30 2011-02-14 12:51:12-08 - - $
=======
// $Id: treemap.java,v 1.1 2011-01-28 19:52:24-08 - - $
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
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
<<<<<<< HEAD

   private node root;

   // Print tree in debug format with depth.
   private void debug_dump_rec (node tree, int depth) {
      if (tree == null) return;
      debug_dump_rec (tree.left, depth+1);
      for (int indnt = 0; indnt < depth; ++indnt) out.printf ("  ");
      out.printf ("%d %s %s%n", depth, tree.key, tree.value);
      debug_dump_rec (tree.right, depth + 1);
   }

   // Visit the tree recursively, in-order.
   private void do_visit_rec (visitor <key_t, value_t> visit_fn,
                              node tree) {
      if (tree == null) return;
      do_visit_rec ( visit_fn, tree.left );
      visit_fn.visit(tree.key, tree.value);
      do_visit_rec ( visit_fn, tree.right );
   }

   public value_t get (key_t key) {
      node curr = root;
      while (curr!=null){
         int cmp = key.compareTo(curr.key);
         if ( cmp == 0 ) return curr.value;
         if ( cmp < 0 ) curr = curr.left;
            else curr = curr.right;
      }
      return null;
   }

   // Add a queue and key pair to the binary search tree.
   public value_t put (key_t key, value_t value) {
      node newnode = new node();
      newnode.key = key;
      newnode.value = value;
      newnode.left = null;
      newnode.right = null;
      if (root == null) {
         root = newnode;
         return null;
      }
      node curr = root;
      while (curr!=null){
         int cmp = key.compareTo(curr.key);
         if ( cmp == 0 ) {
            curr.value = value;
            return curr.value;
         }
         if (cmp < 0) {
            if (curr.left == null) {
               curr.left = newnode;
               break;
            }else curr = curr.left;
         }else {
            if (curr.right == null){
               curr.right = newnode;
               break;
            }else curr = curr.right;
         }
      }
      return null;
=======
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
      

>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
   }

   public void debug_dump () {
      debug_dump_rec (root, 0);
   }

   public void do_visit (visitor <key_t, value_t> visit_fn) {
      do_visit_rec (visit_fn, root);
   }

}
