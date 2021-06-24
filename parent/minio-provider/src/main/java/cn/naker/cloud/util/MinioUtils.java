package cn.naker.cloud.util;

import cn.naker.cloud.config.MinioConfig;
import cn.naker.cloud.enums.MinioPolicy;
import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.SetBucketPolicyArgs;
import io.minio.UploadObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.minio.http.Method;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Zhang Dingjie
 * @date 2021/6/22
 * @Description Minio工具类，容器上下文加载完成后才能使用
 */

public class MinioUtils {


	protected static String ENDPOINT;
	protected static volatile MinioClient MINIO_CLIENT;


	/**
	* @Author Zhang Dingjie
	* @Date 2021/6/24
	* @Param []
	* @return void
	* @description 初始化方法，在SpringBootApplication容器加载完成后会被调用，为endpoint和client赋初值
	**/
	public static void init() {
		MinioConfig config = SpringContextUtils.getBean(MinioConfig.class);
		ENDPOINT = config.getEndpoint();
		if (MINIO_CLIENT == null) {
			synchronized (MinioUtils.class) {
				if (MINIO_CLIENT == null) {
					MINIO_CLIENT = SpringContextUtils.getBean("minioClient", MinioClient.class);
				}
			}
		}
	}

	public static String getPrefixUrl(String bucketName) {
		return String.format("%s/%s/", ENDPOINT, bucketName);
	}

	public static void makeBucket(String bucketName) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
		boolean bucketExists = MINIO_CLIENT.bucketExists(BucketExistsArgs.builder()
				.bucket(bucketName).build());
		if (!bucketExists) {
			MINIO_CLIENT.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
		}
	}

	public static void setPolicy(String bucketName, MinioPolicy policy) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
		MINIO_CLIENT.setBucketPolicy(SetBucketPolicyArgs.builder()
				.bucket(bucketName)
				.config(policy.getConfig(bucketName))
				.build());
	}

	public static String uploadFile(String bucketName, String objectKey, String filePath) throws IOException, ServerException, InsufficientDataException, InternalException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, XmlParserException, ErrorResponseException {
		makeBucket(bucketName);
		MINIO_CLIENT.uploadObject(UploadObjectArgs.builder()
				.bucket(bucketName)
				.object(objectKey)
				.filename(filePath).build());
		return getPrefixUrl(bucketName) + objectKey;
	}

	/**
	* @Author Zhang Dingjie
	* @Date 2021/6/22
	* @Param [bucketName, objectKey, inputStream, contentType]
	* @return java.lang.String
	* @description 流形式上传文件，如果objectKey相同，会覆盖原来的文件
	**/
	public static String uploadFile(String bucketName, String objectKey, InputStream inputStream, String contentType) throws IOException, ServerException, InsufficientDataException, InternalException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, XmlParserException, ErrorResponseException {
		makeBucket(bucketName);
		MINIO_CLIENT.putObject(PutObjectArgs.builder()
				.bucket(bucketName)
				.object(objectKey)
				.stream(inputStream, inputStream.available(), -1)
				.contentType(contentType).build());
		return getPrefixUrl(bucketName) + objectKey;
	}

	public static InputStream downloadFile(String bucketName, String objectKey) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
		return MINIO_CLIENT.getObject(GetObjectArgs.builder()
				.bucket(bucketName)
				.object(objectKey).build());
	}

	public static void deleteFile(String bucketName, String objectKey) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
		MINIO_CLIENT.removeObject(RemoveObjectArgs.builder()
				.bucket(bucketName).object(objectKey)
				.build());
	}

	/**
	* @Author Zhang Dingjie
	* @Date 2021/6/22
	* @Param [bucketName, objectKey, expires]
	* @return java.lang.String
	* @description 获取文件签名地址，有效时间单位: 秒
	**/
	public static String getSignedUrl(String bucketName, String objectKey, int expires) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
		return MINIO_CLIENT.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
				.method(Method.GET)
				.bucket(bucketName)
				.object(objectKey)
				.expiry(expires).build());
	}


}
