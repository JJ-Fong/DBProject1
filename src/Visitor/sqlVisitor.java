// Generated from D:\Asus WebStorage\Septimo semestre\Bases de Datos\DBProject1-master\src\dbproject1\sql.g4 by ANTLR 4.4
package Visitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link sqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface sqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code showTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowTB(@NotNull sqlParser.ShowTBContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#logicExpOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpOr(@NotNull sqlParser.LogicExpOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(@NotNull sqlParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTB(@NotNull sqlParser.DropTBContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(@NotNull sqlParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(@NotNull sqlParser.DataContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#references}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferences(@NotNull sqlParser.ReferencesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expGL}
	 * labeled alternative in {@link sqlParser#exp4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpGL(@NotNull sqlParser.ExpGLContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#entero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntero(@NotNull sqlParser.EnteroContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#constraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraints(@NotNull sqlParser.ConstraintsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDB(@NotNull sqlParser.AlterDBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowDB(@NotNull sqlParser.ShowDBContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#character}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter(@NotNull sqlParser.CharacterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expNotOr}
	 * labeled alternative in {@link sqlParser#exp2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpNotOr(@NotNull sqlParser.ExpNotOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributo(@NotNull sqlParser.AtributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expNotGl}
	 * labeled alternative in {@link sqlParser#exp4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpNotGl(@NotNull sqlParser.ExpNotGlContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull sqlParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTB(@NotNull sqlParser.AlterTBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cPK}
	 * labeled alternative in {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCPK(@NotNull sqlParser.CPKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expNotEq}
	 * labeled alternative in {@link sqlParser#exp3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpNotEq(@NotNull sqlParser.ExpNotEqContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#conjuntoId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjuntoId(@NotNull sqlParser.ConjuntoIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expOr}
	 * labeled alternative in {@link sqlParser#exp2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpOr(@NotNull sqlParser.ExpOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(@NotNull sqlParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#orderby}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderby(@NotNull sqlParser.OrderbyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropConstraintTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropConstraintTB(@NotNull sqlParser.DropConstraintTBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showColums}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowColums(@NotNull sqlParser.ShowColumsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#fecha}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFecha(@NotNull sqlParser.FechaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDB(@NotNull sqlParser.DropDBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expNotAnd}
	 * labeled alternative in {@link sqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpNotAnd(@NotNull sqlParser.ExpNotAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addConstraintTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddConstraintTB(@NotNull sqlParser.AddConstraintTBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cCheck}
	 * labeled alternative in {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCCheck(@NotNull sqlParser.CCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#logicExpAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpAnd(@NotNull sqlParser.LogicExpAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#logicExpNot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpNot(@NotNull sqlParser.LogicExpNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#decimal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(@NotNull sqlParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#nullType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullType(@NotNull sqlParser.NullTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expID}
	 * labeled alternative in {@link sqlParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpID(@NotNull sqlParser.ExpIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addColumnTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddColumnTB(@NotNull sqlParser.AddColumnTBContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#relationalExpEq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpEq(@NotNull sqlParser.RelationalExpEqContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert(@NotNull sqlParser.InsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(@NotNull sqlParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#delete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete(@NotNull sqlParser.DeleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull sqlParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(@NotNull sqlParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expAnd}
	 * labeled alternative in {@link sqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAnd(@NotNull sqlParser.ExpAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#formatValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatValue(@NotNull sqlParser.FormatValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#logicExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExp(@NotNull sqlParser.LogicExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expNotFactor}
	 * labeled alternative in {@link sqlParser#unifactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpNotFactor(@NotNull sqlParser.ExpNotFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#relationalExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExp(@NotNull sqlParser.RelationalExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#relationalExpGL}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpGL(@NotNull sqlParser.RelationalExpGLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code useDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseDB(@NotNull sqlParser.UseDBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropColumnTB}
	 * labeled alternative in {@link sqlParser#tableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropColumnTB(@NotNull sqlParser.DropColumnTBContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(@NotNull sqlParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cFK}
	 * labeled alternative in {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCFK(@NotNull sqlParser.CFKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTB(@NotNull sqlParser.CreateTBContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion(@NotNull sqlParser.CondicionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expEq}
	 * labeled alternative in {@link sqlParser#exp3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpEq(@NotNull sqlParser.ExpEqContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#todo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTodo(@NotNull sqlParser.TodoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expFactor}
	 * labeled alternative in {@link sqlParser#unifactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpFactor(@NotNull sqlParser.ExpFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expParentheses}
	 * labeled alternative in {@link sqlParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpParentheses(@NotNull sqlParser.ExpParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#casitodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasitodo(@NotNull sqlParser.CasitodoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code renameTB}
	 * labeled alternative in {@link sqlParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTB(@NotNull sqlParser.RenameTBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expLiteral}
	 * labeled alternative in {@link sqlParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpLiteral(@NotNull sqlParser.ExpLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createDB}
	 * labeled alternative in {@link sqlParser#database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDB(@NotNull sqlParser.CreateDBContext ctx);
}