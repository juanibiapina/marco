
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue Aug 14 20:06:51 BRT 2012
//----------------------------------------------------

package marco.parser;

import java_cup.runtime.*;
import marco.lang.*;
import marco.lang.types.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Tue Aug 14 20:06:51 BRT 2012
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\021\000\002\002\004\000\002\002\003\000\002\002" +
    "\004\000\002\002\005\000\002\003\004\000\002\003\003" +
    "\000\002\004\003\000\002\004\005\000\002\005\003\000" +
    "\002\005\004\000\002\006\003\000\002\006\003\000\002" +
    "\006\003\000\002\006\003\000\002\007\005\000\002\010" +
    "\002\000\002\010\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\026\000\014\005\006\010\013\011\012\012\007\013" +
    "\011\001\002\000\010\002\000\004\027\007\000\001\002" +
    "\000\010\002\ufffc\004\ufffc\007\ufffc\001\002\000\012\010" +
    "\013\011\012\012\007\013\011\001\002\000\014\002\ufff5" +
    "\004\ufff5\005\ufff5\006\ufff5\007\ufff5\001\002\000\014\002" +
    "\ufff9\004\ufff9\005\ufff9\006\022\007\ufff9\001\002\000\014" +
    "\002\ufff4\004\ufff4\005\ufff4\006\ufff4\007\ufff4\001\002\000" +
    "\014\002\ufff6\004\ufff6\005\ufff6\006\ufff6\007\ufff6\001\002" +
    "\000\014\002\ufff7\004\ufff7\005\ufff7\006\ufff7\007\ufff7\001" +
    "\002\000\004\002\020\001\002\000\012\002\ufffb\004\ufffb" +
    "\005\016\007\ufffb\001\002\000\012\010\013\011\012\012" +
    "\007\013\011\001\002\000\010\002\ufffa\004\ufffa\007\ufffa" +
    "\001\002\000\004\002\001\001\002\000\012\002\ufff8\004" +
    "\ufff8\005\ufff8\007\ufff8\001\002\000\016\005\006\007\ufff2" +
    "\010\013\011\012\012\007\013\011\001\002\000\004\007" +
    "\025\001\002\000\004\007\ufff1\001\002\000\012\002\ufff3" +
    "\004\ufff3\005\ufff3\007\ufff3\001\002\000\010\002\ufffd\004" +
    "\ufffd\007\ufffd\001\002\000\020\002\uffff\005\006\007\uffff" +
    "\010\013\011\012\012\007\013\011\001\002\000\006\002" +
    "\ufffe\007\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\026\000\014\002\013\003\003\004\004\005\014\006" +
    "\007\001\001\000\002\001\001\000\002\001\001\000\010" +
    "\004\025\005\014\006\007\001\001\000\002\001\001\000" +
    "\004\007\020\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\010\004\016\005\014\006\007\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\016\002\023\003" +
    "\003\004\004\005\014\006\007\010\022\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\014\002\027\003\003\004\004\005\014\006\007" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public MarcoRuntime runtime;

    public void report_error(String message, Object info) {

        StringBuffer m = new StringBuffer("Error");

        if (info instanceof java_cup.runtime.Symbol) {
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);

            if (s.left >= 0) {
                m.append(" in line "+(s.left+1));
                if (s.right >= 0)
                    m.append(", column "+(s.right+1));
            }
        }

        m.append(" : "+message);

        System.err.println(m);
    }

    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        System.exit(1);
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // arglist ::= chainlist 
            {
              MarcoObject RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		MarcoObject c = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = c; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("arglist",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // arglist ::= 
            {
              MarcoObject RESULT =null;
		 RESULT = parser.runtime.createList(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("arglist",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // arguments ::= LPAREN arglist RPAREN 
            {
              MarcoObject RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		MarcoObject l = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = l; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("arguments",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // symbol ::= STRING 
            {
              MarcoObject RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = parser.runtime.createStringMessage(id); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("symbol",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // symbol ::= NUMBER 
            {
              MarcoObject RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = parser.runtime.createNumberMessage(id); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("symbol",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // symbol ::= OPERATOR 
            {
              MarcoObject RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = parser.runtime.createMessage(id); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("symbol",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // symbol ::= IDENTIFIER 
            {
              MarcoObject RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = parser.runtime.createMessage(id); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("symbol",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // message ::= symbol arguments 
            {
              MarcoObject RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		MarcoObject s = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		MarcoObject l = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = Message.addArgument(s, l); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("message",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // message ::= symbol 
            {
              MarcoObject RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		MarcoObject s = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = s; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("message",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // messagelist ::= message WHITESPACE messagelist 
            {
              MarcoObject RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		MarcoObject m = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		MarcoObject l = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                          MarcoObject messages = parser.runtime.createList();
                          List.add(messages, m);
                          List.addAll(messages, l);
                          RESULT = messages;
                        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("messagelist",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // messagelist ::= message 
            {
              MarcoObject RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		MarcoObject m = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                          MarcoObject messages = parser.runtime.createList();
                          List.add(messages, m);
                          RESULT = messages;
                        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("messagelist",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // chain ::= messagelist 
            {
              MarcoObject RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		MarcoObject l = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = parser.runtime.createChain(l); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("chain",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // chain ::= WHITESPACE messagelist 
            {
              MarcoObject RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("chain",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // chainlist ::= chain SEPARATOR chainlist 
            {
              MarcoObject RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		MarcoObject c = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		MarcoObject l = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                          MarcoObject chains = parser.runtime.createList();
                          List.add(chains, c);
                          List.addAll(chains, l);
                          RESULT = chains;
                        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("chainlist",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // chainlist ::= chain SEPARATOR 
            {
              MarcoObject RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		MarcoObject c = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
                          MarcoObject chains = parser.runtime.createList();
                          List.add(chains, c);
                          RESULT = chains;
                        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("chainlist",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // chainlist ::= chain 
            {
              MarcoObject RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		MarcoObject c = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                          MarcoObject chains = parser.runtime.createList();
                          List.add(chains, c);
                          RESULT = chains;
                        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("chainlist",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= chainlist EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		MarcoObject start_val = (MarcoObject)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

