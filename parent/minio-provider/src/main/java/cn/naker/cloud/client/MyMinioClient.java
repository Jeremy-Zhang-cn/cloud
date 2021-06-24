package cn.naker.cloud.client;

import io.minio.MinioClient;

/**
 * @author Zhang Dingjie
 * @date 2021/6/23
 * @Description 单例封装minioClient 仅供娱乐
 */
public class MyMinioClient extends MinioClient {

	private static volatile MyMinioClient client = null;

	private MyMinioClient(MinioClient client) {
		super(client);
	}

	private MyMinioClient(String endpoint, String accessKey, String secretKey) {
		super(MyMinioClient
				.builder()
				.endpoint(endpoint)
				.credentials(accessKey, secretKey)
				.build());
	}

	public static MyMinioClient getInstance(String endpoint, String accessKey, String secretKey) {
		if (client == null) {
			synchronized (MyMinioClient.class) {
				if (client == null) {
					client = new MyMinioClient(endpoint, accessKey, secretKey);
				}
			}
		}
		return client;
	}

}
