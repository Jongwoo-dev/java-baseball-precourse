package baseball.model;

import java.util.Objects;

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
	
	@Override
	public String toString() {
		return "BaseballCompareResultVO [strike=" + strike + ", ball=" + ball + ", isError=" + isError + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BaseballCompareResultVO)) {
			return false;
		}
		BaseballCompareResultVO target = (BaseballCompareResultVO)obj;
		if (this.getStrike() == target.getStrike() && this.getBall() == target.getBall() && this.isError == target.isError) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(strike, ball, isError);
	}
}
