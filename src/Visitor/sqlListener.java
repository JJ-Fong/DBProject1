// Generated from C:\Users\Javier Fong\Documents\Universidad\2016\Ciclo 1\Clases\Bases de Datos\Proyecto1\DBProject1\src\Visitor\sql.g4 by ANTLR 4.4
package Visitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link sqlParser}.
 */
public interface sqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code cCheck}
	 * labeled alternative in {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterCCheck(@NotNull sqlParser.CCheckContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cCheck}
	 * labeled alternative in {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitCCheck(@NotNull sqlParser.CCheckContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropColumnTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 */
	void enterDropColumnTB(@NotNull sqlParser.DropColumnTBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropColumnTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 */
	void exitDropColumnTB(@NotNull sqlParser.DropColumnTBContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(@NotNull sqlParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(@NotNull sqlParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expAnd}
	 * labeled alternative in {@link sqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpAnd(@NotNull sqlParser.ExpAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expAnd}
	 * labeled alternative in {@link sqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpAnd(@NotNull sqlParser.ExpAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void enterDropTB(@NotNull sqlParser.DropTBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void exitDropTB(@NotNull sqlParser.DropTBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expGL}
	 * labeled alternative in {@link sqlParser#exp4}.
	 * @param ctx the parse tree
	 */
	void enterExpGL(@NotNull sqlParser.ExpGLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expGL}
	 * labeled alternative in {@link sqlParser#exp4}.
	 * @param ctx the parse tree
	 */
	void exitExpGL(@NotNull sqlParser.ExpGLContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#references}.
	 * @param ctx the parse tree
	 */
	void enterReferences(@NotNull sqlParser.ReferencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#references}.
	 * @param ctx the parse tree
	 */
	void exitReferences(@NotNull sqlParser.ReferencesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void enterShowTB(@NotNull sqlParser.ShowTBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void exitShowTB(@NotNull sqlParser.ShowTBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expLiteral}
	 * labeled alternative in {@link sqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterExpLiteral(@NotNull sqlParser.ExpLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expLiteral}
	 * labeled alternative in {@link sqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitExpLiteral(@NotNull sqlParser.ExpLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#formatValue}.
	 * @param ctx the parse tree
	 */
	void enterFormatValue(@NotNull sqlParser.FormatValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#formatValue}.
	 * @param ctx the parse tree
	 */
	void exitFormatValue(@NotNull sqlParser.FormatValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code alterDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void enterAlterDB(@NotNull sqlParser.AlterDBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code alterDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void exitAlterDB(@NotNull sqlParser.AlterDBContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtributo(@NotNull sqlParser.AtributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtributo(@NotNull sqlParser.AtributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#logicExpAnd}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpAnd(@NotNull sqlParser.LogicExpAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#logicExpAnd}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpAnd(@NotNull sqlParser.LogicExpAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void enterShowDB(@NotNull sqlParser.ShowDBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void exitShowDB(@NotNull sqlParser.ShowDBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code useDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void enterUseDB(@NotNull sqlParser.UseDBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code useDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void exitUseDB(@NotNull sqlParser.UseDBContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#constraints}.
	 * @param ctx the parse tree
	 */
	void enterConstraints(@NotNull sqlParser.ConstraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#constraints}.
	 * @param ctx the parse tree
	 */
	void exitConstraints(@NotNull sqlParser.ConstraintsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expID}
	 * labeled alternative in {@link sqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterExpID(@NotNull sqlParser.ExpIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expID}
	 * labeled alternative in {@link sqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitExpID(@NotNull sqlParser.ExpIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cPK}
	 * labeled alternative in {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterCPK(@NotNull sqlParser.CPKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cPK}
	 * labeled alternative in {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitCPK(@NotNull sqlParser.CPKContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#logicExp}.
	 * @param ctx the parse tree
	 */
	void enterLogicExp(@NotNull sqlParser.LogicExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#logicExp}.
	 * @param ctx the parse tree
	 */
	void exitLogicExp(@NotNull sqlParser.LogicExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addConstraintTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 */
	void enterAddConstraintTB(@NotNull sqlParser.AddConstraintTBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addConstraintTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 */
	void exitAddConstraintTB(@NotNull sqlParser.AddConstraintTBContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull sqlParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull sqlParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expOr}
	 * labeled alternative in {@link sqlParser#exp2}.
	 * @param ctx the parse tree
	 */
	void enterExpOr(@NotNull sqlParser.ExpOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expOr}
	 * labeled alternative in {@link sqlParser#exp2}.
	 * @param ctx the parse tree
	 */
	void exitExpOr(@NotNull sqlParser.ExpOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expFactor}
	 * labeled alternative in {@link sqlParser#unifactor}.
	 * @param ctx the parse tree
	 */
	void enterExpFactor(@NotNull sqlParser.ExpFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expFactor}
	 * labeled alternative in {@link sqlParser#unifactor}.
	 * @param ctx the parse tree
	 */
	void exitExpFactor(@NotNull sqlParser.ExpFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#logicExpNot}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpNot(@NotNull sqlParser.LogicExpNotContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#logicExpNot}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpNot(@NotNull sqlParser.LogicExpNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(@NotNull sqlParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(@NotNull sqlParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code renameTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void enterRenameTB(@NotNull sqlParser.RenameTBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code renameTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void exitRenameTB(@NotNull sqlParser.RenameTBContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(@NotNull sqlParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(@NotNull sqlParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void enterCreateTB(@NotNull sqlParser.CreateTBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void exitCreateTB(@NotNull sqlParser.CreateTBContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#orderby}.
	 * @param ctx the parse tree
	 */
	void enterOrderby(@NotNull sqlParser.OrderbyContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#orderby}.
	 * @param ctx the parse tree
	 */
	void exitOrderby(@NotNull sqlParser.OrderbyContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#logicExpOr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpOr(@NotNull sqlParser.LogicExpOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#logicExpOr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpOr(@NotNull sqlParser.LogicExpOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(@NotNull sqlParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(@NotNull sqlParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cFK}
	 * labeled alternative in {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterCFK(@NotNull sqlParser.CFKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cFK}
	 * labeled alternative in {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitCFK(@NotNull sqlParser.CFKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void enterDropDB(@NotNull sqlParser.DropDBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void exitDropDB(@NotNull sqlParser.DropDBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void enterCreateDB(@NotNull sqlParser.CreateDBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void exitCreateDB(@NotNull sqlParser.CreateDBContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull sqlParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull sqlParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#todo}.
	 * @param ctx the parse tree
	 */
	void enterTodo(@NotNull sqlParser.TodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#todo}.
	 * @param ctx the parse tree
	 */
	void exitTodo(@NotNull sqlParser.TodoContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(@NotNull sqlParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(@NotNull sqlParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expNotGl}
	 * labeled alternative in {@link sqlParser#exp4}.
	 * @param ctx the parse tree
	 */
	void enterExpNotGl(@NotNull sqlParser.ExpNotGlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expNotGl}
	 * labeled alternative in {@link sqlParser#exp4}.
	 * @param ctx the parse tree
	 */
	void exitExpNotGl(@NotNull sqlParser.ExpNotGlContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#relationalExpGL}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpGL(@NotNull sqlParser.RelationalExpGLContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#relationalExpGL}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpGL(@NotNull sqlParser.RelationalExpGLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expNotAnd}
	 * labeled alternative in {@link sqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpNotAnd(@NotNull sqlParser.ExpNotAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expNotAnd}
	 * labeled alternative in {@link sqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpNotAnd(@NotNull sqlParser.ExpNotAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#character}.
	 * @param ctx the parse tree
	 */
	void enterCharacter(@NotNull sqlParser.CharacterContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#character}.
	 * @param ctx the parse tree
	 */
	void exitCharacter(@NotNull sqlParser.CharacterContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#relationalExpEq}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpEq(@NotNull sqlParser.RelationalExpEqContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#relationalExpEq}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpEq(@NotNull sqlParser.RelationalExpEqContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#variosId}.
	 * @param ctx the parse tree
	 */
	void enterVariosId(@NotNull sqlParser.VariosIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#variosId}.
	 * @param ctx the parse tree
	 */
	void exitVariosId(@NotNull sqlParser.VariosIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#delete}.
	 * @param ctx the parse tree
	 */
	void enterDelete(@NotNull sqlParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#delete}.
	 * @param ctx the parse tree
	 */
	void exitDelete(@NotNull sqlParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expNotOr}
	 * labeled alternative in {@link sqlParser#exp2}.
	 * @param ctx the parse tree
	 */
	void enterExpNotOr(@NotNull sqlParser.ExpNotOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expNotOr}
	 * labeled alternative in {@link sqlParser#exp2}.
	 * @param ctx the parse tree
	 */
	void exitExpNotOr(@NotNull sqlParser.ExpNotOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#casitodo}.
	 * @param ctx the parse tree
	 */
	void enterCasitodo(@NotNull sqlParser.CasitodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#casitodo}.
	 * @param ctx the parse tree
	 */
	void exitCasitodo(@NotNull sqlParser.CasitodoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showColums}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void enterShowColums(@NotNull sqlParser.ShowColumsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showColums}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void exitShowColums(@NotNull sqlParser.ShowColumsContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#fecha}.
	 * @param ctx the parse tree
	 */
	void enterFecha(@NotNull sqlParser.FechaContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#fecha}.
	 * @param ctx the parse tree
	 */
	void exitFecha(@NotNull sqlParser.FechaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code alterTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void enterAlterTB(@NotNull sqlParser.AlterTBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code alterTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void exitAlterTB(@NotNull sqlParser.AlterTBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expParentheses}
	 * labeled alternative in {@link sqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterExpParentheses(@NotNull sqlParser.ExpParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expParentheses}
	 * labeled alternative in {@link sqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitExpParentheses(@NotNull sqlParser.ExpParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addColumnTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 */
	void enterAddColumnTB(@NotNull sqlParser.AddColumnTBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addColumnTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 */
	void exitAddColumnTB(@NotNull sqlParser.AddColumnTBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expNotFactor}
	 * labeled alternative in {@link sqlParser#unifactor}.
	 * @param ctx the parse tree
	 */
	void enterExpNotFactor(@NotNull sqlParser.ExpNotFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expNotFactor}
	 * labeled alternative in {@link sqlParser#unifactor}.
	 * @param ctx the parse tree
	 */
	void exitExpNotFactor(@NotNull sqlParser.ExpNotFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#entero}.
	 * @param ctx the parse tree
	 */
	void enterEntero(@NotNull sqlParser.EnteroContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#entero}.
	 * @param ctx the parse tree
	 */
	void exitEntero(@NotNull sqlParser.EnteroContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(@NotNull sqlParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(@NotNull sqlParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(@NotNull sqlParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(@NotNull sqlParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropConstraintTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 */
	void enterDropConstraintTB(@NotNull sqlParser.DropConstraintTBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropConstraintTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 */
	void exitDropConstraintTB(@NotNull sqlParser.DropConstraintTBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expNotEq}
	 * labeled alternative in {@link sqlParser#exp3}.
	 * @param ctx the parse tree
	 */
	void enterExpNotEq(@NotNull sqlParser.ExpNotEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expNotEq}
	 * labeled alternative in {@link sqlParser#exp3}.
	 * @param ctx the parse tree
	 */
	void exitExpNotEq(@NotNull sqlParser.ExpNotEqContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#literalString}.
	 * @param ctx the parse tree
	 */
	void enterLiteralString(@NotNull sqlParser.LiteralStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#literalString}.
	 * @param ctx the parse tree
	 */
	void exitLiteralString(@NotNull sqlParser.LiteralStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#relationalExp}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExp(@NotNull sqlParser.RelationalExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#relationalExp}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExp(@NotNull sqlParser.RelationalExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull sqlParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull sqlParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#nullType}.
	 * @param ctx the parse tree
	 */
	void enterNullType(@NotNull sqlParser.NullTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#nullType}.
	 * @param ctx the parse tree
	 */
	void exitNullType(@NotNull sqlParser.NullTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#conjuntoId}.
	 * @param ctx the parse tree
	 */
	void enterConjuntoId(@NotNull sqlParser.ConjuntoIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#conjuntoId}.
	 * @param ctx the parse tree
	 */
	void exitConjuntoId(@NotNull sqlParser.ConjuntoIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#insert}.
	 * @param ctx the parse tree
	 */
	void enterInsert(@NotNull sqlParser.InsertContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#insert}.
	 * @param ctx the parse tree
	 */
	void exitInsert(@NotNull sqlParser.InsertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expEq}
	 * labeled alternative in {@link sqlParser#exp3}.
	 * @param ctx the parse tree
	 */
	void enterExpEq(@NotNull sqlParser.ExpEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expEq}
	 * labeled alternative in {@link sqlParser#exp3}.
	 * @param ctx the parse tree
	 */
	void exitExpEq(@NotNull sqlParser.ExpEqContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull sqlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull sqlParser.LiteralContext ctx);
}