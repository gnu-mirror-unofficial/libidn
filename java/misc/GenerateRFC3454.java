/**
 * Copyright (C) 2004, 2005, 2006, 2007  Free Software Foundation, Inc.
 *
 * Author: Oliver Hitz
 *
 * This file is part of GNU Libidn.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class GenerateRFC3454
{
  static class Range
  {
    int t, f;

    public Range(String r)
    {
      if (r.length() == 9) {
	f = Integer.parseInt(r.substring(0, 4), 16);
	t = Integer.parseInt(r.substring(5, 9), 16);
      } else {
	f = Integer.parseInt(r.substring(0, 5), 16);
	t = Integer.parseInt(r.substring(6, 11), 16);
      }
    }

    public boolean hasNext()
    {
      return (f <= t);
    }

    public String next()
    {
      StringBuffer s = new StringBuffer(Integer.toHexString(f));
      while (s.length() < 4) {
	s.insert(0, '0');
      }
      f++;
      return s.toString();
    }
  }

  public static void main(String[] arg)
    throws Exception
  {
    File f = new File("rfc3454.txt");
    if (!f.exists()) {
      System.err.println("Unable to find rfc3454.txt.");
      System.err.println("Please download this file from:");
      System.err.println("http://www.ietf.org/rfc/rfc3454.txt");
      System.exit(1);
    }

    System.out.print("Creating RFC3454.java...");

    BufferedReader r = new BufferedReader(new FileReader(f));
    PrintWriter w = new PrintWriter(new FileWriter("RFC3454.java"));
    w.println("/* Do not edit - automatically generated */");
    w.println();
    w.println("public class RFC3454");
    w.println("{");
    
    int n = 0;
    
    String t = null;
    StringBuffer o1 = null;
    StringBuffer o2 = null;
    
    while (true) {
      String l = r.readLine();
      if (null == l) {
	break;
      }
      l = l.trim();
      
      if (l.equals("")) {
	// Ignore empty line
      } else if (-1 != l.indexOf("\u000c")) {
	// Ignore FF
      } else if (0 == l.indexOf("RFC")) {
	// Ignore page header
      } else if (0 == l.indexOf("Hoffman & Blanchet")) {
	// Ignore page footer
      } else if (-1 != l.indexOf("----- Start Table ")) {
	// Start of a table
	t = l.substring(l.indexOf("Table")+6, l.lastIndexOf("-----")-1);
	o1 = new StringBuffer();
	o2 = new StringBuffer();
      } else if (-1 != l.indexOf("----- End Table ")) {
	// End of a table
	if ("A.1".equals(t)) {
	  w.println("  final static char[][] A1 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("B.1".equals(t)) {
	  w.println("  final static char[] B1 = new char[] {\n"+o1.toString()+"  };\n");
	} else if ("B.2".equals(t)) {
	  w.println("  final static char[] B2search = new char[] {\n"+o1.toString()+"  };\n");
	  w.println("  final static String[] B2replace = new String[] {\n"+o2.toString()+"  };\n");
	} else if ("B.3".equals(t)) {
	  w.println("  final static char[] B3search = new char[] {\n"+o1.toString()+"  };\n");
	  w.println("  final static String[] B3replace = new String[] {\n"+o2.toString()+"  };\n");
	} else if ("C.1.1".equals(t)) {
	  w.println("  final static char[] C11 = new char[] {\n"+o1.toString()+"  };\n");
	} else if ("C.1.2".equals(t)) {
	  w.println("  final static char[] C12 = new char[] {\n"+o1.toString()+"  };\n");
	} else if ("C.2.1".equals(t)) {
	  w.println("  final static char[][] C21 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("C.2.2".equals(t)) {
	  w.println("  final static char[][] C22 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("C.3".equals(t)) {
	  w.println("  final static char[][] C3 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("C.4".equals(t)) {
	  w.println("  final static char[][] C4 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("C.5".equals(t)) {
	  w.println("  final static char[][] C5 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("C.6".equals(t)) {
	  w.println("  final static char[][] C6 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("C.7".equals(t)) {
	  w.println("  final static char[][] C7 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("C.8".equals(t)) {
	  w.println("  final static char[][] C8 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("D.1".equals(t)) {
	  w.println("  final static char[][] D1 = new char[][] {\n"+o1.toString()+"  };\n");
	} else if ("D.2".equals(t)) {
	  w.println("  final static char[][] D2 = new char[][] {\n"+o1.toString()+"  };\n");
	}
	t = null;
      } else if (null != t) {
	// Filter comments
	if (-1 != l.lastIndexOf(";")) {
	  String c = l.substring(l.lastIndexOf(";")).trim();
	  try {
	    Integer.parseInt(c, 16);
	  } catch (NumberFormatException e) {
	    l = l.substring(0, l.lastIndexOf(";"));
	  }
	}
	
	if ("A.1".equals(t)) {
	  if (4 == l.length()) {
	    o1.append("    new char[] { '\\u");
	    o1.append(l);
	    o1.append("' },\n");
	  } else if (5 == l.length()) {
	    // Skip characters outside the range of Java unicode
	  } else if (9 == l.length()) {
	    o1.append("    new char[] { '\\u");
	    o1.append(l.substring(0, 4));
	    o1.append("', '\\u");
	    o1.append(l.substring(5, 9));
	    o1.append("' },\n");
	  } else if (11 == l.length()) {
	    // Skip characters outside the range of Java unicode
	  } else {
	    System.err.println("Unknown format of A.1 line: "+l);
	  }
	} else if ("B.1".equals(t)) {
	  StringTokenizer tok = new StringTokenizer(l, " ;");
	  o1.append("    '\\u"+tok.nextToken()+"',\n");
	} else if ("B.2".equals(t) || "B.3".equals(t)) {
	  StringTokenizer tok = new StringTokenizer(l, "; ");
	  String c = tok.nextToken();
	  if (c.length() == 4) {
	    o1.append("    '\\u"+c+"',\n");
	    if (tok.hasMoreElements()) {
	      o2.append("    \"");
	      while (tok.hasMoreElements()) {
		o2.append("\\u"+tok.nextToken());
	      }
	      o2.append("\",\n");
	    } else {
	      o2.append("    null,\n");
	    }
	  }
	} else if ("C.1.1".equals(t)) {
	  o1.append("    '\\u"+l+"',\n");
	} else if ("C.1.2".equals(t)) {
	  o1.append("    '\\u"+l+"',\n");
	} else if ("C.2.1".equals(t) || "C.2.2".equals(t) || "C.3".equals(t) || "C.4".equals(t) || "C.5".equals(t) || "C.6".equals(t) || "C.7".equals(t) || "C.8".equals(t) || "D.1".equals(t) || "D.2".equals(t)) {
	  if (4 == l.length()) {
	    o1.append("    new char[] { '\\u"+l+"' },\n");
	  } else if (9 == l.length()) {
	    o1.append("    new char[] { '\\u");
	    o1.append(l.substring(0, 4));
	    o1.append("', '\\u");
	    o1.append(l.substring(5, 9));
	    o1.append("' },\n");
	  }
	}
      }
      
      n++;
    }
    
    w.println("}");
    w.close();
    
    System.out.println(" Ok.");
  }
}