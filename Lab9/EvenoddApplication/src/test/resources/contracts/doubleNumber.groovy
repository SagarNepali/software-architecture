import org.springframework.cloud.contract.spec.Contract
Contract.make {
	description "Return double (2X) of the input"
	request{
		method GET()
		url("/double") {
			queryParameters {
				parameter("number", "3")
			}
		}
	}
	response {
		body("6")
		status 200
	}
}