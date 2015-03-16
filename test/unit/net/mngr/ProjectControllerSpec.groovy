package net.mngr

import grails.test.GrailsMock
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(ProjectController)
@Mock(Project)
class ProjectControllerSpec extends Specification {

    def setupSpec() {
        GrailsMock mock = mockFor(ProjectService)
        mock.demand.arrangePriorities() {};
        controller.projectService = mock.createMock();
    }

    def populateValidParams(params) {
        assert params != null
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.projectInstanceList
            model.projectInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.projectInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def project = new Project()
            project.validate()
            controller.save(project)

        then:"The create view is rendered again with the correct model"
            model.projectInstance!= null
            view == 'create'
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def project = new Project(params)
            controller.show(project)

        then:"A model is populated containing the domain instance"
            model.projectInstance == project
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def project = new Project(params)
            controller.edit(project)

        then:"A model is populated containing the domain instance"
            model.projectInstance == project
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/project/index'
            flash.message != null

    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/project/index'
            flash.message != null
    }

    def mockService() {
    }
}
