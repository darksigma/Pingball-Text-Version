// Generated from BoardExpression.g4 by ANTLR 4.0

package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoardExpressionParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, WHITE=21, COMMENTERS=22, NAME=23, 
		NUMBAH=24, EQUALS=25;
	public static final String[] tokenNames = {
		"<INVALID>", "'yVelocity'", "'fire trigger'", "'squareBumper name'", "'friction1'", 
		"'name'", "'absorber name'", "'gravity'", "'xVelocity'", "'circleBumper name'", 
		"'orientation'", "'height'", "'triangleBumper name'", "'x'", "'y'", "'action'", 
		"'leftFlipper name'", "'rightFlipper name'", "'ball name'", "'friction2'", 
		"'width'", "WHITE", "COMMENTERS", "NAME", "NUMBAH", "'='"
	};
	public static final int
		RULE_root = 0, RULE_premise = 1, RULE_board = 2, RULE_name = 3, RULE_gravity = 4, 
		RULE_friction1 = 5, RULE_friction2 = 6, RULE_ball = 7, RULE_squareBumper = 8, 
		RULE_circleBumper = 9, RULE_triangleBumper = 10, RULE_leftFlipper = 11, 
		RULE_rightFlipper = 12, RULE_absorber = 13, RULE_fire = 14;
	public static final String[] ruleNames = {
		"root", "premise", "board", "name", "gravity", "friction1", "friction2", 
		"ball", "squareBumper", "circleBumper", "triangleBumper", "leftFlipper", 
		"rightFlipper", "absorber", "fire"
	};

	@Override
	public String getGrammarFileName() { return "BoardExpression.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }



		public void reportErrorAsExceptions(){
			addErrorListener(new ExceptionThrowingErrorListener());
		}
		
		private static class ExceptionThrowingErrorListener extends BaseErrorListener {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer,
					Object offendingSymbol, int line, int charPositionLine,
					String msg, RecognitionException e) {
				throw new RuntimeException(msg);
			}
		}

	public BoardExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public PremiseContext premise() {
			return getRuleContext(PremiseContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BoardExpressionParser.EOF, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); premise();
			setState(31); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PremiseContext extends ParserRuleContext {
		public SquareBumperContext squareBumper(int i) {
			return getRuleContext(SquareBumperContext.class,i);
		}
		public CircleBumperContext circleBumper(int i) {
			return getRuleContext(CircleBumperContext.class,i);
		}
		public List<TriangleBumperContext> triangleBumper() {
			return getRuleContexts(TriangleBumperContext.class);
		}
		public List<AbsorberContext> absorber() {
			return getRuleContexts(AbsorberContext.class);
		}
		public List<BallContext> ball() {
			return getRuleContexts(BallContext.class);
		}
		public AbsorberContext absorber(int i) {
			return getRuleContext(AbsorberContext.class,i);
		}
		public List<SquareBumperContext> squareBumper() {
			return getRuleContexts(SquareBumperContext.class);
		}
		public List<CircleBumperContext> circleBumper() {
			return getRuleContexts(CircleBumperContext.class);
		}
		public BoardContext board() {
			return getRuleContext(BoardContext.class,0);
		}
		public List<FireContext> fire() {
			return getRuleContexts(FireContext.class);
		}
		public TriangleBumperContext triangleBumper(int i) {
			return getRuleContext(TriangleBumperContext.class,i);
		}
		public LeftFlipperContext leftFlipper(int i) {
			return getRuleContext(LeftFlipperContext.class,i);
		}
		public FireContext fire(int i) {
			return getRuleContext(FireContext.class,i);
		}
		public List<RightFlipperContext> rightFlipper() {
			return getRuleContexts(RightFlipperContext.class);
		}
		public BallContext ball(int i) {
			return getRuleContext(BallContext.class,i);
		}
		public RightFlipperContext rightFlipper(int i) {
			return getRuleContext(RightFlipperContext.class,i);
		}
		public List<LeftFlipperContext> leftFlipper() {
			return getRuleContexts(LeftFlipperContext.class);
		}
		public PremiseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_premise; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterPremise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitPremise(this);
		}
	}

	public final PremiseContext premise() throws RecognitionException {
		PremiseContext _localctx = new PremiseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_premise);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); board();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 6) | (1L << 9) | (1L << 12) | (1L << 16) | (1L << 17) | (1L << 18))) != 0)) {
				{
				setState(42);
				switch (_input.LA(1)) {
				case 18:
					{
					setState(34); ball();
					}
					break;
				case 3:
					{
					setState(35); squareBumper();
					}
					break;
				case 9:
					{
					setState(36); circleBumper();
					}
					break;
				case 12:
					{
					setState(37); triangleBumper();
					}
					break;
				case 17:
					{
					setState(38); rightFlipper();
					}
					break;
				case 16:
					{
					setState(39); leftFlipper();
					}
					break;
				case 6:
					{
					setState(40); absorber();
					}
					break;
				case 2:
					{
					setState(41); fire();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoardContext extends ParserRuleContext {
		public List<Friction1Context> friction1() {
			return getRuleContexts(Friction1Context.class);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public Friction2Context friction2(int i) {
			return getRuleContext(Friction2Context.class,i);
		}
		public Friction1Context friction1(int i) {
			return getRuleContext(Friction1Context.class,i);
		}
		public GravityContext gravity(int i) {
			return getRuleContext(GravityContext.class,i);
		}
		public List<Friction2Context> friction2() {
			return getRuleContexts(Friction2Context.class);
		}
		public List<GravityContext> gravity() {
			return getRuleContexts(GravityContext.class);
		}
		public BoardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_board; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterBoard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitBoard(this);
		}
	}

	public final BoardContext board() throws RecognitionException {
		BoardContext _localctx = new BoardContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_board);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 5) | (1L << 7) | (1L << 19))) != 0)) {
				{
				setState(51);
				switch (_input.LA(1)) {
				case 5:
					{
					setState(47); name();
					}
					break;
				case 7:
					{
					setState(48); gravity();
					}
					break;
				case 4:
					{
					setState(49); friction1();
					}
					break;
				case 19:
					{
					setState(50); friction2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardExpressionParser.NAME, 0); }
		public TerminalNode EQUALS() { return getToken(BoardExpressionParser.EQUALS, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(5);
			setState(57); match(EQUALS);
			setState(58); match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GravityContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(BoardExpressionParser.EQUALS, 0); }
		public TerminalNode NUMBAH() { return getToken(BoardExpressionParser.NUMBAH, 0); }
		public GravityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gravity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterGravity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitGravity(this);
		}
	}

	public final GravityContext gravity() throws RecognitionException {
		GravityContext _localctx = new GravityContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_gravity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); match(7);
			setState(61); match(EQUALS);
			setState(62); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Friction1Context extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(BoardExpressionParser.EQUALS, 0); }
		public TerminalNode NUMBAH() { return getToken(BoardExpressionParser.NUMBAH, 0); }
		public Friction1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_friction1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterFriction1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitFriction1(this);
		}
	}

	public final Friction1Context friction1() throws RecognitionException {
		Friction1Context _localctx = new Friction1Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_friction1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(4);
			setState(65); match(EQUALS);
			setState(66); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Friction2Context extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(BoardExpressionParser.EQUALS, 0); }
		public TerminalNode NUMBAH() { return getToken(BoardExpressionParser.NUMBAH, 0); }
		public Friction2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_friction2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterFriction2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitFriction2(this);
		}
	}

	public final Friction2Context friction2() throws RecognitionException {
		Friction2Context _localctx = new Friction2Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_friction2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(19);
			setState(69); match(EQUALS);
			setState(70); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BallContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardExpressionParser.NAME, 0); }
		public TerminalNode NUMBAH(int i) {
			return getToken(BoardExpressionParser.NUMBAH, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(BoardExpressionParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(BoardExpressionParser.EQUALS, i);
		}
		public List<TerminalNode> NUMBAH() { return getTokens(BoardExpressionParser.NUMBAH); }
		public BallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ball; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterBall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitBall(this);
		}
	}

	public final BallContext ball() throws RecognitionException {
		BallContext _localctx = new BallContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ball);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(18);
			setState(73); match(EQUALS);
			setState(74); match(NAME);
			setState(75); match(13);
			setState(76); match(EQUALS);
			setState(77); match(NUMBAH);
			setState(78); match(14);
			setState(79); match(EQUALS);
			setState(80); match(NUMBAH);
			setState(81); match(8);
			setState(82); match(EQUALS);
			setState(83); match(NUMBAH);
			setState(84); match(1);
			setState(85); match(EQUALS);
			setState(86); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SquareBumperContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardExpressionParser.NAME, 0); }
		public TerminalNode NUMBAH(int i) {
			return getToken(BoardExpressionParser.NUMBAH, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(BoardExpressionParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(BoardExpressionParser.EQUALS, i);
		}
		public List<TerminalNode> NUMBAH() { return getTokens(BoardExpressionParser.NUMBAH); }
		public SquareBumperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareBumper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterSquareBumper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitSquareBumper(this);
		}
	}

	public final SquareBumperContext squareBumper() throws RecognitionException {
		SquareBumperContext _localctx = new SquareBumperContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_squareBumper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(3);
			setState(89); match(EQUALS);
			setState(90); match(NAME);
			setState(91); match(13);
			setState(92); match(EQUALS);
			setState(93); match(NUMBAH);
			setState(94); match(14);
			setState(95); match(EQUALS);
			setState(96); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CircleBumperContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardExpressionParser.NAME, 0); }
		public TerminalNode NUMBAH(int i) {
			return getToken(BoardExpressionParser.NUMBAH, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(BoardExpressionParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(BoardExpressionParser.EQUALS, i);
		}
		public List<TerminalNode> NUMBAH() { return getTokens(BoardExpressionParser.NUMBAH); }
		public CircleBumperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circleBumper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterCircleBumper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitCircleBumper(this);
		}
	}

	public final CircleBumperContext circleBumper() throws RecognitionException {
		CircleBumperContext _localctx = new CircleBumperContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_circleBumper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(9);
			setState(99); match(EQUALS);
			setState(100); match(NAME);
			setState(101); match(13);
			setState(102); match(EQUALS);
			setState(103); match(NUMBAH);
			setState(104); match(14);
			setState(105); match(EQUALS);
			setState(106); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriangleBumperContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardExpressionParser.NAME, 0); }
		public TerminalNode NUMBAH(int i) {
			return getToken(BoardExpressionParser.NUMBAH, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(BoardExpressionParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(BoardExpressionParser.EQUALS, i);
		}
		public List<TerminalNode> NUMBAH() { return getTokens(BoardExpressionParser.NUMBAH); }
		public TriangleBumperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triangleBumper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterTriangleBumper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitTriangleBumper(this);
		}
	}

	public final TriangleBumperContext triangleBumper() throws RecognitionException {
		TriangleBumperContext _localctx = new TriangleBumperContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_triangleBumper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(12);
			setState(109); match(EQUALS);
			setState(110); match(NAME);
			setState(111); match(13);
			setState(112); match(EQUALS);
			setState(113); match(NUMBAH);
			setState(114); match(14);
			setState(115); match(EQUALS);
			setState(116); match(NUMBAH);
			setState(117); match(10);
			setState(118); match(EQUALS);
			setState(119); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeftFlipperContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardExpressionParser.NAME, 0); }
		public TerminalNode NUMBAH(int i) {
			return getToken(BoardExpressionParser.NUMBAH, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(BoardExpressionParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(BoardExpressionParser.EQUALS, i);
		}
		public List<TerminalNode> NUMBAH() { return getTokens(BoardExpressionParser.NUMBAH); }
		public LeftFlipperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftFlipper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterLeftFlipper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitLeftFlipper(this);
		}
	}

	public final LeftFlipperContext leftFlipper() throws RecognitionException {
		LeftFlipperContext _localctx = new LeftFlipperContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_leftFlipper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(16);
			setState(122); match(EQUALS);
			setState(123); match(NAME);
			setState(124); match(13);
			setState(125); match(EQUALS);
			setState(126); match(NUMBAH);
			setState(127); match(14);
			setState(128); match(EQUALS);
			setState(129); match(NUMBAH);
			setState(130); match(10);
			setState(131); match(EQUALS);
			setState(132); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RightFlipperContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardExpressionParser.NAME, 0); }
		public TerminalNode NUMBAH(int i) {
			return getToken(BoardExpressionParser.NUMBAH, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(BoardExpressionParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(BoardExpressionParser.EQUALS, i);
		}
		public List<TerminalNode> NUMBAH() { return getTokens(BoardExpressionParser.NUMBAH); }
		public RightFlipperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightFlipper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterRightFlipper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitRightFlipper(this);
		}
	}

	public final RightFlipperContext rightFlipper() throws RecognitionException {
		RightFlipperContext _localctx = new RightFlipperContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rightFlipper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(17);
			setState(135); match(EQUALS);
			setState(136); match(NAME);
			setState(137); match(13);
			setState(138); match(EQUALS);
			setState(139); match(NUMBAH);
			setState(140); match(14);
			setState(141); match(EQUALS);
			setState(142); match(NUMBAH);
			setState(143); match(10);
			setState(144); match(EQUALS);
			setState(145); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbsorberContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardExpressionParser.NAME, 0); }
		public TerminalNode NUMBAH(int i) {
			return getToken(BoardExpressionParser.NUMBAH, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(BoardExpressionParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(BoardExpressionParser.EQUALS, i);
		}
		public List<TerminalNode> NUMBAH() { return getTokens(BoardExpressionParser.NUMBAH); }
		public AbsorberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absorber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterAbsorber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitAbsorber(this);
		}
	}

	public final AbsorberContext absorber() throws RecognitionException {
		AbsorberContext _localctx = new AbsorberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_absorber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(6);
			setState(148); match(EQUALS);
			setState(149); match(NAME);
			setState(150); match(13);
			setState(151); match(EQUALS);
			setState(152); match(NUMBAH);
			setState(153); match(14);
			setState(154); match(EQUALS);
			setState(155); match(NUMBAH);
			setState(156); match(20);
			setState(157); match(EQUALS);
			setState(158); match(NUMBAH);
			setState(159); match(11);
			setState(160); match(EQUALS);
			setState(161); match(NUMBAH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FireContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(BoardExpressionParser.NAME); }
		public List<TerminalNode> EQUALS() { return getTokens(BoardExpressionParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(BoardExpressionParser.EQUALS, i);
		}
		public TerminalNode NAME(int i) {
			return getToken(BoardExpressionParser.NAME, i);
		}
		public FireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).enterFire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardExpressionListener ) ((BoardExpressionListener)listener).exitFire(this);
		}
	}

	public final FireContext fire() throws RecognitionException {
		FireContext _localctx = new FireContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); match(2);
			setState(164); match(EQUALS);
			setState(165); match(NAME);
			setState(166); match(15);
			setState(167); match(EQUALS);
			setState(168); match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\33\u00ad\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3"+
		"\60\13\3\3\4\3\4\3\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\2"+
		"\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\u00a9\2 \3\2\2\2\4#\3\2"+
		"\2\2\6\67\3\2\2\2\b:\3\2\2\2\n>\3\2\2\2\fB\3\2\2\2\16F\3\2\2\2\20J\3\2"+
		"\2\2\22Z\3\2\2\2\24d\3\2\2\2\26n\3\2\2\2\30{\3\2\2\2\32\u0088\3\2\2\2"+
		"\34\u0095\3\2\2\2\36\u00a5\3\2\2\2 !\5\4\3\2!\"\7\1\2\2\"\3\3\2\2\2#."+
		"\5\6\4\2$-\5\20\t\2%-\5\22\n\2&-\5\24\13\2\'-\5\26\f\2(-\5\32\16\2)-\5"+
		"\30\r\2*-\5\34\17\2+-\5\36\20\2,$\3\2\2\2,%\3\2\2\2,&\3\2\2\2,\'\3\2\2"+
		"\2,(\3\2\2\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2"+
		"\2\2/\5\3\2\2\2\60.\3\2\2\2\61\66\5\b\5\2\62\66\5\n\6\2\63\66\5\f\7\2"+
		"\64\66\5\16\b\2\65\61\3\2\2\2\65\62\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2"+
		"\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\7\3\2\2\29\67\3\2\2\2:;\7\7"+
		"\2\2;<\7\33\2\2<=\7\31\2\2=\t\3\2\2\2>?\7\t\2\2?@\7\33\2\2@A\7\32\2\2"+
		"A\13\3\2\2\2BC\7\6\2\2CD\7\33\2\2DE\7\32\2\2E\r\3\2\2\2FG\7\25\2\2GH\7"+
		"\33\2\2HI\7\32\2\2I\17\3\2\2\2JK\7\24\2\2KL\7\33\2\2LM\7\31\2\2MN\7\17"+
		"\2\2NO\7\33\2\2OP\7\32\2\2PQ\7\20\2\2QR\7\33\2\2RS\7\32\2\2ST\7\n\2\2"+
		"TU\7\33\2\2UV\7\32\2\2VW\7\3\2\2WX\7\33\2\2XY\7\32\2\2Y\21\3\2\2\2Z[\7"+
		"\5\2\2[\\\7\33\2\2\\]\7\31\2\2]^\7\17\2\2^_\7\33\2\2_`\7\32\2\2`a\7\20"+
		"\2\2ab\7\33\2\2bc\7\32\2\2c\23\3\2\2\2de\7\13\2\2ef\7\33\2\2fg\7\31\2"+
		"\2gh\7\17\2\2hi\7\33\2\2ij\7\32\2\2jk\7\20\2\2kl\7\33\2\2lm\7\32\2\2m"+
		"\25\3\2\2\2no\7\16\2\2op\7\33\2\2pq\7\31\2\2qr\7\17\2\2rs\7\33\2\2st\7"+
		"\32\2\2tu\7\20\2\2uv\7\33\2\2vw\7\32\2\2wx\7\f\2\2xy\7\33\2\2yz\7\32\2"+
		"\2z\27\3\2\2\2{|\7\22\2\2|}\7\33\2\2}~\7\31\2\2~\177\7\17\2\2\177\u0080"+
		"\7\33\2\2\u0080\u0081\7\32\2\2\u0081\u0082\7\20\2\2\u0082\u0083\7\33\2"+
		"\2\u0083\u0084\7\32\2\2\u0084\u0085\7\f\2\2\u0085\u0086\7\33\2\2\u0086"+
		"\u0087\7\32\2\2\u0087\31\3\2\2\2\u0088\u0089\7\23\2\2\u0089\u008a\7\33"+
		"\2\2\u008a\u008b\7\31\2\2\u008b\u008c\7\17\2\2\u008c\u008d\7\33\2\2\u008d"+
		"\u008e\7\32\2\2\u008e\u008f\7\20\2\2\u008f\u0090\7\33\2\2\u0090\u0091"+
		"\7\32\2\2\u0091\u0092\7\f\2\2\u0092\u0093\7\33\2\2\u0093\u0094\7\32\2"+
		"\2\u0094\33\3\2\2\2\u0095\u0096\7\b\2\2\u0096\u0097\7\33\2\2\u0097\u0098"+
		"\7\31\2\2\u0098\u0099\7\17\2\2\u0099\u009a\7\33\2\2\u009a\u009b\7\32\2"+
		"\2\u009b\u009c\7\20\2\2\u009c\u009d\7\33\2\2\u009d\u009e\7\32\2\2\u009e"+
		"\u009f\7\26\2\2\u009f\u00a0\7\33\2\2\u00a0\u00a1\7\32\2\2\u00a1\u00a2"+
		"\7\r\2\2\u00a2\u00a3\7\33\2\2\u00a3\u00a4\7\32\2\2\u00a4\35\3\2\2\2\u00a5"+
		"\u00a6\7\4\2\2\u00a6\u00a7\7\33\2\2\u00a7\u00a8\7\31\2\2\u00a8\u00a9\7"+
		"\21\2\2\u00a9\u00aa\7\33\2\2\u00aa\u00ab\7\31\2\2\u00ab\37\3\2\2\2\6,"+
		".\65\67";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}