import java.util.*;
public class TaskList {
    private ArrayList<Task> taskList = new ArrayList<>();
    
    public void addTask(Task task)  {
        taskList.add(task);
    }
    
    public Task findByID(int id) {
        for (Task t : taskList) {
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
    
    public void deleteTask(int id) {
        for (Task task : taskList) {
            if(task.equals(findByID(id))){
                taskList.remove(task);
                break;
            }
        }
    }
    
    public void getDataTasks(){
        for (Task task : taskList) {
            task.display();
        }
    }
    
    public boolean checkEmpty(){
        if(taskList.isEmpty()) return true;
        return false;
    }
}