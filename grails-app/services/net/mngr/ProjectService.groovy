package net.mngr

import grails.transaction.Transactional

@Transactional
class ProjectService {

    /**
     * method keeps projects' priorities arranged in that manner all values sequenced.
     * for example, having existing projects with priorities of 1, 2, 3 and adding a new one
     * with priority of 6, sets the new priority to 4.
     * needs to be invoked after every save / update.
     */
    def arrangePriorities() {
        def all = Project.list([sort: "priority", order: "asc"]);

        // algorith is pretty straigthforward, it iterate over sorted array and adjusts its priorities
        for(int i = 0; i < all.size(); i++) {
            Project p = all.get(i);
            // if not equal then change and save it
            if(p.priority != i + 1) {
                println("project's (id == ${p.id}) priority adjusted: ${p.priority} -> ${i + 1}")

                p.priority = i + 1;
                p.save();
            }
        }
    }
}
