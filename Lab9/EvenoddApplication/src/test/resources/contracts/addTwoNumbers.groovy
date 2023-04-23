package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "add 2 numbers"
    request{
        method GET()
        url("/add") {
            queryParameters {
                parameter("value1", "12")
                parameter("value2", "15")
            }
        }
    }
    response {
        body("27")
        status 200
    }
}

