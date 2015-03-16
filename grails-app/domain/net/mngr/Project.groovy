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
        code (shared: "alphanumeric")
        techLead (matches: /[a-zA-Z ]+/)
        manager (matches: /[a-zA-Z ]+/)
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", priority=" + priority +
                '}';
    }
}
