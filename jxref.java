<<<<<<< HEAD
// $Id: jxref.java,v 1.56 2011-02-14 12:02:53-08 - - $
// Stewart Bracken
// bbracken@ucsc.edu
=======
// $Id: jxref.java,v 1.17 2011-02-06 16:38:59-08 - - $
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class jxref {
   static final String STDIN_NAME = "-";
   static boolean debug_dump_flag = false;
   static boolean lower_case_flag = false;

   static class printer implements visitor <String, queue <Integer>> {
      public void visit (String key, queue <Integer> value) {
<<<<<<< HEAD
         out.printf ("%s", key);
         // How does one create a new itor on a queue?
         // I couldn't get the syntax right.
         for (int linenr: value) {
            out.printf (" %d", linenr);
         }
=======
         out.printf ("%s %s", key, value);
         for (int linenr: value) out.printf (" %d", linenr);
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
         out.printf ("%n");
      }
   }

<<<<<<< HEAD
   static void print_title (String filename) {
      out.printf ("%n");
      for (int ct = 0; ct < 65; ++ct) out.printf(":");
      out.printf ("%n%s%n", filename);
      for (int ct = 0; ct < 65; ++ct) out.printf(":");
      out.printf ("%n%n");
   }

   static void xref_file (String filename, Scanner scan) {
      print_title(filename);
=======
   static void xref_file (String filename, Scanner scan) {
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
      treemap <String, queue <Integer>> map =
            new treemap <String, queue <Integer>> ();
      for (int linenr = 1; scan.hasNextLine (); ++linenr) {
         for (String word: scan.nextLine().split ("\\W+")) {
            if (word.matches ("^\\d*$")) continue;
            if (lower_case_flag == true) word =  word.toLowerCase();
<<<<<<< HEAD
            queue<Integer> qcheck = map.get(word);
            if (qcheck != null) {
               qcheck.insert(linenr);
            }else {
                  queue<Integer> newqueue = new queue <Integer> ();
                  newqueue.insert(linenr);
                  map.put(word, newqueue);
               }
         }
      }
      //either do_visit or debug_dump.
      if (debug_dump_flag == true) map.debug_dump();
         else {
            visitor <String, queue <Integer>> print_fn = new printer ();
            map.do_visit (print_fn);
         }
   }

   // scans for args or exits with usage_exit status 1.
=======
            out.printf ("%s: %d: %s%n", filename, linenr, word);
         }
      }
      visitor <String, queue <Integer>> print_fn = new printer ();
      map.do_visit (print_fn);
   }

>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
   static void getopt (String opts) {
      if ( opts.equals("-d") ) debug_dump_flag = true;
      else if ( opts.equals("-f") ) lower_case_flag = true;
      else if ( opts.equals("-df") ) {
         debug_dump_flag = true;
         lower_case_flag = true;
      } else if ( opts.equals("-fd") ) {
         debug_dump_flag = true;
         lower_case_flag = true;
<<<<<<< HEAD
      } else auxlib.usage_exit ("[-df] [filename...]");
=======
      } else auxlib.warn ("SUCKA");
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
      return;
   }

   public static void main (String[] args) {
      boolean loopcheck = false;
<<<<<<< HEAD
      if (args.length == 0) {
         xref_file (STDIN_NAME, new Scanner (in));
      }else {
         if ( args[0].startsWith("-") && args[0].length() > 1 )
            getopt(args[0]);
         for (int argi = 0; argi < args.length; ++argi) {
=======
      if (args.length == 0) { //no operands or filenames, go to stdin
         xref_file (STDIN_NAME, new Scanner (in));
      }else {
         if ( args[0].startsWith("-") && args[0].length() > 1 )
            getopt(args[0]);  //options check
         out.printf ("debug_dump: %s\n",debug_dump_flag);
         out.printf ("lowercase: %s\n",lower_case_flag);
         for (int argi = 0; argi < args.length; ++argi) {
            
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
            String filename = args[argi];
            if (filename.equals ("-d")||filename.equals("-f")||
                  filename.equals ("-df")||filename.equals("-fd")) {
               continue;
            }else if (filename.equals (STDIN_NAME)) {
               loopcheck = true;
               xref_file (STDIN_NAME, new Scanner (in));
            }else {
               try {
<<<<<<< HEAD
                  //send file to xref_file or throw IO exception
=======
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
                  Scanner scan = new Scanner (new File (filename));
                  xref_file (filename, scan);
                  loopcheck = true;
                  scan.close ();
               }catch (IOException error) {
                  auxlib.warn (error.getMessage ());
               }
            }
         }
<<<<<<< HEAD
         //if options found but no filename given, read from stdin
         if (loopcheck == false &&
               (debug_dump_flag==true || lower_case_flag==true))
            xref_file (STDIN_NAME, new Scanner (in));
=======
         if (loopcheck == false) xref_file (STDIN_NAME, new Scanner (in));
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
      }
      auxlib.exit ();
   }

}

