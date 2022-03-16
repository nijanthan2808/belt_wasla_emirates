package com.beltWasla.utils;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import com.beltWasla.setUp.FileReaderManager;

import io.restassured.response.Response;

public class TestRailConnect {
	public static void update(String testID, String status) throws IOException {

		int status_id = 0;
		if (status.equalsIgnoreCase("Passed")) {
			status_id = 1;
		} else if (status.equalsIgnoreCase("Failed")) {
			status_id = 5;
		}
		String runId = FileReaderManager.getInstance().getConfigReader().getTestRailRunId();
		String userID = FileReaderManager.getInstance().getConfigReader().getTestRailUserID();
		String userPwd = FileReaderManager.getInstance().getConfigReader().getTestRailUserPWD();
		String testRailIntegration = FileReaderManager.getInstance().getConfigReader().getTestRailIntegration();
		String URL = "https://emirates.testrail.io/index.php?/api/v2/add_result_for_case/" + runId + "/" + testID + "";
		String body = "{\"status_id\":" + status_id + "}";

		//Updates the test run status in TestRail for the test cases 
		if (testRailIntegration.equalsIgnoreCase("true")) {
			Response response = given().log().all().header("Content-Type", "application/json").auth().preemptive()
					.basic(userID, userPwd).body(body).when().post(URL);
			System.out.println("responseCode:" + response.getStatusCode());
			response.prettyPrint();
		}
	}
}
