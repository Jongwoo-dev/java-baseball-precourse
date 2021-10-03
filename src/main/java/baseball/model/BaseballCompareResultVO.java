package baseball.model;

public class BaseballCompareResultVO {
	private int strike;
	private int ball;
	private boolean isError;
	
	/* Constructor */
	public BaseballCompareResultVO(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}
	public BaseballCompareResultVO(boolean isError) {
		super();
		this.isError = isError;
	}

	
	/* Getter, Setter */
	public int getStrike() {
		return strike;
	}
	public int getBall() {
		return ball;
	}
	public boolean isError() {
		return isError;
	}
	
	
	/* Logic */
	public boolean isCorrectAnswer() {
		return this.strike == 3;
	}
}
