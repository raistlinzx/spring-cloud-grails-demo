package user.ms


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


class UserService {

	static transactional = false


	@HystrixCommand(fallbackMethod = "findUsersWithError")
	def findUsers() {
		[[id:'1',name:'zhaoxin'],[id:'2',name:'zhuna'],[id:'3',name:'lilong'],[id:'4',name:'zhaolibing']]
	}

	@HystrixCommand(fallbackMethod = "findUsersWithError")
	def findUsersError() {
		// 抛出异常，测试fallbackMethod方法
		throw new Exception()
		[[id:'1',name:'zhaoxin'],[id:'2',name:'zhuna'],[id:'3',name:'lilong'],[id:'4',name:'zhaolibing']]
	}


	def findUsersWithError() {
		[]
	}
}