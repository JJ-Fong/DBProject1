// Generated from D:\Asus WebStorage\Septimo semestre\Bases de Datos\DBProject1-master\src\dbproject1\sql.g4 by ANTLR 4.4
package Visitor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, K_CREATE=14, K_DATABASE=15, K_DATABASES=16, 
		K_DROP=17, K_USE=18, K_SHOW=19, K_ALTER=20, K_RENAME=21, K_TO=22, K_TABLE=23, 
		K_TABLES=24, K_CONSTRAINT=25, K_COLUMN=26, K_COLUMNS=27, K_FROM=28, K_ADD=29, 
		K_SELECT=30, K_WHERE=31, K_INT=32, K_DATE=33, K_CHAR=34, K_FLOAT=35, K_PRIMARY=36, 
		K_CHECK=37, K_REFERENCES=38, K_FOREIGN=39, K_KEY=40, K_INSERT=41, K_INTO=42, 
		K_VALUES=43, K_ORDER=44, K_SET=45, K_UPDATE=46, K_BY=47, K_ASC=48, K_DESC=49, 
		K_AND=50, K_OR=51, K_NOT=52, K_NULL=53, K_DELETE=54, SPACES=55, SINGLE_LINE_COMMENT=56, 
		MULTILINE_COMMENT=57, ID=58, NUM=59, UNUM=60, DATE=61, CHAR=62;
	public static final String[] tokenNames = {
		"<INVALID>", "'>='", "';'", "'<'", "'='", "'>'", "'<='", "'<>'", "'('", 
		"')'", "'*'", "','", "'-'", "'.'", "K_CREATE", "K_DATABASE", "K_DATABASES", 
		"K_DROP", "K_USE", "K_SHOW", "K_ALTER", "K_RENAME", "K_TO", "K_TABLE", 
		"K_TABLES", "K_CONSTRAINT", "K_COLUMN", "K_COLUMNS", "K_FROM", "K_ADD", 
		"K_SELECT", "K_WHERE", "K_INT", "K_DATE", "K_CHAR", "K_FLOAT", "K_PRIMARY", 
		"K_CHECK", "K_REFERENCES", "K_FOREIGN", "K_KEY", "K_INSERT", "K_INTO", 
		"K_VALUES", "K_ORDER", "K_SET", "K_UPDATE", "K_BY", "K_ASC", "K_DESC", 
		"K_AND", "K_OR", "K_NOT", "K_NULL", "K_DELETE", "SPACES", "SINGLE_LINE_COMMENT", 
		"MULTILINE_COMMENT", "ID", "NUM", "UNUM", "DATE", "CHAR"
	};
	public static final int
		RULE_todo = 0, RULE_casitodo = 1, RULE_database = 2, RULE_data = 3, RULE_table = 4, 
		RULE_atributo = 5, RULE_constraints = 6, RULE_tableAction = 7, RULE_tipo = 8, 
		RULE_constraint = 9, RULE_conjuntoId = 10, RULE_references = 11, RULE_exp = 12, 
		RULE_expr = 13, RULE_exp2 = 14, RULE_exp3 = 15, RULE_exp4 = 16, RULE_unifactor = 17, 
		RULE_factor = 18, RULE_literal = 19, RULE_logicExp = 20, RULE_logicExpNot = 21, 
		RULE_logicExpOr = 22, RULE_logicExpAnd = 23, RULE_relationalExpEq = 24, 
		RULE_relationalExpGL = 25, RULE_relationalExp = 26, RULE_insert = 27, 
		RULE_formatValue = 28, RULE_nullType = 29, RULE_entero = 30, RULE_decimal = 31, 
		RULE_fecha = 32, RULE_character = 33, RULE_update = 34, RULE_asignacion = 35, 
		RULE_condicion = 36, RULE_delete = 37, RULE_query = 38, RULE_column = 39, 
		RULE_orderby = 40, RULE_expresion = 41;
	public static final String[] ruleNames = {
		"todo", "casitodo", "database", "data", "table", "atributo", "constraints", 
		"tableAction", "tipo", "constraint", "conjuntoId", "references", "exp", 
		"expr", "exp2", "exp3", "exp4", "unifactor", "factor", "literal", "logicExp", 
		"logicExpNot", "logicExpOr", "logicExpAnd", "relationalExpEq", "relationalExpGL", 
		"relationalExp", "insert", "formatValue", "nullType", "entero", "decimal", 
		"fecha", "character", "update", "asignacion", "condicion", "delete", "query", 
		"column", "orderby", "expresion"
	};

	@Override
	public String getGrammarFileName() { return "sql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public sqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TodoContext extends ParserRuleContext {
		public CasitodoContext casitodo(int i) {
			return getRuleContext(CasitodoContext.class,i);
		}
		public List<CasitodoContext> casitodo() {
			return getRuleContexts(CasitodoContext.class);
		}
		public TodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_todo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TodoContext todo() throws RecognitionException {
		TodoContext _localctx = new TodoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_todo);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(84); casitodo();
			}
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(85); match(T__11);
					setState(86); casitodo();
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(93);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(92); match(T__11);
				}
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

	public static class CasitodoContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public DatabaseContext database() {
			return getRuleContext(DatabaseContext.class,0);
		}
		public CasitodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_casitodo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCasitodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCasitodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCasitodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CasitodoContext casitodo() throws RecognitionException {
		CasitodoContext _localctx = new CasitodoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_casitodo);
		try {
			setState(98);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95); database();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96); table();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97); data();
				}
				break;
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

	public static class DatabaseContext extends ParserRuleContext {
		public DatabaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database; }
	 
		public DatabaseContext() { }
		public void copyFrom(DatabaseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ShowDBContext extends DatabaseContext {
		public TerminalNode K_DATABASES() { return getToken(sqlParser.K_DATABASES, 0); }
		public TerminalNode K_SHOW() { return getToken(sqlParser.K_SHOW, 0); }
		public ShowDBContext(DatabaseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShowDB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShowDB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShowDB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropDBContext extends DatabaseContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_DATABASE() { return getToken(sqlParser.K_DATABASE, 0); }
		public TerminalNode K_DROP() { return getToken(sqlParser.K_DROP, 0); }
		public DropDBContext(DatabaseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDropDB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDropDB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDropDB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UseDBContext extends DatabaseContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_DATABASE() { return getToken(sqlParser.K_DATABASE, 0); }
		public TerminalNode K_USE() { return getToken(sqlParser.K_USE, 0); }
		public UseDBContext(DatabaseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUseDB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUseDB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUseDB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateDBContext extends DatabaseContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_DATABASE() { return getToken(sqlParser.K_DATABASE, 0); }
		public TerminalNode K_CREATE() { return getToken(sqlParser.K_CREATE, 0); }
		public CreateDBContext(DatabaseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCreateDB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCreateDB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCreateDB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlterDBContext extends DatabaseContext {
		public TerminalNode K_RENAME() { return getToken(sqlParser.K_RENAME, 0); }
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode K_DATABASE() { return getToken(sqlParser.K_DATABASE, 0); }
		public TerminalNode K_ALTER() { return getToken(sqlParser.K_ALTER, 0); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public TerminalNode K_TO() { return getToken(sqlParser.K_TO, 0); }
		public AlterDBContext(DatabaseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlterDB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlterDB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlterDB(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatabaseContext database() throws RecognitionException {
		DatabaseContext _localctx = new DatabaseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_database);
		try {
			setState(117);
			switch (_input.LA(1)) {
			case K_CREATE:
				_localctx = new CreateDBContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100); match(K_CREATE);
				setState(101); match(K_DATABASE);
				setState(102); match(ID);
				}
				break;
			case K_DROP:
				_localctx = new DropDBContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103); match(K_DROP);
				setState(104); match(K_DATABASE);
				setState(105); match(ID);
				}
				break;
			case K_USE:
				_localctx = new UseDBContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(106); match(K_USE);
				setState(107); match(K_DATABASE);
				setState(108); match(ID);
				}
				break;
			case K_SHOW:
				_localctx = new ShowDBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(109); match(K_SHOW);
				setState(110); match(K_DATABASES);
				}
				break;
			case K_ALTER:
				_localctx = new AlterDBContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(111); match(K_ALTER);
				setState(112); match(K_DATABASE);
				setState(113); match(ID);
				setState(114); match(K_RENAME);
				setState(115); match(K_TO);
				setState(116); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DataContext extends ParserRuleContext {
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public UpdateContext update() {
			return getRuleContext(UpdateContext.class,0);
		}
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_data);
		try {
			setState(123);
			switch (_input.LA(1)) {
			case K_INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); insert();
				}
				break;
			case K_UPDATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); update();
				}
				break;
			case K_DELETE:
				enterOuterAlt(_localctx, 3);
				{
				setState(121); delete();
				}
				break;
			case K_SELECT:
				enterOuterAlt(_localctx, 4);
				{
				setState(122); query();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TableContext extends ParserRuleContext {
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
	 
		public TableContext() { }
		public void copyFrom(TableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ShowTBContext extends TableContext {
		public TerminalNode K_TABLES() { return getToken(sqlParser.K_TABLES, 0); }
		public TerminalNode K_SHOW() { return getToken(sqlParser.K_SHOW, 0); }
		public ShowTBContext(TableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShowTB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShowTB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShowTB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropTBContext extends TableContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_TABLE() { return getToken(sqlParser.K_TABLE, 0); }
		public TerminalNode K_DROP() { return getToken(sqlParser.K_DROP, 0); }
		public DropTBContext(TableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDropTB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDropTB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDropTB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameTBContext extends TableContext {
		public TerminalNode K_RENAME() { return getToken(sqlParser.K_RENAME, 0); }
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode K_ALTER() { return getToken(sqlParser.K_ALTER, 0); }
		public TerminalNode K_TABLE() { return getToken(sqlParser.K_TABLE, 0); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public TerminalNode K_TO() { return getToken(sqlParser.K_TO, 0); }
		public RenameTBContext(TableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRenameTB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRenameTB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRenameTB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateTBContext extends TableContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_CREATE() { return getToken(sqlParser.K_CREATE, 0); }
		public TerminalNode K_TABLE() { return getToken(sqlParser.K_TABLE, 0); }
		public AtributoContext atributo(int i) {
			return getRuleContext(AtributoContext.class,i);
		}
		public List<AtributoContext> atributo() {
			return getRuleContexts(AtributoContext.class);
		}
		public ConstraintsContext constraints() {
			return getRuleContext(ConstraintsContext.class,0);
		}
		public CreateTBContext(TableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCreateTB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCreateTB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCreateTB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlterTBContext extends TableContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_ALTER() { return getToken(sqlParser.K_ALTER, 0); }
		public TerminalNode K_TABLE() { return getToken(sqlParser.K_TABLE, 0); }
		public List<TableActionContext> tableAction() {
			return getRuleContexts(TableActionContext.class);
		}
		public TableActionContext tableAction(int i) {
			return getRuleContext(TableActionContext.class,i);
		}
		public AlterTBContext(TableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlterTB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlterTB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlterTB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowColumsContext extends TableContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_FROM() { return getToken(sqlParser.K_FROM, 0); }
		public TerminalNode K_SHOW() { return getToken(sqlParser.K_SHOW, 0); }
		public TerminalNode K_COLUMNS() { return getToken(sqlParser.K_COLUMNS, 0); }
		public ShowColumsContext(TableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShowColums(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShowColums(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShowColums(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_table);
		int _la;
		try {
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new CreateTBContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(125); match(K_CREATE);
				setState(126); match(K_TABLE);
				setState(127); match(ID);
				setState(128); match(T__5);
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(129); atributo();
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(130); match(T__2);
						setState(131); atributo();
						}
						}
						setState(136);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(139); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				{
				setState(141); constraints();
				}
				setState(142); match(T__4);
				}
				break;
			case 2:
				_localctx = new AlterTBContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144); match(K_ALTER);
				setState(145); match(K_TABLE);
				setState(146); match(ID);
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(147); tableAction();
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(148); match(T__2);
						setState(149); tableAction();
						}
						}
						setState(154);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(157); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_DROP || _la==K_ADD );
				}
				break;
			case 3:
				_localctx = new RenameTBContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159); match(K_ALTER);
				setState(160); match(K_TABLE);
				setState(161); match(ID);
				setState(162); match(K_RENAME);
				setState(163); match(K_TO);
				setState(164); match(ID);
				}
				break;
			case 4:
				_localctx = new DropTBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(165); match(K_DROP);
				setState(166); match(K_TABLE);
				setState(167); match(ID);
				}
				break;
			case 5:
				_localctx = new ShowTBContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(168); match(K_SHOW);
				setState(169); match(K_TABLES);
				}
				break;
			case 6:
				_localctx = new ShowColumsContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(170); match(K_SHOW);
				setState(171); match(K_COLUMNS);
				setState(172); match(K_FROM);
				setState(173); match(ID);
				}
				break;
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

	public static class AtributoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public AtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAtributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributoContext atributo() throws RecognitionException {
		AtributoContext _localctx = new AtributoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atributo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(ID);
			setState(177); tipo();
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

	public static class ConstraintsContext extends ParserRuleContext {
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public List<TerminalNode> K_CONSTRAINT() { return getTokens(sqlParser.K_CONSTRAINT); }
		public TerminalNode K_CONSTRAINT(int i) {
			return getToken(sqlParser.K_CONSTRAINT, i);
		}
		public ConstraintContext constraint(int i) {
			return getRuleContext(ConstraintContext.class,i);
		}
		public ConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraints(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintsContext constraints() throws RecognitionException {
		ConstraintsContext _localctx = new ConstraintsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constraints);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_CONSTRAINT) {
				{
				{
				setState(179); match(K_CONSTRAINT);
				setState(180); constraint();
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(181); match(T__2);
						setState(182); match(K_CONSTRAINT);
						setState(183); constraint();
						}
						} 
					}
					setState(188);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				}
				setState(193);
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

	public static class TableActionContext extends ParserRuleContext {
		public TableActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAction; }
	 
		public TableActionContext() { }
		public void copyFrom(TableActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddColumnTBContext extends TableActionContext {
		public TerminalNode K_COLUMN() { return getToken(sqlParser.K_COLUMN, 0); }
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public ConstraintsContext constraints() {
			return getRuleContext(ConstraintsContext.class,0);
		}
		public TerminalNode K_ADD() { return getToken(sqlParser.K_ADD, 0); }
		public AddColumnTBContext(TableActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAddColumnTB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAddColumnTB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAddColumnTB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddConstraintTBContext extends TableActionContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode K_CONSTRAINT() { return getToken(sqlParser.K_CONSTRAINT, 0); }
		public TerminalNode K_ADD() { return getToken(sqlParser.K_ADD, 0); }
		public AddConstraintTBContext(TableActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAddConstraintTB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAddConstraintTB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAddConstraintTB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropColumnTBContext extends TableActionContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_COLUMN() { return getToken(sqlParser.K_COLUMN, 0); }
		public TerminalNode K_DROP() { return getToken(sqlParser.K_DROP, 0); }
		public DropColumnTBContext(TableActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDropColumnTB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDropColumnTB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDropColumnTB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropConstraintTBContext extends TableActionContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_DROP() { return getToken(sqlParser.K_DROP, 0); }
		public TerminalNode K_CONSTRAINT() { return getToken(sqlParser.K_CONSTRAINT, 0); }
		public DropConstraintTBContext(TableActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDropConstraintTB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDropConstraintTB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDropConstraintTB(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableActionContext tableAction() throws RecognitionException {
		TableActionContext _localctx = new TableActionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tableAction);
		try {
			setState(208);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new AddColumnTBContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(194); match(K_ADD);
				setState(195); match(K_COLUMN);
				setState(196); atributo();
				{
				setState(197); constraints();
				}
				}
				break;
			case 2:
				_localctx = new AddConstraintTBContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(199); match(K_ADD);
				setState(200); match(K_CONSTRAINT);
				setState(201); constraint();
				}
				break;
			case 3:
				_localctx = new DropColumnTBContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(202); match(K_DROP);
				setState(203); match(K_COLUMN);
				setState(204); match(ID);
				}
				break;
			case 4:
				_localctx = new DropConstraintTBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(205); match(K_DROP);
				setState(206); match(K_CONSTRAINT);
				setState(207); match(ID);
				}
				break;
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

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode K_INT() { return getToken(sqlParser.K_INT, 0); }
		public TerminalNode NUM() { return getToken(sqlParser.NUM, 0); }
		public TerminalNode K_FLOAT() { return getToken(sqlParser.K_FLOAT, 0); }
		public TerminalNode K_DATE() { return getToken(sqlParser.K_DATE, 0); }
		public TerminalNode K_CHAR() { return getToken(sqlParser.K_CHAR, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tipo);
		try {
			setState(217);
			switch (_input.LA(1)) {
			case K_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(210); match(K_INT);
				}
				break;
			case K_FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(211); match(K_FLOAT);
				}
				break;
			case K_DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(212); match(K_DATE);
				}
				break;
			case K_CHAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(213); match(K_CHAR);
				setState(214); match(T__5);
				setState(215); match(NUM);
				setState(216); match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConstraintContext extends ParserRuleContext {
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
	 
		public ConstraintContext() { }
		public void copyFrom(ConstraintContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CCheckContext extends ConstraintContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_CHECK() { return getToken(sqlParser.K_CHECK, 0); }
		public CCheckContext(ConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCCheck(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CFKContext extends ConstraintContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_FOREIGN() { return getToken(sqlParser.K_FOREIGN, 0); }
		public ConjuntoIdContext conjuntoId() {
			return getRuleContext(ConjuntoIdContext.class,0);
		}
		public ReferencesContext references() {
			return getRuleContext(ReferencesContext.class,0);
		}
		public TerminalNode K_KEY() { return getToken(sqlParser.K_KEY, 0); }
		public CFKContext(ConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCFK(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCFK(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCFK(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CPKContext extends ConstraintContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public ConjuntoIdContext conjuntoId() {
			return getRuleContext(ConjuntoIdContext.class,0);
		}
		public TerminalNode K_KEY() { return getToken(sqlParser.K_KEY, 0); }
		public TerminalNode K_PRIMARY() { return getToken(sqlParser.K_PRIMARY, 0); }
		public CPKContext(ConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCPK(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCPK(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCPK(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constraint);
		try {
			setState(237);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new CPKContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(219); match(ID);
				setState(220); match(K_PRIMARY);
				setState(221); match(K_KEY);
				setState(222); match(T__5);
				setState(223); conjuntoId();
				setState(224); match(T__4);
				}
				break;
			case 2:
				_localctx = new CFKContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(226); match(ID);
				setState(227); match(K_FOREIGN);
				setState(228); match(K_KEY);
				setState(229); match(T__5);
				setState(230); conjuntoId();
				setState(231); match(T__4);
				setState(232); references();
				}
				break;
			case 3:
				_localctx = new CCheckContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(234); match(ID);
				setState(235); match(K_CHECK);
				{
				setState(236); exp();
				}
				}
				break;
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

	public static class ConjuntoIdContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public ConjuntoIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjuntoId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConjuntoId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConjuntoId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConjuntoId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjuntoIdContext conjuntoId() throws RecognitionException {
		ConjuntoIdContext _localctx = new ConjuntoIdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_conjuntoId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(239); match(ID);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(240); match(T__2);
				setState(241); match(ID);
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ReferencesContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_REFERENCES() { return getToken(sqlParser.K_REFERENCES, 0); }
		public ConjuntoIdContext conjuntoId() {
			return getRuleContext(ConjuntoIdContext.class,0);
		}
		public ReferencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_references; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterReferences(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitReferences(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitReferences(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferencesContext references() throws RecognitionException {
		ReferencesContext _localctx = new ReferencesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_references);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247); match(K_REFERENCES);
			setState(248); match(ID);
			setState(249); match(T__5);
			setState(250); conjuntoId();
			setState(251); match(T__4);
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

	public static class ExpContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpAndContext extends ExprContext {
		public Exp2Context exp2() {
			return getRuleContext(Exp2Context.class,0);
		}
		public LogicExpAndContext logicExpAnd() {
			return getRuleContext(LogicExpAndContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpNotAndContext extends ExprContext {
		public Exp2Context exp2() {
			return getRuleContext(Exp2Context.class,0);
		}
		public ExpNotAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpNotAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpNotAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpNotAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExpNotAndContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(256); exp2(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpAndContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(258);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(259); logicExpAnd();
					setState(260); exp2(0);
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp2Context extends ParserRuleContext {
		public Exp2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp2; }
	 
		public Exp2Context() { }
		public void copyFrom(Exp2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpOrContext extends Exp2Context {
		public Exp2Context exp2() {
			return getRuleContext(Exp2Context.class,0);
		}
		public Exp3Context exp3() {
			return getRuleContext(Exp3Context.class,0);
		}
		public LogicExpOrContext logicExpOr() {
			return getRuleContext(LogicExpOrContext.class,0);
		}
		public ExpOrContext(Exp2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpNotOrContext extends Exp2Context {
		public Exp3Context exp3() {
			return getRuleContext(Exp3Context.class,0);
		}
		public ExpNotOrContext(Exp2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpNotOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpNotOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpNotOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp2Context exp2() throws RecognitionException {
		return exp2(0);
	}

	private Exp2Context exp2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp2Context _localctx = new Exp2Context(_ctx, _parentState);
		Exp2Context _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_exp2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExpNotOrContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(268); exp3(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpOrContext(new Exp2Context(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exp2);
					setState(270);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(271); logicExpOr();
					setState(272); exp3(0);
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp3Context extends ParserRuleContext {
		public Exp3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp3; }
	 
		public Exp3Context() { }
		public void copyFrom(Exp3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpNotEqContext extends Exp3Context {
		public Exp4Context exp4() {
			return getRuleContext(Exp4Context.class,0);
		}
		public ExpNotEqContext(Exp3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpNotEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpNotEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpNotEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpEqContext extends Exp3Context {
		public Exp4Context exp4() {
			return getRuleContext(Exp4Context.class,0);
		}
		public RelationalExpEqContext relationalExpEq() {
			return getRuleContext(RelationalExpEqContext.class,0);
		}
		public Exp3Context exp3() {
			return getRuleContext(Exp3Context.class,0);
		}
		public ExpEqContext(Exp3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpEq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp3Context exp3() throws RecognitionException {
		return exp3(0);
	}

	private Exp3Context exp3(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp3Context _localctx = new Exp3Context(_ctx, _parentState);
		Exp3Context _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_exp3, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExpNotEqContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(280); exp4(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpEqContext(new Exp3Context(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exp3);
					setState(282);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(283); relationalExpEq();
					setState(284); exp4(0);
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp4Context extends ParserRuleContext {
		public Exp4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp4; }
	 
		public Exp4Context() { }
		public void copyFrom(Exp4Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpGLContext extends Exp4Context {
		public Exp4Context exp4() {
			return getRuleContext(Exp4Context.class,0);
		}
		public UnifactorContext unifactor() {
			return getRuleContext(UnifactorContext.class,0);
		}
		public RelationalExpGLContext relationalExpGL() {
			return getRuleContext(RelationalExpGLContext.class,0);
		}
		public ExpGLContext(Exp4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpGL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpGL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpGL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpNotGlContext extends Exp4Context {
		public UnifactorContext unifactor() {
			return getRuleContext(UnifactorContext.class,0);
		}
		public ExpNotGlContext(Exp4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpNotGl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpNotGl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpNotGl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp4Context exp4() throws RecognitionException {
		return exp4(0);
	}

	private Exp4Context exp4(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp4Context _localctx = new Exp4Context(_ctx, _parentState);
		Exp4Context _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_exp4, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExpNotGlContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(292); unifactor();
			}
			_ctx.stop = _input.LT(-1);
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpGLContext(new Exp4Context(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exp4);
					setState(294);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(295); relationalExpGL();
					setState(296); unifactor();
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnifactorContext extends ParserRuleContext {
		public UnifactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unifactor; }
	 
		public UnifactorContext() { }
		public void copyFrom(UnifactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpFactorContext extends UnifactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public ExpFactorContext(UnifactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpNotFactorContext extends UnifactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode K_NOT() { return getToken(sqlParser.K_NOT, 0); }
		public ExpNotFactorContext(UnifactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpNotFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpNotFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpNotFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnifactorContext unifactor() throws RecognitionException {
		UnifactorContext _localctx = new UnifactorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unifactor);
		try {
			setState(306);
			switch (_input.LA(1)) {
			case K_NOT:
				_localctx = new ExpNotFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(303); match(K_NOT);
				setState(304); factor();
				}
				break;
			case T__5:
			case T__1:
			case K_NULL:
			case ID:
			case NUM:
			case DATE:
			case CHAR:
				_localctx = new ExpFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(305); factor();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpParenthesesContext extends FactorContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpParenthesesContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpLiteralContext extends FactorContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExpLiteralContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIDContext extends FactorContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public ExpIDContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_factor);
		try {
			setState(318);
			switch (_input.LA(1)) {
			case T__1:
			case K_NULL:
			case NUM:
			case DATE:
			case CHAR:
				_localctx = new ExpLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(308); literal();
				}
				break;
			case T__5:
				_localctx = new ExpParenthesesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(309); match(T__5);
				setState(310); exp();
				setState(311); match(T__4);
				}
				break;
			case ID:
				_localctx = new ExpIDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(313); match(ID);
				setState(316);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(314); match(T__0);
					setState(315); match(ID);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LiteralContext extends ParserRuleContext {
		public FormatValueContext formatValue() {
			return getRuleContext(FormatValueContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320); formatValue();
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

	public static class LogicExpContext extends ParserRuleContext {
		public LogicExpAndContext logicExpAnd() {
			return getRuleContext(LogicExpAndContext.class,0);
		}
		public LogicExpNotContext logicExpNot() {
			return getRuleContext(LogicExpNotContext.class,0);
		}
		public LogicExpOrContext logicExpOr() {
			return getRuleContext(LogicExpOrContext.class,0);
		}
		public LogicExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLogicExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLogicExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLogicExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExpContext logicExp() throws RecognitionException {
		LogicExpContext _localctx = new LogicExpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_logicExp);
		try {
			setState(325);
			switch (_input.LA(1)) {
			case K_AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(322); logicExpAnd();
				}
				break;
			case K_OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(323); logicExpOr();
				}
				break;
			case K_NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(324); logicExpNot();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LogicExpNotContext extends ParserRuleContext {
		public TerminalNode K_NOT() { return getToken(sqlParser.K_NOT, 0); }
		public LogicExpNotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpNot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLogicExpNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLogicExpNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLogicExpNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExpNotContext logicExpNot() throws RecognitionException {
		LogicExpNotContext _localctx = new LogicExpNotContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_logicExpNot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327); match(K_NOT);
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

	public static class LogicExpOrContext extends ParserRuleContext {
		public TerminalNode K_OR() { return getToken(sqlParser.K_OR, 0); }
		public LogicExpOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLogicExpOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLogicExpOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLogicExpOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExpOrContext logicExpOr() throws RecognitionException {
		LogicExpOrContext _localctx = new LogicExpOrContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_logicExpOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329); match(K_OR);
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

	public static class LogicExpAndContext extends ParserRuleContext {
		public TerminalNode K_AND() { return getToken(sqlParser.K_AND, 0); }
		public LogicExpAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLogicExpAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLogicExpAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLogicExpAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExpAndContext logicExpAnd() throws RecognitionException {
		LogicExpAndContext _localctx = new LogicExpAndContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logicExpAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331); match(K_AND);
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

	public static class RelationalExpEqContext extends ParserRuleContext {
		public RelationalExpEqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpEq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRelationalExpEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRelationalExpEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRelationalExpEq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpEqContext relationalExpEq() throws RecognitionException {
		RelationalExpEqContext _localctx = new RelationalExpEqContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_relationalExpEq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__6) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class RelationalExpGLContext extends ParserRuleContext {
		public RelationalExpGLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpGL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRelationalExpGL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRelationalExpGL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRelationalExpGL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpGLContext relationalExpGL() throws RecognitionException {
		RelationalExpGLContext _localctx = new RelationalExpGLContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_relationalExpGL);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__10) | (1L << T__8) | (1L << T__7))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class RelationalExpContext extends ParserRuleContext {
		public RelationalExpEqContext relationalExpEq() {
			return getRuleContext(RelationalExpEqContext.class,0);
		}
		public RelationalExpGLContext relationalExpGL() {
			return getRuleContext(RelationalExpGLContext.class,0);
		}
		public RelationalExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRelationalExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRelationalExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRelationalExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpContext relationalExp() throws RecognitionException {
		RelationalExpContext _localctx = new RelationalExpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_relationalExp);
		try {
			setState(339);
			switch (_input.LA(1)) {
			case T__12:
			case T__10:
			case T__8:
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(337); relationalExpGL();
				}
				break;
			case T__9:
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(338); relationalExpEq();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class InsertContext extends ParserRuleContext {
		public TerminalNode K_INTO() { return getToken(sqlParser.K_INTO, 0); }
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public List<FormatValueContext> formatValue() {
			return getRuleContexts(FormatValueContext.class);
		}
		public TerminalNode K_VALUES() { return getToken(sqlParser.K_VALUES, 0); }
		public TerminalNode K_INSERT() { return getToken(sqlParser.K_INSERT, 0); }
		public FormatValueContext formatValue(int i) {
			return getRuleContext(FormatValueContext.class,i);
		}
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public InsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitInsert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitInsert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertContext insert() throws RecognitionException {
		InsertContext _localctx = new InsertContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_insert);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341); match(K_INSERT);
			setState(342); match(K_INTO);
			setState(343); match(ID);
			setState(359);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(344); match(T__5);
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(345); match(ID);
					setState(350);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(346); match(T__2);
						setState(347); match(ID);
						}
						}
						setState(352);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(357);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(358); match(T__4);
				}
			}

			setState(361); match(K_VALUES);
			setState(362); match(T__5);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << K_NULL) | (1L << NUM) | (1L << DATE) | (1L << CHAR))) != 0)) {
				{
				{
				setState(363); formatValue();
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(364); match(T__2);
					setState(365); formatValue();
					}
					}
					setState(370);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(376); match(T__4);
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

	public static class FormatValueContext extends ParserRuleContext {
		public FechaContext fecha() {
			return getRuleContext(FechaContext.class,0);
		}
		public NullTypeContext nullType() {
			return getRuleContext(NullTypeContext.class,0);
		}
		public DecimalContext decimal() {
			return getRuleContext(DecimalContext.class,0);
		}
		public EnteroContext entero() {
			return getRuleContext(EnteroContext.class,0);
		}
		public CharacterContext character() {
			return getRuleContext(CharacterContext.class,0);
		}
		public FormatValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formatValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFormatValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFormatValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFormatValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormatValueContext formatValue() throws RecognitionException {
		FormatValueContext _localctx = new FormatValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_formatValue);
		try {
			setState(383);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(378); entero();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(379); decimal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(380); fecha();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(381); character();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(382); nullType();
				}
				break;
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

	public static class NullTypeContext extends ParserRuleContext {
		public TerminalNode K_NULL() { return getToken(sqlParser.K_NULL, 0); }
		public NullTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterNullType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitNullType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitNullType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullTypeContext nullType() throws RecognitionException {
		NullTypeContext _localctx = new NullTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_nullType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385); match(K_NULL);
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

	public static class EnteroContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(sqlParser.NUM, 0); }
		public EnteroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entero; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterEntero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitEntero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitEntero(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnteroContext entero() throws RecognitionException {
		EnteroContext _localctx = new EnteroContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_entero);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(387); match(T__1);
				}
			}

			setState(390); match(NUM);
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

	public static class DecimalContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(sqlParser.NUM, 0); }
		public EnteroContext entero() {
			return getRuleContext(EnteroContext.class,0);
		}
		public DecimalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalContext decimal() throws RecognitionException {
		DecimalContext _localctx = new DecimalContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_decimal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392); entero();
			setState(393); match(T__0);
			setState(394); match(NUM);
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

	public static class FechaContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(sqlParser.DATE, 0); }
		public FechaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fecha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFecha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFecha(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFecha(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FechaContext fecha() throws RecognitionException {
		FechaContext _localctx = new FechaContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_fecha);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396); match(DATE);
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

	public static class CharacterContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(sqlParser.CHAR, 0); }
		public CharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCharacter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCharacter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCharacter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharacterContext character() throws RecognitionException {
		CharacterContext _localctx = new CharacterContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_character);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398); match(CHAR);
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

	public static class UpdateContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_WHERE() { return getToken(sqlParser.K_WHERE, 0); }
		public TerminalNode K_UPDATE() { return getToken(sqlParser.K_UPDATE, 0); }
		public TerminalNode K_SET() { return getToken(sqlParser.K_SET, 0); }
		public List<AsignacionContext> asignacion() {
			return getRuleContexts(AsignacionContext.class);
		}
		public AsignacionContext asignacion(int i) {
			return getRuleContext(AsignacionContext.class,i);
		}
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_update);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400); match(K_UPDATE);
			setState(401); match(ID);
			setState(402); match(K_SET);
			setState(403); asignacion();
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(404); match(T__2);
				setState(405); asignacion();
				}
				}
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(413);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(411); match(K_WHERE);
				setState(412); exp();
				}
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

	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415); match(ID);
			setState(416); match(T__9);
			setState(417); literal();
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

	public static class CondicionContext extends ParserRuleContext {
		public RelationalExpContext relationalExp() {
			return getRuleContext(RelationalExpContext.class,0);
		}
		public FormatValueContext formatValue() {
			return getRuleContext(FormatValueContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public LogicExpContext logicExp() {
			return getRuleContext(LogicExpContext.class,0);
		}
		public CondicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCondicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCondicion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCondicion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionContext condicion() throws RecognitionException {
		CondicionContext _localctx = new CondicionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_condicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(419); expresion();
			setState(420); relationalExp();
			setState(423);
			switch (_input.LA(1)) {
			case T__1:
			case K_NULL:
			case NUM:
			case DATE:
			case CHAR:
				{
				setState(421); formatValue();
				}
				break;
			case ID:
				{
				setState(422); expresion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			setState(428);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(425); logicExp();
				setState(426); condicion();
				}
				break;
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

	public static class DeleteContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode K_WHERE() { return getToken(sqlParser.K_WHERE, 0); }
		public TerminalNode K_FROM() { return getToken(sqlParser.K_FROM, 0); }
		public TerminalNode K_DELETE() { return getToken(sqlParser.K_DELETE, 0); }
		public DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDelete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDelete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteContext delete() throws RecognitionException {
		DeleteContext _localctx = new DeleteContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_delete);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430); match(K_DELETE);
			setState(431); match(K_FROM);
			setState(432); match(ID);
			setState(435);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(433); match(K_WHERE);
				setState(434); exp();
				}
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

	public static class QueryContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode K_ORDER() { return getToken(sqlParser.K_ORDER, 0); }
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public TerminalNode K_WHERE() { return getToken(sqlParser.K_WHERE, 0); }
		public TerminalNode K_SELECT() { return getToken(sqlParser.K_SELECT, 0); }
		public List<OrderbyContext> orderby() {
			return getRuleContexts(OrderbyContext.class);
		}
		public TerminalNode K_FROM() { return getToken(sqlParser.K_FROM, 0); }
		public TerminalNode K_BY() { return getToken(sqlParser.K_BY, 0); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public OrderbyContext orderby(int i) {
			return getRuleContext(OrderbyContext.class,i);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437); match(K_SELECT);
			setState(447);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(438); match(T__3);
				}
				break;
			case ID:
				{
				setState(439); column();
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(440); match(T__2);
					setState(441); column();
					}
					}
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(449); match(K_FROM);
			setState(450); match(ID);
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(451); match(T__2);
				setState(452); match(ID);
				}
				}
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(460);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(458); match(K_WHERE);
				setState(459); exp();
				}
			}

			setState(472);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(462); match(K_ORDER);
				setState(463); match(K_BY);
				setState(464); orderby();
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(465); match(T__2);
					setState(466); orderby();
					}
					}
					setState(471);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class ColumnContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); match(ID);
			setState(477);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(475); match(T__0);
				setState(476); match(ID);
				}
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

	public static class OrderbyContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode K_DESC() { return getToken(sqlParser.K_DESC, 0); }
		public TerminalNode K_ASC() { return getToken(sqlParser.K_ASC, 0); }
		public OrderbyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderby; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterOrderby(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitOrderby(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitOrderby(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderbyContext orderby() throws RecognitionException {
		OrderbyContext _localctx = new OrderbyContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_orderby);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479); expresion();
			setState(481);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(480);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
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

	public static class ExpresionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_expresion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483); match(ID);
			setState(486);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(484); match(T__0);
				setState(485); match(ID);
				}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13: return expr_sempred((ExprContext)_localctx, predIndex);
		case 14: return exp2_sempred((Exp2Context)_localctx, predIndex);
		case 15: return exp3_sempred((Exp3Context)_localctx, predIndex);
		case 16: return exp4_sempred((Exp4Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp4_sempred(Exp4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp3_sempred(Exp3Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp2_sempred(Exp2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u01eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\5\2`\n\2\3\3\3\3\3\3\5\3e\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"x\n\4\3\5\3\5\3\5\3\5\5\5~\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0087\n"+
		"\6\f\6\16\6\u008a\13\6\6\6\u008c\n\6\r\6\16\6\u008d\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\7\6\u0099\n\6\f\6\16\6\u009c\13\6\6\6\u009e\n\6\r\6"+
		"\16\6\u009f\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6\u00b1\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\u00bb\n\b\f\b\16"+
		"\b\u00be\13\b\7\b\u00c0\n\b\f\b\16\b\u00c3\13\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00d3\n\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u00dc\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00f0\n\13\3\f\3\f\3\f\7"+
		"\f\u00f5\n\f\f\f\16\f\u00f8\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0109\n\17\f\17\16\17\u010c\13\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0115\n\20\f\20\16\20\u0118\13"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0121\n\21\f\21\16\21\u0124"+
		"\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u012d\n\22\f\22\16\22\u0130"+
		"\13\22\3\23\3\23\3\23\5\23\u0135\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\5\24\u013f\n\24\5\24\u0141\n\24\3\25\3\25\3\26\3\26\3\26\5\26"+
		"\u0148\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\5\34\u0156\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u015f\n\35\f"+
		"\35\16\35\u0162\13\35\7\35\u0164\n\35\f\35\16\35\u0167\13\35\3\35\5\35"+
		"\u016a\n\35\3\35\3\35\3\35\3\35\3\35\7\35\u0171\n\35\f\35\16\35\u0174"+
		"\13\35\7\35\u0176\n\35\f\35\16\35\u0179\13\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\5\36\u0182\n\36\3\37\3\37\3 \5 \u0187\n \3 \3 \3!\3!\3!\3!"+
		"\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\7$\u0199\n$\f$\16$\u019c\13$\3$\3$\5"+
		"$\u01a0\n$\3%\3%\3%\3%\3&\3&\3&\3&\5&\u01aa\n&\3&\3&\3&\5&\u01af\n&\3"+
		"\'\3\'\3\'\3\'\3\'\5\'\u01b6\n\'\3(\3(\3(\3(\3(\7(\u01bd\n(\f(\16(\u01c0"+
		"\13(\5(\u01c2\n(\3(\3(\3(\3(\7(\u01c8\n(\f(\16(\u01cb\13(\3(\3(\5(\u01cf"+
		"\n(\3(\3(\3(\3(\3(\7(\u01d6\n(\f(\16(\u01d9\13(\5(\u01db\n(\3)\3)\3)\5"+
		")\u01e0\n)\3*\3*\5*\u01e4\n*\3+\3+\3+\5+\u01e9\n+\3+\2\6\34\36 \",\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RT\2\5\4\2\6\6\t\t\5\2\3\3\5\5\7\b\3\2\62\63\u0202\2V\3\2\2\2\4d\3\2\2"+
		"\2\6w\3\2\2\2\b}\3\2\2\2\n\u00b0\3\2\2\2\f\u00b2\3\2\2\2\16\u00c1\3\2"+
		"\2\2\20\u00d2\3\2\2\2\22\u00db\3\2\2\2\24\u00ef\3\2\2\2\26\u00f1\3\2\2"+
		"\2\30\u00f9\3\2\2\2\32\u00ff\3\2\2\2\34\u0101\3\2\2\2\36\u010d\3\2\2\2"+
		" \u0119\3\2\2\2\"\u0125\3\2\2\2$\u0134\3\2\2\2&\u0140\3\2\2\2(\u0142\3"+
		"\2\2\2*\u0147\3\2\2\2,\u0149\3\2\2\2.\u014b\3\2\2\2\60\u014d\3\2\2\2\62"+
		"\u014f\3\2\2\2\64\u0151\3\2\2\2\66\u0155\3\2\2\28\u0157\3\2\2\2:\u0181"+
		"\3\2\2\2<\u0183\3\2\2\2>\u0186\3\2\2\2@\u018a\3\2\2\2B\u018e\3\2\2\2D"+
		"\u0190\3\2\2\2F\u0192\3\2\2\2H\u01a1\3\2\2\2J\u01a5\3\2\2\2L\u01b0\3\2"+
		"\2\2N\u01b7\3\2\2\2P\u01dc\3\2\2\2R\u01e1\3\2\2\2T\u01e5\3\2\2\2V[\5\4"+
		"\3\2WX\7\4\2\2XZ\5\4\3\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\_\3"+
		"\2\2\2][\3\2\2\2^`\7\4\2\2_^\3\2\2\2_`\3\2\2\2`\3\3\2\2\2ae\5\6\4\2be"+
		"\5\n\6\2ce\5\b\5\2da\3\2\2\2db\3\2\2\2dc\3\2\2\2e\5\3\2\2\2fg\7\20\2\2"+
		"gh\7\21\2\2hx\7<\2\2ij\7\23\2\2jk\7\21\2\2kx\7<\2\2lm\7\24\2\2mn\7\21"+
		"\2\2nx\7<\2\2op\7\25\2\2px\7\22\2\2qr\7\26\2\2rs\7\21\2\2st\7<\2\2tu\7"+
		"\27\2\2uv\7\30\2\2vx\7<\2\2wf\3\2\2\2wi\3\2\2\2wl\3\2\2\2wo\3\2\2\2wq"+
		"\3\2\2\2x\7\3\2\2\2y~\58\35\2z~\5F$\2{~\5L\'\2|~\5N(\2}y\3\2\2\2}z\3\2"+
		"\2\2}{\3\2\2\2}|\3\2\2\2~\t\3\2\2\2\177\u0080\7\20\2\2\u0080\u0081\7\31"+
		"\2\2\u0081\u0082\7<\2\2\u0082\u008b\7\n\2\2\u0083\u0088\5\f\7\2\u0084"+
		"\u0085\7\r\2\2\u0085\u0087\5\f\7\2\u0086\u0084\3\2\2\2\u0087\u008a\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\u0083\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\5\16\b\2\u0090"+
		"\u0091\7\13\2\2\u0091\u00b1\3\2\2\2\u0092\u0093\7\26\2\2\u0093\u0094\7"+
		"\31\2\2\u0094\u009d\7<\2\2\u0095\u009a\5\20\t\2\u0096\u0097\7\r\2\2\u0097"+
		"\u0099\5\20\t\2\u0098\u0096\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3"+
		"\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u0095\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00b1\3\2\2\2\u00a1\u00a2\7\26\2\2\u00a2\u00a3\7\31\2\2\u00a3"+
		"\u00a4\7<\2\2\u00a4\u00a5\7\27\2\2\u00a5\u00a6\7\30\2\2\u00a6\u00b1\7"+
		"<\2\2\u00a7\u00a8\7\23\2\2\u00a8\u00a9\7\31\2\2\u00a9\u00b1\7<\2\2\u00aa"+
		"\u00ab\7\25\2\2\u00ab\u00b1\7\32\2\2\u00ac\u00ad\7\25\2\2\u00ad\u00ae"+
		"\7\35\2\2\u00ae\u00af\7\36\2\2\u00af\u00b1\7<\2\2\u00b0\177\3\2\2\2\u00b0"+
		"\u0092\3\2\2\2\u00b0\u00a1\3\2\2\2\u00b0\u00a7\3\2\2\2\u00b0\u00aa\3\2"+
		"\2\2\u00b0\u00ac\3\2\2\2\u00b1\13\3\2\2\2\u00b2\u00b3\7<\2\2\u00b3\u00b4"+
		"\5\22\n\2\u00b4\r\3\2\2\2\u00b5\u00b6\7\33\2\2\u00b6\u00bc\5\24\13\2\u00b7"+
		"\u00b8\7\r\2\2\u00b8\u00b9\7\33\2\2\u00b9\u00bb\5\24\13\2\u00ba\u00b7"+
		"\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00b5\3\2\2\2\u00c0\u00c3\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\17\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\u00c5\7\37\2\2\u00c5\u00c6\7\34\2\2\u00c6\u00c7\5\f\7\2"+
		"\u00c7\u00c8\5\16\b\2\u00c8\u00d3\3\2\2\2\u00c9\u00ca\7\37\2\2\u00ca\u00cb"+
		"\7\33\2\2\u00cb\u00d3\5\24\13\2\u00cc\u00cd\7\23\2\2\u00cd\u00ce\7\34"+
		"\2\2\u00ce\u00d3\7<\2\2\u00cf\u00d0\7\23\2\2\u00d0\u00d1\7\33\2\2\u00d1"+
		"\u00d3\7<\2\2\u00d2\u00c4\3\2\2\2\u00d2\u00c9\3\2\2\2\u00d2\u00cc\3\2"+
		"\2\2\u00d2\u00cf\3\2\2\2\u00d3\21\3\2\2\2\u00d4\u00dc\7\"\2\2\u00d5\u00dc"+
		"\7%\2\2\u00d6\u00dc\7#\2\2\u00d7\u00d8\7$\2\2\u00d8\u00d9\7\n\2\2\u00d9"+
		"\u00da\7=\2\2\u00da\u00dc\7\13\2\2\u00db\u00d4\3\2\2\2\u00db\u00d5\3\2"+
		"\2\2\u00db\u00d6\3\2\2\2\u00db\u00d7\3\2\2\2\u00dc\23\3\2\2\2\u00dd\u00de"+
		"\7<\2\2\u00de\u00df\7&\2\2\u00df\u00e0\7*\2\2\u00e0\u00e1\7\n\2\2\u00e1"+
		"\u00e2\5\26\f\2\u00e2\u00e3\7\13\2\2\u00e3\u00f0\3\2\2\2\u00e4\u00e5\7"+
		"<\2\2\u00e5\u00e6\7)\2\2\u00e6\u00e7\7*\2\2\u00e7\u00e8\7\n\2\2\u00e8"+
		"\u00e9\5\26\f\2\u00e9\u00ea\7\13\2\2\u00ea\u00eb\5\30\r\2\u00eb\u00f0"+
		"\3\2\2\2\u00ec\u00ed\7<\2\2\u00ed\u00ee\7\'\2\2\u00ee\u00f0\5\32\16\2"+
		"\u00ef\u00dd\3\2\2\2\u00ef\u00e4\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0\25"+
		"\3\2\2\2\u00f1\u00f6\7<\2\2\u00f2\u00f3\7\r\2\2\u00f3\u00f5\7<\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\27\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\7(\2\2\u00fa\u00fb"+
		"\7<\2\2\u00fb\u00fc\7\n\2\2\u00fc\u00fd\5\26\f\2\u00fd\u00fe\7\13\2\2"+
		"\u00fe\31\3\2\2\2\u00ff\u0100\5\34\17\2\u0100\33\3\2\2\2\u0101\u0102\b"+
		"\17\1\2\u0102\u0103\5\36\20\2\u0103\u010a\3\2\2\2\u0104\u0105\f\4\2\2"+
		"\u0105\u0106\5\60\31\2\u0106\u0107\5\36\20\2\u0107\u0109\3\2\2\2\u0108"+
		"\u0104\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2"+
		"\2\2\u010b\35\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\b\20\1\2\u010e\u010f"+
		"\5 \21\2\u010f\u0116\3\2\2\2\u0110\u0111\f\4\2\2\u0111\u0112\5.\30\2\u0112"+
		"\u0113\5 \21\2\u0113\u0115\3\2\2\2\u0114\u0110\3\2\2\2\u0115\u0118\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\37\3\2\2\2\u0118\u0116"+
		"\3\2\2\2\u0119\u011a\b\21\1\2\u011a\u011b\5\"\22\2\u011b\u0122\3\2\2\2"+
		"\u011c\u011d\f\4\2\2\u011d\u011e\5\62\32\2\u011e\u011f\5\"\22\2\u011f"+
		"\u0121\3\2\2\2\u0120\u011c\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123!\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126"+
		"\b\22\1\2\u0126\u0127\5$\23\2\u0127\u012e\3\2\2\2\u0128\u0129\f\4\2\2"+
		"\u0129\u012a\5\64\33\2\u012a\u012b\5$\23\2\u012b\u012d\3\2\2\2\u012c\u0128"+
		"\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"#\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\7\66\2\2\u0132\u0135\5&\24\2"+
		"\u0133\u0135\5&\24\2\u0134\u0131\3\2\2\2\u0134\u0133\3\2\2\2\u0135%\3"+
		"\2\2\2\u0136\u0141\5(\25\2\u0137\u0138\7\n\2\2\u0138\u0139\5\32\16\2\u0139"+
		"\u013a\7\13\2\2\u013a\u0141\3\2\2\2\u013b\u013e\7<\2\2\u013c\u013d\7\17"+
		"\2\2\u013d\u013f\7<\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0141\3\2\2\2\u0140\u0136\3\2\2\2\u0140\u0137\3\2\2\2\u0140\u013b\3\2"+
		"\2\2\u0141\'\3\2\2\2\u0142\u0143\5:\36\2\u0143)\3\2\2\2\u0144\u0148\5"+
		"\60\31\2\u0145\u0148\5.\30\2\u0146\u0148\5,\27\2\u0147\u0144\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0146\3\2\2\2\u0148+\3\2\2\2\u0149\u014a\7\66\2\2"+
		"\u014a-\3\2\2\2\u014b\u014c\7\65\2\2\u014c/\3\2\2\2\u014d\u014e\7\64\2"+
		"\2\u014e\61\3\2\2\2\u014f\u0150\t\2\2\2\u0150\63\3\2\2\2\u0151\u0152\t"+
		"\3\2\2\u0152\65\3\2\2\2\u0153\u0156\5\64\33\2\u0154\u0156\5\62\32\2\u0155"+
		"\u0153\3\2\2\2\u0155\u0154\3\2\2\2\u0156\67\3\2\2\2\u0157\u0158\7+\2\2"+
		"\u0158\u0159\7,\2\2\u0159\u0169\7<\2\2\u015a\u0165\7\n\2\2\u015b\u0160"+
		"\7<\2\2\u015c\u015d\7\r\2\2\u015d\u015f\7<\2\2\u015e\u015c\3\2\2\2\u015f"+
		"\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0164\3\2"+
		"\2\2\u0162\u0160\3\2\2\2\u0163\u015b\3\2\2\2\u0164\u0167\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0165\3\2"+
		"\2\2\u0168\u016a\7\13\2\2\u0169\u015a\3\2\2\2\u0169\u016a\3\2\2\2\u016a"+
		"\u016b\3\2\2\2\u016b\u016c\7-\2\2\u016c\u0177\7\n\2\2\u016d\u0172\5:\36"+
		"\2\u016e\u016f\7\r\2\2\u016f\u0171\5:\36\2\u0170\u016e\3\2\2\2\u0171\u0174"+
		"\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0176\3\2\2\2\u0174"+
		"\u0172\3\2\2\2\u0175\u016d\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2"+
		"\2\2\u0177\u0178\3\2\2\2\u0178\u017a\3\2\2\2\u0179\u0177\3\2\2\2\u017a"+
		"\u017b\7\13\2\2\u017b9\3\2\2\2\u017c\u0182\5> \2\u017d\u0182\5@!\2\u017e"+
		"\u0182\5B\"\2\u017f\u0182\5D#\2\u0180\u0182\5<\37\2\u0181\u017c\3\2\2"+
		"\2\u0181\u017d\3\2\2\2\u0181\u017e\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0180"+
		"\3\2\2\2\u0182;\3\2\2\2\u0183\u0184\7\67\2\2\u0184=\3\2\2\2\u0185\u0187"+
		"\7\16\2\2\u0186\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2"+
		"\u0188\u0189\7=\2\2\u0189?\3\2\2\2\u018a\u018b\5> \2\u018b\u018c\7\17"+
		"\2\2\u018c\u018d\7=\2\2\u018dA\3\2\2\2\u018e\u018f\7?\2\2\u018fC\3\2\2"+
		"\2\u0190\u0191\7@\2\2\u0191E\3\2\2\2\u0192\u0193\7\60\2\2\u0193\u0194"+
		"\7<\2\2\u0194\u0195\7/\2\2\u0195\u019a\5H%\2\u0196\u0197\7\r\2\2\u0197"+
		"\u0199\5H%\2\u0198\u0196\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2"+
		"\2\u019a\u019b\3\2\2\2\u019b\u019f\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e"+
		"\7!\2\2\u019e\u01a0\5\32\16\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2"+
		"\u01a0G\3\2\2\2\u01a1\u01a2\7<\2\2\u01a2\u01a3\7\6\2\2\u01a3\u01a4\5("+
		"\25\2\u01a4I\3\2\2\2\u01a5\u01a6\5T+\2\u01a6\u01a9\5\66\34\2\u01a7\u01aa"+
		"\5:\36\2\u01a8\u01aa\5T+\2\u01a9\u01a7\3\2\2\2\u01a9\u01a8\3\2\2\2\u01aa"+
		"\u01ae\3\2\2\2\u01ab\u01ac\5*\26\2\u01ac\u01ad\5J&\2\u01ad\u01af\3\2\2"+
		"\2\u01ae\u01ab\3\2\2\2\u01ae\u01af\3\2\2\2\u01afK\3\2\2\2\u01b0\u01b1"+
		"\78\2\2\u01b1\u01b2\7\36\2\2\u01b2\u01b5\7<\2\2\u01b3\u01b4\7!\2\2\u01b4"+
		"\u01b6\5\32\16\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6M\3\2\2"+
		"\2\u01b7\u01c1\7 \2\2\u01b8\u01c2\7\f\2\2\u01b9\u01be\5P)\2\u01ba\u01bb"+
		"\7\r\2\2\u01bb\u01bd\5P)\2\u01bc\u01ba\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be"+
		"\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01be\3\2"+
		"\2\2\u01c1\u01b8\3\2\2\2\u01c1\u01b9\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3"+
		"\u01c4\7\36\2\2\u01c4\u01c9\7<\2\2\u01c5\u01c6\7\r\2\2\u01c6\u01c8\7<"+
		"\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9"+
		"\u01ca\3\2\2\2\u01ca\u01ce\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01cd\7!"+
		"\2\2\u01cd\u01cf\5\32\16\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"\u01da\3\2\2\2\u01d0\u01d1\7.\2\2\u01d1\u01d2\7\61\2\2\u01d2\u01d7\5R"+
		"*\2\u01d3\u01d4\7\r\2\2\u01d4\u01d6\5R*\2\u01d5\u01d3\3\2\2\2\u01d6\u01d9"+
		"\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9"+
		"\u01d7\3\2\2\2\u01da\u01d0\3\2\2\2\u01da\u01db\3\2\2\2\u01dbO\3\2\2\2"+
		"\u01dc\u01df\7<\2\2\u01dd\u01de\7\17\2\2\u01de\u01e0\7<\2\2\u01df\u01dd"+
		"\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0Q\3\2\2\2\u01e1\u01e3\5T+\2\u01e2\u01e4"+
		"\t\4\2\2\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4S\3\2\2\2\u01e5"+
		"\u01e8\7<\2\2\u01e6\u01e7\7\17\2\2\u01e7\u01e9\7<\2\2\u01e8\u01e6\3\2"+
		"\2\2\u01e8\u01e9\3\2\2\2\u01e9U\3\2\2\2\60[_dw}\u0088\u008d\u009a\u009f"+
		"\u00b0\u00bc\u00c1\u00d2\u00db\u00ef\u00f6\u010a\u0116\u0122\u012e\u0134"+
		"\u013e\u0140\u0147\u0155\u0160\u0165\u0169\u0172\u0177\u0181\u0186\u019a"+
		"\u019f\u01a9\u01ae\u01b5\u01be\u01c1\u01c9\u01ce\u01d7\u01da\u01df\u01e3"+
		"\u01e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}