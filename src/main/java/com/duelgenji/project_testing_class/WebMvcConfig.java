//package com.duelgenji.project_testing_class;
//
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.ssl.SSLContextBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import javax.net.ssl.SSLContext;
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//
//	@Value("${global.mock.enable}")
//	private String mock;
//
//	@Bean
//	public RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
//		RestTemplate restTemplate = new RestTemplate();
//
//		SSLContext context = SSLContextBuilder.create().loadTrustMaterial(null, (chain, authType) -> true).build();
//		SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(context, new NoopHostnameVerifier());
//		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
//				.register("http", PlainConnectionSocketFactory.INSTANCE)
//				.register("https", factory)
//				.build();
//
////		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
////				.register("http", PlainConnectionSocketFactory.INSTANCE)
////				.register("https", new SSLConnectionSocketFactory(HttpsUtil.createIgnoreVerifySSL(),new String[]{"TLS"},new String[]{"SSL_RSA_WITH_RC4_128_MD5", " SSL_RSA_WITH_RC4_128_SHA", " TLS_RSA_WITH_AES_128_CBC_SHA", " TLS_DHE_RSA_WITH_AES_128_CBC_SHA", " TLS_DHE_DSS_WITH_AES_128_CBC_SHA", " SSL_RSA_WITH_3DES_EDE_CBC_SHA", " SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", " SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", " SSL_RSA_WITH_DES_CBC_SHA", " SSL_DHE_RSA_WITH_DES_CBC_SHA", " SSL_DHE_DSS_WITH_DES_CBC_SHA", " SSL_RSA_EXPORT_WITH_RC4_40_MD5", " SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", " SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", " SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", " SSL_RSA_WITH_NULL_MD5", " SSL_RSA_WITH_NULL_SHA", " SSL_DH_anon_WITH_RC4_128_MD5", " TLS_DH_anon_WITH_AES_128_CBC_SHA", " SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", " SSL_DH_anon_WITH_DES_CBC_SHA", " SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", " SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", " TLS_KRB5_WITH_RC4_128_SHA", " TLS_KRB5_WITH_RC4_128_MD5", " TLS_KRB5_WITH_3DES_EDE_CBC_SHA", " TLS_KRB5_WITH_3DES_EDE_CBC_MD5", " TLS_KRB5_WITH_DES_CBC_SHA", " TLS_KRB5_WITH_DES_CBC_MD5", " TLS_KRB5_EXPORT_WITH_RC4_40_SHA", " TLS_KRB5_EXPORT_WITH_RC4_40_MD5", " TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", " TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5"}
////				.register("https", new SSLConnectionSocketFactory(context,new String[] {"SSLv2Hello","SSLv3","TLSv1","TLSv1.1","TLSv1.2"},null,SSLConnectionSocketFactory.getDefaultHostnameVerifier())).build();
////				.register("https", new SSLConnectionSocketFactory(HttpsUtil.createIgnoreVerifySSL())).build();
//
//		HttpClientBuilder builder =  HttpClients.custom();
//		builder.setRetryHandler(new DefaultHttpRequestRetryHandler(3,false));
//
//		PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
//		clientConnectionManager.setMaxTotal(200);
//		clientConnectionManager.setDefaultMaxPerRoute(100);
//		builder.setConnectionManager(clientConnectionManager);
//
//		CloseableHttpClient client = HttpClients.custom()
////				.setProxy(new HttpHost("sin4.sme.zscalertwo.net",10758))
//				.setConnectionManager(clientConnectionManager).build();
//
//		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
//				client);
//		requestFactory.setConnectTimeout(9000);
//		requestFactory.setReadTimeout(9000);
//		requestFactory.setConnectionRequestTimeout(9000);
//		requestFactory.setHttpClient(client);
//
//		restTemplate.setRequestFactory(requestFactory);
//
//		return restTemplate;
//	}
//
////	@ReadingConverter
////	enum bigConverter implements Converter<Decimal128,String> {
////		INSTANCE;
////		@Override
////		public String convert(Decimal128 localDate) {
////			System.out.println(localDate.getClass() + " " + localDate.toString());
////			return "123";
////		}
////	}
////
////	@Bean
////	public MongoCustomConversions customConversions(){
////		List<Converter<?,?>> converters = new ArrayList<>();
////		converters.add(bigConverter.INSTANCE);
////		return new MongoCustomConversions(converters);
////	}
//
//
//
//}
