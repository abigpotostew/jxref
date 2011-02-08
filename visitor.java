// $Id: visitor.java,v 1.1 2011-01-28 19:52:24-08 - - $
// Stewart Bracken
// bbracken@ucsc.edu

interface visitor <key_t, value_t> {
   public void visit (key_t key, value_t value);
}

