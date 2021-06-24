package cn.naker.cloud.controller;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.minio.http.Method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Zhang Dingjie
 * @date 2021/6/23
 * @Description
 */

@RestController
@RequestMapping(value = "/sys/minio/provider")
public class MinioProviderController {

	@Resource
	private MinioClient minioClient;

	@GetMapping(value = "test")
	public String test() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
		return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs
				.builder()
				.method(Method.GET)
				.bucket("my-bucket")
				.expiry(120)
				.object("1624351773138")
				.build());
	}


}
