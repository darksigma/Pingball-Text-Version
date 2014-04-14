package parser;

import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import boardPhysics.Board;

public class BoardExpression {
    
    /**
     * @param file a .pb representing a pingball board
     * @return a pingball board corresponding to the input file, for use in pingball
     * games
     */
    public static Board parse(File file) {
        //TODO
    }
}