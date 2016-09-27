package user.ms

import grails.core.GrailsApplication
import grails.util.Environment
import grails.plugins.*

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def userService

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

}
