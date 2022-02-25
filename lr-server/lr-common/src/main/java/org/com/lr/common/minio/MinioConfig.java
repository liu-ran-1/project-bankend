package org.com.lr.common.minio;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Data
@ConditionalOnProperty(prefix = "file",name = "type",havingValue = "minio",matchIfMissing = false)
public class MinioConfig {

    @Value("${minio.endpoint}")
    private String minioEndPoint;

  @Value("${minio.accessKey}")
  private String minioAccessKey;

  @Value("${minio.secretKey}")
  private String minioSecretKey;

  @Bean
  public MinioClient minioClient(){
    try {
      MinioClient minioClient = new MinioClient(minioEndPoint,minioAccessKey,minioSecretKey);
      return minioClient;
    }  catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


}
