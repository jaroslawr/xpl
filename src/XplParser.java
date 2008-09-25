// $ANTLR 3.1 Xpl.g 2008-09-25 16:41:45

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class XplParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CALL", "CALL_ARGUMENTS", "WHILE", "WHILE_BODY", "IF", "IF_BODY", "ELSE", "ELSE_BODY", "METHOD", "METHOD_BODY", "RETURN", "IDENTIFIER", "NUMBER", "STRING", "NEWLINE", "WS", "'end'", "'method'", "'('", "')'", "','", "'if'", "'else'", "'while'", "'='", "'&&'", "'||'", "'=='", "'<='", "'>='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'return'"
    };
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int WHILE=6;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int ELSE=10;
    public static final int NUMBER=16;
    public static final int ELSE_BODY=11;
    public static final int EOF=-1;
    public static final int IF=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int WS=19;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int NEWLINE=18;
    public static final int T__35=35;
    public static final int CALL_ARGUMENTS=5;
    public static final int T__36=36;
    public static final int METHOD_BODY=13;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int IDENTIFIER=15;
    public static final int RETURN=14;
    public static final int CALL=4;
    public static final int IF_BODY=9;
    public static final int METHOD=12;
    public static final int WHILE_BODY=7;
    public static final int STRING=17;

    // delegates
    // delegators


        public XplParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public XplParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return XplParser.tokenNames; }
    public String getGrammarFileName() { return "Xpl.g"; }


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // Xpl.g:7:1: program : ( ( method_definition | atomic_operation ) ( newline )? )+ ;
    public final XplParser.program_return program() throws RecognitionException {
        XplParser.program_return retval = new XplParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        XplParser.method_definition_return method_definition1 = null;

        XplParser.atomic_operation_return atomic_operation2 = null;

        XplParser.newline_return newline3 = null;



        try {
            // Xpl.g:7:8: ( ( ( method_definition | atomic_operation ) ( newline )? )+ )
            // Xpl.g:7:26: ( ( method_definition | atomic_operation ) ( newline )? )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // Xpl.g:7:26: ( ( method_definition | atomic_operation ) ( newline )? )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=IDENTIFIER && LA3_0<=STRING)||(LA3_0>=21 && LA3_0<=22)||LA3_0==25||LA3_0==27||LA3_0==41) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Xpl.g:7:27: ( method_definition | atomic_operation ) ( newline )?
            	    {
            	    // Xpl.g:7:27: ( method_definition | atomic_operation )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==21) ) {
            	        alt1=1;
            	    }
            	    else if ( ((LA1_0>=IDENTIFIER && LA1_0<=STRING)||LA1_0==22||LA1_0==25||LA1_0==27||LA1_0==41) ) {
            	        alt1=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // Xpl.g:7:28: method_definition
            	            {
            	            pushFollow(FOLLOW_method_definition_in_program80);
            	            method_definition1=method_definition();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, method_definition1.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // Xpl.g:7:48: atomic_operation
            	            {
            	            pushFollow(FOLLOW_atomic_operation_in_program84);
            	            atomic_operation2=atomic_operation();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, atomic_operation2.getTree());

            	            }
            	            break;

            	    }

            	    // Xpl.g:7:66: ( newline )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==NEWLINE) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // Xpl.g:7:66: newline
            	            {
            	            pushFollow(FOLLOW_newline_in_program87);
            	            newline3=newline();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, newline3.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class atomic_operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atomic_operation"
    // Xpl.g:9:1: atomic_operation : ( conditional | loop | assignment | expression | return_expression );
    public final XplParser.atomic_operation_return atomic_operation() throws RecognitionException {
        XplParser.atomic_operation_return retval = new XplParser.atomic_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        XplParser.conditional_return conditional4 = null;

        XplParser.loop_return loop5 = null;

        XplParser.assignment_return assignment6 = null;

        XplParser.expression_return expression7 = null;

        XplParser.return_expression_return return_expression8 = null;



        try {
            // Xpl.g:9:17: ( conditional | loop | assignment | expression | return_expression )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt4=1;
                }
                break;
            case 27:
                {
                alt4=2;
                }
                break;
            case IDENTIFIER:
                {
                int LA4_3 = input.LA(2);

                if ( (LA4_3==EOF||(LA4_3>=IDENTIFIER && LA4_3<=NEWLINE)||(LA4_3>=20 && LA4_3<=22)||LA4_3==25||LA4_3==27||(LA4_3>=29 && LA4_3<=41)) ) {
                    alt4=4;
                }
                else if ( (LA4_3==28) ) {
                    alt4=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;
                }
                }
                break;
            case NUMBER:
            case STRING:
            case 22:
                {
                alt4=4;
                }
                break;
            case 41:
                {
                alt4=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // Xpl.g:9:26: conditional
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_conditional_in_atomic_operation104);
                    conditional4=conditional();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conditional4.getTree());

                    }
                    break;
                case 2 :
                    // Xpl.g:9:40: loop
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_loop_in_atomic_operation108);
                    loop5=loop();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, loop5.getTree());

                    }
                    break;
                case 3 :
                    // Xpl.g:9:47: assignment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignment_in_atomic_operation112);
                    assignment6=assignment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment6.getTree());

                    }
                    break;
                case 4 :
                    // Xpl.g:9:60: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_atomic_operation116);
                    expression7=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression7.getTree());

                    }
                    break;
                case 5 :
                    // Xpl.g:9:73: return_expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_return_expression_in_atomic_operation120);
                    return_expression8=return_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, return_expression8.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atomic_operation"

    public static class atomic_operations_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atomic_operations_list"
    // Xpl.g:11:1: atomic_operations_list : ( atomic_operation ( newline )? )+ ;
    public final XplParser.atomic_operations_list_return atomic_operations_list() throws RecognitionException {
        XplParser.atomic_operations_list_return retval = new XplParser.atomic_operations_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        XplParser.atomic_operation_return atomic_operation9 = null;

        XplParser.newline_return newline10 = null;



        try {
            // Xpl.g:11:23: ( ( atomic_operation ( newline )? )+ )
            // Xpl.g:11:26: ( atomic_operation ( newline )? )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // Xpl.g:11:26: ( atomic_operation ( newline )? )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=IDENTIFIER && LA6_0<=STRING)||LA6_0==22||LA6_0==25||LA6_0==27||LA6_0==41) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Xpl.g:11:27: atomic_operation ( newline )?
            	    {
            	    pushFollow(FOLLOW_atomic_operation_in_atomic_operations_list129);
            	    atomic_operation9=atomic_operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomic_operation9.getTree());
            	    // Xpl.g:11:44: ( newline )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==NEWLINE) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // Xpl.g:11:45: newline
            	            {
            	            pushFollow(FOLLOW_newline_in_atomic_operations_list132);
            	            newline10=newline();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atomic_operations_list"

    public static class method_definition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method_definition"
    // Xpl.g:13:1: method_definition : method_header method_body 'end' -> ^( METHOD method_header METHOD_BODY method_body ) ;
    public final XplParser.method_definition_return method_definition() throws RecognitionException {
        XplParser.method_definition_return retval = new XplParser.method_definition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal13=null;
        XplParser.method_header_return method_header11 = null;

        XplParser.method_body_return method_body12 = null;


        CommonTree string_literal13_tree=null;
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleSubtreeStream stream_method_body=new RewriteRuleSubtreeStream(adaptor,"rule method_body");
        RewriteRuleSubtreeStream stream_method_header=new RewriteRuleSubtreeStream(adaptor,"rule method_header");
        try {
            // Xpl.g:13:18: ( method_header method_body 'end' -> ^( METHOD method_header METHOD_BODY method_body ) )
            // Xpl.g:13:26: method_header method_body 'end'
            {
            pushFollow(FOLLOW_method_header_in_method_definition150);
            method_header11=method_header();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_method_header.add(method_header11.getTree());
            pushFollow(FOLLOW_method_body_in_method_definition152);
            method_body12=method_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_method_body.add(method_body12.getTree());
            string_literal13=(Token)match(input,20,FOLLOW_20_in_method_definition154); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_20.add(string_literal13);



            // AST REWRITE
            // elements: method_body, method_header
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 13:58: -> ^( METHOD method_header METHOD_BODY method_body )
            {
                // Xpl.g:13:61: ^( METHOD method_header METHOD_BODY method_body )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(METHOD, "METHOD"), root_1);

                adaptor.addChild(root_1, stream_method_header.nextTree());
                adaptor.addChild(root_1, (CommonTree)adaptor.create(METHOD_BODY, "METHOD_BODY"));
                adaptor.addChild(root_1, stream_method_body.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "method_definition"

    public static class method_header_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method_header"
    // Xpl.g:15:1: method_header : ( 'method' identifier '(' ')' -> ^( identifier ) | 'method' identifier '(' method_arguments ')' -> ^( identifier method_arguments ) );
    public final XplParser.method_header_return method_header() throws RecognitionException {
        XplParser.method_header_return retval = new XplParser.method_header_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal14=null;
        Token char_literal16=null;
        Token char_literal17=null;
        Token string_literal18=null;
        Token char_literal20=null;
        Token char_literal22=null;
        XplParser.identifier_return identifier15 = null;

        XplParser.identifier_return identifier19 = null;

        XplParser.method_arguments_return method_arguments21 = null;


        CommonTree string_literal14_tree=null;
        CommonTree char_literal16_tree=null;
        CommonTree char_literal17_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree char_literal20_tree=null;
        CommonTree char_literal22_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleSubtreeStream stream_method_arguments=new RewriteRuleSubtreeStream(adaptor,"rule method_arguments");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // Xpl.g:16:5: ( 'method' identifier '(' ')' -> ^( identifier ) | 'method' identifier '(' method_arguments ')' -> ^( identifier method_arguments ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==IDENTIFIER) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==22) ) {
                        int LA7_3 = input.LA(4);

                        if ( (LA7_3==23) ) {
                            alt7=1;
                        }
                        else if ( (LA7_3==IDENTIFIER) ) {
                            alt7=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // Xpl.g:16:26: 'method' identifier '(' ')'
                    {
                    string_literal14=(Token)match(input,21,FOLLOW_21_in_method_header197); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_21.add(string_literal14);

                    pushFollow(FOLLOW_identifier_in_method_header199);
                    identifier15=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_identifier.add(identifier15.getTree());
                    char_literal16=(Token)match(input,22,FOLLOW_22_in_method_header201); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_22.add(char_literal16);

                    char_literal17=(Token)match(input,23,FOLLOW_23_in_method_header203); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_23.add(char_literal17);



                    // AST REWRITE
                    // elements: identifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 16:54: -> ^( identifier )
                    {
                        // Xpl.g:16:57: ^( identifier )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_identifier.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Xpl.g:17:26: 'method' identifier '(' method_arguments ')'
                    {
                    string_literal18=(Token)match(input,21,FOLLOW_21_in_method_header236); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_21.add(string_literal18);

                    pushFollow(FOLLOW_identifier_in_method_header238);
                    identifier19=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_identifier.add(identifier19.getTree());
                    char_literal20=(Token)match(input,22,FOLLOW_22_in_method_header240); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_22.add(char_literal20);

                    pushFollow(FOLLOW_method_arguments_in_method_header242);
                    method_arguments21=method_arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_method_arguments.add(method_arguments21.getTree());
                    char_literal22=(Token)match(input,23,FOLLOW_23_in_method_header244); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_23.add(char_literal22);



                    // AST REWRITE
                    // elements: method_arguments, identifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 17:71: -> ^( identifier method_arguments )
                    {
                        // Xpl.g:17:74: ^( identifier method_arguments )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_identifier.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_method_arguments.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "method_header"

    public static class method_arguments_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method_arguments"
    // Xpl.g:19:1: method_arguments : identifier ( ',' identifier )* ;
    public final XplParser.method_arguments_return method_arguments() throws RecognitionException {
        XplParser.method_arguments_return retval = new XplParser.method_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal24=null;
        XplParser.identifier_return identifier23 = null;

        XplParser.identifier_return identifier25 = null;


        CommonTree char_literal24_tree=null;

        try {
            // Xpl.g:19:17: ( identifier ( ',' identifier )* )
            // Xpl.g:19:26: identifier ( ',' identifier )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_method_arguments266);
            identifier23=identifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier23.getTree());
            // Xpl.g:19:37: ( ',' identifier )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Xpl.g:19:38: ',' identifier
            	    {
            	    char_literal24=(Token)match(input,24,FOLLOW_24_in_method_arguments269); if (state.failed) return retval;
            	    pushFollow(FOLLOW_identifier_in_method_arguments272);
            	    identifier25=identifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier25.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "method_arguments"

    public static class method_body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method_body"
    // Xpl.g:21:1: method_body : ( atomic_operation )+ ;
    public final XplParser.method_body_return method_body() throws RecognitionException {
        XplParser.method_body_return retval = new XplParser.method_body_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        XplParser.atomic_operation_return atomic_operation26 = null;



        try {
            // Xpl.g:21:12: ( ( atomic_operation )+ )
            // Xpl.g:21:26: ( atomic_operation )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // Xpl.g:21:26: ( atomic_operation )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=IDENTIFIER && LA9_0<=STRING)||LA9_0==22||LA9_0==25||LA9_0==27||LA9_0==41) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Xpl.g:21:26: atomic_operation
            	    {
            	    pushFollow(FOLLOW_atomic_operation_in_method_body293);
            	    atomic_operation26=atomic_operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomic_operation26.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "method_body"

    public static class conditional_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditional"
    // Xpl.g:23:1: conditional : 'if' expression ( newline )? atomic_operations_list 'end' -> ^( IF expression IF_BODY atomic_operations_list ) ;
    public final XplParser.conditional_return conditional() throws RecognitionException {
        XplParser.conditional_return retval = new XplParser.conditional_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal27=null;
        Token string_literal31=null;
        XplParser.expression_return expression28 = null;

        XplParser.newline_return newline29 = null;

        XplParser.atomic_operations_list_return atomic_operations_list30 = null;


        CommonTree string_literal27_tree=null;
        CommonTree string_literal31_tree=null;
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_atomic_operations_list=new RewriteRuleSubtreeStream(adaptor,"rule atomic_operations_list");
        RewriteRuleSubtreeStream stream_newline=new RewriteRuleSubtreeStream(adaptor,"rule newline");
        try {
            // Xpl.g:23:12: ( 'if' expression ( newline )? atomic_operations_list 'end' -> ^( IF expression IF_BODY atomic_operations_list ) )
            // Xpl.g:23:26: 'if' expression ( newline )? atomic_operations_list 'end'
            {
            string_literal27=(Token)match(input,25,FOLLOW_25_in_conditional313); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_25.add(string_literal27);

            pushFollow(FOLLOW_expression_in_conditional315);
            expression28=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression28.getTree());
            // Xpl.g:23:42: ( newline )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==NEWLINE) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Xpl.g:23:42: newline
                    {
                    pushFollow(FOLLOW_newline_in_conditional317);
                    newline29=newline();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_newline.add(newline29.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_atomic_operations_list_in_conditional320);
            atomic_operations_list30=atomic_operations_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_atomic_operations_list.add(atomic_operations_list30.getTree());
            string_literal31=(Token)match(input,20,FOLLOW_20_in_conditional322); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_20.add(string_literal31);



            // AST REWRITE
            // elements: atomic_operations_list, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 24:26: -> ^( IF expression IF_BODY atomic_operations_list )
            {
                // Xpl.g:24:29: ^( IF expression IF_BODY atomic_operations_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, (CommonTree)adaptor.create(IF_BODY, "IF_BODY"));
                adaptor.addChild(root_1, stream_atomic_operations_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conditional"

    public static class conditional_else_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditional_else"
    // Xpl.g:26:1: conditional_else : 'else' expression ( newline )? atomic_operations_list -> ^( ELSE expression ELSE_BODY atomic_operations_list ) ;
    public final XplParser.conditional_else_return conditional_else() throws RecognitionException {
        XplParser.conditional_else_return retval = new XplParser.conditional_else_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal32=null;
        XplParser.expression_return expression33 = null;

        XplParser.newline_return newline34 = null;

        XplParser.atomic_operations_list_return atomic_operations_list35 = null;


        CommonTree string_literal32_tree=null;
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_atomic_operations_list=new RewriteRuleSubtreeStream(adaptor,"rule atomic_operations_list");
        RewriteRuleSubtreeStream stream_newline=new RewriteRuleSubtreeStream(adaptor,"rule newline");
        try {
            // Xpl.g:26:17: ( 'else' expression ( newline )? atomic_operations_list -> ^( ELSE expression ELSE_BODY atomic_operations_list ) )
            // Xpl.g:26:26: 'else' expression ( newline )? atomic_operations_list
            {
            string_literal32=(Token)match(input,26,FOLLOW_26_in_conditional_else373); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_26.add(string_literal32);

            pushFollow(FOLLOW_expression_in_conditional_else375);
            expression33=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression33.getTree());
            // Xpl.g:26:44: ( newline )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NEWLINE) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Xpl.g:26:44: newline
                    {
                    pushFollow(FOLLOW_newline_in_conditional_else377);
                    newline34=newline();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_newline.add(newline34.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_atomic_operations_list_in_conditional_else380);
            atomic_operations_list35=atomic_operations_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_atomic_operations_list.add(atomic_operations_list35.getTree());


            // AST REWRITE
            // elements: atomic_operations_list, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 26:76: -> ^( ELSE expression ELSE_BODY atomic_operations_list )
            {
                // Xpl.g:26:79: ^( ELSE expression ELSE_BODY atomic_operations_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ELSE, "ELSE"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, (CommonTree)adaptor.create(ELSE_BODY, "ELSE_BODY"));
                adaptor.addChild(root_1, stream_atomic_operations_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conditional_else"

    public static class loop_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "loop"
    // Xpl.g:28:1: loop : 'while' expression ( newline )? atomic_operations_list 'end' -> ^( WHILE expression WHILE_BODY atomic_operations_list ) ;
    public final XplParser.loop_return loop() throws RecognitionException {
        XplParser.loop_return retval = new XplParser.loop_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal36=null;
        Token string_literal40=null;
        XplParser.expression_return expression37 = null;

        XplParser.newline_return newline38 = null;

        XplParser.atomic_operations_list_return atomic_operations_list39 = null;


        CommonTree string_literal36_tree=null;
        CommonTree string_literal40_tree=null;
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_atomic_operations_list=new RewriteRuleSubtreeStream(adaptor,"rule atomic_operations_list");
        RewriteRuleSubtreeStream stream_newline=new RewriteRuleSubtreeStream(adaptor,"rule newline");
        try {
            // Xpl.g:28:5: ( 'while' expression ( newline )? atomic_operations_list 'end' -> ^( WHILE expression WHILE_BODY atomic_operations_list ) )
            // Xpl.g:28:26: 'while' expression ( newline )? atomic_operations_list 'end'
            {
            string_literal36=(Token)match(input,27,FOLLOW_27_in_loop418); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_27.add(string_literal36);

            pushFollow(FOLLOW_expression_in_loop420);
            expression37=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression37.getTree());
            // Xpl.g:28:45: ( newline )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NEWLINE) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Xpl.g:28:45: newline
                    {
                    pushFollow(FOLLOW_newline_in_loop422);
                    newline38=newline();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_newline.add(newline38.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_atomic_operations_list_in_loop425);
            atomic_operations_list39=atomic_operations_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_atomic_operations_list.add(atomic_operations_list39.getTree());
            string_literal40=(Token)match(input,20,FOLLOW_20_in_loop427); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_20.add(string_literal40);



            // AST REWRITE
            // elements: atomic_operations_list, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 28:83: -> ^( WHILE expression WHILE_BODY atomic_operations_list )
            {
                // Xpl.g:28:86: ^( WHILE expression WHILE_BODY atomic_operations_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, (CommonTree)adaptor.create(WHILE_BODY, "WHILE_BODY"));
                adaptor.addChild(root_1, stream_atomic_operations_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "loop"

    public static class assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // Xpl.g:30:1: assignment : identifier ( '=' expression ) ;
    public final XplParser.assignment_return assignment() throws RecognitionException {
        XplParser.assignment_return retval = new XplParser.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal42=null;
        XplParser.identifier_return identifier41 = null;

        XplParser.expression_return expression43 = null;


        CommonTree char_literal42_tree=null;

        try {
            // Xpl.g:30:11: ( identifier ( '=' expression ) )
            // Xpl.g:30:26: identifier ( '=' expression )
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_assignment459);
            identifier41=identifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier41.getTree());
            // Xpl.g:30:37: ( '=' expression )
            // Xpl.g:30:38: '=' expression
            {
            char_literal42=(Token)match(input,28,FOLLOW_28_in_assignment462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal42_tree = (CommonTree)adaptor.create(char_literal42);
            root_0 = (CommonTree)adaptor.becomeRoot(char_literal42_tree, root_0);
            }
            pushFollow(FOLLOW_expression_in_assignment465);
            expression43=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression43.getTree());

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // Xpl.g:32:1: expression : boolean_expression ;
    public final XplParser.expression_return expression() throws RecognitionException {
        XplParser.expression_return retval = new XplParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        XplParser.boolean_expression_return boolean_expression44 = null;



        try {
            // Xpl.g:32:11: ( boolean_expression )
            // Xpl.g:32:26: boolean_expression
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_boolean_expression_in_expression486);
            boolean_expression44=boolean_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, boolean_expression44.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class boolean_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "boolean_expression"
    // Xpl.g:34:1: boolean_expression : comparision_expression ( ( '&&' | '||' ) boolean_expression )? ;
    public final XplParser.boolean_expression_return boolean_expression() throws RecognitionException {
        XplParser.boolean_expression_return retval = new XplParser.boolean_expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal46=null;
        Token string_literal47=null;
        XplParser.comparision_expression_return comparision_expression45 = null;

        XplParser.boolean_expression_return boolean_expression48 = null;


        CommonTree string_literal46_tree=null;
        CommonTree string_literal47_tree=null;

        try {
            // Xpl.g:34:19: ( comparision_expression ( ( '&&' | '||' ) boolean_expression )? )
            // Xpl.g:34:26: comparision_expression ( ( '&&' | '||' ) boolean_expression )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_comparision_expression_in_boolean_expression498);
            comparision_expression45=comparision_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, comparision_expression45.getTree());
            // Xpl.g:34:49: ( ( '&&' | '||' ) boolean_expression )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=29 && LA14_0<=30)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Xpl.g:34:50: ( '&&' | '||' ) boolean_expression
                    {
                    // Xpl.g:34:50: ( '&&' | '||' )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==29) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==30) ) {
                        alt13=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // Xpl.g:34:51: '&&'
                            {
                            string_literal46=(Token)match(input,29,FOLLOW_29_in_boolean_expression502); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal46_tree = (CommonTree)adaptor.create(string_literal46);
                            root_0 = (CommonTree)adaptor.becomeRoot(string_literal46_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // Xpl.g:34:59: '||'
                            {
                            string_literal47=(Token)match(input,30,FOLLOW_30_in_boolean_expression507); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal47_tree = (CommonTree)adaptor.create(string_literal47);
                            root_0 = (CommonTree)adaptor.becomeRoot(string_literal47_tree, root_0);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_boolean_expression_in_boolean_expression511);
                    boolean_expression48=boolean_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, boolean_expression48.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "boolean_expression"

    public static class comparision_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparision_expression"
    // Xpl.g:36:1: comparision_expression : arithmetic_expression ( ( '==' | '<=' | '>=' | '<' | '>' ) arithmetic_expression )? ;
    public final XplParser.comparision_expression_return comparision_expression() throws RecognitionException {
        XplParser.comparision_expression_return retval = new XplParser.comparision_expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal50=null;
        Token string_literal51=null;
        Token string_literal52=null;
        Token char_literal53=null;
        Token char_literal54=null;
        XplParser.arithmetic_expression_return arithmetic_expression49 = null;

        XplParser.arithmetic_expression_return arithmetic_expression55 = null;


        CommonTree string_literal50_tree=null;
        CommonTree string_literal51_tree=null;
        CommonTree string_literal52_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree char_literal54_tree=null;

        try {
            // Xpl.g:36:23: ( arithmetic_expression ( ( '==' | '<=' | '>=' | '<' | '>' ) arithmetic_expression )? )
            // Xpl.g:36:26: arithmetic_expression ( ( '==' | '<=' | '>=' | '<' | '>' ) arithmetic_expression )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression521);
            arithmetic_expression49=arithmetic_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmetic_expression49.getTree());
            // Xpl.g:36:48: ( ( '==' | '<=' | '>=' | '<' | '>' ) arithmetic_expression )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=31 && LA16_0<=35)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Xpl.g:36:49: ( '==' | '<=' | '>=' | '<' | '>' ) arithmetic_expression
                    {
                    // Xpl.g:36:49: ( '==' | '<=' | '>=' | '<' | '>' )
                    int alt15=5;
                    switch ( input.LA(1) ) {
                    case 31:
                        {
                        alt15=1;
                        }
                        break;
                    case 32:
                        {
                        alt15=2;
                        }
                        break;
                    case 33:
                        {
                        alt15=3;
                        }
                        break;
                    case 34:
                        {
                        alt15=4;
                        }
                        break;
                    case 35:
                        {
                        alt15=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }

                    switch (alt15) {
                        case 1 :
                            // Xpl.g:36:50: '=='
                            {
                            string_literal50=(Token)match(input,31,FOLLOW_31_in_comparision_expression525); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal50_tree = (CommonTree)adaptor.create(string_literal50);
                            root_0 = (CommonTree)adaptor.becomeRoot(string_literal50_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // Xpl.g:36:58: '<='
                            {
                            string_literal51=(Token)match(input,32,FOLLOW_32_in_comparision_expression530); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal51_tree = (CommonTree)adaptor.create(string_literal51);
                            root_0 = (CommonTree)adaptor.becomeRoot(string_literal51_tree, root_0);
                            }

                            }
                            break;
                        case 3 :
                            // Xpl.g:36:66: '>='
                            {
                            string_literal52=(Token)match(input,33,FOLLOW_33_in_comparision_expression535); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal52_tree = (CommonTree)adaptor.create(string_literal52);
                            root_0 = (CommonTree)adaptor.becomeRoot(string_literal52_tree, root_0);
                            }

                            }
                            break;
                        case 4 :
                            // Xpl.g:36:74: '<'
                            {
                            char_literal53=(Token)match(input,34,FOLLOW_34_in_comparision_expression540); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal53_tree = (CommonTree)adaptor.create(char_literal53);
                            root_0 = (CommonTree)adaptor.becomeRoot(char_literal53_tree, root_0);
                            }

                            }
                            break;
                        case 5 :
                            // Xpl.g:36:81: '>'
                            {
                            char_literal54=(Token)match(input,35,FOLLOW_35_in_comparision_expression545); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal54_tree = (CommonTree)adaptor.create(char_literal54);
                            root_0 = (CommonTree)adaptor.becomeRoot(char_literal54_tree, root_0);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression549);
                    arithmetic_expression55=arithmetic_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmetic_expression55.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparision_expression"

    public static class arithmetic_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arithmetic_expression"
    // Xpl.g:38:1: arithmetic_expression : term ( ( '+' | '-' ) term )* ;
    public final XplParser.arithmetic_expression_return arithmetic_expression() throws RecognitionException {
        XplParser.arithmetic_expression_return retval = new XplParser.arithmetic_expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal57=null;
        Token char_literal58=null;
        XplParser.term_return term56 = null;

        XplParser.term_return term59 = null;


        CommonTree char_literal57_tree=null;
        CommonTree char_literal58_tree=null;

        try {
            // Xpl.g:38:22: ( term ( ( '+' | '-' ) term )* )
            // Xpl.g:38:26: term ( ( '+' | '-' ) term )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_term_in_arithmetic_expression560);
            term56=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term56.getTree());
            // Xpl.g:38:31: ( ( '+' | '-' ) term )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=36 && LA18_0<=37)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Xpl.g:38:32: ( '+' | '-' ) term
            	    {
            	    // Xpl.g:38:32: ( '+' | '-' )
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0==36) ) {
            	        alt17=1;
            	    }
            	    else if ( (LA17_0==37) ) {
            	        alt17=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 17, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // Xpl.g:38:33: '+'
            	            {
            	            char_literal57=(Token)match(input,36,FOLLOW_36_in_arithmetic_expression564); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal57_tree = (CommonTree)adaptor.create(char_literal57);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal57_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Xpl.g:38:40: '-'
            	            {
            	            char_literal58=(Token)match(input,37,FOLLOW_37_in_arithmetic_expression569); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal58_tree = (CommonTree)adaptor.create(char_literal58);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal58_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_arithmetic_expression573);
            	    term59=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term59.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arithmetic_expression"

    public static class term_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "term"
    // Xpl.g:40:1: term : factor ( ( '*' | '/' ) factor )* ;
    public final XplParser.term_return term() throws RecognitionException {
        XplParser.term_return retval = new XplParser.term_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal61=null;
        Token char_literal62=null;
        XplParser.factor_return factor60 = null;

        XplParser.factor_return factor63 = null;


        CommonTree char_literal61_tree=null;
        CommonTree char_literal62_tree=null;

        try {
            // Xpl.g:40:5: ( factor ( ( '*' | '/' ) factor )* )
            // Xpl.g:40:21: factor ( ( '*' | '/' ) factor )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_factor_in_term596);
            factor60=factor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor60.getTree());
            // Xpl.g:40:28: ( ( '*' | '/' ) factor )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=38 && LA20_0<=39)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Xpl.g:40:29: ( '*' | '/' ) factor
            	    {
            	    // Xpl.g:40:29: ( '*' | '/' )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==38) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==39) ) {
            	        alt19=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // Xpl.g:40:30: '*'
            	            {
            	            char_literal61=(Token)match(input,38,FOLLOW_38_in_term600); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal61_tree = (CommonTree)adaptor.create(char_literal61);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal61_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Xpl.g:40:37: '/'
            	            {
            	            char_literal62=(Token)match(input,39,FOLLOW_39_in_term605); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal62_tree = (CommonTree)adaptor.create(char_literal62);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal62_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_factor_in_term609);
            	    factor63=factor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, factor63.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "term"

    public static class factor_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor"
    // Xpl.g:42:1: factor : atom ( '%' atom )* ;
    public final XplParser.factor_return factor() throws RecognitionException {
        XplParser.factor_return retval = new XplParser.factor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal65=null;
        XplParser.atom_return atom64 = null;

        XplParser.atom_return atom66 = null;


        CommonTree char_literal65_tree=null;

        try {
            // Xpl.g:42:7: ( atom ( '%' atom )* )
            // Xpl.g:42:26: atom ( '%' atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_factor635);
            atom64=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom64.getTree());
            // Xpl.g:42:31: ( '%' atom )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==40) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Xpl.g:42:32: '%' atom
            	    {
            	    char_literal65=(Token)match(input,40,FOLLOW_40_in_factor638); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal65_tree = (CommonTree)adaptor.create(char_literal65);
            	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal65_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_atom_in_factor641);
            	    atom66=atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom66.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "factor"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // Xpl.g:44:1: atom : ( number | string | ( identifier '(' )=> call | '(' expression ')' | reference );
    public final XplParser.atom_return atom() throws RecognitionException {
        XplParser.atom_return retval = new XplParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal70=null;
        Token char_literal72=null;
        XplParser.number_return number67 = null;

        XplParser.string_return string68 = null;

        XplParser.call_return call69 = null;

        XplParser.expression_return expression71 = null;

        XplParser.reference_return reference73 = null;


        CommonTree char_literal70_tree=null;
        CommonTree char_literal72_tree=null;

        try {
            // Xpl.g:44:5: ( number | string | ( identifier '(' )=> call | '(' expression ')' | reference )
            int alt22=5;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt22=1;
                }
                break;
            case STRING:
                {
                alt22=2;
                }
                break;
            case IDENTIFIER:
                {
                int LA22_3 = input.LA(2);

                if ( (synpred1_Xpl()) ) {
                    alt22=3;
                }
                else if ( (true) ) {
                    alt22=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 3, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // Xpl.g:44:26: number
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_number_in_atom669);
                    number67=number();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, number67.getTree());

                    }
                    break;
                case 2 :
                    // Xpl.g:44:35: string
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_string_in_atom673);
                    string68=string();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string68.getTree());

                    }
                    break;
                case 3 :
                    // Xpl.g:44:44: ( identifier '(' )=> call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_call_in_atom685);
                    call69=call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, call69.getTree());

                    }
                    break;
                case 4 :
                    // Xpl.g:44:71: '(' expression ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal70=(Token)match(input,22,FOLLOW_22_in_atom689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal70_tree = (CommonTree)adaptor.create(char_literal70);
                    adaptor.addChild(root_0, char_literal70_tree);
                    }
                    pushFollow(FOLLOW_expression_in_atom691);
                    expression71=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression71.getTree());
                    char_literal72=(Token)match(input,23,FOLLOW_23_in_atom693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal72_tree = (CommonTree)adaptor.create(char_literal72);
                    adaptor.addChild(root_0, char_literal72_tree);
                    }

                    }
                    break;
                case 5 :
                    // Xpl.g:44:92: reference
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_reference_in_atom697);
                    reference73=reference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, reference73.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class return_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "return_expression"
    // Xpl.g:46:1: return_expression : 'return' expression -> ^( RETURN expression ) ;
    public final XplParser.return_expression_return return_expression() throws RecognitionException {
        XplParser.return_expression_return retval = new XplParser.return_expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal74=null;
        XplParser.expression_return expression75 = null;


        CommonTree string_literal74_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Xpl.g:46:18: ( 'return' expression -> ^( RETURN expression ) )
            // Xpl.g:46:26: 'return' expression
            {
            string_literal74=(Token)match(input,41,FOLLOW_41_in_return_expression710); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(string_literal74);

            pushFollow(FOLLOW_expression_in_return_expression712);
            expression75=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression75.getTree());


            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 46:46: -> ^( RETURN expression )
            {
                // Xpl.g:46:49: ^( RETURN expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURN, "RETURN"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "return_expression"

    public static class call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call"
    // Xpl.g:48:1: call : ( identifier '(' ')' -> ^( CALL identifier ) | identifier call_arguments -> ^( CALL identifier call_arguments ) );
    public final XplParser.call_return call() throws RecognitionException {
        XplParser.call_return retval = new XplParser.call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal77=null;
        Token char_literal78=null;
        XplParser.identifier_return identifier76 = null;

        XplParser.identifier_return identifier79 = null;

        XplParser.call_arguments_return call_arguments80 = null;


        CommonTree char_literal77_tree=null;
        CommonTree char_literal78_tree=null;
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleSubtreeStream stream_call_arguments=new RewriteRuleSubtreeStream(adaptor,"rule call_arguments");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // Xpl.g:49:5: ( identifier '(' ')' -> ^( CALL identifier ) | identifier call_arguments -> ^( CALL identifier call_arguments ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDENTIFIER) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==22) ) {
                    int LA23_2 = input.LA(3);

                    if ( (LA23_2==23) ) {
                        alt23=1;
                    }
                    else if ( ((LA23_2>=IDENTIFIER && LA23_2<=STRING)||LA23_2==22) ) {
                        alt23=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // Xpl.g:49:26: identifier '(' ')'
                    {
                    pushFollow(FOLLOW_identifier_in_call751);
                    identifier76=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_identifier.add(identifier76.getTree());
                    char_literal77=(Token)match(input,22,FOLLOW_22_in_call753); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_22.add(char_literal77);

                    char_literal78=(Token)match(input,23,FOLLOW_23_in_call755); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_23.add(char_literal78);



                    // AST REWRITE
                    // elements: identifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 49:52: -> ^( CALL identifier )
                    {
                        // Xpl.g:49:55: ^( CALL identifier )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, "CALL"), root_1);

                        adaptor.addChild(root_1, stream_identifier.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Xpl.g:50:26: identifier call_arguments
                    {
                    pushFollow(FOLLOW_identifier_in_call797);
                    identifier79=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_identifier.add(identifier79.getTree());
                    pushFollow(FOLLOW_call_arguments_in_call799);
                    call_arguments80=call_arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_call_arguments.add(call_arguments80.getTree());


                    // AST REWRITE
                    // elements: call_arguments, identifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 50:52: -> ^( CALL identifier call_arguments )
                    {
                        // Xpl.g:50:55: ^( CALL identifier call_arguments )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, "CALL"), root_1);

                        adaptor.addChild(root_1, stream_identifier.nextTree());
                        adaptor.addChild(root_1, stream_call_arguments.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "call"

    public static class call_arguments_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call_arguments"
    // Xpl.g:52:1: call_arguments : '(' call_arguments_list ')' -> ^( CALL_ARGUMENTS call_arguments_list ) ;
    public final XplParser.call_arguments_return call_arguments() throws RecognitionException {
        XplParser.call_arguments_return retval = new XplParser.call_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal81=null;
        Token char_literal83=null;
        XplParser.call_arguments_list_return call_arguments_list82 = null;


        CommonTree char_literal81_tree=null;
        CommonTree char_literal83_tree=null;
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleSubtreeStream stream_call_arguments_list=new RewriteRuleSubtreeStream(adaptor,"rule call_arguments_list");
        try {
            // Xpl.g:52:15: ( '(' call_arguments_list ')' -> ^( CALL_ARGUMENTS call_arguments_list ) )
            // Xpl.g:52:26: '(' call_arguments_list ')'
            {
            char_literal81=(Token)match(input,22,FOLLOW_22_in_call_arguments825); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_22.add(char_literal81);

            pushFollow(FOLLOW_call_arguments_list_in_call_arguments827);
            call_arguments_list82=call_arguments_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_call_arguments_list.add(call_arguments_list82.getTree());
            char_literal83=(Token)match(input,23,FOLLOW_23_in_call_arguments829); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_23.add(char_literal83);



            // AST REWRITE
            // elements: call_arguments_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 52:54: -> ^( CALL_ARGUMENTS call_arguments_list )
            {
                // Xpl.g:52:57: ^( CALL_ARGUMENTS call_arguments_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL_ARGUMENTS, "CALL_ARGUMENTS"), root_1);

                adaptor.addChild(root_1, stream_call_arguments_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "call_arguments"

    public static class call_arguments_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call_arguments_list"
    // Xpl.g:54:1: call_arguments_list : expression ( ',' expression )* ;
    public final XplParser.call_arguments_list_return call_arguments_list() throws RecognitionException {
        XplParser.call_arguments_list_return retval = new XplParser.call_arguments_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal85=null;
        XplParser.expression_return expression84 = null;

        XplParser.expression_return expression86 = null;


        CommonTree char_literal85_tree=null;

        try {
            // Xpl.g:54:20: ( expression ( ',' expression )* )
            // Xpl.g:54:26: expression ( ',' expression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_expression_in_call_arguments_list848);
            expression84=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression84.getTree());
            // Xpl.g:54:37: ( ',' expression )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==24) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // Xpl.g:54:38: ',' expression
            	    {
            	    char_literal85=(Token)match(input,24,FOLLOW_24_in_call_arguments_list851); if (state.failed) return retval;
            	    pushFollow(FOLLOW_expression_in_call_arguments_list854);
            	    expression86=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression86.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "call_arguments_list"

    public static class reference_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "reference"
    // Xpl.g:56:1: reference : identifier ;
    public final XplParser.reference_return reference() throws RecognitionException {
        XplParser.reference_return retval = new XplParser.reference_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        XplParser.identifier_return identifier87 = null;



        try {
            // Xpl.g:56:10: ( identifier )
            // Xpl.g:56:26: identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_reference877);
            identifier87=identifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier87.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "reference"

    public static class identifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "identifier"
    // Xpl.g:58:1: identifier : IDENTIFIER ;
    public final XplParser.identifier_return identifier() throws RecognitionException {
        XplParser.identifier_return retval = new XplParser.identifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENTIFIER88=null;

        CommonTree IDENTIFIER88_tree=null;

        try {
            // Xpl.g:58:11: ( IDENTIFIER )
            // Xpl.g:58:26: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENTIFIER88=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier897); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER88_tree = (CommonTree)adaptor.create(IDENTIFIER88);
            adaptor.addChild(root_0, IDENTIFIER88_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifier"

    public static class number_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "number"
    // Xpl.g:60:1: number : NUMBER ;
    public final XplParser.number_return number() throws RecognitionException {
        XplParser.number_return retval = new XplParser.number_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NUMBER89=null;

        CommonTree NUMBER89_tree=null;

        try {
            // Xpl.g:60:7: ( NUMBER )
            // Xpl.g:60:26: NUMBER
            {
            root_0 = (CommonTree)adaptor.nil();

            NUMBER89=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_number921); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NUMBER89_tree = (CommonTree)adaptor.create(NUMBER89);
            adaptor.addChild(root_0, NUMBER89_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "number"

    public static class string_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string"
    // Xpl.g:62:1: string : STRING ;
    public final XplParser.string_return string() throws RecognitionException {
        XplParser.string_return retval = new XplParser.string_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING90=null;

        CommonTree STRING90_tree=null;

        try {
            // Xpl.g:62:7: ( STRING )
            // Xpl.g:62:26: STRING
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING90=(Token)match(input,STRING,FOLLOW_STRING_in_string945); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING90_tree = (CommonTree)adaptor.create(STRING90);
            adaptor.addChild(root_0, STRING90_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "string"

    public static class newline_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "newline"
    // Xpl.g:64:1: newline : NEWLINE ;
    public final XplParser.newline_return newline() throws RecognitionException {
        XplParser.newline_return retval = new XplParser.newline_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE91=null;

        CommonTree NEWLINE91_tree=null;

        try {
            // Xpl.g:64:8: ( NEWLINE )
            // Xpl.g:64:26: NEWLINE
            {
            root_0 = (CommonTree)adaptor.nil();

            NEWLINE91=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_newline968); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NEWLINE91_tree = (CommonTree)adaptor.create(NEWLINE91);
            adaptor.addChild(root_0, NEWLINE91_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "newline"

    // $ANTLR start synpred1_Xpl
    public final void synpred1_Xpl_fragment() throws RecognitionException {   
        // Xpl.g:44:44: ( identifier '(' )
        // Xpl.g:44:45: identifier '('
        {
        pushFollow(FOLLOW_identifier_in_synpred1_Xpl678);
        identifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,22,FOLLOW_22_in_synpred1_Xpl680); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Xpl

    // Delegated rules

    public final boolean synpred1_Xpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Xpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_method_definition_in_program80 = new BitSet(new long[]{0x000002000A678002L});
    public static final BitSet FOLLOW_atomic_operation_in_program84 = new BitSet(new long[]{0x000002000A678002L});
    public static final BitSet FOLLOW_newline_in_program87 = new BitSet(new long[]{0x000002000A678002L});
    public static final BitSet FOLLOW_conditional_in_atomic_operation104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_in_atomic_operation108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_atomic_operation112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_atomic_operation116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_expression_in_atomic_operation120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_operation_in_atomic_operations_list129 = new BitSet(new long[]{0x000002000A678002L});
    public static final BitSet FOLLOW_newline_in_atomic_operations_list132 = new BitSet(new long[]{0x000002000A678002L});
    public static final BitSet FOLLOW_method_header_in_method_definition150 = new BitSet(new long[]{0x000002000A678000L});
    public static final BitSet FOLLOW_method_body_in_method_definition152 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_method_definition154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_method_header197 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_identifier_in_method_header199 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_method_header201 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_method_header203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_method_header236 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_identifier_in_method_header238 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_method_header240 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_method_arguments_in_method_header242 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_method_header244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_method_arguments266 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_method_arguments269 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_identifier_in_method_arguments272 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_atomic_operation_in_method_body293 = new BitSet(new long[]{0x000002000A678002L});
    public static final BitSet FOLLOW_25_in_conditional313 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_expression_in_conditional315 = new BitSet(new long[]{0x000002000A678000L});
    public static final BitSet FOLLOW_newline_in_conditional317 = new BitSet(new long[]{0x000002000A678000L});
    public static final BitSet FOLLOW_atomic_operations_list_in_conditional320 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_conditional322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_conditional_else373 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_expression_in_conditional_else375 = new BitSet(new long[]{0x000002000A678000L});
    public static final BitSet FOLLOW_newline_in_conditional_else377 = new BitSet(new long[]{0x000002000A678000L});
    public static final BitSet FOLLOW_atomic_operations_list_in_conditional_else380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_loop418 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_expression_in_loop420 = new BitSet(new long[]{0x000002000A678000L});
    public static final BitSet FOLLOW_newline_in_loop422 = new BitSet(new long[]{0x000002000A678000L});
    public static final BitSet FOLLOW_atomic_operations_list_in_loop425 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loop427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_assignment459 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_assignment462 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_expression_in_assignment465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_expression_in_expression486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparision_expression_in_boolean_expression498 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_29_in_boolean_expression502 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_30_in_boolean_expression507 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_boolean_expression_in_boolean_expression511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression521 = new BitSet(new long[]{0x0000000F80000002L});
    public static final BitSet FOLLOW_31_in_comparision_expression525 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_32_in_comparision_expression530 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_33_in_comparision_expression535 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_34_in_comparision_expression540 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_35_in_comparision_expression545 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_arithmetic_expression560 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_36_in_arithmetic_expression564 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_37_in_arithmetic_expression569 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_term_in_arithmetic_expression573 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_factor_in_term596 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_38_in_term600 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_39_in_term605 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_factor_in_term609 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_atom_in_factor635 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_factor638 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_atom_in_factor641 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_number_in_atom669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_atom673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_in_atom685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_atom689 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_expression_in_atom691 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_atom693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_atom697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_return_expression710 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_expression_in_return_expression712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_call751 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_call753 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_call755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_call797 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_call_arguments_in_call799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_call_arguments825 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_call_arguments_list_in_call_arguments827 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_call_arguments829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_call_arguments_list848 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_call_arguments_list851 = new BitSet(new long[]{0x0000000000438000L});
    public static final BitSet FOLLOW_expression_in_call_arguments_list854 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_identifier_in_reference877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifier897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_number921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_newline968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred1_Xpl678 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_synpred1_Xpl680 = new BitSet(new long[]{0x0000000000000002L});

}