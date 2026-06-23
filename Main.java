import java.util.Scanner;



public class Main {
   public static void main(String[] args) {
         // Create necessary objects (LinkedList, Queue, Stack)
         LinkedList taskList = new LinkedList();
         Queue taskQueue = new Queue();
         Stack taskStack = new Stack(10); // Assume stack size of 10
         
         Scanner scanner = new Scanner(System.in);
         boolean running = true;


         while (running) {
               // Display menu
               System.out.println("\nJob Scheduling System:");
               System.out.println("1. Add a new job");
               System.out.println("2. Modify an existing job");
               System.out.println("3. Cancel a job");
               System.out.println("4. Process jobs");
               System.out.println("5. Undo jobs");
               System.out.println("6. Exit");
               System.out.print("Enter your choice: ");
               
               int choice = scanner.nextInt();
               scanner.nextLine(); // Consume newline character
               
               switch (choice) {
                  case 1: // Add a new job
                      // TODO: Prompt for task details and add to LinkedList and queue
                      System.out.print("Enter Job name: ");
                      String name = scanner.nextLine();        //Task or Job name
                      
                      System.out.print("Enter Job priority: ");
                      int priority = scanner.nextInt();        //Task/Job priority rank
                      
                      System.out.print("Enter Job duration: ");
                      int duration = scanner.nextInt();        //Task/Job duration 
                      scanner.nextLine();
                      
                      Task newTask = new Task(name, priority, duration);
                      taskList.add(newTask);
                      taskQueue.enqueue(newTask);

                        break;
                        
                        
                      case 2: // Modify an existing job
                      // TODO: Find task, modify details, and update queue order
                      System.out.print("Enter job to modify: ");
                      String modifyName = scanner.nextLine();
                      
                      Task taskToModify = findTask(taskList, modifyName);  
                      if (taskToModify != null){
                      
                          System.out.print("Enter new priority: ");
                          int newPriority = scanner.nextInt();
                          System.out.print("Enter a new duration: ");
                          int newDuration = scanner.nextInt();
                          
                          taskToModify.setPriority(newPriority);   //a new priority
                          taskToModify.setDuration(newDuration);   //a new duration
                          System.out.println("Job has been updated successfully.");
                       } else {
                           System.out.println("Job not found.");     
                     }
                     break;
                      
                      
                      case 3: // Cancel a job
                      // TODO: Remove task from LinkedList
                      System.out.print("Enter a job to delete: ");
                      String deleteName = scanner.nextLine();
                      Task jobToDelete = findTask(taskList, deleteName);
                      
                      
                      if(jobToDelete != null) {
                         taskStack.push(jobToDelete);
                         taskList.remove(jobToDelete);
                         System.out.print("Job has been cancelled successfully. ");
                      } else {
                           System.out.println("Job not found.");
                      }
                      break;
                        
                        
                      case 4: // Process jobs
                      // TODO: Process tasks from Queue and push to Stack
                      System.out.print("Processing jobs: ");
                      while (!taskQueue.isEmpty()){
                           Task processed = taskQueue.dequeue();
                           taskStack.push(processed);
                           System.out.println("Processed: " + processed);
                     }
                     break;
                        
                        
                      case 5: // Undo jobs
                      // TODO: Pop tasks from Stack and display them
                      System.out.print("Undoing jobs");
                      while (!taskStack.empty()) {
                           Task undoneTask = taskStack.pop();
                           System.out.println("Undone: " + undoneTask);
                      }
                      break;
                        
                        
                      case 6: // Exit
                      running = false;
                      System.out.println("Exiting the system.");
                        break;
                        
                        
                      default:
                      System.out.println("Invalid option. Please try again.");
                    }
                }
                scanner.close();
            }
               
               // TODO: Helper method to find a task by name in the linked list
               private static Task findTask(LinkedList taskList, String name) {
                  // Skeleton implementation for finding a task
                  for (Task task : taskList.getAllTasks()) {
                        if (task.getName().equals(name)) {
                           return task;
                        }
                   }
                  return null; // Replace with actual logic
            }
        }