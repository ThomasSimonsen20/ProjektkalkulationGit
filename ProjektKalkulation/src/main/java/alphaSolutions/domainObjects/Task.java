package alphaSolutions.domainObjects;

public class Task {

        private int taskId;
        private int projectId;
        private int subProjectId;
        private String taskName;
        private String taskDescription;


        public Task(int projectId, int subProjectId, String taskName, String taskDescription) {
            this.projectId = projectId;
            this.subProjectId = subProjectId;
            this.taskName = taskName;
            this.taskDescription = taskDescription;
        }

        public Task() {
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public int getSubProjectId() {
            return subProjectId;
        }

        public void setSubProjectId(int subProjectId) {
            this.subProjectId = subProjectId;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getTaskDescription() {
            return taskDescription;
        }

        public void setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
        }

}


