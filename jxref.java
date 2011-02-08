// $Id: jxref.java,v 1.17 2011-02-06 16:38:59-08 - - $
// Stewart Bracken
// bbracken@ucsc.edu

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class jxref {
   static final String STDIN_NAME = "-";
   static boolean debug_dump_flag = false;
   static boolean lower_case_flag = false;

   static class printer implements visitor <String, queue <Integer>> {
      public void visit (String key, queue <Integer> value) {
         out.printf ("%s %s", key, value);
         for (int linenr: value) out.printf (" %d", linenr);
         out.printf ("%n");
      }
   }

   static void xref_file (String filename, Scanner scan) {
      treemap <String, queue <Integer>> map =
            new treemap <String, queue <Integer>> ();
      for (int linenr = 1; scan.hasNextLine (); ++linenr) {
         for (String word: scan.nextLine().split ("\\W+")) {
            if (word.matches ("^\\d*$")) continue;
            if (lower_case_flag == true) word =  word.toLowerCase();
            out.printf ("%s: %d: %s%n", filename, linenr, word);
         }
      }
      visitor <String, queue <Integer>> print_fn = new printer ();
      map.do_visit (print_fn);
   }

   static void getopt (String opts) {
      if ( opts.equals("-d") ) debug_dump_flag = true;
      else if ( opts.equals("-f") ) lower_case_flag = true;
      else if ( opts.equals("-df") ) {
         debug_dump_flag = true;
         lower_case_flag = true;
      } else if ( opts.equals("-fd") ) {
         debug_dump_flag = true;
         lower_case_flag = true;
      } else auxlib.warn ("SUCKA");
      return;
   }

   public static void main (String[] args) {
      boolean loopcheck = false;
      if (args.length == 0) { //no operands or filenames, go to stdin
         xref_file (STDIN_NAME, new Scanner (in));
      }else {
         if ( args[0].startsWith("-") && args[0].length() > 1 )
            getopt(args[0]);  //options check
         out.printf ("debug_dump: %s\n",debug_dump_flag);
         out.printf ("lowercase: %s\n",lower_case_flag);
         for (int argi = 0; argi < args.length; ++argi) {
            
            String filename = args[argi];
            if (filename.equals ("-d")||filename.equals("-f")||
                  filename.equals ("-df")||filename.equals("-fd")) {
               continue;
            }else if (filename.equals (STDIN_NAME)) {
               loopcheck = true;
               xref_file (STDIN_NAME, new Scanner (in));
            }else {
               try {
                  Scanner scan = new Scanner (new File (filename));
                  xref_file (filename, scan);
                  loopcheck = true;
                  scan.close ();
               }catch (IOException error) {
                  auxlib.warn (error.getMessage ());
               }
            }
         }
         if (loopcheck == false) xref_file (STDIN_NAME, new Scanner (in));
      }
      auxlib.exit ();
   }

}

