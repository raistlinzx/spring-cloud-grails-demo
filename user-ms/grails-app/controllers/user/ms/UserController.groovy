package user.ms

import grails.converters.JSON

class UserController {

    def userService

    /**
     * 正常返回数据
     */
    def findUsers() {
    	def users=userService.findUsers()
    	render users as JSON
    }

    /**
     * 异常返回数据，具体请查看UserService.groovy
     */
    def findUsersError() {
    	def users=userService.findUsersError()
    	render users as JSON
    }
}
