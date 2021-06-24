package cn.naker.cloud.config;

import cn.naker.cloud.client.SingletonClient;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Zhang Dingjie
 * @date 2021/6/23
 * @Description
 */

@Configuration
public class MinioConfig {

	@Value("${minio.endpoint}")
	private String endpoint;
	@Value("${minio.accessKey}")
	private String accessKey;
	@Value("${minio.secretKey}")
	private String accessToken;

	@Bean(name = "minioClient")
	public MinioClient minioClient() {
		return SingletonClient.SINGLETON_CLIENT.getMinioClient(endpoint, accessKey, accessToken);
	}

	public String getEndpoint() {
		return endpoint;
	}

}
