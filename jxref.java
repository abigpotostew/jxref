// $Id: jxref.java,v 1.56 2011-02-14 12:02:53-08 - - $
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
         out.printf ("%s", key);
         // How does one create a new itor on a queue?
         // I couldn't get the syntax right.
         for (int linenr: value) {
            out.printf (" %d", linenr);
         }
         out.printf ("%n");
      }
   }

   static void print_title (String filename) {
      out.printf ("%n");
      for (int ct = 0; ct < 65; ++ct) out.printf(":");
      out.printf ("%n%s%n", filename);
      for (int ct = 0; ct < 65; ++ct) out.printf(":");
      out.printf ("%n%n");
   }

   static void xref_file (String filename, Scanner scan) {
      print_title(filename);
      treemap <String, queue <Integer>> map =
            new treemap <String, queue <Integer>> ();
      for (int linenr = 1; scan.hasNextLine (); ++linenr) {
         for (String word: scan.nextLine().split ("\\W+")) {
            if (word.matches ("^\\d*$")) continue;
            if (lower_case_flag == true) word =  word.toLowerCase();
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
   static void getopt (String opts) {
      if ( opts.equals("-d") ) debug_dump_flag = true;
      else if ( opts.equals("-f") ) lower_case_flag = true;
      else if ( opts.equals("-df") ) {
         debug_dump_flag = true;
         lower_case_flag = true;
      } else if ( opts.equals("-fd") ) {
         debug_dump_flag = true;
         lower_case_flag = true;
      } else auxlib.usage_exit ("[-df] [filename...]");
      return;
   }

   public static void main (String[] args) {
      boolean loopcheck = false;
      if (args.length == 0) {
         xref_file (STDIN_NAME, new Scanner (in));
      }else {
         if ( args[0].startsWith("-") && args[0].length() > 1 )
            getopt(args[0]);
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
                  //send file to xref_file or throw IO exception
                  Scanner scan = new Scanner (new File (filename));
                  xref_file (filename, scan);
                  loopcheck = true;
                  scan.close ();
               }catch (IOException error) {
                  auxlib.warn (error.getMessage ());
               }
            }
         }
         //if options found but no filename given, read from stdin
         if (loopcheck == false &&
               (debug_dump_flag==true || lower_case_flag==true))
            xref_file (STDIN_NAME, new Scanner (in));
      }
      auxlib.exit ();
   }

}

