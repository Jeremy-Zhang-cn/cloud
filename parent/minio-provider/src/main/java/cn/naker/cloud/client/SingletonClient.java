package cn.naker.cloud.client;

import io.minio.MinioClient;

/**
 * @author Zhang Dingjie
 * @date 2021/6/23
 * @Description 枚举获取单例模型 仅供娱乐
 */
public enum SingletonClient {

	SINGLETON_CLIENT;

	private MinioClient minioClient;

	public MinioClient getMinioClient(String endpoint, String accessKey, String secretKey) {
		return minioClient == null ?
						(minioClient = MinioClient.builder()
						.endpoint(endpoint)
						.credentials(accessKey, secretKey)
						.build()) : minioClient;
	}


}
