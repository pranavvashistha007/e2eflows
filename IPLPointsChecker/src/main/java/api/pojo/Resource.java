package api.pojo;

public class Resource {

	private String name;
    private String job;

    public Resource() {}

    public Resource(String name, String job) {
        this.name = name;
        this.job = job;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }
}