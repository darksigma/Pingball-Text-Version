//grammar goes here, to be compiled by antlr

grammar BoardExpression;

@header{
	package.pingball;
}

@members{

	public void reportErrorAsExceptions(){
		addErrorListenListener(new ExceptionThrowingErrorListener());
	}
	
	private static class ExceptionThowingErrorListeer extends BaseErrorListener {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer,
				Object offendingSymbol, int line, int charPositionLine,
				String msg, RecognitionException e) {
			throw new RuntimeExcpetion(msg);
		}
	}
}
	
	//lexer rules
	
	WHITE: [ \t\r\n]+ -> skip;
	COMMENTERS: '#'~[\r\n]* -> skip;
	NAME: [A-Za-z_][A-Za-z_0-9]*;
	NUMBAH:	'-'?[0-9]+ | '-'[0-9]*'.'[0-9]*;
	EQUALS: '=';
	
	
	
	
	//parser rules
	
	root: premise EOF;
	premise: board (ball | squareBumper | circleBumper | triangleBumper | rightFlipper | leftFlipper | absorber | fire)*;
	board: 'board name' EQUALS NAME ('gravity' EQUALS NUMBAH | 'friction1' EQUALS NUMBAH | 'friction2' EQUALS NUMBAH)*;
	ball: 'ball name' EQUALS NAME 'x' EQUALS NUMBAH 'y' EQUALS NUMBAH 'xVelocity' EQUALS NUMBAH 'yVelocity' EQUALS NUMBAH;
	squareBumper: 'squareBumper name' EQUALS NAME 'x' EQUALS NUMBAH 'y' EQUALS NUMBAH;
	circleBumper: 'circleBumper name' EQUALS NAME 'x' EQUALS NUMBAH 'y' EQUALS NUMBAH;
	triangleBumper: 'triangleBumper name' EQUALS NAME 'x' EQUALS NUMBAH 'y' EQUALS NUMBAH 'orientation' EQUALS NUMBAH;
	leftFlipper: 'leftFlipper name' EQUALS NAME 'x' EQUALS NUMBAH 'y' EQUALS NUMBAH 'orientation' EQUALS NUMBAH;
	rightFlipper: 'rightFlipper name' EQUALS NAME 'x' EQUALS NUMBAH 'y' EQUALS NUMBAH 'orientation' EQUALS NUMBAH;
	absorber: 'absorber name' EQUALS NAME 'x' EQUALS NUMBAH 'y' EQUALS NUMBAH 'width' EQUALS NUMBAH 'height' EQUALS NUMBAH;
	fire: 'fire trigger' EQUALS NAME 'action' EQUALS NAME;
	
	 
	
	
	