package business.demo

import grails.plugins.rest.client.RestBuilder
import org.springframework.web.client.RestTemplate
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

class DemoController {

	@Autowired
    @LoadBalanced
    RestTemplate loadBalanced

	def index() {

		def rest = new RestBuilder(loadBalanced)

		def resp = rest.get('http://user-microservice/user/findUsers')

		render resp.body
		// render 'OK'
	}
}