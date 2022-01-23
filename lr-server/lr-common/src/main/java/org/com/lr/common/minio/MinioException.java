package org.com.lr.common.minio;

import lombok.Data;

@Data
public class MinioException extends Exception{
  private String code ;

  private String msg;

  public MinioException(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public MinioException(String message, String code, String msg) {
    super(message);
    this.code = code;
    this.msg = msg;
  }

  public MinioException(String message, Throwable cause, String code, String msg) {
    super(message, cause);
    this.code = code;
    this.msg = msg;
  }

  public MinioException(Throwable cause, String code, String msg) {
    super(cause);
    this.code = code;
    this.msg = msg;
  }

  public MinioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String msg) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.code = code;
    this.msg = msg;
  }
}
