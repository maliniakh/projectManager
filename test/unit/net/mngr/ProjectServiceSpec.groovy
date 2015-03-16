    package net.mngr

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ProjectService)
@Mock(Project)
class ProjectServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "arrangePriorities test"() {
        when: "Priorities: 1, 2, 4"
            Project.saveAll(new Project(id: 1, priority: 1));
            Project.saveAll(new Project(id: 2, priority: 2));
            Project.saveAll(new Project(id: 3, priority: 4));
            service.arrangePriorities();

        then: "1, 2, 3"
        Project.count() == 3;
        Project.createCriteria().get { projections { min "priority" } } == 1;
        Project.createCriteria().get { projections { max "priority" } } == 3;

        //
        when: "Priorities: 1, 2, 2"
        Project.where {}.deleteAll();
        Project.saveAll(new Project(id: 1, priority: 1));
        Project.saveAll(new Project(id: 2, priority: 2));
        Project.saveAll(new Project(id: 3, priority: 2));
        service.arrangePriorities();

        then: "1, 2, 3"
        Project.count() == 3;
        Project.createCriteria().get { projections { min "priority" } } == 1;
        Project.createCriteria().get { projections { max "priority" } } == 3;

        //
        when: "Priorities: empty"
        Project.where {}.deleteAll();
        service.arrangePriorities();

        then: "empty"
        Project.count() == 0;

        //
        when: "Priorities: 1, 1, 4, 4"
        Project.where {}.deleteAll();
        Project.saveAll(new Project(priority: 1));
        Project.saveAll(new Project(priority: 1));
        Project.saveAll(new Project(priority: 4));
        Project.saveAll(new Project(priority: 4));
        service.arrangePriorities();

        then: "1, 2, 3, 4"
        Project.count() == 4;
        Project.createCriteria().get { projections { min "priority" } } == 1;
        Project.createCriteria().get { projections { max "priority" } } == 4;

        //
        when: "Priorities: 5, 4, 3, 2, 1"
        Project.where {}.deleteAll();
        Project.saveAll(new Project(priority: 5));
        Project.saveAll(new Project(priority: 4));
        Project.saveAll(new Project(priority: 3));
        Project.saveAll(new Project(priority: 2));
        Project.saveAll(new Project(priority: 1));
        service.arrangePriorities();

        then: "1, 2, 3, 4, 5"
        Project.count() == 5;
        Project.createCriteria().get { projections { min "priority" } } == 1;
        Project.createCriteria().get { projections { max "priority" } } == 5;
    }
}
