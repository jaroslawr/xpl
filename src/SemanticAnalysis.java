// $ANTLR 3.1 SemanticAnalysis.g 2008-09-25 11:12:50

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SemanticAnalysis extends TreeParser {
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
    public static final int T__33=33;
    public static final int WS=19;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int NEWLINE=18;
    public static final int T__36=36;
    public static final int CALL_ARGUMENTS=5;
    public static final int T__37=37;
    public static final int METHOD_BODY=13;
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


        public SemanticAnalysis(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public SemanticAnalysis(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SemanticAnalysis.tokenNames; }
    public String getGrammarFileName() { return "SemanticAnalysis.g"; }


      private SymbolTable symbolTable = new SymbolTable();


    public static class program_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "program"
    // SemanticAnalysis.g:12:1: program : ( ( method_definition | atomic_operation ) ( newline )? )+ ;
    public final SemanticAnalysis.program_return program() throws RecognitionException {
        SemanticAnalysis.program_return retval = new SemanticAnalysis.program_return();
        retval.start = input.LT(1);

         ((ASTNode)retval.start).scope = symbolTable.enterScope(); 
        try {
            // SemanticAnalysis.g:14:5: ( ( ( method_definition | atomic_operation ) ( newline )? )+ )
            // SemanticAnalysis.g:14:7: ( ( method_definition | atomic_operation ) ( newline )? )+
            {
            // SemanticAnalysis.g:14:7: ( ( method_definition | atomic_operation ) ( newline )? )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==CALL||LA3_0==WHILE||LA3_0==IF||LA3_0==METHOD||(LA3_0>=RETURN && LA3_0<=STRING)||(LA3_0>=28 && LA3_0<=40)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // SemanticAnalysis.g:14:8: ( method_definition | atomic_operation ) ( newline )?
            	    {
            	    // SemanticAnalysis.g:14:8: ( method_definition | atomic_operation )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==METHOD) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==CALL||LA1_0==WHILE||LA1_0==IF||(LA1_0>=RETURN && LA1_0<=STRING)||(LA1_0>=28 && LA1_0<=40)) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // SemanticAnalysis.g:14:9: method_definition
            	            {
            	            pushFollow(FOLLOW_method_definition_in_program52);
            	            method_definition();

            	            state._fsp--;


            	            }
            	            break;
            	        case 2 :
            	            // SemanticAnalysis.g:14:29: atomic_operation
            	            {
            	            pushFollow(FOLLOW_atomic_operation_in_program56);
            	            atomic_operation();

            	            state._fsp--;


            	            }
            	            break;

            	    }

            	    // SemanticAnalysis.g:14:47: ( newline )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==NEWLINE) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // SemanticAnalysis.g:14:47: newline
            	            {
            	            pushFollow(FOLLOW_newline_in_program59);
            	            newline();

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"


    // $ANTLR start "atomic_operation"
    // SemanticAnalysis.g:16:1: atomic_operation : ( conditional | loop | assignment | expression | return_expression );
    public final void atomic_operation() throws RecognitionException {
        try {
            // SemanticAnalysis.g:17:5: ( conditional | loop | assignment | expression | return_expression )
            int alt4=5;
            switch ( input.LA(1) ) {
            case IF:
                {
                alt4=1;
                }
                break;
            case WHILE:
                {
                alt4=2;
                }
                break;
            case 28:
                {
                alt4=3;
                }
                break;
            case CALL:
            case IDENTIFIER:
            case NUMBER:
            case STRING:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
                {
                alt4=4;
                }
                break;
            case RETURN:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // SemanticAnalysis.g:17:8: conditional
                    {
                    pushFollow(FOLLOW_conditional_in_atomic_operation75);
                    conditional();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // SemanticAnalysis.g:17:22: loop
                    {
                    pushFollow(FOLLOW_loop_in_atomic_operation79);
                    loop();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // SemanticAnalysis.g:17:29: assignment
                    {
                    pushFollow(FOLLOW_assignment_in_atomic_operation83);
                    assignment();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // SemanticAnalysis.g:17:42: expression
                    {
                    pushFollow(FOLLOW_expression_in_atomic_operation87);
                    expression();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // SemanticAnalysis.g:17:55: return_expression
                    {
                    pushFollow(FOLLOW_return_expression_in_atomic_operation91);
                    return_expression();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "atomic_operation"


    // $ANTLR start "atomic_operations_list"
    // SemanticAnalysis.g:19:1: atomic_operations_list : ( atomic_operation )+ ;
    public final void atomic_operations_list() throws RecognitionException {
        try {
            // SemanticAnalysis.g:20:5: ( ( atomic_operation )+ )
            // SemanticAnalysis.g:20:8: ( atomic_operation )+
            {
            // SemanticAnalysis.g:20:8: ( atomic_operation )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==CALL||LA5_0==WHILE||LA5_0==IF||(LA5_0>=RETURN && LA5_0<=STRING)||(LA5_0>=28 && LA5_0<=40)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // SemanticAnalysis.g:20:8: atomic_operation
            	    {
            	    pushFollow(FOLLOW_atomic_operation_in_atomic_operations_list104);
            	    atomic_operation();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "atomic_operations_list"


    // $ANTLR start "method_definition"
    // SemanticAnalysis.g:22:1: method_definition : ^( METHOD method_header METHOD_BODY method_body ) ;
    public final void method_definition() throws RecognitionException {
        try {
            // SemanticAnalysis.g:24:5: ( ^( METHOD method_header METHOD_BODY method_body ) )
            // SemanticAnalysis.g:24:8: ^( METHOD method_header METHOD_BODY method_body )
            {
            match(input,METHOD,FOLLOW_METHOD_in_method_definition124); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_method_header_in_method_definition126);
            method_header();

            state._fsp--;

            match(input,METHOD_BODY,FOLLOW_METHOD_BODY_in_method_definition128); 
            pushFollow(FOLLOW_method_body_in_method_definition130);
            method_body();

            state._fsp--;


            match(input, Token.UP, null); 

            }

             symbolTable.exitScope(); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "method_definition"

    public static class method_header_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "method_header"
    // SemanticAnalysis.g:26:1: method_header : ^(name= IDENTIFIER ( (args+= IDENTIFIER )+ )? ) ;
    public final SemanticAnalysis.method_header_return method_header() throws RecognitionException {
        SemanticAnalysis.method_header_return retval = new SemanticAnalysis.method_header_return();
        retval.start = input.LT(1);

        ASTNode name=null;
        ASTNode args=null;
        List list_args=null;

        try {
            // SemanticAnalysis.g:27:5: ( ^(name= IDENTIFIER ( (args+= IDENTIFIER )+ )? ) )
            // SemanticAnalysis.g:27:8: ^(name= IDENTIFIER ( (args+= IDENTIFIER )+ )? )
            {
            name=(ASTNode)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_method_header147); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // SemanticAnalysis.g:27:26: ( (args+= IDENTIFIER )+ )?
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENTIFIER) ) {
                    alt7=1;
                }
                switch (alt7) {
                    case 1 :
                        // SemanticAnalysis.g:27:27: (args+= IDENTIFIER )+
                        {
                        // SemanticAnalysis.g:27:27: (args+= IDENTIFIER )+
                        int cnt6=0;
                        loop6:
                        do {
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( (LA6_0==IDENTIFIER) ) {
                                alt6=1;
                            }


                            switch (alt6) {
                        	case 1 :
                        	    // SemanticAnalysis.g:27:28: args+= IDENTIFIER
                        	    {
                        	    args=(ASTNode)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_method_header153); 
                        	    if (list_args==null) list_args=new ArrayList();
                        	    list_args.add(args);


                        	    }
                        	    break;

                        	default :
                        	    if ( cnt6 >= 1 ) break loop6;
                                    EarlyExitException eee =
                                        new EarlyExitException(6, input);
                                    throw eee;
                            }
                            cnt6++;
                        } while (true);


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

                      ArrayList<String> arguments = new ArrayList<String>();
                      for(Object tree : list_args)
                        arguments.add(((ASTNode)tree).getText());
                      Scope scope = symbolTable.addMethod((name!=null?name.getText():null), arguments);
                      ((ASTNode)retval.start).scope = scope;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "method_header"


    // $ANTLR start "method_body"
    // SemanticAnalysis.g:35:1: method_body : ( atomic_operation )+ ;
    public final void method_body() throws RecognitionException {
        try {
            // SemanticAnalysis.g:36:5: ( ( atomic_operation )+ )
            // SemanticAnalysis.g:36:8: ( atomic_operation )+
            {
            // SemanticAnalysis.g:36:8: ( atomic_operation )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==CALL||LA8_0==WHILE||LA8_0==IF||(LA8_0>=RETURN && LA8_0<=STRING)||(LA8_0>=28 && LA8_0<=40)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // SemanticAnalysis.g:36:8: atomic_operation
            	    {
            	    pushFollow(FOLLOW_atomic_operation_in_method_body173);
            	    atomic_operation();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "method_body"


    // $ANTLR start "conditional"
    // SemanticAnalysis.g:38:1: conditional : ^( IF conditional_test IF_BODY atomic_operations_list ) ;
    public final void conditional() throws RecognitionException {
        try {
            // SemanticAnalysis.g:39:5: ( ^( IF conditional_test IF_BODY atomic_operations_list ) )
            // SemanticAnalysis.g:39:8: ^( IF conditional_test IF_BODY atomic_operations_list )
            {
            match(input,IF,FOLLOW_IF_in_conditional188); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_conditional_test_in_conditional190);
            conditional_test();

            state._fsp--;

            match(input,IF_BODY,FOLLOW_IF_BODY_in_conditional192); 
            pushFollow(FOLLOW_atomic_operations_list_in_conditional194);
            atomic_operations_list();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "conditional"


    // $ANTLR start "conditional_test"
    // SemanticAnalysis.g:41:1: conditional_test : expression ;
    public final void conditional_test() throws RecognitionException {
        try {
            // SemanticAnalysis.g:42:5: ( expression )
            // SemanticAnalysis.g:42:8: expression
            {
            pushFollow(FOLLOW_expression_in_conditional_test208);
            expression();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "conditional_test"


    // $ANTLR start "conditional_else"
    // SemanticAnalysis.g:44:1: conditional_else : ^( ELSE expression ELSE_BODY atomic_operations_list ) ;
    public final void conditional_else() throws RecognitionException {
        try {
            // SemanticAnalysis.g:45:5: ( ^( ELSE expression ELSE_BODY atomic_operations_list ) )
            // SemanticAnalysis.g:45:8: ^( ELSE expression ELSE_BODY atomic_operations_list )
            {
            match(input,ELSE,FOLLOW_ELSE_in_conditional_else222); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_conditional_else224);
            expression();

            state._fsp--;

            match(input,ELSE_BODY,FOLLOW_ELSE_BODY_in_conditional_else226); 
            pushFollow(FOLLOW_atomic_operations_list_in_conditional_else228);
            atomic_operations_list();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "conditional_else"


    // $ANTLR start "conditional_body"
    // SemanticAnalysis.g:47:1: conditional_body : ( conditional | assignment | expression )+ ;
    public final void conditional_body() throws RecognitionException {
        try {
            // SemanticAnalysis.g:48:5: ( ( conditional | assignment | expression )+ )
            // SemanticAnalysis.g:48:8: ( conditional | assignment | expression )+
            {
            // SemanticAnalysis.g:48:8: ( conditional | assignment | expression )+
            int cnt9=0;
            loop9:
            do {
                int alt9=4;
                switch ( input.LA(1) ) {
                case IF:
                    {
                    alt9=1;
                    }
                    break;
                case 28:
                    {
                    alt9=2;
                    }
                    break;
                case CALL:
                case IDENTIFIER:
                case NUMBER:
                case STRING:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                    {
                    alt9=3;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // SemanticAnalysis.g:48:9: conditional
            	    {
            	    pushFollow(FOLLOW_conditional_in_conditional_body243);
            	    conditional();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // SemanticAnalysis.g:48:23: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_conditional_body247);
            	    assignment();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // SemanticAnalysis.g:48:36: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_conditional_body251);
            	    expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "conditional_body"


    // $ANTLR start "loop"
    // SemanticAnalysis.g:50:1: loop : ^( WHILE loop_test WHILE_BODY loop_body ) ;
    public final void loop() throws RecognitionException {
        try {
            // SemanticAnalysis.g:51:5: ( ^( WHILE loop_test WHILE_BODY loop_body ) )
            // SemanticAnalysis.g:51:8: ^( WHILE loop_test WHILE_BODY loop_body )
            {
            match(input,WHILE,FOLLOW_WHILE_in_loop267); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_loop_test_in_loop269);
            loop_test();

            state._fsp--;

            match(input,WHILE_BODY,FOLLOW_WHILE_BODY_in_loop271); 
            pushFollow(FOLLOW_loop_body_in_loop273);
            loop_body();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "loop"


    // $ANTLR start "loop_test"
    // SemanticAnalysis.g:53:1: loop_test : expression ;
    public final void loop_test() throws RecognitionException {
        try {
            // SemanticAnalysis.g:54:5: ( expression )
            // SemanticAnalysis.g:54:8: expression
            {
            pushFollow(FOLLOW_expression_in_loop_test287);
            expression();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "loop_test"


    // $ANTLR start "loop_body"
    // SemanticAnalysis.g:56:1: loop_body : ( conditional | assignment | expression )+ ;
    public final void loop_body() throws RecognitionException {
        try {
            // SemanticAnalysis.g:57:5: ( ( conditional | assignment | expression )+ )
            // SemanticAnalysis.g:57:8: ( conditional | assignment | expression )+
            {
            // SemanticAnalysis.g:57:8: ( conditional | assignment | expression )+
            int cnt10=0;
            loop10:
            do {
                int alt10=4;
                switch ( input.LA(1) ) {
                case IF:
                    {
                    alt10=1;
                    }
                    break;
                case 28:
                    {
                    alt10=2;
                    }
                    break;
                case CALL:
                case IDENTIFIER:
                case NUMBER:
                case STRING:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                    {
                    alt10=3;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // SemanticAnalysis.g:57:9: conditional
            	    {
            	    pushFollow(FOLLOW_conditional_in_loop_body301);
            	    conditional();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // SemanticAnalysis.g:57:23: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_loop_body305);
            	    assignment();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // SemanticAnalysis.g:57:36: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_loop_body309);
            	    expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "loop_body"

    public static class assignment_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "assignment"
    // SemanticAnalysis.g:59:1: assignment : ^( '=' name= IDENTIFIER value= expression ) ;
    public final SemanticAnalysis.assignment_return assignment() throws RecognitionException {
        SemanticAnalysis.assignment_return retval = new SemanticAnalysis.assignment_return();
        retval.start = input.LT(1);

        ASTNode name=null;
        SemanticAnalysis.expression_return value = null;


        try {
            // SemanticAnalysis.g:60:5: ( ^( '=' name= IDENTIFIER value= expression ) )
            // SemanticAnalysis.g:60:8: ^( '=' name= IDENTIFIER value= expression )
            {
            match(input,28,FOLLOW_28_in_assignment325); 

            match(input, Token.DOWN, null); 
            name=(ASTNode)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignment329); 
            pushFollow(FOLLOW_expression_in_assignment333);
            value=expression();

            state._fsp--;


            match(input, Token.UP, null); 

                      LocalVariable var = symbolTable.lookupLocalVariable((name!=null?name.getText():null));
                      if(var == null)
                        symbolTable.addLocalVariable((name!=null?name.getText():null));
                      ((ASTNode)retval.start).type = (value!=null?((ASTNode)value.start):null).type;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class expression_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "expression"
    // SemanticAnalysis.g:67:1: expression : exp= boolean_expression ;
    public final SemanticAnalysis.expression_return expression() throws RecognitionException {
        SemanticAnalysis.expression_return retval = new SemanticAnalysis.expression_return();
        retval.start = input.LT(1);

         ((ASTNode)retval.start).type = "integer"; 
        try {
            // SemanticAnalysis.g:69:5: (exp= boolean_expression )
            // SemanticAnalysis.g:69:7: exp= boolean_expression
            {
            pushFollow(FOLLOW_boolean_expression_in_expression355);
            boolean_expression();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"


    // $ANTLR start "boolean_expression"
    // SemanticAnalysis.g:71:1: boolean_expression : ( ^( '&&' a= comparision_expression b= boolean_expression ) | ^( '||' a= comparision_expression b= boolean_expression ) | comparision_expression );
    public final void boolean_expression() throws RecognitionException {
        try {
            // SemanticAnalysis.g:72:5: ( ^( '&&' a= comparision_expression b= boolean_expression ) | ^( '||' a= comparision_expression b= boolean_expression ) | comparision_expression )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt11=1;
                }
                break;
            case 30:
                {
                alt11=2;
                }
                break;
            case CALL:
            case IDENTIFIER:
            case NUMBER:
            case STRING:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // SemanticAnalysis.g:72:8: ^( '&&' a= comparision_expression b= boolean_expression )
                    {
                    match(input,29,FOLLOW_29_in_boolean_expression369); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_comparision_expression_in_boolean_expression373);
                    comparision_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_boolean_expression_in_boolean_expression377);
                    boolean_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // SemanticAnalysis.g:73:8: ^( '||' a= comparision_expression b= boolean_expression )
                    {
                    match(input,30,FOLLOW_30_in_boolean_expression388); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_comparision_expression_in_boolean_expression392);
                    comparision_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_boolean_expression_in_boolean_expression396);
                    boolean_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // SemanticAnalysis.g:74:8: comparision_expression
                    {
                    pushFollow(FOLLOW_comparision_expression_in_boolean_expression406);
                    comparision_expression();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "boolean_expression"


    // $ANTLR start "comparision_expression"
    // SemanticAnalysis.g:77:1: comparision_expression : ( ^( '==' a= arithmetic_expression b= arithmetic_expression ) | ^( '<=' a= arithmetic_expression b= arithmetic_expression ) | ^( '>=' a= arithmetic_expression b= arithmetic_expression ) | ^( '<' a= arithmetic_expression b= arithmetic_expression ) | ^( '>' a= arithmetic_expression b= arithmetic_expression ) | arithmetic_expression );
    public final void comparision_expression() throws RecognitionException {
        try {
            // SemanticAnalysis.g:78:5: ( ^( '==' a= arithmetic_expression b= arithmetic_expression ) | ^( '<=' a= arithmetic_expression b= arithmetic_expression ) | ^( '>=' a= arithmetic_expression b= arithmetic_expression ) | ^( '<' a= arithmetic_expression b= arithmetic_expression ) | ^( '>' a= arithmetic_expression b= arithmetic_expression ) | arithmetic_expression )
            int alt12=6;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt12=1;
                }
                break;
            case 32:
                {
                alt12=2;
                }
                break;
            case 33:
                {
                alt12=3;
                }
                break;
            case 34:
                {
                alt12=4;
                }
                break;
            case 35:
                {
                alt12=5;
                }
                break;
            case CALL:
            case IDENTIFIER:
            case NUMBER:
            case STRING:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
                {
                alt12=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // SemanticAnalysis.g:78:8: ^( '==' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,31,FOLLOW_31_in_comparision_expression425); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression429);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression433);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // SemanticAnalysis.g:79:8: ^( '<=' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,32,FOLLOW_32_in_comparision_expression444); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression448);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression452);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // SemanticAnalysis.g:80:8: ^( '>=' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,33,FOLLOW_33_in_comparision_expression463); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression467);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression471);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // SemanticAnalysis.g:81:8: ^( '<' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,34,FOLLOW_34_in_comparision_expression482); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression487);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression491);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // SemanticAnalysis.g:82:8: ^( '>' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,35,FOLLOW_35_in_comparision_expression502); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression507);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression511);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // SemanticAnalysis.g:83:8: arithmetic_expression
                    {
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression521);
                    arithmetic_expression();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "comparision_expression"


    // $ANTLR start "arithmetic_expression"
    // SemanticAnalysis.g:86:1: arithmetic_expression : ( ^( '+' a= arithmetic_expression b= arithmetic_expression ) | ^( '-' a= arithmetic_expression b= arithmetic_expression ) | ^( '*' a= arithmetic_expression b= arithmetic_expression ) | ^( '/' a= arithmetic_expression b= arithmetic_expression ) | ^( '%' a= arithmetic_expression b= arithmetic_expression ) | number | string | identifier | call );
    public final void arithmetic_expression() throws RecognitionException {
        try {
            // SemanticAnalysis.g:87:5: ( ^( '+' a= arithmetic_expression b= arithmetic_expression ) | ^( '-' a= arithmetic_expression b= arithmetic_expression ) | ^( '*' a= arithmetic_expression b= arithmetic_expression ) | ^( '/' a= arithmetic_expression b= arithmetic_expression ) | ^( '%' a= arithmetic_expression b= arithmetic_expression ) | number | string | identifier | call )
            int alt13=9;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt13=1;
                }
                break;
            case 37:
                {
                alt13=2;
                }
                break;
            case 38:
                {
                alt13=3;
                }
                break;
            case 39:
                {
                alt13=4;
                }
                break;
            case 40:
                {
                alt13=5;
                }
                break;
            case NUMBER:
                {
                alt13=6;
                }
                break;
            case STRING:
                {
                alt13=7;
                }
                break;
            case IDENTIFIER:
                {
                alt13=8;
                }
                break;
            case CALL:
                {
                alt13=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // SemanticAnalysis.g:87:8: ^( '+' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,36,FOLLOW_36_in_arithmetic_expression540); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression544);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression548);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // SemanticAnalysis.g:88:8: ^( '-' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,37,FOLLOW_37_in_arithmetic_expression559); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression563);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression567);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // SemanticAnalysis.g:89:8: ^( '*' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,38,FOLLOW_38_in_arithmetic_expression578); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression582);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression586);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // SemanticAnalysis.g:90:8: ^( '/' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,39,FOLLOW_39_in_arithmetic_expression597); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression601);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression605);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // SemanticAnalysis.g:91:8: ^( '%' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,40,FOLLOW_40_in_arithmetic_expression616); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression620);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression624);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // SemanticAnalysis.g:92:8: number
                    {
                    pushFollow(FOLLOW_number_in_arithmetic_expression634);
                    number();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // SemanticAnalysis.g:93:8: string
                    {
                    pushFollow(FOLLOW_string_in_arithmetic_expression643);
                    string();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // SemanticAnalysis.g:94:8: identifier
                    {
                    pushFollow(FOLLOW_identifier_in_arithmetic_expression652);
                    identifier();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // SemanticAnalysis.g:95:8: call
                    {
                    pushFollow(FOLLOW_call_in_arithmetic_expression661);
                    call();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "arithmetic_expression"


    // $ANTLR start "return_expression"
    // SemanticAnalysis.g:98:1: return_expression : ^( RETURN expression ) ;
    public final void return_expression() throws RecognitionException {
        try {
            // SemanticAnalysis.g:99:5: ( ^( RETURN expression ) )
            // SemanticAnalysis.g:99:8: ^( RETURN expression )
            {
            match(input,RETURN,FOLLOW_RETURN_in_return_expression680); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_return_expression682);
            expression();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "return_expression"


    // $ANTLR start "call"
    // SemanticAnalysis.g:101:1: call : ^( CALL IDENTIFIER ( call_arguments )? ) ;
    public final void call() throws RecognitionException {
        try {
            // SemanticAnalysis.g:102:5: ( ^( CALL IDENTIFIER ( call_arguments )? ) )
            // SemanticAnalysis.g:102:8: ^( CALL IDENTIFIER ( call_arguments )? )
            {
            match(input,CALL,FOLLOW_CALL_in_call697); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_call699); 
            // SemanticAnalysis.g:102:26: ( call_arguments )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==CALL_ARGUMENTS) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // SemanticAnalysis.g:102:26: call_arguments
                    {
                    pushFollow(FOLLOW_call_arguments_in_call701);
                    call_arguments();

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "call"


    // $ANTLR start "call_arguments"
    // SemanticAnalysis.g:104:1: call_arguments : ^( CALL_ARGUMENTS call_arguments_list ) ;
    public final void call_arguments() throws RecognitionException {
        try {
            // SemanticAnalysis.g:105:5: ( ^( CALL_ARGUMENTS call_arguments_list ) )
            // SemanticAnalysis.g:105:8: ^( CALL_ARGUMENTS call_arguments_list )
            {
            match(input,CALL_ARGUMENTS,FOLLOW_CALL_ARGUMENTS_in_call_arguments717); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                pushFollow(FOLLOW_call_arguments_list_in_call_arguments719);
                call_arguments_list();

                state._fsp--;


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "call_arguments"


    // $ANTLR start "call_arguments_list"
    // SemanticAnalysis.g:107:1: call_arguments_list : ( expression )* ;
    public final void call_arguments_list() throws RecognitionException {
        try {
            // SemanticAnalysis.g:108:5: ( ( expression )* )
            // SemanticAnalysis.g:108:8: ( expression )*
            {
            // SemanticAnalysis.g:108:8: ( expression )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==CALL||(LA15_0>=IDENTIFIER && LA15_0<=STRING)||(LA15_0>=29 && LA15_0<=40)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // SemanticAnalysis.g:108:8: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_call_arguments_list733);
            	    expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "call_arguments_list"

    public static class number_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "number"
    // SemanticAnalysis.g:110:1: number : NUMBER ;
    public final SemanticAnalysis.number_return number() throws RecognitionException {
        SemanticAnalysis.number_return retval = new SemanticAnalysis.number_return();
        retval.start = input.LT(1);

        try {
            // SemanticAnalysis.g:110:7: ( NUMBER )
            // SemanticAnalysis.g:110:17: NUMBER
            {
            match(input,NUMBER,FOLLOW_NUMBER_in_number749); 
             ((ASTNode)retval.start).type = "integer"; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "number"

    public static class string_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "string"
    // SemanticAnalysis.g:112:1: string : STRING ;
    public final SemanticAnalysis.string_return string() throws RecognitionException {
        SemanticAnalysis.string_return retval = new SemanticAnalysis.string_return();
        retval.start = input.LT(1);

        try {
            // SemanticAnalysis.g:112:7: ( STRING )
            // SemanticAnalysis.g:112:17: STRING
            {
            match(input,STRING,FOLLOW_STRING_in_string766); 
             ((ASTNode)retval.start).type = "string"; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "string"

    public static class identifier_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "identifier"
    // SemanticAnalysis.g:114:1: identifier : IDENTIFIER ;
    public final SemanticAnalysis.identifier_return identifier() throws RecognitionException {
        SemanticAnalysis.identifier_return retval = new SemanticAnalysis.identifier_return();
        retval.start = input.LT(1);

        try {
            // SemanticAnalysis.g:114:11: ( IDENTIFIER )
            // SemanticAnalysis.g:114:17: IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier779); 
             ((ASTNode)retval.start).type = "integer"; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifier"


    // $ANTLR start "method_name"
    // SemanticAnalysis.g:116:1: method_name : IDENTIFIER ;
    public final void method_name() throws RecognitionException {
        try {
            // SemanticAnalysis.g:116:12: ( IDENTIFIER )
            // SemanticAnalysis.g:116:17: IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_method_name791); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "method_name"


    // $ANTLR start "variable_name"
    // SemanticAnalysis.g:118:1: variable_name : IDENTIFIER ;
    public final void variable_name() throws RecognitionException {
        try {
            // SemanticAnalysis.g:118:14: ( IDENTIFIER )
            // SemanticAnalysis.g:118:17: IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variable_name799); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "variable_name"


    // $ANTLR start "newline"
    // SemanticAnalysis.g:120:1: newline : NEWLINE ;
    public final void newline() throws RecognitionException {
        try {
            // SemanticAnalysis.g:120:8: ( NEWLINE )
            // SemanticAnalysis.g:120:17: NEWLINE
            {
            match(input,NEWLINE,FOLLOW_NEWLINE_in_newline813); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "newline"

    // Delegated rules


 

    public static final BitSet FOLLOW_method_definition_in_program52 = new BitSet(new long[]{0x000001FFF007D152L});
    public static final BitSet FOLLOW_atomic_operation_in_program56 = new BitSet(new long[]{0x000001FFF007D152L});
    public static final BitSet FOLLOW_newline_in_program59 = new BitSet(new long[]{0x000001FFF007D152L});
    public static final BitSet FOLLOW_conditional_in_atomic_operation75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_in_atomic_operation79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_atomic_operation83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_atomic_operation87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_expression_in_atomic_operation91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_operation_in_atomic_operations_list104 = new BitSet(new long[]{0x000001FFF007D152L});
    public static final BitSet FOLLOW_METHOD_in_method_definition124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_method_header_in_method_definition126 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_METHOD_BODY_in_method_definition128 = new BitSet(new long[]{0x000001FFF007D150L});
    public static final BitSet FOLLOW_method_body_in_method_definition130 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_method_header147 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_method_header153 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_atomic_operation_in_method_body173 = new BitSet(new long[]{0x000001FFF007D152L});
    public static final BitSet FOLLOW_IF_in_conditional188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditional_test_in_conditional190 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_IF_BODY_in_conditional192 = new BitSet(new long[]{0x000001FFF007D150L});
    public static final BitSet FOLLOW_atomic_operations_list_in_conditional194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_conditional_test208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_conditional_else222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_conditional_else224 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ELSE_BODY_in_conditional_else226 = new BitSet(new long[]{0x000001FFF007D150L});
    public static final BitSet FOLLOW_atomic_operations_list_in_conditional_else228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_conditional_in_conditional_body243 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_assignment_in_conditional_body247 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_expression_in_conditional_body251 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_WHILE_in_loop267 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_loop_test_in_loop269 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_WHILE_BODY_in_loop271 = new BitSet(new long[]{0x000001FFF0038110L});
    public static final BitSet FOLLOW_loop_body_in_loop273 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_loop_test287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_loop_body301 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_assignment_in_loop_body305 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_expression_in_loop_body309 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_28_in_assignment325 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assignment329 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_expression_in_assignment333 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_boolean_expression_in_expression355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_boolean_expression369 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_comparision_expression_in_boolean_expression373 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_boolean_expression_in_boolean_expression377 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_boolean_expression388 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_comparision_expression_in_boolean_expression392 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_boolean_expression_in_boolean_expression396 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_comparision_expression_in_boolean_expression406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_comparision_expression425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression429 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression433 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_comparision_expression444 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression448 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression452 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_comparision_expression463 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression467 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression471 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_comparision_expression482 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression487 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression491 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_comparision_expression502 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression507 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression511 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_arithmetic_expression540 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression544 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression548 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_37_in_arithmetic_expression559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression563 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression567 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_38_in_arithmetic_expression578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression582 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_39_in_arithmetic_expression597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression601 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_40_in_arithmetic_expression616 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression620 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression624 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_number_in_arithmetic_expression634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_arithmetic_expression643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_arithmetic_expression652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_in_arithmetic_expression661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_return_expression680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_return_expression682 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CALL_in_call697 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_call699 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_call_arguments_in_call701 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CALL_ARGUMENTS_in_call_arguments717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_call_arguments_list_in_call_arguments719 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_call_arguments_list733 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_NUMBER_in_number749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifier779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_method_name791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_variable_name799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_newline813 = new BitSet(new long[]{0x0000000000000002L});

}