package net.mngr

class Project {

    String name;
    String code;
    String techLead;        // these two probably should map DB reference, instead of being strings
    String manager;         //
    Date deliveryDate;
    Phase phase;
    Integer priority;

    static constraints = {
        priority (min: 1)
        name (shared: "alphanumeric")
        code (nullable: true, shared: "alphanumeric")
        techLead (nullable: true, matches: /[a-zA-Z ]+/)
        manager (nullable: true, matches: /[a-zA-Z ]+/)
        deliveryDate (nullable: false)
        phase (nullable: false)
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", priority=" + priority +
                '}';
    }
}
