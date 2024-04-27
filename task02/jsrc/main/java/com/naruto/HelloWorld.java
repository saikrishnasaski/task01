package com.naruto;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.annotations.lambda.LambdaUrlConfig;
import com.syndicate.deployment.model.RetentionSetting;
import com.syndicate.deployment.model.lambda.url.AuthType;

@LambdaHandler(lambdaName = "hello_world",
		roleName = "hello_world-role",
		logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)
@LambdaUrlConfig(authType = AuthType.NONE)
public class HelloWorld implements RequestHandler<Object, String> {

	public String handleRequest(Object request, Context context) {
		System.out.println("Hello from lambda sai");

		HelloResponse response = new HelloResponse();
		response.statusCode = 200;
		response.message = "Hello from Lambda";

		String res = new Gson().toJson(response);

		System.out.println(res);

		return res;
	}

	static class HelloResponse {

		int statusCode;
		String message;
	}
}
