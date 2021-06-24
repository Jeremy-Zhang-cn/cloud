package cn.naker.cloud.enums;

/**
 * @author Zhang Dingjie
 * @date 2021/6/23
 * @Description bucket策略
 */
public enum MinioPolicy {

	READ_ONLY("{\n" +
			"  \"Version\": \"2012-10-17\",\n" +
			"  \"Statement\": [\n" +
			"    {\n" +
			"      \"Action\": [\n" +
			"        \"s3:GetAccessPoint\",\n" +
			"        \"s3:GetBucketLocation\",\n" +
			"        \"s3:GetBucketPolicy\",\n" +
			"        \"s3:GetObject\",\n" +
			"        \"s3:ListAllMyBuckets\",\n" +
			"        \"s3:ListBucket\"\n" +
			"      ],\n" +
			"      \"Effect\": \"Allow\",\n" +
			"      \"Resource\": \"arn:aws:s3:::#bucket#\",\n" +
			"      \"Principal\": \"*\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"Action\": [\n" +
			"        \"s3:GetObject\",\n" +
			"      ],\n" +
			"      \"Effect\": \"Allow\",\n" +
			"      \"Resource\": \"arn:aws:s3:::#bucket#/*\",\n" +
			"      \"Principal\": \"*\"\n" +
			"    }\n" +
			"  ]\n" +
			"}"),

	WRITE_ONLY("{\n" +
			"  \"Version\": \"2012-10-17\",\n" +
			"  \"Statement\": [\n" +
			"    {\n" +
			"      \"Action\": [\n" +
			"        \"s3:GetBucketLocation\",\n" +
			"        \"s3:ListBucketMultipartUploads\"\n" +
			"      ],\n" +
			"      \"Effect\": \"Allow\",\n" +
			"      \"Resource\": \"arn:aws:s3:::#bucket#\",\n" +
			"      \"Principal\": \"*\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"Action\": [\n" +
			"        \"s3:AbortMultipartUpload\",\n" +
			"        \"s3:DeleteObject\",\n" +
			"        \"s3:ListMultipartUploadParts\",\n" +
			"        \"s3:PutObject\"\n" +
			"      ],\n" +
			"      \"Effect\": \"Allow\",\n" +
			"      \"Resource\": \"arn:aws:s3:::#bucket#/*\",\n" +
			"      \"Principal\": \"*\"\n" +
			"    }\n" +
			"  ]\n" +
			"}"),

	READ_WRITE("{\n" +
			"  \"Version\": \"2012-10-17\",\n" +
			"  \"Statement\": [\n" +
			"    {\n" +
			"      \"Action\": [\n" +
			"        \"s3:GetBucketLocation\",\n" +
			"        \"s3:GetBucketPolicy\",\n" +
			"        \"s3:GetObject\",\n" +
			"        \"s3:ListAllMyBuckets\",\n" +
			"        \"s3:ListBucket\",\n" +
			"        \"s3:ListBucketMultipartUploads\"\n" +
			"      ],\n" +
			"      \"Effect\": \"Allow\",\n" +
			"      \"Resource\": \"arn:aws:s3:::#bucket#\",\n" +
			"      \"Principal\": \"*\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"Action\": [\n" +
			"        \"s3:AbortMultipartUpload\",\n" +
			"        \"s3:DeleteObject\",\n" +
			"        \"s3:GetObject\",\n" +
			"        \"s3:ListMultipartUploadParts\",\n" +
			"        \"s3:PutObject\"\n" +
			"      ],\n" +
			"      \"Effect\": \"Allow\",\n" +
			"      \"Resource\": \"arn:aws:s3:::#bucket#/*\",\n" +
			"      \"Principal\": \"*\"\n" +
			"    }\n" +
			"  ]\n" +
			"}");

	private String config;
	private static final String BUCKET_PARAM = "#bucket#";


	MinioPolicy(String config) {
		this.config = config;
	}

	public String getConfig(String bucketName) {
		return this.config.replaceAll(BUCKET_PARAM, bucketName);
	}

	public void setConfig(String policy, String bucketName) {
		this.config = policy.replaceAll(BUCKET_PARAM, bucketName);
	}

}
