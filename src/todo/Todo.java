package todo;

public class Todo {
        private String task;
        private boolean completed;

        public Todo(String task) {
            this.task = task;
            this.completed = false;
        }

        public String getTask() {
            return task;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void completeTask() {
            completed = true;
        }

        public String toString() {
            return "할 일 : " + task + " | 완료 여부 : " + completed;
        }
}
