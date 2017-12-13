package lab8.Part2.exercise03.src;

public class Expression {

	private char op;

	private Expression left;

	private Expression right;

	private int constant;

	Expression(int constant) {
		this.op = 'c';
		this.constant = constant;
	}

	Expression(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}

	public int evaluate() {
		switch (op) {
		case 'c':
			return constant;
		case '+':
			return left.evaluate() + right.evaluate();
		case '-':
			return left.evaluate() - right.evaluate();
		case '*':
			return left.evaluate() * right.evaluate();
		case '/':
			return left.evaluate() / right.evaluate();
		default:
			throw new IllegalStateException();
		}
	}
}
