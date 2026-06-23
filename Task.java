public class Task {

            private String name;
            private int priority;
            private int duration;

      


public Task(String name, int priority, int duration){
            this.name = name;
            this.priority = priority;
            this.duration = duration;


        }
      
          
      //Getter and Setter for name      
      public String getName() {
               return name;
    }           
      
      public void setName(String newName) {
               this.name = newName;
     }
       
       
      //Getter and setter for priority 
      public int  getPriority()   {
             return priority;
    }
    
      public void setPriority(int newPriority){
               this.priority = newPriority;
    }
    
    
     //Getter and setter for duration
     public int getDuration()  {
            return duration;
    }
    
     public void setDuration(int newDuration) {
              this.duration = newDuration;
    }
    
    
    
    @Override
    public String toString() {
         return "Task: " + name + " Priority: " + priority + " ,Duration: " + duration + " minutes";      // Return a string representation of task
    }
    
    @Override
    public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;       //Compare tasks based on name
    
         
         Task other = (Task) obj;
    
         return name.equalsIgnoreCase(other.name);
    }
    
    
    
}
