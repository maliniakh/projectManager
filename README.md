### projectManager

Simple Grails application to manage projects. 

Each Project domain class has a few fields like name, deliveryDate or priority. Priorities are guarenteed to be sequenced, i.e. if a user adds / updates / deletes one of the projects, all priority values are checked through and adjusted via ProjectService method (there are tests as well which cover the service class).

#### Requirements
Grails 2.4
