package br.com.mefit.domain.exception;

public class NotFoundEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1121040781122377512L;
	
	public NotFoundEntityException(String mensagem)
	{
		super(mensagem);
	}

}
