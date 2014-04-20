// Generated from BoardExpression.g4 by ANTLR 4.0

	package.pingball;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface BoardExpressionListener extends ParseTreeListener {
	void enterTriangleBumper(BoardExpressionParser.TriangleBumperContext ctx);
	void exitTriangleBumper(BoardExpressionParser.TriangleBumperContext ctx);

	void enterAbsorber(BoardExpressionParser.AbsorberContext ctx);
	void exitAbsorber(BoardExpressionParser.AbsorberContext ctx);

	void enterBall(BoardExpressionParser.BallContext ctx);
	void exitBall(BoardExpressionParser.BallContext ctx);

	void enterPremise(BoardExpressionParser.PremiseContext ctx);
	void exitPremise(BoardExpressionParser.PremiseContext ctx);

	void enterSquareBumper(BoardExpressionParser.SquareBumperContext ctx);
	void exitSquareBumper(BoardExpressionParser.SquareBumperContext ctx);

	void enterRoot(BoardExpressionParser.RootContext ctx);
	void exitRoot(BoardExpressionParser.RootContext ctx);

	void enterRightFlipper(BoardExpressionParser.RightFlipperContext ctx);
	void exitRightFlipper(BoardExpressionParser.RightFlipperContext ctx);

	void enterCircleBumper(BoardExpressionParser.CircleBumperContext ctx);
	void exitCircleBumper(BoardExpressionParser.CircleBumperContext ctx);

	void enterBoard(BoardExpressionParser.BoardContext ctx);
	void exitBoard(BoardExpressionParser.BoardContext ctx);

	void enterFire(BoardExpressionParser.FireContext ctx);
	void exitFire(BoardExpressionParser.FireContext ctx);

	void enterLeftFlipper(BoardExpressionParser.LeftFlipperContext ctx);
	void exitLeftFlipper(BoardExpressionParser.LeftFlipperContext ctx);
}