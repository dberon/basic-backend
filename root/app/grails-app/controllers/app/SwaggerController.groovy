package app

import grails.plugin.springsecurity.annotation.Secured
import io.swagger.util.Json
import swagger.grails.SwaggerService
import swagger.grails.model.SwaggerApi

@Secured(['permitAll'])
class SwaggerController {
    SwaggerService swaggerService

    def api() {
        header("Access-Control-Allow-Origin", request.getHeader('Origin'))
        render(status: 200, contentType: "application/json", text: swaggerService.generate())
    }

    def internal() {
        header("Access-Control-Allow-Origin", request.getHeader('Origin'))
        render(status: 200, contentType: "application/json", text: Json.mapper().writeValueAsString(SwaggerApi.apis))
    }

}

