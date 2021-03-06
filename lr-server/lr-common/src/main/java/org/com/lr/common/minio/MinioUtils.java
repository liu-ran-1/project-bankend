package org.com.lr.common.minio;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.com.lr.common.springcontext.SpringContextHolder;

public class MinioUtils {

  private static MinioClient minioClient;

  public static boolean upLoadFile(String fileName, InputStream io) {
    try {
      return upLoadMinioFile(fileName, io);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public static boolean upLoadMinioFile(String fileName, InputStream io)
      throws IOException, InvalidKeyException, MinioException, NoSuchAlgorithmException {
    String bucketName = MinioBucketNameEnum.getBucketNameByPath(fileName);
    PutObjectOptions putObjectOptions = new PutObjectOptions(io.available(), 0);
    boolean b = minioClient().bucketExists(bucketName);
    if(!b){
      minioClient().makeBucket(bucketName);
    }
    minioClient().putObject(bucketName, fileName, io, putObjectOptions);
    return true;
  }

  public static boolean upLoadFile(String fileName, String bucketName, InputStream io)
      throws IOException, InvalidKeyException, MinioException, NoSuchAlgorithmException {
    try {
      boolean b ;
      b = minioClient().bucketExists(bucketName);
      if (!b) {
        throw new MinioException("minio桶不存在");
      }
      PutObjectOptions putObjectOptions = new PutObjectOptions(PutObjectOptions.MAX_OBJECT_SIZE, PutObjectOptions.MAX_PART_SIZE);
      minioClient.putObject(bucketName, fileName, io, putObjectOptions);
    }catch (Exception e){
      e.printStackTrace();
    }
    return false;
  }

  private static MinioClient minioClient() {
    if(minioClient != null){
      return minioClient;
    }

    if (minioClient == null) {
      try {
        minioClient = new MinioClient("http://82.156.187.67:9000/","liuranandkexinlan","liuranandkexinlan");
      } catch (Exception e) {
        e.printStackTrace();
      }
//      minioClient = SpringContextHolder.getBean(MinioClient.class);
    }
    if (minioClient == null) {
      new Exception("minio clinet not init");
    }
    return minioClient;
  }


}
