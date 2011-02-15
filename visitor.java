// $Id: visitor.java,v 1.2 2011/02/14 20:51:12 - - bbracken $
// Stewart Bracken
// bbracken@ucsc.edu

interface visitor <key_t, value_t> {
   public void visit (key_t key, value_t value);
}
