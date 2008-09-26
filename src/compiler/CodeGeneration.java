// $ANTLR 3.1 CodeGeneration.g 2008-09-25 16:41:48

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CodeGeneration extends TreeParser {
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


        public CodeGeneration(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public CodeGeneration(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CodeGeneration.tokenNames; }
    public String getGrammarFileName() { return "CodeGeneration.g"; }


      private CodeGenerator generate;

      public CodeGeneration(TreeNodeStream input, String filename) {
        this(input);
        generate = new CodeGenerator(filename);
      }


    public static class program_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "program"
    // CodeGeneration.g:17:1: program : ( ( method_definition | atomic_operation ) ( newline )? )+ ;
    public final CodeGeneration.program_return program() throws RecognitionException {
        CodeGeneration.program_return retval = new CodeGeneration.program_return();
        retval.start = input.LT(1);

        try {
            // CodeGeneration.g:22:5: ( ( ( method_definition | atomic_operation ) ( newline )? )+ )
            // CodeGeneration.g:22:7: ( ( method_definition | atomic_operation ) ( newline )? )+
            {
            // CodeGeneration.g:22:7: ( ( method_definition | atomic_operation ) ( newline )? )+
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
            	    // CodeGeneration.g:22:8: ( method_definition | atomic_operation ) ( newline )?
            	    {
            	    // CodeGeneration.g:22:8: ( method_definition | atomic_operation )
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
            	            // CodeGeneration.g:22:9: method_definition
            	            {
            	            pushFollow(FOLLOW_method_definition_in_program52);
            	            method_definition();

            	            state._fsp--;


            	            }
            	            break;
            	        case 2 :
            	            // CodeGeneration.g:22:29: atomic_operation
            	            {
            	            pushFollow(FOLLOW_atomic_operation_in_program56);
            	            atomic_operation();

            	            state._fsp--;


            	            }
            	            break;

            	    }

            	    // CodeGeneration.g:22:47: ( newline )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==NEWLINE) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // CodeGeneration.g:22:47: newline
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


                      generate.switchScope(((ASTNode)retval.start).scope);
                    

            }


                generate.misc().finish();
                generate.getOutput().save();

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
    // CodeGeneration.g:26:1: atomic_operation : ( conditional | loop | assignment | expression | return_expression );
    public final void atomic_operation() throws RecognitionException {
        try {
            // CodeGeneration.g:27:5: ( conditional | loop | assignment | expression | return_expression )
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
                    // CodeGeneration.g:27:8: conditional
                    {
                    pushFollow(FOLLOW_conditional_in_atomic_operation77);
                    conditional();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // CodeGeneration.g:27:22: loop
                    {
                    pushFollow(FOLLOW_loop_in_atomic_operation81);
                    loop();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // CodeGeneration.g:27:29: assignment
                    {
                    pushFollow(FOLLOW_assignment_in_atomic_operation85);
                    assignment();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // CodeGeneration.g:27:42: expression
                    {
                    pushFollow(FOLLOW_expression_in_atomic_operation89);
                    expression();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // CodeGeneration.g:27:55: return_expression
                    {
                    pushFollow(FOLLOW_return_expression_in_atomic_operation93);
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
    // CodeGeneration.g:29:1: atomic_operations_list : ( atomic_operation )+ ;
    public final void atomic_operations_list() throws RecognitionException {
        try {
            // CodeGeneration.g:30:5: ( ( atomic_operation )+ )
            // CodeGeneration.g:30:8: ( atomic_operation )+
            {
            // CodeGeneration.g:30:8: ( atomic_operation )+
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
            	    // CodeGeneration.g:30:8: atomic_operation
            	    {
            	    pushFollow(FOLLOW_atomic_operation_in_atomic_operations_list106);
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
    // CodeGeneration.g:32:1: method_definition : ^( METHOD method_header METHOD_BODY method_body ) ;
    public final void method_definition() throws RecognitionException {
        try {
            // CodeGeneration.g:34:5: ( ^( METHOD method_header METHOD_BODY method_body ) )
            // CodeGeneration.g:34:8: ^( METHOD method_header METHOD_BODY method_body )
            {
            match(input,METHOD,FOLLOW_METHOD_in_method_definition126); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_method_header_in_method_definition128);
            method_header();

            state._fsp--;

            match(input,METHOD_BODY,FOLLOW_METHOD_BODY_in_method_definition130); 
            pushFollow(FOLLOW_method_body_in_method_definition132);
            method_body();

            state._fsp--;


            match(input, Token.UP, null); 

            }

             generate.method().finish(); 
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
    // CodeGeneration.g:36:1: method_header : ^(name= IDENTIFIER ( (args+= IDENTIFIER )+ )? ) ;
    public final CodeGeneration.method_header_return method_header() throws RecognitionException {
        CodeGeneration.method_header_return retval = new CodeGeneration.method_header_return();
        retval.start = input.LT(1);

        ASTNode name=null;
        ASTNode args=null;
        List list_args=null;

        try {
            // CodeGeneration.g:37:5: ( ^(name= IDENTIFIER ( (args+= IDENTIFIER )+ )? ) )
            // CodeGeneration.g:37:8: ^(name= IDENTIFIER ( (args+= IDENTIFIER )+ )? )
            {
            name=(ASTNode)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_method_header149); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // CodeGeneration.g:37:26: ( (args+= IDENTIFIER )+ )?
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENTIFIER) ) {
                    alt7=1;
                }
                switch (alt7) {
                    case 1 :
                        // CodeGeneration.g:37:27: (args+= IDENTIFIER )+
                        {
                        // CodeGeneration.g:37:27: (args+= IDENTIFIER )+
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
                        	    // CodeGeneration.g:37:28: args+= IDENTIFIER
                        	    {
                        	    args=(ASTNode)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_method_header155); 
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

                      generate.switchScope(((ASTNode)retval.start).scope);
                      generate.method().definition((name!=null?name.getText():null));


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
    // CodeGeneration.g:42:1: method_body : ( atomic_operation )+ ;
    public final void method_body() throws RecognitionException {
        try {
            // CodeGeneration.g:43:5: ( ( atomic_operation )+ )
            // CodeGeneration.g:43:8: ( atomic_operation )+
            {
            // CodeGeneration.g:43:8: ( atomic_operation )+
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
            	    // CodeGeneration.g:43:8: atomic_operation
            	    {
            	    pushFollow(FOLLOW_atomic_operation_in_method_body175);
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
    // CodeGeneration.g:45:1: conditional : ^( IF conditional_test IF_BODY atomic_operations_list ) ;
    public final void conditional() throws RecognitionException {
        try {
            // CodeGeneration.g:47:5: ( ^( IF conditional_test IF_BODY atomic_operations_list ) )
            // CodeGeneration.g:47:8: ^( IF conditional_test IF_BODY atomic_operations_list )
            {
            match(input,IF,FOLLOW_IF_in_conditional195); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_conditional_test_in_conditional197);
            conditional_test();

            state._fsp--;

            match(input,IF_BODY,FOLLOW_IF_BODY_in_conditional199); 
            pushFollow(FOLLOW_atomic_operations_list_in_conditional201);
            atomic_operations_list();

            state._fsp--;


            match(input, Token.UP, null); 

            }

             generate.conditional().ifAfterBody(); 
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
    // CodeGeneration.g:49:1: conditional_test : expression ;
    public final void conditional_test() throws RecognitionException {
        try {
            // CodeGeneration.g:51:5: ( expression )
            // CodeGeneration.g:51:8: expression
            {
            pushFollow(FOLLOW_expression_in_conditional_test220);
            expression();

            state._fsp--;


            }

             generate.conditional().ifAfterCondition(); 
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
    // CodeGeneration.g:53:1: conditional_else : ^( ELSE expression ELSE_BODY atomic_operations_list ) ;
    public final void conditional_else() throws RecognitionException {
        try {
            // CodeGeneration.g:54:5: ( ^( ELSE expression ELSE_BODY atomic_operations_list ) )
            // CodeGeneration.g:54:8: ^( ELSE expression ELSE_BODY atomic_operations_list )
            {
            match(input,ELSE,FOLLOW_ELSE_in_conditional_else234); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_conditional_else236);
            expression();

            state._fsp--;

            match(input,ELSE_BODY,FOLLOW_ELSE_BODY_in_conditional_else238); 
            pushFollow(FOLLOW_atomic_operations_list_in_conditional_else240);
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
    // CodeGeneration.g:56:1: conditional_body : ( conditional | assignment | expression )+ ;
    public final void conditional_body() throws RecognitionException {
        try {
            // CodeGeneration.g:57:5: ( ( conditional | assignment | expression )+ )
            // CodeGeneration.g:57:8: ( conditional | assignment | expression )+
            {
            // CodeGeneration.g:57:8: ( conditional | assignment | expression )+
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
            	    // CodeGeneration.g:57:9: conditional
            	    {
            	    pushFollow(FOLLOW_conditional_in_conditional_body255);
            	    conditional();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // CodeGeneration.g:57:23: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_conditional_body259);
            	    assignment();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // CodeGeneration.g:57:36: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_conditional_body263);
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
    // CodeGeneration.g:59:1: loop : ^( WHILE loop_test WHILE_BODY loop_body ) ;
    public final void loop() throws RecognitionException {
        try {
            // CodeGeneration.g:60:5: ( ^( WHILE loop_test WHILE_BODY loop_body ) )
            // CodeGeneration.g:60:8: ^( WHILE loop_test WHILE_BODY loop_body )
            {
            match(input,WHILE,FOLLOW_WHILE_in_loop279); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_loop_test_in_loop281);
            loop_test();

            state._fsp--;

            match(input,WHILE_BODY,FOLLOW_WHILE_BODY_in_loop283); 
            pushFollow(FOLLOW_loop_body_in_loop285);
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
    // CodeGeneration.g:62:1: loop_test : expression ;
    public final void loop_test() throws RecognitionException {
         generate.loop().whileBeforeCondition(); 
        try {
            // CodeGeneration.g:65:5: ( expression )
            // CodeGeneration.g:65:8: expression
            {
            pushFollow(FOLLOW_expression_in_loop_test310);
            expression();

            state._fsp--;


            }

             generate.loop().whileAfterCondition(); 
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
    // CodeGeneration.g:67:1: loop_body : ( conditional | assignment | expression )+ ;
    public final void loop_body() throws RecognitionException {
        try {
            // CodeGeneration.g:69:5: ( ( conditional | assignment | expression )+ )
            // CodeGeneration.g:69:8: ( conditional | assignment | expression )+
            {
            // CodeGeneration.g:69:8: ( conditional | assignment | expression )+
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
            	    // CodeGeneration.g:69:9: conditional
            	    {
            	    pushFollow(FOLLOW_conditional_in_loop_body329);
            	    conditional();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // CodeGeneration.g:69:23: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_loop_body333);
            	    assignment();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // CodeGeneration.g:69:36: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_loop_body337);
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

             generate.loop().whileAfterBody(); 
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


    // $ANTLR start "assignment"
    // CodeGeneration.g:71:1: assignment : ^( '=' var= IDENTIFIER val= expression ) ;
    public final void assignment() throws RecognitionException {
        ASTNode var=null;
        CodeGeneration.expression_return val = null;


         generate.misc().pushThis(); 
        try {
            // CodeGeneration.g:73:5: ( ^( '=' var= IDENTIFIER val= expression ) )
            // CodeGeneration.g:73:8: ^( '=' var= IDENTIFIER val= expression )
            {
            match(input,28,FOLLOW_28_in_assignment359); 

            match(input, Token.DOWN, null); 
            var=(ASTNode)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignment363); 
            pushFollow(FOLLOW_expression_in_assignment367);
            val=expression();

            state._fsp--;


            match(input, Token.UP, null); 
             generate.misc().storeVariable((var!=null?var.getText():null)); 

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
    // $ANTLR end "assignment"

    public static class expression_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "expression"
    // CodeGeneration.g:75:1: expression : boolean_expression ;
    public final CodeGeneration.expression_return expression() throws RecognitionException {
        CodeGeneration.expression_return retval = new CodeGeneration.expression_return();
        retval.start = input.LT(1);

        try {
            // CodeGeneration.g:76:5: ( boolean_expression )
            // CodeGeneration.g:76:7: boolean_expression
            {
            pushFollow(FOLLOW_boolean_expression_in_expression382);
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
    // CodeGeneration.g:78:1: boolean_expression : ( ^( '&&' a= comparision_expression b= boolean_expression ) | ^( '||' a= comparision_expression b= boolean_expression ) | comparision_expression );
    public final void boolean_expression() throws RecognitionException {
        try {
            // CodeGeneration.g:79:5: ( ^( '&&' a= comparision_expression b= boolean_expression ) | ^( '||' a= comparision_expression b= boolean_expression ) | comparision_expression )
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
                    // CodeGeneration.g:79:8: ^( '&&' a= comparision_expression b= boolean_expression )
                    {
                    match(input,29,FOLLOW_29_in_boolean_expression396); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_comparision_expression_in_boolean_expression400);
                    comparision_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_boolean_expression_in_boolean_expression404);
                    boolean_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.bool().and(); 

                    }
                    break;
                case 2 :
                    // CodeGeneration.g:80:8: ^( '||' a= comparision_expression b= boolean_expression )
                    {
                    match(input,30,FOLLOW_30_in_boolean_expression417); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_comparision_expression_in_boolean_expression421);
                    comparision_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_boolean_expression_in_boolean_expression425);
                    boolean_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.bool().or(); 

                    }
                    break;
                case 3 :
                    // CodeGeneration.g:81:8: comparision_expression
                    {
                    pushFollow(FOLLOW_comparision_expression_in_boolean_expression437);
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
    // CodeGeneration.g:83:1: comparision_expression : ( ^( '==' a= arithmetic_expression b= arithmetic_expression ) | ^( '<=' a= arithmetic_expression b= arithmetic_expression ) | ^( '>=' a= arithmetic_expression b= arithmetic_expression ) | ^( '<' a= arithmetic_expression b= arithmetic_expression ) | ^( '>' a= arithmetic_expression b= arithmetic_expression ) | arithmetic_expression );
    public final void comparision_expression() throws RecognitionException {
        try {
            // CodeGeneration.g:84:5: ( ^( '==' a= arithmetic_expression b= arithmetic_expression ) | ^( '<=' a= arithmetic_expression b= arithmetic_expression ) | ^( '>=' a= arithmetic_expression b= arithmetic_expression ) | ^( '<' a= arithmetic_expression b= arithmetic_expression ) | ^( '>' a= arithmetic_expression b= arithmetic_expression ) | arithmetic_expression )
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
                    // CodeGeneration.g:84:8: ^( '==' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,31,FOLLOW_31_in_comparision_expression451); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression455);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression459);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.bool().equal(); 

                    }
                    break;
                case 2 :
                    // CodeGeneration.g:85:8: ^( '<=' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,32,FOLLOW_32_in_comparision_expression472); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression476);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression480);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.bool().lessThanOrEqual(); 

                    }
                    break;
                case 3 :
                    // CodeGeneration.g:86:8: ^( '>=' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,33,FOLLOW_33_in_comparision_expression493); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression497);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression501);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.bool().greaterThanOrEqual(); 

                    }
                    break;
                case 4 :
                    // CodeGeneration.g:87:8: ^( '<' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,34,FOLLOW_34_in_comparision_expression514); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression519);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression523);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.bool().lessThan(); 

                    }
                    break;
                case 5 :
                    // CodeGeneration.g:88:8: ^( '>' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,35,FOLLOW_35_in_comparision_expression536); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression541);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression545);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.bool().greaterThan(); 

                    }
                    break;
                case 6 :
                    // CodeGeneration.g:89:8: arithmetic_expression
                    {
                    pushFollow(FOLLOW_arithmetic_expression_in_comparision_expression557);
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
    // CodeGeneration.g:91:1: arithmetic_expression : ( ^( '+' a= arithmetic_expression b= arithmetic_expression ) | ^( '-' a= arithmetic_expression b= arithmetic_expression ) | ^( '*' a= arithmetic_expression b= arithmetic_expression ) | ^( '/' a= arithmetic_expression b= arithmetic_expression ) | ^( '%' a= arithmetic_expression b= arithmetic_expression ) | NUMBER | IDENTIFIER | STRING | call );
    public final void arithmetic_expression() throws RecognitionException {
        ASTNode NUMBER1=null;
        ASTNode IDENTIFIER2=null;

        try {
            // CodeGeneration.g:92:5: ( ^( '+' a= arithmetic_expression b= arithmetic_expression ) | ^( '-' a= arithmetic_expression b= arithmetic_expression ) | ^( '*' a= arithmetic_expression b= arithmetic_expression ) | ^( '/' a= arithmetic_expression b= arithmetic_expression ) | ^( '%' a= arithmetic_expression b= arithmetic_expression ) | NUMBER | IDENTIFIER | STRING | call )
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
            case IDENTIFIER:
                {
                alt13=7;
                }
                break;
            case STRING:
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
                    // CodeGeneration.g:92:8: ^( '+' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,36,FOLLOW_36_in_arithmetic_expression571); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression575);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression579);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.arithmetic().add(); 

                    }
                    break;
                case 2 :
                    // CodeGeneration.g:93:8: ^( '-' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,37,FOLLOW_37_in_arithmetic_expression592); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression596);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression600);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.arithmetic().subtract(); 

                    }
                    break;
                case 3 :
                    // CodeGeneration.g:94:8: ^( '*' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,38,FOLLOW_38_in_arithmetic_expression613); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression617);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression621);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.arithmetic().multiply(); 

                    }
                    break;
                case 4 :
                    // CodeGeneration.g:95:8: ^( '/' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,39,FOLLOW_39_in_arithmetic_expression634); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression638);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression642);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.arithmetic().divide(); 

                    }
                    break;
                case 5 :
                    // CodeGeneration.g:96:8: ^( '%' a= arithmetic_expression b= arithmetic_expression )
                    {
                    match(input,40,FOLLOW_40_in_arithmetic_expression655); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression659);
                    arithmetic_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_arithmetic_expression_in_arithmetic_expression663);
                    arithmetic_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     generate.arithmetic().mod(); 

                    }
                    break;
                case 6 :
                    // CodeGeneration.g:97:8: NUMBER
                    {
                    NUMBER1=(ASTNode)match(input,NUMBER,FOLLOW_NUMBER_in_arithmetic_expression675); 
                     generate.misc().load(Integer.parseInt((NUMBER1!=null?NUMBER1.getText():null))); 

                    }
                    break;
                case 7 :
                    // CodeGeneration.g:98:8: IDENTIFIER
                    {
                    IDENTIFIER2=(ASTNode)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_arithmetic_expression734); 
                     generate.misc().loadVariable((IDENTIFIER2!=null?IDENTIFIER2.getText():null)); 

                    }
                    break;
                case 8 :
                    // CodeGeneration.g:99:8: STRING
                    {
                    match(input,STRING,FOLLOW_STRING_in_arithmetic_expression789); 

                    }
                    break;
                case 9 :
                    // CodeGeneration.g:100:8: call
                    {
                    pushFollow(FOLLOW_call_in_arithmetic_expression798);
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
    // CodeGeneration.g:103:1: return_expression : ^( RETURN expression ) ;
    public final void return_expression() throws RecognitionException {
        try {
            // CodeGeneration.g:104:5: ( ^( RETURN expression ) )
            // CodeGeneration.g:104:8: ^( RETURN expression )
            {
            match(input,RETURN,FOLLOW_RETURN_in_return_expression817); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_return_expression819);
            expression();

            state._fsp--;


            match(input, Token.UP, null); 
             generate.method().ret(); 

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
    // CodeGeneration.g:106:1: call : ^( CALL IDENTIFIER ( call_arguments )? ) ;
    public final void call() throws RecognitionException {
        ASTNode IDENTIFIER3=null;

         generate.method().prepareCall(); 
        try {
            // CodeGeneration.g:108:5: ( ^( CALL IDENTIFIER ( call_arguments )? ) )
            // CodeGeneration.g:108:8: ^( CALL IDENTIFIER ( call_arguments )? )
            {
            match(input,CALL,FOLLOW_CALL_in_call841); 

            match(input, Token.DOWN, null); 
            IDENTIFIER3=(ASTNode)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_call843); 
            // CodeGeneration.g:108:26: ( call_arguments )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==CALL_ARGUMENTS) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // CodeGeneration.g:108:26: call_arguments
                    {
                    pushFollow(FOLLOW_call_arguments_in_call845);
                    call_arguments();

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
             generate.method().call((IDENTIFIER3!=null?IDENTIFIER3.getText():null)); 

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

    protected static class call_arguments_scope {
        ArrayList<ASTNode> arguments;
    }
    protected Stack call_arguments_stack = new Stack();


    // $ANTLR start "call_arguments"
    // CodeGeneration.g:110:1: call_arguments : ^( CALL_ARGUMENTS ( argument )* ) ;
    public final void call_arguments() throws RecognitionException {
        call_arguments_stack.push(new call_arguments_scope());
         ((call_arguments_scope)call_arguments_stack.peek()).arguments = new ArrayList<ASTNode>(); 
        try {
            // CodeGeneration.g:115:5: ( ^( CALL_ARGUMENTS ( argument )* ) )
            // CodeGeneration.g:115:8: ^( CALL_ARGUMENTS ( argument )* )
            {
            match(input,CALL_ARGUMENTS,FOLLOW_CALL_ARGUMENTS_in_call_arguments892); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // CodeGeneration.g:115:25: ( argument )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==CALL||(LA15_0>=IDENTIFIER && LA15_0<=STRING)||(LA15_0>=29 && LA15_0<=40)) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // CodeGeneration.g:115:25: argument
                	    {
                	    pushFollow(FOLLOW_argument_in_call_arguments894);
                	    argument();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop15;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

                      System.out.println("Arguments");
                      for(ASTNode argument : ((call_arguments_scope)call_arguments_stack.peek()).arguments)
                          System.out.println(argument);
                      System.out.println();
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            call_arguments_stack.pop();
        }
        return ;
    }
    // $ANTLR end "call_arguments"


    // $ANTLR start "argument"
    // CodeGeneration.g:122:1: argument : expression ;
    public final void argument() throws RecognitionException {
        CodeGeneration.expression_return expression4 = null;


        try {
            // CodeGeneration.g:122:9: ( expression )
            // CodeGeneration.g:122:11: expression
            {
            pushFollow(FOLLOW_expression_in_argument906);
            expression4=expression();

            state._fsp--;


                      ((call_arguments_scope)call_arguments_stack.peek()).arguments.add((ASTNode)(expression4!=null?((ASTNode)expression4.start):null));
                    

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
    // $ANTLR end "argument"


    // $ANTLR start "number"
    // CodeGeneration.g:126:1: number : NUMBER ;
    public final void number() throws RecognitionException {
        try {
            // CodeGeneration.g:126:7: ( NUMBER )
            // CodeGeneration.g:126:17: NUMBER
            {
            match(input,NUMBER,FOLLOW_NUMBER_in_number923); 

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
    // $ANTLR end "number"


    // $ANTLR start "string"
    // CodeGeneration.g:128:1: string : STRING ;
    public final void string() throws RecognitionException {
        try {
            // CodeGeneration.g:128:7: ( STRING )
            // CodeGeneration.g:128:17: STRING
            {
            match(input,STRING,FOLLOW_STRING_in_string938); 

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
    // $ANTLR end "string"


    // $ANTLR start "identifier"
    // CodeGeneration.g:130:1: identifier : IDENTIFIER ;
    public final void identifier() throws RecognitionException {
        try {
            // CodeGeneration.g:130:11: ( IDENTIFIER )
            // CodeGeneration.g:130:17: IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier949); 

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
    // $ANTLR end "identifier"


    // $ANTLR start "method_name"
    // CodeGeneration.g:132:1: method_name : IDENTIFIER ;
    public final void method_name() throws RecognitionException {
        try {
            // CodeGeneration.g:132:12: ( IDENTIFIER )
            // CodeGeneration.g:132:17: IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_method_name959); 

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
    // CodeGeneration.g:134:1: variable_name : IDENTIFIER ;
    public final void variable_name() throws RecognitionException {
        try {
            // CodeGeneration.g:134:14: ( IDENTIFIER )
            // CodeGeneration.g:134:17: IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variable_name967); 

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
    // CodeGeneration.g:136:1: newline : NEWLINE ;
    public final void newline() throws RecognitionException {
        try {
            // CodeGeneration.g:136:8: ( NEWLINE )
            // CodeGeneration.g:136:17: NEWLINE
            {
            match(input,NEWLINE,FOLLOW_NEWLINE_in_newline981); 

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
    public static final BitSet FOLLOW_conditional_in_atomic_operation77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_in_atomic_operation81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_atomic_operation85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_atomic_operation89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_expression_in_atomic_operation93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_operation_in_atomic_operations_list106 = new BitSet(new long[]{0x000001FFF007D152L});
    public static final BitSet FOLLOW_METHOD_in_method_definition126 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_method_header_in_method_definition128 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_METHOD_BODY_in_method_definition130 = new BitSet(new long[]{0x000001FFF007D150L});
    public static final BitSet FOLLOW_method_body_in_method_definition132 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_method_header149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_method_header155 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_atomic_operation_in_method_body175 = new BitSet(new long[]{0x000001FFF007D152L});
    public static final BitSet FOLLOW_IF_in_conditional195 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditional_test_in_conditional197 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_IF_BODY_in_conditional199 = new BitSet(new long[]{0x000001FFF007D150L});
    public static final BitSet FOLLOW_atomic_operations_list_in_conditional201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_conditional_test220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_conditional_else234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_conditional_else236 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ELSE_BODY_in_conditional_else238 = new BitSet(new long[]{0x000001FFF007D150L});
    public static final BitSet FOLLOW_atomic_operations_list_in_conditional_else240 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_conditional_in_conditional_body255 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_assignment_in_conditional_body259 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_expression_in_conditional_body263 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_WHILE_in_loop279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_loop_test_in_loop281 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_WHILE_BODY_in_loop283 = new BitSet(new long[]{0x000001FFF0038110L});
    public static final BitSet FOLLOW_loop_body_in_loop285 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_loop_test310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_loop_body329 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_assignment_in_loop_body333 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_expression_in_loop_body337 = new BitSet(new long[]{0x000001FFF0038112L});
    public static final BitSet FOLLOW_28_in_assignment359 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assignment363 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_expression_in_assignment367 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_boolean_expression_in_expression382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_boolean_expression396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_comparision_expression_in_boolean_expression400 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_boolean_expression_in_boolean_expression404 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_boolean_expression417 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_comparision_expression_in_boolean_expression421 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_boolean_expression_in_boolean_expression425 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_comparision_expression_in_boolean_expression437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_comparision_expression451 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression455 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression459 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_comparision_expression472 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression476 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression480 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_comparision_expression493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression497 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression501 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_comparision_expression514 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression519 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression523 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_comparision_expression536 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression541 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression545 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arithmetic_expression_in_comparision_expression557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_arithmetic_expression571 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression575 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_37_in_arithmetic_expression592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression596 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression600 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_38_in_arithmetic_expression613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression617 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression621 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_39_in_arithmetic_expression634 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression638 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression642 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_40_in_arithmetic_expression655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression659 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_arithmetic_expression_in_arithmetic_expression663 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NUMBER_in_arithmetic_expression675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_arithmetic_expression734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_arithmetic_expression789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_in_arithmetic_expression798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_return_expression817 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_return_expression819 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CALL_in_call841 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_call843 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_call_arguments_in_call845 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CALL_ARGUMENTS_in_call_arguments892 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_argument_in_call_arguments894 = new BitSet(new long[]{0x000001FFF0038118L});
    public static final BitSet FOLLOW_expression_in_argument906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_number923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifier949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_method_name959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_variable_name967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_newline981 = new BitSet(new long[]{0x0000000000000002L});

}