package org.seckill.exception;

/**
 * 秒杀相关异常
 * @author lin-w
 *
 */
public class SeckillException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8181529577964661145L;

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SeckillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
