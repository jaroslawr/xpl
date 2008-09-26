// $ANTLR 3.1 Xpl.g 2008-09-25 16:41:46

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class XplLexer extends Lexer {
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

    public XplLexer() {;} 
    public XplLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public XplLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Xpl.g"; }

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:3:7: ( 'end' )
            // Xpl.g:3:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:4:7: ( 'method' )
            // Xpl.g:4:9: 'method'
            {
            match("method"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:5:7: ( '(' )
            // Xpl.g:5:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:6:7: ( ')' )
            // Xpl.g:6:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:7:7: ( ',' )
            // Xpl.g:7:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:8:7: ( 'if' )
            // Xpl.g:8:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:9:7: ( 'else' )
            // Xpl.g:9:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:10:7: ( 'while' )
            // Xpl.g:10:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:11:7: ( '=' )
            // Xpl.g:11:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:12:7: ( '&&' )
            // Xpl.g:12:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:13:7: ( '||' )
            // Xpl.g:13:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:14:7: ( '==' )
            // Xpl.g:14:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:15:7: ( '<=' )
            // Xpl.g:15:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:16:7: ( '>=' )
            // Xpl.g:16:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:17:7: ( '<' )
            // Xpl.g:17:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:18:7: ( '>' )
            // Xpl.g:18:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:19:7: ( '+' )
            // Xpl.g:19:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:20:7: ( '-' )
            // Xpl.g:20:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:21:7: ( '*' )
            // Xpl.g:21:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:22:7: ( '/' )
            // Xpl.g:22:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:23:7: ( '%' )
            // Xpl.g:23:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:24:7: ( 'return' )
            // Xpl.g:24:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:66:7: ( '\\\"' ( options {greedy=false; } : ( 'A' .. 'z' ) | ' ' )* '\\\"' )
            // Xpl.g:66:26: '\\\"' ( options {greedy=false; } : ( 'A' .. 'z' ) | ' ' )* '\\\"'
            {
            match('\"'); 
            // Xpl.g:66:31: ( options {greedy=false; } : ( 'A' .. 'z' ) | ' ' )*
            loop1:
            do {
                int alt1=3;
                switch ( input.LA(1) ) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '[':
                case '\\':
                case ']':
                case '^':
                case '_':
                case '`':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt1=1;
                    }
                    break;
                case ' ':
                    {
                    alt1=2;
                    }
                    break;
                case '\"':
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // Xpl.g:66:57: ( 'A' .. 'z' )
            	    {
            	    // Xpl.g:66:57: ( 'A' .. 'z' )
            	    // Xpl.g:66:58: 'A' .. 'z'
            	    {
            	    matchRange('A','z'); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Xpl.g:66:70: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:68:11: ( ( 'a' .. 'z' )+ )
            // Xpl.g:68:26: ( 'a' .. 'z' )+
            {
            // Xpl.g:68:26: ( 'a' .. 'z' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Xpl.g:68:27: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:70:7: ( ( '0' .. '9' )+ )
            // Xpl.g:70:26: ( '0' .. '9' )+
            {
            // Xpl.g:70:26: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Xpl.g:70:27: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:72:8: ( ( '\\n' )+ )
            // Xpl.g:72:26: ( '\\n' )+
            {
            // Xpl.g:72:26: ( '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\n') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Xpl.g:72:27: '\\n'
            	    {
            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

             emit(); skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpl.g:74:3: ( ( ' ' | '\\t' )+ )
            // Xpl.g:74:26: ( ' ' | '\\t' )+
            {
            // Xpl.g:74:26: ( ' ' | '\\t' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Xpl.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // Xpl.g:1:8: ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | STRING | IDENTIFIER | NUMBER | NEWLINE | WS )
        int alt6=27;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // Xpl.g:1:10: T__20
                {
                mT__20(); 

                }
                break;
            case 2 :
                // Xpl.g:1:16: T__21
                {
                mT__21(); 

                }
                break;
            case 3 :
                // Xpl.g:1:22: T__22
                {
                mT__22(); 

                }
                break;
            case 4 :
                // Xpl.g:1:28: T__23
                {
                mT__23(); 

                }
                break;
            case 5 :
                // Xpl.g:1:34: T__24
                {
                mT__24(); 

                }
                break;
            case 6 :
                // Xpl.g:1:40: T__25
                {
                mT__25(); 

                }
                break;
            case 7 :
                // Xpl.g:1:46: T__26
                {
                mT__26(); 

                }
                break;
            case 8 :
                // Xpl.g:1:52: T__27
                {
                mT__27(); 

                }
                break;
            case 9 :
                // Xpl.g:1:58: T__28
                {
                mT__28(); 

                }
                break;
            case 10 :
                // Xpl.g:1:64: T__29
                {
                mT__29(); 

                }
                break;
            case 11 :
                // Xpl.g:1:70: T__30
                {
                mT__30(); 

                }
                break;
            case 12 :
                // Xpl.g:1:76: T__31
                {
                mT__31(); 

                }
                break;
            case 13 :
                // Xpl.g:1:82: T__32
                {
                mT__32(); 

                }
                break;
            case 14 :
                // Xpl.g:1:88: T__33
                {
                mT__33(); 

                }
                break;
            case 15 :
                // Xpl.g:1:94: T__34
                {
                mT__34(); 

                }
                break;
            case 16 :
                // Xpl.g:1:100: T__35
                {
                mT__35(); 

                }
                break;
            case 17 :
                // Xpl.g:1:106: T__36
                {
                mT__36(); 

                }
                break;
            case 18 :
                // Xpl.g:1:112: T__37
                {
                mT__37(); 

                }
                break;
            case 19 :
                // Xpl.g:1:118: T__38
                {
                mT__38(); 

                }
                break;
            case 20 :
                // Xpl.g:1:124: T__39
                {
                mT__39(); 

                }
                break;
            case 21 :
                // Xpl.g:1:130: T__40
                {
                mT__40(); 

                }
                break;
            case 22 :
                // Xpl.g:1:136: T__41
                {
                mT__41(); 

                }
                break;
            case 23 :
                // Xpl.g:1:142: STRING
                {
                mSTRING(); 

                }
                break;
            case 24 :
                // Xpl.g:1:149: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 25 :
                // Xpl.g:1:160: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 26 :
                // Xpl.g:1:167: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 27 :
                // Xpl.g:1:175: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\2\24\3\uffff\2\24\1\36\2\uffff\1\40\1\42\5\uffff\1\24\5"+
        "\uffff\3\24\1\47\1\24\6\uffff\1\24\1\52\2\24\1\uffff\2\24\1\uffff"+
        "\1\57\3\24\1\uffff\1\24\1\64\1\24\1\66\1\uffff\1\67\2\uffff";
    static final String DFA6_eofS =
        "\70\uffff";
    static final String DFA6_minS =
        "\1\11\1\154\1\145\3\uffff\1\146\1\150\1\75\2\uffff\2\75\5\uffff"+
        "\1\145\5\uffff\1\144\1\163\1\164\1\141\1\151\6\uffff\1\164\1\141"+
        "\1\145\1\150\1\uffff\1\154\1\165\1\uffff\1\141\1\157\1\145\1\162"+
        "\1\uffff\1\144\1\141\1\156\1\141\1\uffff\1\141\2\uffff";
    static final String DFA6_maxS =
        "\1\174\1\156\1\145\3\uffff\1\146\1\150\1\75\2\uffff\2\75\5\uffff"+
        "\1\145\5\uffff\1\144\1\163\1\164\1\172\1\151\6\uffff\1\164\1\172"+
        "\1\145\1\150\1\uffff\1\154\1\165\1\uffff\1\172\1\157\1\145\1\162"+
        "\1\uffff\1\144\1\172\1\156\1\172\1\uffff\1\172\2\uffff";
    static final String DFA6_acceptS =
        "\3\uffff\1\3\1\4\1\5\3\uffff\1\12\1\13\2\uffff\1\21\1\22\1\23\1"+
        "\24\1\25\1\uffff\1\27\1\30\1\31\1\32\1\33\5\uffff\1\14\1\11\1\15"+
        "\1\17\1\16\1\20\4\uffff\1\6\2\uffff\1\1\4\uffff\1\7\4\uffff\1\10"+
        "\1\uffff\1\2\1\26";
    static final String DFA6_specialS =
        "\70\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\27\1\26\25\uffff\1\27\1\uffff\1\23\2\uffff\1\21\1\11\1\uffff"+
            "\1\3\1\4\1\17\1\15\1\5\1\16\1\uffff\1\20\12\25\2\uffff\1\13"+
            "\1\10\1\14\42\uffff\4\24\1\1\3\24\1\6\3\24\1\2\4\24\1\22\4\24"+
            "\1\7\3\24\1\uffff\1\12",
            "\1\31\1\uffff\1\30",
            "\1\32",
            "",
            "",
            "",
            "\1\33",
            "\1\34",
            "\1\35",
            "",
            "",
            "\1\37",
            "\1\41",
            "",
            "",
            "",
            "",
            "",
            "\1\43",
            "",
            "",
            "",
            "",
            "",
            "\1\44",
            "\1\45",
            "\1\46",
            "\32\24",
            "\1\50",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\51",
            "\32\24",
            "\1\53",
            "\1\54",
            "",
            "\1\55",
            "\1\56",
            "",
            "\32\24",
            "\1\60",
            "\1\61",
            "\1\62",
            "",
            "\1\63",
            "\32\24",
            "\1\65",
            "\32\24",
            "",
            "\32\24",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | STRING | IDENTIFIER | NUMBER | NEWLINE | WS );";
        }
    }
 

}