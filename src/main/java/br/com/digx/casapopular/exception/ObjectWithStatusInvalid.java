package br.com.digx.casapopular.exception;

public class ObjectWithStatusInvalid extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ObjectWithStatusInvalid(String msg) {
    super(msg);
  }

}