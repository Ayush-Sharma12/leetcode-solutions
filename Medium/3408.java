class TaskManager {

    class  User{
           int userId;
           int taskId;
           int priority;

           public User(int userId, int taskId, int priority) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
           }
    }
 
    Map<Integer, User> map;
    TreeSet<User> sortedSet;
    public TaskManager(List<List<Integer>> tasks) {
        this.map = new HashMap<>();
        this.sortedSet = new TreeSet<>((u1, u2) ->{

                if(u1.priority != u2.priority) {
                       return u2.priority - u1.priority;
                }   

                return u2.taskId - u1.taskId;
        });

        for(List<Integer> task : tasks) {
                int userId = task.get(0);
                int taskId = task.get(1);
                int priority = task.get(2);
            
                User newUser = new User(userId, taskId, priority);
             
                map.put(taskId, newUser);
                sortedSet.add(newUser);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
           User newUser = new User(userId, taskId, priority);
          
           map.put(taskId, newUser);
           sortedSet.add(newUser);
    }
    
    public void edit(int taskId, int newPriority) {
           User user = map.get(taskId);
           sortedSet.remove(user);

           user.priority = newPriority;

           sortedSet.add(user);
           map.put(taskId, user);

    }
    
    public void rmv(int taskId) {
            User user = map.get(taskId);
            sortedSet.remove(user);
            map.remove(taskId);
    }
    
    public int execTop() {

          if(sortedSet.isEmpty()) return -1; 

          User user = sortedSet.first();

          sortedSet.remove(user);

          return user.userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */