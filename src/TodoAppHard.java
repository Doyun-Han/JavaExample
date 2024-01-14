import todo.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoAppHard {
    private List<Todo> todoList;
    private Scanner scanner;

    public TodoAppHard() {
        this.todoList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void startApp() {
        while (true) {
            displayMenu();
            int choice ;
            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            }catch (Exception e) {
                System.out.println("숫자만 입력 가능합니다.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addTodo();
                    break;
                case 2:
                    showTodoList();
                    break;
                case 3:
                    completeTodo();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
            }
        }
    }
        private void displayMenu() {
            System.out.println("==== 할 일 관리 어플리케이션 ====");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 할 일 목록 표시");
            System.out.println("3. 할 일 완료 처리");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택: ");
        }
        private void addTodo() {
            System.out.print("추가할 할 일을 입력하세요: ");
            String task = scanner.nextLine();
            Todo newTodo = new Todo(task);
            todoList.add(newTodo);
            System.out.println("할 일이 추가되었습니다.");
        }
        private void showTodoList() {
            if (todoList.isEmpty()) {
                System.out.println("할 일이 없습니다.");
            } else {
                System.out.println("==== 할 일 목록 ====");
                for (int i = 0 ; i < todoList.size() ; i++) {
                    System.out.println((i+1)+". " + todoList.get(i));
                }
            }
        }
    private void completeTodo() {
        if (todoList.isEmpty()) {
            System.out.println("완료할 할 일이 없습니다.");
        } else {
            System.out.print("완료할 할 일 번호를 입력하세요: ");
            showTodoList();
            int index = scanner.nextInt()-1;
            if (index >= 0 && index < todoList.size()) {
                Todo todo = todoList.get(index);
                todo.completeTask();
                System.out.println("할 일이 완료되었습니다.");
            } else {
                System.out.println("올바른 번호를 선택하세요.");
            }
        }
    }

    public static void main(String[] args) {
        TodoAppHard todoAppHard = new TodoAppHard();
        todoAppHard.startApp();
    }
}
