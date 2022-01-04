package org.lr.com.minio;

import org.springframework.util.StringUtils;

public enum MinioBucketNameEnum {
  BUCKET_NAME_PDF(MinioBucketConstant.BUCKET_NAME_PDF, MinioBucketConstant.FILE_SUFFIX_PDF),
  BUCKET_NAME_WORD01(MinioBucketConstant.BUCKET_NAME_WORD, MinioBucketConstant.FILE_SUFFIX_DOC),
  BUCKET_NAME_WORD22(MinioBucketConstant.BUCKET_NAME_WORD, MinioBucketConstant.FILE_SUFFIX_DOCX),
  BUCKET_NAME_EXCEL01(MinioBucketConstant.BUCKET_NAME_EXCEL, MinioBucketConstant.FILE_SUFFIX_XLS),
  BUCKET_NAME_EXCEL02(MinioBucketConstant.BUCKET_NAME_EXCEL, MinioBucketConstant.FILE_SUFFIX_XLSX),
  BUCKET_NAME_ZIP(MinioBucketConstant.BUCKET_NAME_ZIP, MinioBucketConstant.FILE_SUFFIX_ZIP),
  BUCKET_NAME_TXT(MinioBucketConstant.BUCKET_NAME_TXT, MinioBucketConstant.FILE_SUFFIX_TXT);

  private String name;
  private String fileSuffix;

  MinioBucketNameEnum(String name, String fileSuffix) {
    this.name = name;
    this.fileSuffix = fileSuffix;
  }

  public static String getBucketName(String fileSuffix) {
    MinioBucketNameEnum[] bucketNameEnums = MinioBucketNameEnum.values();
    for (MinioBucketNameEnum bucketNameEnum : bucketNameEnums) {
      if (bucketNameEnum.fileSuffix.equals(fileSuffix)) {
        return bucketNameEnum.name;
      }
    }
    return MinioBucketConstant.BUCKET_NAME_OTHER;
  }

  public static String getBucketNameByPath(String filePath) {
    try {
      if (!StringUtils.hasLength(filePath) || !filePath.contains("."))
        new Exception("文件名称不正确" + filePath);
      String suffix = filePath.substring(filePath.lastIndexOf(".") + 1);
      return getBucketName(suffix);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
