import net.mngr.Phase
import net.mngr.Project

class BootStrap {

    def init = { servletContext ->
        // insert example data if there is no project yet
        if (!Project.count()) {
            new Project(name: "Example Project", manager: "Steve Ballmer", deliveryDate: new Date() + 14, code: "code",
            techLead: "CTO", phase: Phase.SCOPING, priority: 1).save(failOnError: true);
        }
    }

    def destroy = {
    }
}
